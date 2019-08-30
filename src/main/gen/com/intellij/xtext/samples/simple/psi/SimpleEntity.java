// This is a generated file. Not intended for manual editing.
package com.intellij.xtext.samples.simple.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface SimpleEntity extends SimpleNamedElement {

  @NotNull
  List<SimpleProperty> getPropertyList();

  @NotNull
  List<SimpleProperty2> getProperty2List();

  @Nullable
  SimpleREFERENCETOJvmTypeValidID getREFERENCETOJvmTypeValidID();

  @Nullable
  SimpleValidID getValidID();

  @Nullable
  PsiElement getExtends();

    @Nullable
    PsiElement getExtends2();

  @NotNull
  PsiElement getKwEntity();

    @Nullable
    PsiElement getLBrace();

    @Nullable
    PsiElement getRBrace();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

}
