// This is a generated file. Not intended for manual editing.
package com.intellij.xtext.samples.simple.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.xtext.samples.simple.psi.SimpleAbstractPropertyRecover;
import com.intellij.xtext.samples.simple.psi.SimpleVisitor;
import com.intellij.xtext.samples.simple.psi.impl.SimplePsiCompositeElementImpl;
import org.jetbrains.annotations.NotNull;

public class SimpleAbstractPropertyRecoverImpl extends SimplePsiCompositeElementImpl implements SimpleAbstractPropertyRecover {

    public SimpleAbstractPropertyRecoverImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull SimpleVisitor visitor) {
        visitor.visitAbstractPropertyRecover(this);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof SimpleVisitor) accept((SimpleVisitor) visitor);
        else super.accept(visitor);
    }

}
