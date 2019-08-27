package com.intellij.xtext.samples.simple.psi.impl;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.xtext.samples.simple.psi.SimpleTokenType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SimpleGeneratedParserUtilBase extends GeneratedParserUtilBaseCopy {
    public static PsiBuilder adapt_builder_(IElementType root, PsiBuilder builder, PsiParser parser) {
        return adapt_builder_(root, builder, parser, null);
    }
    public static PsiBuilder adapt_builder_(IElementType root, PsiBuilder builder, PsiParser parser, TokenSet[] extendsSets){
        ErrorState state = new ErrorStateExt();
        ErrorState.initState(state, builder, root, extendsSets);
        return new Builder(builder, state, parser);
    }

    public static class ErrorStateExt extends GeneratedParserUtilBaseCopy.ErrorState{
        public static ArrayList<SimpleTokenType> expectedKeywords = new ArrayList<>();
        @Override
        public void appendExpected(@NotNull StringBuilder sb, int position, boolean expected) {
            super.appendExpected(sb, position, expected);
            expectedKeywords.clear();
            MyList<Variant> list = variants;
            for (Variant variant : list){
                if (position == variant.position){
                    if(variant.object instanceof SimpleTokenType){
                        expectedKeywords.add((SimpleTokenType) variant.object);
                    }
                    else if (variant.object instanceof SimpleTokenType){
                        String name = (String) variant.object;
                        name = name.substring(1,name.length()-1).toUpperCase().replace(" ", "_");
                        expectedKeywords.add(SimpleKeywordHolderBase.getKeyword(name)) ;
                    }
                }
            }

        }
    }
}
