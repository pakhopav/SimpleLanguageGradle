// This is a generated file. Not intended for manual editing.
package com.intellij.xtext.samples.simple.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.xtext.samples.simple.psi.SimpleTest;
import com.intellij.xtext.samples.simple.psi.SimpleValidID;
import com.intellij.xtext.samples.simple.psi.SimpleVisitor;
import com.intellij.xtext.samples.simple.psi.impl.SimplePsiCompositeElementImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.intellij.xtext.samples.simple.psi.SimpleTypes.KW_TEST;
import static com.intellij.xtext.samples.simple.psi.SimpleTypes.SEMICOLON;

public class SimpleTestImpl extends SimplePsiCompositeElementImpl implements SimpleTest {

  public SimpleTestImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitTest(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimpleValidID getValidID() {
      return findChildByClass(SimpleValidID.class);
  }

  @Override
  @NotNull
  public PsiElement getKwTest() {
    return findNotNullChildByType(KW_TEST);
  }

    @Override
    @NotNull
    public PsiElement getSemicolon() {
        return findNotNullChildByType(SEMICOLON);
    }

}
