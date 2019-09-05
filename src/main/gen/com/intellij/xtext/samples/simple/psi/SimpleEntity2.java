// This is a generated file. Not intended for manual editing.
package com.intellij.xtext.samples.simple.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface SimpleEntity2 extends PsiElement {

    @NotNull
    List<SimpleEntity> getEntityList();

  @NotNull
  List<SimpleEntity2> getEntity2List();

  @NotNull
  List<SimpleProp> getPropList();

    @NotNull
    List<SimpleProp2> getProp2List();

  @Nullable
  SimpleREFERENCETOJvmTypeValidID getREFERENCETOJvmTypeValidID();

  @Nullable
  SimpleValidID getValidID();

  @Nullable
  PsiElement getExtends();

    @Nullable
    PsiElement getExtends2();

  @NotNull
  PsiElement getKwEntity2();

    @Nullable
    PsiElement getLBrace();

    @NotNull
    PsiElement getRBrace();

}
