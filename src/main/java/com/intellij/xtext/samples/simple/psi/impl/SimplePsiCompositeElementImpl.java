package com.intellij.xtext.samples.simple.psi.impl;
import java.util.List;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.intellij.util.IncorrectOperationException;
import com.intellij.xtext.samples.simple.psi.SimpleNamedElement;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.extapi.psi.ASTWrapperPsiElement;

public class SimplePsiCompositeElementImpl extends ASTWrapperPsiElement  {

    public PsiElement referenceTo;

    public SimplePsiCompositeElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @NotNull
    @Override
    public PsiReference[] getReferences() {
        return ReferenceProvidersRegistry.getReferencesFromProviders(this);
    }



}
