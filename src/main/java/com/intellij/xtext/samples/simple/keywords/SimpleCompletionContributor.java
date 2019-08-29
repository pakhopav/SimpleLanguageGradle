package com.intellij.xtext.samples.simple.keywords;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.ide.scratch.ScratchFileType;
import com.intellij.xtext.samples.simple.SimpleLanguage;
import com.intellij.xtext.samples.simple.psi.SimpleFile;
import com.intellij.xtext.samples.simple.psi.SimpleTokenType;
import com.intellij.xtext.samples.simple.psi.SimpleTypes;

import static com.intellij.patterns.PlatformPatterns.psiElement;

public class SimpleCompletionContributor extends CompletionContributor {
    public SimpleCompletionContributor() {
        extend(CompletionType.BASIC, psiElement(SimpleTypes.ID).withLanguage(SimpleLanguage.INSTANCE),
                new KeywordCompletionProvider<SimpleFile, SimpleTokenType>(SimpleLanguage.INSTANCE, ScratchFileType.INSTANCE, SimpleTokenType.class));
    }

}