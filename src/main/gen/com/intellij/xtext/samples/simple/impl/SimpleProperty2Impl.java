// This is a generated file. Not intended for manual editing.
package com.intellij.xtext.samples.simple.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.xtext.samples.simple.psi.SimpleProperty2;
import com.intellij.xtext.samples.simple.psi.SimpleREFERENCETOJvmTypeValidID;
import com.intellij.xtext.samples.simple.psi.SimpleValidID;
import com.intellij.xtext.samples.simple.psi.SimpleVisitor;
import com.intellij.xtext.samples.simple.psi.impl.SimplePsiCompositeElementImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.intellij.xtext.samples.simple.psi.SimpleTypes.COLON;
import static com.intellij.xtext.samples.simple.psi.SimpleTypes.KW_PROPERTY2;

public class SimpleProperty2Impl extends SimplePsiCompositeElementImpl implements SimpleProperty2 {

  public SimpleProperty2Impl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitProperty2(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimpleREFERENCETOJvmTypeValidID getREFERENCETOJvmTypeValidID() {
    return findChildByClass(SimpleREFERENCETOJvmTypeValidID.class);
  }

  @Override
  @Nullable
  public SimpleValidID getValidID() {
    return findChildByClass(SimpleValidID.class);
  }

    @Override
    @Nullable
    public PsiElement getColon() {
        return findChildByType(COLON);
    }

  @Override
  @NotNull
  public PsiElement getKwProperty2() {
    return findNotNullChildByType(KW_PROPERTY2);
  }

}
