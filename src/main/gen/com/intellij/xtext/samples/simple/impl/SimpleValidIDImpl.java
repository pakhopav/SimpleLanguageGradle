// This is a generated file. Not intended for manual editing.
package com.intellij.xtext.samples.simple.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.xtext.samples.simple.psi.SimpleValidID;
import com.intellij.xtext.samples.simple.psi.SimpleVisitor;
import com.intellij.xtext.samples.simple.psi.impl.SimplePsiCompositeElementImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.intellij.xtext.samples.simple.psi.SimpleTypes.ID;
import static com.intellij.xtext.samples.simple.psi.SimpleTypes.ID2;

public class SimpleValidIDImpl extends SimplePsiCompositeElementImpl implements SimpleValidID {

  public SimpleValidIDImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitValidID(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getId() {
    return findChildByType(ID);
  }

  @Override
  @Nullable
  public PsiElement getId2() {
    return findChildByType(ID2);
  }

}
