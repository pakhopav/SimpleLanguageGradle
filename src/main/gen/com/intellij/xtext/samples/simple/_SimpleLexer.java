/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package com.intellij.xtext.samples.simple;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.intellij.xtext.samples.simple.psi.SimpleTypes.*;
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
          "\11\0\1\15\1\6\2\7\1\6\22\0\1\15\1\16\1\4\1\16\1\2\2\0\1\11\2\0\2\14\1\13" +
                  "\1\14\1\12\1\14\2\3\1\32\7\3\1\17\1\22\5\0\32\2\1\0\1\5\1\0\1\1\1\2\1\0\1" +
                  "\35\2\2\1\41\1\24\1\2\1\37\1\2\1\34\1\2\1\36\2\2\1\33\1\30\1\26\1\2\1\27\1" +
                  "\25\1\23\3\2\1\40\1\31\1\2\1\20\1\0\1\21\7\0\1\10\242\0\2\10\26\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
          "\1\0\2\1\1\2\1\3\1\1\1\4\1\1\1\5" +
                  "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\3\2" +
                  "\1\0\1\15\3\0\12\2\1\16\10\2\1\17\2\2" +
                  "\1\20\1\21\1\22\1\2\1\23\1\24\1\25";
    private static final String ZZ_ROWMAP_PACKED_0 =
            "\0\0\0\42\0\104\0\146\0\210\0\252\0\314\0\356" +
                    "\0\42\0\42\0\42\0\u0110\0\42\0\42\0\42\0\42" +
                    "\0\u0132\0\u0154\0\u0176\0\252\0\42\0\u0198\0\356\0\u01ba" +
                    "\0\u01dc\0\u01fe\0\u0220\0\u0242\0\u0264\0\u0286\0\u02a8\0\u02ca" +
                    "\0\u02ec\0\u030e\0\146\0\u0330\0\u0352\0\u0374\0\u0396\0\u03b8" +
                    "\0\u03da\0\u03fc\0\u041e\0\u0440\0\u0462\0\u0484\0\146\0\146" +
                    "\0\u04a6\0\u04c8\0\146\0\u04ea\0\146";

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
    private static final String ZZ_TRANS_PACKED_0 =
            "\1\2\1\3\1\4\1\5\1\6\1\2\2\7\1\2" +
                    "\1\10\1\11\1\12\1\13\1\7\1\14\1\15\1\16" +
                    "\1\17\1\20\1\21\1\22\1\4\1\23\3\4\1\5" +
                    "\7\4\44\0\1\4\20\0\7\4\1\0\7\4\2\0" +
                    "\2\4\17\0\17\4\3\0\1\5\26\0\1\5\7\0" +
                    "\4\24\1\25\1\26\34\24\6\0\2\7\5\0\1\7" +
                    "\24\0\5\27\1\30\3\27\1\25\30\27\6\14\1\0" +
                    "\33\14\2\0\2\4\17\0\1\4\1\31\15\4\2\0" +
                    "\2\4\17\0\10\4\1\32\4\4\1\33\1\4\2\0" +
                    "\2\4\17\0\4\4\1\34\5\4\1\35\4\4\6\24" +
                    "\3\0\31\24\6\27\3\0\31\27\2\0\2\4\17\0" +
                    "\2\4\1\36\14\4\2\0\2\4\17\0\1\37\16\4" +
                    "\2\0\2\4\17\0\1\40\16\4\2\0\2\4\17\0" +
                    "\5\4\1\41\11\4\2\0\2\4\17\0\13\4\1\42" +
                    "\3\4\2\0\2\4\17\0\1\43\16\4\2\0\2\4" +
                    "\17\0\11\4\1\44\5\4\2\0\2\4\17\0\1\4" +
                    "\1\45\15\4\2\0\2\4\17\0\3\4\1\46\13\4" +
                    "\2\0\2\4\17\0\12\4\1\47\4\4\2\0\2\4" +
                    "\17\0\1\50\16\4\2\0\2\4\17\0\10\4\1\51" +
                    "\6\4\2\0\2\4\17\0\1\4\1\52\15\4\2\0" +
                    "\2\4\17\0\14\4\1\53\2\4\2\0\2\4\17\0" +
                    "\6\4\1\54\10\4\2\0\2\4\17\0\16\4\1\55" +
                    "\2\0\2\4\17\0\4\4\1\56\12\4\2\0\2\4" +
                    "\17\0\1\4\1\57\15\4\2\0\2\4\17\0\7\4" +
                    "\1\60\7\4\2\0\2\4\17\0\2\4\1\61\14\4" +
                    "\2\0\2\4\17\0\1\62\16\4\2\0\2\4\17\0" +
                    "\7\4\1\63\7\4\2\0\2\4\17\0\6\4\1\64" +
                    "\10\4\2\0\2\4\17\0\7\4\1\65\7\4";
    private static final String ZZ_ATTRIBUTE_PACKED_0 =
            "\1\0\1\11\6\1\3\11\1\1\4\11\3\1\1\0" +
                    "\1\11\3\0\35\1";

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

    private static int[] zzUnpackAction() {
        int[] result = new int[53];
    int offset = 0;
        offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
        return result;
    }

    private static int[] zzUnpackRowMap() {
        int[] result = new int[53];
        int offset = 0;
        offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
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

    private static int[] zzUnpackTrans() {
        int[] result = new int[1292];
        int offset = 0;
        offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
        return result;
    }

  private static int [] zzUnpackAttribute() {
      int[] result = new int[53];
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
            case 22:
                break;
          case 2: 
            { return ID;
            } 
            // fall through
            case 23:
                break;
          case 3: 
            { return INT;
            } 
            // fall through
            case 24:
                break;
          case 4: 
            { return WHITE_SPACE;
            } 
            // fall through
            case 25:
                break;
            case 5:
            { return DOT;
            } 
            // fall through
            case 26:
                break;
            case 6:
            { return COMMA;
            } 
            // fall through
            case 27:
                break;
            case 7:
            { return OPERATORS;
            } 
            // fall through
          case 28: break;
            case 8: {
                return SL_COMMENT;
            } 
            // fall through
          case 29: break;
            case 9: {
                return COLON;
            } 
            // fall through
          case 30: break;
            case 10: {
                return L_BRACE;
            } 
            // fall through
          case 31: break;
            case 11: {
                return R_BRACE;
            } 
            // fall through
          case 32: break;
            case 12: {
                return SEMICOLON;
            } 
            // fall through
          case 33: break;
            case 13: {
                return STRING;
            } 
            // fall through
          case 34: break;
            case 14: {
                return KW_TEST;
            } 
            // fall through
          case 35: break;
            case 15: {
                return KW_ENTITY;
            }
            // fall through
            case 36:
                break;
            case 16: {
                return PACKAGE;
            }
            // fall through
            case 37:
                break;
            case 17: {
                return KW_ENTITY2;
            } 
            // fall through
            case 38:
                break;
            case 18: {
                return EXTENDS;
            }
            // fall through
            case 39:
                break;
            case 19: {
                return EXTENDS2;
            } 
            // fall through
            case 40:
                break;
            case 20: {
                return PROPERTY;
            }
            // fall through
            case 41:
                break;
            case 21: {
                return PROPERTY2;
            }
            // fall through
            case 42:
                break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
