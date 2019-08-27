// This is a generated file. Not intended for manual editing.
package com.intellij.xtext.samples.simple.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class SimpleVisitor extends PsiElementVisitor {

  public void visitEntity(@NotNull SimpleEntity o) {
    visitNamedElement(o);
  }

  public void visitEntity2(@NotNull SimpleEntity2 o) {
    visitNamedElement(o);
  }

  public void visitProperty(@NotNull SimpleProperty o) {
    visitPsiElement(o);
  }

  public void visitProperty2(@NotNull SimpleProperty2 o) {
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

  public void visitNamedElement(@NotNull SimpleNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
