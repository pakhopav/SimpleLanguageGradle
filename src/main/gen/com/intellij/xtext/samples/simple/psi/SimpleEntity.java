// This is a generated file. Not intended for manual editing.
package com.intellij.xtext.samples.simple.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

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

  @NotNull
  PsiElement getKwEntity();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

}
