// This is a generated file. Not intended for manual editing.
package com.intellij.xtext.samples.simple.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.LightPsiParser;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;

import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import static com.intellij.xtext.samples.simple.psi.SimpleTypes.*;

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

  /* ********************************************************** */
  // Entity | Entity2| Property| Property2 | Test
  static boolean AbstractElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AbstractElement")) return false;
    boolean r;
    r = Entity(b, l + 1);
    if (!r) r = Entity2(b, l + 1);
    if (!r) r = Property(b, l + 1);
    if (!r) r = Property2(b, l + 1);
    if (!r) r = Test(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'entity'  ValidID  (('extends'|'extends2') REFERENCE_TO_JvmType_ValidID  )? "{"
  //     Feature*
  //     "}"
  public static boolean Entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity")) return false;
    if (!nextTokenIs(b, KW_ENTITY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENTITY, null);
    r = consumeToken(b, KW_ENTITY);
    p = r; // pin = 1
    r = r && report_error_(b, ValidID(b, l + 1));
    r = p && report_error_(b, Entity_2(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, "{")) && r;
    r = p && report_error_(b, Entity_4(b, l + 1)) && r;
    r = p && consumeToken(b, "}") && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (('extends'|'extends2') REFERENCE_TO_JvmType_ValidID  )?
  private static boolean Entity_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_2")) return false;
    Entity_2_0(b, l + 1);
    return true;
  }

  // ('extends'|'extends2') REFERENCE_TO_JvmType_ValidID
  private static boolean Entity_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Entity_2_0_0(b, l + 1);
    r = r && REFERENCE_TO_JvmType_ValidID(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'extends'|'extends2'
  private static boolean Entity_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENDS);
    if (!r) r = consumeToken(b, "extends2");
    exit_section_(b, m, null, r);
    return r;
  }

  // Feature*
  private static boolean Entity_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Feature(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Entity_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'entity2'  ValidID  ('extends' REFERENCE_TO_JvmType_ValidID  )? "{"
  //     Feature*
  //     "}"
  public static boolean Entity2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity2")) return false;
    if (!nextTokenIs(b, KW_ENTITY2)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENTITY_2, null);
    r = consumeToken(b, KW_ENTITY2);
    p = r; // pin = 1
    r = r && report_error_(b, ValidID(b, l + 1));
    r = p && report_error_(b, Entity2_2(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, "{")) && r;
    r = p && report_error_(b, Entity2_4(b, l + 1)) && r;
    r = p && consumeToken(b, "}") && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('extends' REFERENCE_TO_JvmType_ValidID  )?
  private static boolean Entity2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity2_2")) return false;
    Entity2_2_0(b, l + 1);
    return true;
  }

  // 'extends' REFERENCE_TO_JvmType_ValidID
  private static boolean Entity2_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity2_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENDS);
    r = r && REFERENCE_TO_JvmType_ValidID(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Feature*
  private static boolean Entity2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Entity2_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Feature(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Entity2_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // Property | Property2
  static boolean Feature(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Feature")) return false;
    if (!nextTokenIs(b, "", KW_PROPERTY, KW_PROPERTY2)) return false;
    boolean r;
    r = Property(b, l + 1);
    if (!r) r = Property2(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // "property" ValidID ':' REFERENCE_TO_JvmType_ValidID
  public static boolean Property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Property")) return false;
    if (!nextTokenIs(b, KW_PROPERTY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY, null);
    r = consumeToken(b, KW_PROPERTY);
    p = r; // pin = 1
    r = r && report_error_(b, ValidID(b, l + 1));
    r = p && report_error_(b, consumeToken(b, ":")) && r;
    r = p && REFERENCE_TO_JvmType_ValidID(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // "property2" ValidID ':' REFERENCE_TO_JvmType_ValidID
  public static boolean Property2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Property2")) return false;
    if (!nextTokenIs(b, KW_PROPERTY2)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY_2, null);
    r = consumeToken(b, KW_PROPERTY2);
    p = r; // pin = 1
    r = r && report_error_(b, ValidID(b, l + 1));
    r = p && report_error_(b, consumeToken(b, ":")) && r;
    r = p && REFERENCE_TO_JvmType_ValidID(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
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
  // 'test' ValidID
  public static boolean Test(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Test")) return false;
    if (!nextTokenIs(b, KW_TEST)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_TEST);
    r = r && ValidID(b, l + 1);
    exit_section_(b, m, TEST, r);
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

}
