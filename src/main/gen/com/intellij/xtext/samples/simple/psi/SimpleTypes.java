// This is a generated file. Not intended for manual editing.
package com.intellij.xtext.samples.simple.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.xtext.samples.simple.impl.*;

public interface SimpleTypes {

    IElementType ABSTRACT_ENTITY_RECOVER = new SimpleElementType("ABSTRACT_ENTITY_RECOVER");
    IElementType ABSTRACT_PROPERTY_RECOVER = new SimpleElementType("ABSTRACT_PROPERTY_RECOVER");
  IElementType ENTITY = new SimpleElementType("ENTITY");
  IElementType ENTITY_2 = new SimpleElementType("ENTITY_2");
    IElementType PROP = new SimpleElementType("PROP");
    IElementType PROP_2 = new SimpleElementType("PROP_2");
  IElementType REFERENCE_TO_JVM_TYPE_VALID_ID = new SimpleElementType("REFERENCE_TO_JVM_TYPE_VALID_ID");
  IElementType TEST = new SimpleElementType("TEST");
  IElementType VALID_ID = new SimpleElementType("VALID_ID");

  IElementType BRACKET = new SimpleTokenType("BRACKET");
    IElementType COLON = new SimpleTokenType(":");
  IElementType COMMA = new SimpleTokenType("COMMA");
  IElementType DOT = new SimpleTokenType("DOT");
  IElementType EXTENDS = new SimpleTokenType("extends");
    IElementType EXTENDS2 = new SimpleTokenType("extends2");
  IElementType HEX = new SimpleTokenType("HEX");
  IElementType ID = new SimpleTokenType("ID");
  IElementType ID2 = new SimpleTokenType("ID2");
  IElementType INT = new SimpleTokenType("INT");
  IElementType KW_ENTITY = new SimpleTokenType("entity");
  IElementType KW_ENTITY2 = new SimpleTokenType("entity2");
  IElementType KW_TEST = new SimpleTokenType("test");
    IElementType L_BRACE = new SimpleTokenType("{");
  IElementType ML_COMMENT = new SimpleTokenType("ML_COMMENT");
  IElementType OPERATORS = new SimpleTokenType("OPERATORS");
  IElementType PACKAGE = new SimpleTokenType("package");
    IElementType PROPERTY = new SimpleTokenType("property");
    IElementType PROPERTY2 = new SimpleTokenType("property2");
    IElementType R_BRACE = new SimpleTokenType("}");
    IElementType SEMICOLON = new SimpleTokenType(";");
  IElementType SEP = new SimpleTokenType("SEP");
  IElementType SL_COMMENT = new SimpleTokenType("SL_COMMENT");
  IElementType STRING = new SimpleTokenType("STRING");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
        if (type == ABSTRACT_ENTITY_RECOVER) {
            return new SimpleAbstractEntityRecoverImpl(node);
        } else if (type == ABSTRACT_PROPERTY_RECOVER) {
            return new SimpleAbstractPropertyRecoverImpl(node);
        } else if (type == ENTITY) {
        return new SimpleEntityImpl(node);
      }
      else if (type == ENTITY_2) {
        return new SimpleEntity2Impl(node);
      } else if (type == PROP) {
            return new SimplePropImpl(node);
      } else if (type == PROP_2) {
            return new SimpleProp2Impl(node);
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
