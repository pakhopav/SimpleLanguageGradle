// This is a generated file. Not intended for manual editing.
package com.intellij.xtext.samples.simple.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

public class SimpleVisitor extends PsiElementVisitor {

  public void visitEntity(@NotNull SimpleEntity o) {
      visitPsiElement(o);
  }

  public void visitEntity2(@NotNull SimpleEntity2 o) {
    visitPsiElement(o);
  }

    public void visitProp(@NotNull SimpleProp o) {
        visitPsiElement(o);
    }

    public void visitProp2(@NotNull SimpleProp2 o) {
    visitPsiElement(o);
  }

  public void visitREFERENCETOJvmTypeValidID(@NotNull SimpleREFERENCETOJvmTypeValidID o) {
    visitPsiElement(o);
  }

  public void visitTest(@NotNull SimpleTest o) {
    visitPsiElement(o);
  }

  public void visitValidID(@NotNull SimpleValidID o) {
    visitPsiElement(o);
  }

    public void visitAbstractEntityRecover(@NotNull SimpleAbstractEntityRecover o) {
        visitPsiElement(o);
    }

    public void visitAbstractPropertyRecover(@NotNull SimpleAbstractPropertyRecover o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
