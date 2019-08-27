package com.intellij.xtext.samples.simple.psi;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilderFactory;
import com.intellij.openapi.application.ReadAction;
import com. intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.search.scope.packageSet.lexer.ScopesLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.xtext.samples.simple.SimpleFileType;
import com.intellij.xtext.samples.simple.SimpleParserDefinition;
import com.intellij.xtext.samples.simple.parser.SimpleParser;
import com.intellij.xtext.samples.simple.psi.SimpleEntity;

public class SimpleElementFactory {

    public static <T> T parseFromString(String text, IElementType type, Class<T> expectedClass) {
        PsiBuilderFactory factory = PsiBuilderFactory.getInstance();
        PsiBuilder psiBuilder = factory.createBuilder(new SimpleParserDefinition(), new ScopesLexer(), text);
        SimpleParser parser = new SimpleParser();
        parser.parseLight(type, psiBuilder);
        ASTNode astNode = ReadAction.compute(psiBuilder::getTreeBuilt);
        PsiElement psiResult = SimpleTypes.Factory.createElement(astNode);
        if (PsiTreeUtil.hasErrorElements(psiResult)) {
            return null;
        }
        return expectedClass.isInstance(psiResult) ? expectedClass.cast(psiResult) : null;
    }

    public static PsiElement createValidID(String name) {
        SimpleREFERENCETOJvmTypeValidID ruleId =
                parseFromString(name, SimpleTypes.REFERENCE_TO_JVM_TYPE_VALID_ID, SimpleREFERENCETOJvmTypeValidID.class);
        if (ruleId == null) {
            throw new IllegalStateException("Can't parse to RULE_IDENTIFIER declaration: " + name);
        }
        return ruleId.getValidID();
    }
}