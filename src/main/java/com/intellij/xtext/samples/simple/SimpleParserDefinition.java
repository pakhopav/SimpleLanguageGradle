package com.intellij.xtext.samples.simple;


import com.intellij.lang.*;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.tree.*;
import com.intellij.xtext.samples.simple.psi.SimpleFile;
import com.intellij.xtext.samples.simple.parser.SimpleParser;
import com.intellij.xtext.samples.simple.psi.*;
import org.jetbrains.annotations.NotNull;

public class SimpleParserDefinition implements ParserDefinition {
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(SimpleTypes.SL_COMMENT);
    public static final TokenSet KEYWORDS = TokenSet.create(
            SimpleTypes.KW_ENTITY,
            SimpleTypes.KW_ENTITY2,
            SimpleTypes.KW_PROPERTY,
            SimpleTypes.KW_PROPERTY2,
            SimpleTypes.KW_TEST,
            SimpleTypes.EXTENDS);

    public static final IFileElementType FILE = new IFileElementType(SimpleLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new SimpleLexerAdapter();
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        return new SimpleParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    public PsiFile createFile(FileViewProvider viewProvider) {
        return new SimpleFile(viewProvider);
    }

    public SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    public PsiElement createElement(ASTNode node) {
        return SimpleTypes.Factory.createElement(node);
    }
}