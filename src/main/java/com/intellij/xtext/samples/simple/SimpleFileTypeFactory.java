package com.intellij.xtext.samples.simple;

import com.intellij.openapi.fileTypes.*;
import org.jetbrains.annotations.NotNull;

public class SimpleFileTypeFactory extends FileTypeFactory {


//    public SimpleFileTypeFactory(){
//        System.out.println("as");
//    }
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(SimpleFileType.INSTANCE, "simple");
    }
}