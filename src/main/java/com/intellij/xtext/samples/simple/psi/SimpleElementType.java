package com.intellij.xtext.samples.simple.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.xtext.samples.simple.SimpleLanguage;
import org.jetbrains.annotations.*;

public class SimpleElementType extends IElementType {
    public SimpleElementType(@NotNull @NonNls String debugName) {
        super(debugName, SimpleLanguage.INSTANCE);
    }
}