// This is a generated file. Not intended for manual editing.
package com.intellij.xtext.samples.simple.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.xtext.samples.simple.psi.SimpleAbstractEntityRecover;
import com.intellij.xtext.samples.simple.psi.SimpleVisitor;
import com.intellij.xtext.samples.simple.psi.impl.SimplePsiCompositeElementImpl;
import org.jetbrains.annotations.NotNull;

public class SimpleAbstractEntityRecoverImpl extends SimplePsiCompositeElementImpl implements SimpleAbstractEntityRecover {

    public SimpleAbstractEntityRecoverImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull SimpleVisitor visitor) {
        visitor.visitAbstractEntityRecover(this);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof SimpleVisitor) accept((SimpleVisitor) visitor);
        else super.accept(visitor);
    }

}
