package com.intellij.xtext.samples.simple;


import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class SimpleLexerAdapter extends FlexAdapter {
    public SimpleLexerAdapter() {
        super(new _SimpleLexer((Reader) null));
    }
}