package com.intellij.xtext.samples.simple;

import com.intellij.codeInsight.TailType;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.codeInsight.lookup.TailTypeDecorator;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilderFactory;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.patterns.PatternCondition;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.impl.source.tree.TreeUtil;
import com.intellij.psi.impl.source.tree.injected.InjectedLanguageUtil;
import com.intellij.psi.search.scope.packageSet.lexer.ScopesLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.ProcessingContext;
import com.intellij.xtext.samples.simple.grammar.SimpleLexer;
import com.intellij.xtext.samples.simple.parser.SimpleParser;
import com.intellij.xtext.samples.simple.psi.SimpleFile;
import com.intellij.xtext.samples.simple.psi.SimpleTokenType;
import com.intellij.xtext.samples.simple.psi.SimpleTypes;
import com.intellij.xtext.samples.simple.psi.impl.SimpleGeneratedParserUtilBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import static com.intellij.lang.parser.GeneratedParserUtilBase.isWhitespaceOrComment;
import static com.intellij.patterns.PlatformPatterns.psiElement;
import static com.intellij.util.containers.ContainerUtil.set;

public class SimpleCompletionContributor extends CompletionContributor {
    public SimpleCompletionContributor() {
        extend(CompletionType.BASIC, psiElement(SimpleTypes.ID).withLanguage(SimpleLanguage.INSTANCE),
                new XtextKeywordCompletionProvider());

    }
    public static ArrayList<String> SimpleKeywords = new ArrayList<String>(Arrays.asList(
            "entity",
            "entity2",
            "extends",
            "property",
            "property2",
            "test"));


    static class XtextKeywordCompletionProvider extends CompletionProvider<CompletionParameters> {
        private static String myPrefix;
        @Override
        protected void addCompletions(@NotNull CompletionParameters parameters,
                                      @NotNull ProcessingContext context,
                                      @NotNull CompletionResultSet result) {
            for (String keyword : getKeywordsUsingErrorReport(parameters.getPosition(), parameters)) {
                result.addElement(createKeywordLookupElement(keyword));
            }
        }
        private static Collection<String> getKeywords(PsiElement position,CompletionParameters parameters) {
            SimpleFile xFile = (SimpleFile)position.getContainingFile();
            String fragment = InjectedLanguageUtil.getUnescapedText(xFile, null, position);
            boolean empty = StringUtil.isEmptyOrSpaces(fragment);
            myPrefix =  position.getText().substring(0,parameters.getPosition().getText().length()-(CompletionInitializationContext.DUMMY_IDENTIFIER.length()-1));
            String text = empty ? CompletionInitializationContext.DUMMY_IDENTIFIER : fragment;
            PsiFile file = PsiFileFactory.getInstance(xFile.getProject()).createFileFromText("entity.simple", SimpleLanguage.INSTANCE, text, true, false);
            int completionOffset = empty ? 0 : fragment.length();
            GeneratedParserUtilBase.CompletionState state = new GeneratedParserUtilBase.CompletionState(completionOffset) {
                @Override
                public boolean prefixMatches(@NotNull PsiBuilder builder, @NotNull String text) {

                    return SimplePrefixMathches(builder,text, myPrefix);

                }

                public boolean SimplePrefixMathches(@NotNull PsiBuilder builder, @NotNull String text, String prefix){
                    if (GeneratedParserUtilBase.ErrorState.get(builder).currentFrame.errorReportedAt != -1 && GeneratedParserUtilBase.ErrorState.get(builder).currentFrame.parentFrame.errorReportedAt != -1 ){
                        return false;
                    }
                    int builderOffset = builder.getCurrentOffset();

                    int diff = offset - builderOffset;
                    int length = text.length();
                    if (diff == 0) {
                        return prefixMatches(prefix, text);
                    }
                    else if (diff > 0 && diff <= length) {

                        return prefixMatches(prefix, text);
                    }
                    else if (diff < 0) {
                        for (int i=-1; ; i--) {
                            IElementType type = builder.rawLookup(i);
                            int tokenStart = builder.rawTokenTypeStart(i);
                            if (isWhitespaceOrComment(builder, type)) {
                                diff = offset - tokenStart;
                            }
                            else if (type != null && tokenStart < offset) {
                                CharSequence fragment = builder.getOriginalText().subSequence(tokenStart, offset);
                                if (prefixMatches(fragment.toString(), text)) {
                                    diff = offset - tokenStart;
                                }
                                break;
                            }
                            else break;
                        }
                        return diff >= 0 && diff < length;
                    }
                    return false;
                }

                @Override
                public boolean prefixMatches(@NotNull String prefix, @NotNull String variant) {

                    return variant.startsWith(prefix);
                }
                @Nullable
                @Override
                public String convertItem(Object o) {
//                    if (o instanceof IElementType[]) return super.convertItem(o);
                    String text = o instanceof SimpleTokenType ? ((SimpleTokenType) o).getDebugName(): null;
                    return text != null && text.length() > 0  ? text : null;
                }
            };
            file.putUserData(GeneratedParserUtilBase.COMPLETION_STATE_KEY, state);
            TreeUtil.ensureParsed(file.getNode());

            return state.items;
        }
        private static Collection<String> getKeywordsUsingErrorReport(PsiElement position,CompletionParameters parameters){
            String myPrefix =  position.getText().substring(0,parameters.getPosition().getText().length()-(CompletionInitializationContext.DUMMY_IDENTIFIER.length()-1));

            SimpleFile xFile = (SimpleFile) position.getContainingFile();
            String fragment = InjectedLanguageUtil.getUnescapedText(xFile, null, position);
            PsiBuilderFactory factory = PsiBuilderFactory.getInstance();
            PsiBuilder psiBuilder = factory.createBuilder(new SimpleParserDefinition(), new SimpleLexer(), fragment);
            SimpleParser parser = new SimpleParser();
            parser.parseLight(position.getContainingFile().getNode().getElementType(), psiBuilder);
            ArrayList<String> strings = new ArrayList<>();
            int i = 0;
            for(SimpleTokenType t : SimpleGeneratedParserUtilBase.ErrorStateExt.expectedKeywords){
                if(SimpleKeywords.contains(t.getDebugName()) && t.getDebugName().startsWith(myPrefix)){
                    strings.add(t.getDebugName());
                }

                i++;
            }
            return strings;
        }
        private static LookupElement createKeywordLookupElement(String keyword) {
            LookupElementBuilder builder = LookupElementBuilder.create(keyword).bold();

            return TailTypeDecorator.withTail(builder.withCaseSensitivity(true), TailType.SPACE);
        }
    }
}