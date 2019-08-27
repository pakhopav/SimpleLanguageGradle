/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package com.intellij.xtext.samples.simple;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;import com.intellij.xtext.samples.simple.psi.SimpleTypes;

import static com.intellij.psi.TokenType.BAD_CHARACTER; // Pre-defined bad character token.
import static com.intellij.psi.TokenType.WHITE_SPACE; // Pre-defined whitespace character token.
import static com.intellij.xtext.samples.simple.psi.SimpleTypes.*; // Note that is the class which is specified as `elementTypeHolderClass`
// in bnf grammar file. This will contain all other tokens which we will use.


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>Simple.flex</tt>
 */
public class _SimpleLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [9, 6, 6]
   * Total runtime size is 1568 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>12]|((ch>>6)&0x3f)]<<6)|(ch&0x3f)];
  }

  /* The ZZ_CMAP_Z table has 272 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\100\1\200\u010d\100");

  /* The ZZ_CMAP_Y table has 192 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\175\3\1\4\77\3");

  /* The ZZ_CMAP_A table has 320 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\17\1\7\2\10\1\7\22\0\1\17\1\20\1\5\1\20\1\2\2\0\1\12\2\0\2\15\1\14"+
    "\1\15\1\13\1\15\2\3\1\30\7\3\1\16\1\0\1\4\1\0\1\4\2\0\32\2\1\4\1\6\1\4\1\1"+
    "\1\2\1\0\1\33\2\2\1\37\1\22\1\2\1\35\1\2\1\32\1\2\1\34\2\2\1\31\1\26\1\24"+
    "\1\2\1\25\1\23\1\21\3\2\1\36\1\27\1\2\1\4\1\0\1\4\7\0\1\11\242\0\2\11\26\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\2\1\1\2\1\3\1\4\1\1\1\5\1\1"+
    "\1\6\1\7\1\10\1\11\1\12\3\2\1\0\1\13"+
    "\3\0\12\2\1\14\10\2\1\15\2\2\1\16\1\17"+
    "\1\20\1\2\1\21\1\22";

  private static int [] zzUnpackAction() {
    int [] result = new int[50];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\40\0\100\0\140\0\200\0\40\0\240\0\300"+
    "\0\340\0\40\0\40\0\40\0\40\0\u0100\0\u0120\0\u0140"+
    "\0\u0160\0\240\0\40\0\u0180\0\340\0\u01a0\0\u01c0\0\u01e0"+
    "\0\u0200\0\u0220\0\u0240\0\u0260\0\u0280\0\u02a0\0\u02c0\0\u02e0"+
    "\0\140\0\u0300\0\u0320\0\u0340\0\u0360\0\u0380\0\u03a0\0\u03c0"+
    "\0\u03e0\0\u0400\0\u0420\0\u0440\0\140\0\140\0\140\0\u0460"+
    "\0\u0480\0\140";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[50];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\2\2\10"+
    "\1\2\1\11\1\12\1\13\1\14\1\15\1\10\1\16"+
    "\1\17\1\20\1\4\1\21\3\4\1\5\7\4\42\0"+
    "\1\4\16\0\7\4\1\0\7\4\2\0\2\4\15\0"+
    "\17\4\3\0\1\5\24\0\1\5\7\0\5\22\1\23"+
    "\1\24\31\22\7\0\2\10\6\0\1\10\20\0\6\25"+
    "\1\26\3\25\1\23\25\25\7\16\1\0\30\16\2\0"+
    "\2\4\15\0\1\4\1\27\15\4\2\0\2\4\15\0"+
    "\10\4\1\30\4\4\1\31\1\4\2\0\2\4\15\0"+
    "\4\4\1\32\5\4\1\33\4\4\7\22\3\0\26\22"+
    "\7\25\3\0\26\25\2\0\2\4\15\0\2\4\1\34"+
    "\14\4\2\0\2\4\15\0\1\35\16\4\2\0\2\4"+
    "\15\0\1\36\16\4\2\0\2\4\15\0\5\4\1\37"+
    "\11\4\2\0\2\4\15\0\13\4\1\40\3\4\2\0"+
    "\2\4\15\0\1\41\16\4\2\0\2\4\15\0\11\4"+
    "\1\42\5\4\2\0\2\4\15\0\1\4\1\43\15\4"+
    "\2\0\2\4\15\0\3\4\1\44\13\4\2\0\2\4"+
    "\15\0\12\4\1\45\4\4\2\0\2\4\15\0\1\46"+
    "\16\4\2\0\2\4\15\0\10\4\1\47\6\4\2\0"+
    "\2\4\15\0\1\4\1\50\15\4\2\0\2\4\15\0"+
    "\14\4\1\51\2\4\2\0\2\4\15\0\6\4\1\52"+
    "\10\4\2\0\2\4\15\0\16\4\1\53\2\0\2\4"+
    "\15\0\4\4\1\54\12\4\2\0\2\4\15\0\1\4"+
    "\1\55\15\4\2\0\2\4\15\0\7\4\1\56\7\4"+
    "\2\0\2\4\15\0\2\4\1\57\14\4\2\0\2\4"+
    "\15\0\1\60\16\4\2\0\2\4\15\0\6\4\1\61"+
    "\10\4\2\0\2\4\15\0\7\4\1\62\7\4";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1184];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\3\1\1\11\3\1\4\11\4\1\1\0"+
    "\1\11\3\0\34\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[50];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
public _SimpleLexer(){
   this((java.io.Reader)null);
 }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _SimpleLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return BAD_CHARACTER;
            } 
            // fall through
          case 19: break;
          case 2: 
            { return ID;
            } 
            // fall through
          case 20: break;
          case 3: 
            { return INT;
            } 
            // fall through
          case 21: break;
          case 4: 
            { return BRACKET;
            } 
            // fall through
          case 22: break;
          case 5: 
            { return WHITE_SPACE;
            } 
            // fall through
          case 23: break;
          case 6: 
            { return DOT;
            } 
            // fall through
          case 24: break;
          case 7: 
            { return COMMA;
            } 
            // fall through
          case 25: break;
          case 8: 
            { return OPERATORS;
            } 
            // fall through
          case 26: break;
          case 9: 
            { return SEP;
            } 
            // fall through
          case 27: break;
          case 10: 
            { return SL_COMMENT;
            } 
            // fall through
          case 28: break;
          case 11: 
            { return STRING;
            } 
            // fall through
          case 29: break;
          case 12: 
            { return KW_TEST;
            } 
            // fall through
          case 30: break;
          case 13: 
            { return KW_ENTITY;
            } 
            // fall through
          case 31: break;
          case 14: 
            { return PACKAGE;
            } 
            // fall through
          case 32: break;
          case 15: 
            { return KW_ENTITY2;
            } 
            // fall through
          case 33: break;
          case 16: 
            { return EXTENDS;
            } 
            // fall through
          case 34: break;
          case 17: 
            { return KW_PROPERTY;
            } 
            // fall through
          case 35: break;
          case 18: 
            { return KW_PROPERTY2;
            } 
            // fall through
          case 36: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}