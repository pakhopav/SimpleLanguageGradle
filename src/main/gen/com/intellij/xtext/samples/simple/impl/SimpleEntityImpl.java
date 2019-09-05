// This is a generated file. Not intended for manual editing.
package com.intellij.xtext.samples.simple.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.xtext.samples.simple.psi.*;
import com.intellij.xtext.samples.simple.psi.impl.SimplePsiCompositeElementImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.intellij.xtext.samples.simple.psi.SimpleTypes.*;

public class SimpleEntityImpl extends SimplePsiCompositeElementImpl implements SimpleEntity {

  public SimpleEntityImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitEntity(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SimpleEntity> getEntityList() {
      return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleEntity.class);
  }

    @Override
    @NotNull
    public List<SimpleEntity2> getEntity2List() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleEntity2.class);
  }

  @Override
  @NotNull
  public List<SimpleProp> getPropList() {
      return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleProp.class);
  }

    @Override
    @NotNull
    public List<SimpleProp2> getProp2List() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleProp2.class);
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
  public PsiElement getExtends() {
    return findChildByType(EXTENDS);
  }

    @Override
    @Nullable
    public PsiElement getExtends2() {
        return findChildByType(EXTENDS2);
    }

  @Override
  @NotNull
  public PsiElement getKwEntity() {
    return findNotNullChildByType(KW_ENTITY);
  }

    @Override
    @Nullable
    public PsiElement getLBrace() {
        return findChildByType(L_BRACE);
    }

    @Override
    @NotNull
    public PsiElement getRBrace() {
        return findNotNullChildByType(R_BRACE);
  }

}
