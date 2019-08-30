// This is a generated file. Not intended for manual editing.
package com.intellij.xtext.samples.simple.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.xtext.samples.simple.impl.*;

public interface SimpleTypes {

  IElementType ENTITY = new SimpleElementType("ENTITY");
  IElementType ENTITY_2 = new SimpleElementType("ENTITY_2");
  IElementType PROPERTY = new SimpleElementType("PROPERTY");
  IElementType PROPERTY_2 = new SimpleElementType("PROPERTY_2");
  IElementType REFERENCE_TO_JVM_TYPE_VALID_ID = new SimpleElementType("REFERENCE_TO_JVM_TYPE_VALID_ID");
  IElementType TEST = new SimpleElementType("TEST");
  IElementType VALID_ID = new SimpleElementType("VALID_ID");

  IElementType BRACKET = new SimpleTokenType("BRACKET");
  IElementType COMMA = new SimpleTokenType("COMMA");
  IElementType DOT = new SimpleTokenType("DOT");
  IElementType EXTENDS = new SimpleTokenType("extends");
  IElementType HEX = new SimpleTokenType("HEX");
  IElementType ID = new SimpleTokenType("ID");
  IElementType ID2 = new SimpleTokenType("ID2");
  IElementType INT = new SimpleTokenType("INT");
  IElementType KW_ENTITY = new SimpleTokenType("entity");
  IElementType KW_ENTITY2 = new SimpleTokenType("entity2");
  IElementType KW_PROPERTY = new SimpleTokenType("property");
  IElementType KW_PROPERTY2 = new SimpleTokenType("property2");
  IElementType KW_TEST = new SimpleTokenType("test");
  IElementType ML_COMMENT = new SimpleTokenType("ML_COMMENT");
  IElementType OPERATORS = new SimpleTokenType("OPERATORS");
  IElementType PACKAGE = new SimpleTokenType("package");
  IElementType SEP = new SimpleTokenType("SEP");
  IElementType SL_COMMENT = new SimpleTokenType("SL_COMMENT");
  IElementType STRING = new SimpleTokenType("STRING");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ENTITY) {
        return new SimpleEntityImpl(node);
      }
      else if (type == ENTITY_2) {
        return new SimpleEntity2Impl(node);
      }
      else if (type == PROPERTY) {
        return new SimplePropertyImpl(node);
      }
      else if (type == PROPERTY_2) {
        return new SimpleProperty2Impl(node);
      }
      else if (type == REFERENCE_TO_JVM_TYPE_VALID_ID) {
        return new SimpleREFERENCETOJvmTypeValidIDImpl(node);
      }
      else if (type == TEST) {
        return new SimpleTestImpl(node);
      }
      else if (type == VALID_ID) {
        return new SimpleValidIDImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
