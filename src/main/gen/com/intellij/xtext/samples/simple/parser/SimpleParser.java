// This is a generated file. Not intended for manual editing.
package com.intellij.xtext.samples.simple.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.LightPsiParser;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;

import static com.intellij.xtext.samples.simple.psi.SimpleTypes.*;
import static com.intellij.xtext.samples.simple.psi.impl.simpleParserUtil.GeneratedParserUtilBaseCopy.*;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SimpleParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return simpleFile(b, l + 1);
  }

  static final Parser abstract_entity_recover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return abstract_entity_recover(b, l + 1);
    }
  };
  static final Parser abstract_property_recover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return abstract_property_recover(b, l + 1);
    }
  };

  /* ********************************************************** */
  // 'property' ValidID ':' REFERENCE_TO_JvmType_ValidID
  static boolean AbstactProperty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AbstactProperty")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, PROPERTY);
    p = r; // pin = 1
    r = r && report_error_(b, ValidID(b, l + 1));
    r = p && report_error_(b, consumeToken(b, COLON)) && r;
    r = p && REFERENCE_TO_JvmType_ValidID(b, l + 1) && r;
    exit_section_(b, l, m, r, p, abstract_property_recover_parser_);
    return r || p;
  }

  /* ********************************************************** */
  // 'property2' ValidID ':' REFERENCE_TO_JvmType_ValidID
  static boolean AbstactProperty2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AbstactProperty2")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, PROPERTY2);
    p = r; // pin = 1
    r = r && report_error_(b, ValidID(b, l + 1));
    r = p && report_error_(b, consumeToken(b, COLON)) && r;
    r = p && REFERENCE_TO_JvmType_ValidID(b, l + 1) && r;
    exit_section_(b, l, m, r, p, abstract_property_recover_parser_);
    return r || p;
  }

  /* ********************************************************** */
  // Entity | Entity2| Prop | Prop2 | Test
  static boolean AbstractElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AbstractElement")) return false;
    boolean r;
    r = Entity(b, l + 1);
    if (!r) r = Entity2(b, l + 1);
    if (!r) r = Prop(b, l + 1);
    if (!r) r = Prop2(b, l + 1);
    if (!r) r = Test(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'entity'  ValidID  (('extends'|'extends2') REFERENCE_TO_JvmType_ValidID  )? "{"
  //                     Feature*
  static boolean AbstractEntity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AbstractEntity")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, KW_ENTITY);
    p = r; // pin = 1
    r = r && report_error_(b, ValidID(b, l + 1));
    r = p && report_error_(b, AbstractEntity_2(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, L_BRACE)) && r;
    r = p && AbstractEntity_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, abstract_entity_recover_parser_);
    return r || p;
  }

  // (('extends'|'extends2') REFERENCE_TO_JvmType_ValidID  )?
  private static boolean AbstractEntity_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AbstractEntity_2")) return false;
    AbstractEntity_2_0(b, l + 1);
    return true;
  }

  // ('extends'|'extends2') REFERENCE_TO_JvmType_ValidID
  private static boolean AbstractEntity_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AbstractEntity_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AbstractEntity_2_0_0(b, l + 1);
    r = r && REFERENCE_TO_JvmType_ValidID(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'extends'|'extends2'
  private static boolean AbstractEntity_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AbstractEntity_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENDS);
    if (!r) r = consumeToken(b, EXTENDS2);
    exit_section_(b, m, null, r);
    return r;
  }

  // Feature*
  private static boolean AbstractEntity_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AbstractEntity_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Feature(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "AbstractEntity_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'entity2'  ValidID  (('extends'|'extends2') REFERENCE_TO_JvmType_ValidID  )? "{"
  //                     Feature*
  static boolean AbstractEntity2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AbstractEntity2")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, KW_ENTITY2);
    p = r; // pin = 1
    r = r && report_error_(b, ValidID(b, l + 1));
    r = p && report_error_(b, AbstractEntity2_2(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, L_BRACE)) && r;
    r = p && AbstractEntity2_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, abstract_entity_recover_parser_);
    return r || p;
  }

  // (('extends'|'extends2') REFERENCE_TO_JvmType_ValidID  )?
  private static boolean AbstractEntity2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AbstractEntity2_2")) return false;
    AbstractEntity2_2_0(b, l + 1);
    return true;
  }

  // ('extends'|'extends2') REFERENCE_TO_JvmType_ValidID
  private static boolean AbstractEntity2_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AbstractEntity2_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AbstractEntity2_2_0_0(b, l + 1);
    r = r && REFERENCE_TO_JvmType_ValidID(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'extends'|'extends2'
  private static boolean AbstractEntity2_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AbstractEntity2_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENDS);
    if (!r) r = consumeToken(b, EXTENDS2);
    exit_section_(b, m, null, r);
    return r;
  }

  // Feature*
  private static boolean AbstractEntity2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AbstractEntity2_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Feature(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "AbstractEntity2_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'test' ValidID
  static boolean AbstractTest(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AbstractTest")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, KW_TEST);
    p = r; // pin = 1
    r = r && ValidID(b, l + 1);
    exit_section_(b, l, m, r, p, abstract_property_recover_parser_);
    return r || p;
  }

  /* ********************************************************** */
  // AbstractEntity '}'
  public static boolean Entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity")) return false;
    if (!nextTokenIs(b, KW_ENTITY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AbstractEntity(b, l + 1);
    r = r && consumeToken(b, R_BRACE);
    exit_section_(b, m, ENTITY, r);
    return r;
  }

  /* ********************************************************** */
  // AbstractEntity2 '}'
  public static boolean Entity2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity2")) return false;
    if (!nextTokenIs(b, KW_ENTITY2)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AbstractEntity2(b, l + 1);
    r = r && consumeToken(b, R_BRACE);
    exit_section_(b, m, ENTITY_2, r);
    return r;
  }

  /* ********************************************************** */
  // Prop | Prop2 | Entity |Entity2
  static boolean Feature(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Feature")) return false;
    boolean r;
    r = Prop(b, l + 1);
    if (!r) r = Prop2(b, l + 1);
    if (!r) r = Entity(b, l + 1);
    if (!r) r = Entity2(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ValidID
  public static boolean REFERENCE_TO_JvmType_ValidID(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "REFERENCE_TO_JvmType_ValidID")) return false;
    if (!nextTokenIs(b, "<reference to jvm type valid id>", ID, ID2)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REFERENCE_TO_JVM_TYPE_VALID_ID, "<reference to jvm type valid id>");
    r = ValidID(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // AbstactProperty ';'
  public static boolean Prop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Prop")) return false;
    if (!nextTokenIs(b, PROPERTY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AbstactProperty(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, PROP, r);
    return r;
  }

  /* ********************************************************** */
  // ID | ID2
  public static boolean ValidID(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ValidID")) return false;
    if (!nextTokenIs(b, "<valid id>", ID, ID2)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALID_ID, "<valid id>");
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, ID2);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // AbstactProperty2 ';'
  public static boolean Prop2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Prop2")) return false;
    if (!nextTokenIs(b, PROPERTY2)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AbstactProperty2(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, PROP_2, r);
    return r;
  }

  /* ********************************************************** */
  // AbstractTest ';'
  public static boolean Test(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Test")) return false;
    if (!nextTokenIs(b, KW_TEST)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AbstractTest(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, TEST, r);
    return r;
  }

  /* ********************************************************** */
  // AbstractElement*
  static boolean simpleFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!AbstractElement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simpleFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // !('}')
  public static boolean abstract_entity_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "abstract_entity_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, ABSTRACT_ENTITY_RECOVER, "<abstract entity recover>");
    r = !consumeToken(b, R_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !(';')
  public static boolean abstract_property_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "abstract_property_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, ABSTRACT_PROPERTY_RECOVER, "<abstract property recover>");
    r = !consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }
}
