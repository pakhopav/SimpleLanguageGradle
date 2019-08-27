package com.intellij.xtext.samples.simple.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.*;
import com.intellij.xtext.samples.simple.psi.SimpleElementFactory;
import com.intellij.xtext.samples.simple.psi.*;

import java.util.Optional;

public class SimplePsiImplUtil {
//ENTITY 1
    public static PsiElement getNameIdentifier(SimpleEntity element) {

        return  element.getValidID();
    }

    public static PsiElement setName(SimpleEntity element, String newName) {
        PsiElement oldName = getNameIdentifier(element);
        if (oldName != null) {
            SimpleValidID newNamePsi = (SimpleValidID) SimpleElementFactory.createValidID(newName);
            oldName.getParent().getNode().replaceChild(oldName.getNode(), newNamePsi.getNode());

        }
        return element;
    }

    public static String getName(SimpleEntity element) {
        return Optional.ofNullable(getNameIdentifier(element))
                .map(PsiElement::getText)
                .orElse(null);


    }
//ENITY 2
    public static PsiElement getNameIdentifier(SimpleEntity2 element) {

        return  element.getValidID();
    }

    public static PsiElement setName(SimpleEntity2 element, String newName) {
        PsiElement oldName = getNameIdentifier(element);
        if (oldName != null) {
            SimpleValidID newNamePsi = (SimpleValidID) SimpleElementFactory.createValidID(newName);
            oldName.getParent().getNode().replaceChild(oldName.getNode(), newNamePsi.getNode());

        }
        return element;
    }
    public static String getName(SimpleEntity2 element) {
        return Optional.ofNullable(getNameIdentifier(element))
                .map(PsiElement::getText)
                .orElse(null);


    }
}