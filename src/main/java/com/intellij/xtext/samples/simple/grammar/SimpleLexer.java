package com.intellij.xtext.samples.simple.grammar;

import com.intellij.lexer.FlexAdapter;
import com.intellij.xtext.samples.simple._SimpleLexer;

public class SimpleLexer extends FlexAdapter {


    public SimpleLexer() {
        super(new _SimpleLexer());
    }
}