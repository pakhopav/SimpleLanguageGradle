package com.intellij.xtext.samples.simple.psi;


import com.intellij.psi.tree.IElementType;
import com.intellij.xtext.samples.simple.SimpleLanguage;
import org.jetbrains.annotations.*;

public class SimpleTokenType extends IElementType {
    private String MyDebugName;
    public SimpleTokenType(@NotNull @NonNls String debugName) {
        super(debugName, SimpleLanguage.INSTANCE);
        MyDebugName = debugName;
    }

    public String getDebugName(){
        return MyDebugName;
    }
    @Override
    public String toString() {
        return "SimpleTokenType." + super.toString();
    }
}