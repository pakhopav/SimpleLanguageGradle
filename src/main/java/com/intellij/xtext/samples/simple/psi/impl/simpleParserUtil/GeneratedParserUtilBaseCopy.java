package com.intellij.xtext.samples.simple.psi.impl.simpleParserUtil;

import com.intellij.codeInsight.completion.impl.CamelHumpMatcher;
import com.intellij.lang.*;
import com.intellij.lang.impl.PsiBuilderAdapter;
import com.intellij.lang.impl.PsiBuilderImpl;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.util.Comparing;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.text.StringHash;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.psi.TokenType;
import com.intellij.psi.impl.source.resolve.FileContextUtil;
import com.intellij.psi.impl.source.tree.CompositePsiElement;
import com.intellij.psi.tree.ICompositeElementType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.Function;
import com.intellij.util.PairProcessor;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.containers.LimitedPool;
import gnu.trove.THashSet;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import static com.intellij.openapi.util.text.StringUtil.*;

public class GeneratedParserUtilBaseCopy {
    public static final IElementType DUMMY_BLOCK = new DummyBlockElementType();
    public static final Parser TOKEN_ADVANCER = (builder, level) -> {
        if (builder.eof()) return false;
        builder.advanceLexer();
        return true;
    };
    public static final Parser TRUE_CONDITION = (builder, level) -> true;
    public static final Hook<WhitespacesAndCommentsBinder> LEFT_BINDER =
            (builder, marker, param) -> {
                if (marker != null) marker.setCustomEdgeTokenBinders(param, null);
                return marker;
            };
    public static final Hook<WhitespacesAndCommentsBinder> RIGHT_BINDER =
            (builder, marker, param) -> {
                if (marker != null) marker.setCustomEdgeTokenBinders(null, param);
                return marker;
            };
    public static final Hook<WhitespacesAndCommentsBinder[]> WS_BINDERS =
            (builder, marker, param) -> {
                if (marker != null) marker.setCustomEdgeTokenBinders(param[0], param[1]);
                return marker;
            };
    public static final Hook<String> LOG_HOOK = (builder, marker, param) -> {
        PsiBuilderImpl.ProductionMarker m = (PsiBuilderImpl.ProductionMarker) marker;
        int start = m == null ? builder.getCurrentOffset() : m.getStartOffset();
        int end = m == null ? start : m.getEndOffset();
        String prefix = "[" + start + ", " + end + "]" + (m == null ? "" : " " + m.getTokenType());
        builder.mark().error(prefix + ": " + param);
        return marker;
    };
    // here's the new section API for compact parsers & less IntelliJ platform API exposure
    public static final int _NONE_ = 0x0;
    public static final int _COLLAPSE_ = 0x1;
    public static final int _LEFT_ = 0x2;
    public static final int _LEFT_INNER_ = 0x4;
    public static final int _AND_ = 0x8;
    public static final int _NOT_ = 0x10;
    public static final int _UPPER_ = 0x20;
    public static final Key<CompletionState> COMPLETION_STATE_KEY = Key.create("COMPLETION_STATE_KEY");
    private static final Logger LOG = Logger.getInstance("org.intellij.grammar.parser.GeneratedParserUtilBase");
    private static final int MAX_RECURSION_LEVEL = parseInt(System.getProperty("grammar.kit.gpub.max.level"), 1000);
    private static final int MAX_VARIANTS_SIZE = 10000;
    private static final int MAX_VARIANTS_TO_DISPLAY = 50;
    private static final int MAX_ERROR_TOKEN_TEXT = 20;
    private static final int INITIAL_VARIANTS_SIZE = 1000;
    private static final int VARIANTS_POOL_SIZE = 10000;
    private static final int FRAMES_POOL_SIZE = 500;
    private static final int MAX_CHILDREN_IN_TREE = 10;

    public static boolean eof(PsiBuilder builder, int level) {
        return builder.eof();
    }

    public static int current_position_(PsiBuilder builder) {
        return builder.rawTokenIndex();
    }

    public static boolean recursion_guard_(PsiBuilder builder, int level, String funcName) {
        if (level > MAX_RECURSION_LEVEL) {
            builder.mark().error("Maximum recursion level (" + MAX_RECURSION_LEVEL + ") reached in '" + funcName + "'");
            return false;
        }
        return true;
    }

    public static boolean empty_element_parsed_guard_(PsiBuilder builder, String funcName, int pos) {
        if (pos == current_position_(builder)) {
            // sometimes this is a correct situation, therefore no explicit marker
            builder.error("Empty element parsed in '" + funcName + "' at offset " + builder.getCurrentOffset());
            return false;
        }
        return true;
    }

    public static boolean invalid_left_marker_guard_(PsiBuilder builder, PsiBuilder.Marker marker, String funcName) {
        //builder.error("Invalid left marker encountered in " + funcName_ +" at offset " + builder.getCurrentOffset());
        boolean goodMarker = marker != null; // && ((LighterASTNode)marker).getTokenType() != TokenType.ERROR_ELEMENT;
        if (!goodMarker) return false;
        ErrorState state = ErrorState.get(builder);

        return state.currentFrame != null;
    }

    public static TokenSet create_token_set_(IElementType... tokenTypes) {
        return TokenSet.create(tokenTypes);
    }

    public static boolean leftMarkerIs(PsiBuilder builder, IElementType type) {
        LighterASTNode marker = builder.getLatestDoneMarker();
        return marker != null && marker.getTokenType() == type;
    }

    private static boolean consumeTokens(PsiBuilder builder, boolean smart, int pin, IElementType... tokens) {
        ErrorState state = ErrorState.get(builder);
        if (state.completionState != null && state.predicateSign) {
            addCompletionVariant(builder, state.completionState, tokens);
        }
        // suppress single token completion
        CompletionState completionState = state.completionState;
        state.completionState = null;
        boolean result = true;
        boolean pinned = false;
        for (int i = 0, tokensLength = tokens.length; i < tokensLength; i++) {
            if (pin > 0 && i == pin) pinned = result;
            if (result || pinned) {
                boolean fast = smart && i == 0;
                if (!(fast ? consumeTokenFast(builder, tokens[i]) : consumeToken(builder, tokens[i]))) {
                    result = false;
                    if (pin < 0 || pinned) report_error_(builder, state, false);
                }
            }
        }
        state.completionState = completionState;
        return pinned || result;
    }

    public static boolean consumeTokens(PsiBuilder builder, int pin, IElementType... token) {
        return consumeTokens(builder, false, pin, token);
    }

    public static boolean consumeTokensSmart(PsiBuilder builder, int pin, IElementType... token) {
        return consumeTokens(builder, true, pin, token);
    }

    public static boolean parseTokens(PsiBuilder builder, int pin, IElementType... tokens) {
        return parseTokens(builder, false, pin, tokens);
    }

    public static boolean parseTokensSmart(PsiBuilder builder, int pin, IElementType... tokens) {
        return parseTokens(builder, true, pin, tokens);
    }

    public static boolean parseTokens(PsiBuilder builder, boolean smart, int pin, IElementType... tokens) {
        PsiBuilder.Marker marker = builder.mark();
        boolean result = consumeTokens(builder, smart, pin, tokens);
        if (!result) {
            marker.rollbackTo();
        } else {
            marker.drop();
        }
        return result;
    }

    public static boolean consumeTokenSmart(PsiBuilder builder, IElementType token) {
        addCompletionVariantSmart(builder, token);
        return consumeTokenFast(builder, token);
    }

    public static boolean consumeTokenSmart(PsiBuilder builder, String token) {
        addCompletionVariantSmart(builder, token);
        return consumeTokenFast(builder, token);
    }

    public static boolean consumeToken(PsiBuilder builder, IElementType token) {
        addVariantSmart(builder, token, true);
        if (nextTokenIsFast(builder, token)) {
            builder.advanceLexer();
            return true;
        }
        return false;
    }

    public static boolean consumeTokenFast(PsiBuilder builder, IElementType token) {
        if (nextTokenIsFast(builder, token)) {
            builder.advanceLexer();
            return true;
        }
        return false;
    }

    public static boolean consumeToken(PsiBuilder builder, String text) {
        return consumeToken(builder, text, ErrorState.get(builder).caseSensitive);
    }

    public static boolean consumeToken(PsiBuilder builder, String text, boolean caseSensitive) {
        addVariantSmart(builder, text, true);
        int count = nextTokenIsFast(builder, text, caseSensitive);
        if (count > 0) {
            while (count-- > 0) builder.advanceLexer();
            return true;
        }
        return false;
    }

    public static boolean consumeTokenFast(PsiBuilder builder, String text) {
        int count = nextTokenIsFast(builder, text, ErrorState.get(builder).caseSensitive);
        if (count > 0) {
            while (count-- > 0) builder.advanceLexer();
            return true;
        }
        return false;
    }

    public static boolean consumeToken(PsiBuilder builder, TokenSet tokens) {
        addVariantSmart(builder, tokens.getTypes(), true);
        return consumeTokenFast(builder, tokens);
    }

    public static boolean consumeTokenSmart(PsiBuilder builder, TokenSet tokens) {
        addCompletionVariantSmart(builder, tokens.getTypes());
        return consumeTokenFast(builder, tokens);
    }

    public static boolean consumeTokenFast(PsiBuilder builder, TokenSet tokens) {
        if (nextTokenIsFast(builder, tokens)) {
            builder.advanceLexer();
            return true;
        }
        return false;
    }

    public static boolean nextTokenIsFast(PsiBuilder builder, IElementType token) {
        return builder.getTokenType() == token;
    }

    public static boolean nextTokenIsFast(PsiBuilder builder, IElementType... tokens) {
        IElementType tokenType = builder.getTokenType();
        for (IElementType token : tokens) {
            if (token == tokenType) return true;
        }
        return false;
    }

    public static boolean nextTokenIsFast(PsiBuilder builder, TokenSet tokens) {
        return tokens.contains(builder.getTokenType());
    }

    public static boolean nextTokenIsSmart(PsiBuilder builder, IElementType token) {
        return nextTokenIsFast(builder, token) || ErrorState.get(builder).completionState != null;
    }

    public static boolean nextTokenIsSmart(PsiBuilder builder, IElementType... tokens) {
        return nextTokenIsFast(builder, tokens) || ErrorState.get(builder).completionState != null;
    }

    public static boolean nextTokenIs(PsiBuilder builder, String frameName, IElementType... tokens) {
        ErrorState state = ErrorState.get(builder);
        if (state.completionState != null) return true;
        boolean track = !state.suppressErrors && state.predicateCount < 2 && state.predicateSign;
        return !track ? nextTokenIsFast(builder, tokens) : nextTokenIsSlow(builder, frameName, tokens);
    }

    public static boolean nextTokenIsSlow(PsiBuilder builder, String frameName, IElementType... tokens) {
        ErrorState state = ErrorState.get(builder);
        IElementType tokenType = builder.getTokenType();
        if (isNotEmpty(frameName)) {
            addVariantInner(state, state.currentFrame, builder.rawTokenIndex(), frameName);
        } else {
            for (IElementType token : tokens) {
                addVariant(builder, state, token);
            }
        }
        if (tokenType == null) return false;
        for (IElementType token : tokens) {
            if (tokenType == token) return true;
        }
        return false;
    }

    public static boolean nextTokenIs(PsiBuilder builder, IElementType token) {
        if (!addVariantSmart(builder, token, false)) return true;
        return nextTokenIsFast(builder, token);
    }

    public static boolean nextTokenIs(PsiBuilder builder, String tokenText) {
        if (!addVariantSmart(builder, tokenText, false)) return true;
        return nextTokenIsFast(builder, tokenText, ErrorState.get(builder).caseSensitive) > 0;
    }

    public static boolean nextTokenIsFast(PsiBuilder builder, String tokenText) {
        return nextTokenIsFast(builder, tokenText, ErrorState.get(builder).caseSensitive) > 0;
    }

    public static int nextTokenIsFast(PsiBuilder builder, String tokenText, boolean caseSensitive) {
        CharSequence sequence = builder.getOriginalText();
        int offset = builder.getCurrentOffset();
        int endOffset = offset + tokenText.length();
        CharSequence subSequence = sequence.subSequence(offset, Math.min(endOffset, sequence.length()));

        if (!Comparing.equal(subSequence, tokenText, caseSensitive)) return 0;

        int count = 0;
        while (true) {
            int nextOffset = builder.rawTokenTypeStart(++count);
            if (nextOffset > endOffset) {
                return -count;
            } else if (nextOffset == endOffset) {
                break;
            }
        }
        return count;
    }

    private static void addCompletionVariantSmart(PsiBuilder builder, Object token) {
        ErrorState state = ErrorState.get(builder);
        CompletionState completionState = state.completionState;
        if (completionState != null && state.predicateSign) {
            addCompletionVariant(builder, completionState, token);
        }
    }

    private static boolean addVariantSmart(PsiBuilder builder, Object token, boolean force) {
        ErrorState state = ErrorState.get(builder);
        // skip FIRST check in completion mode
        if (state.completionState != null && !force) return false;
        builder.eof();
        if (!state.suppressErrors && state.predicateCount < 2) {
            addVariant(builder, state, token);
        }
        return true;
    }

    public static void addVariant(PsiBuilder builder, String text) {
        addVariant(builder, ErrorState.get(builder), text);
    }

    private static void addVariant(PsiBuilder builder, ErrorState state, Object o) {
        builder.eof(); // skip whitespaces
        addVariantInner(state, state.currentFrame, builder.rawTokenIndex(), o);

        CompletionState completionState = state.completionState;
        if (completionState != null && state.predicateSign) {
            addCompletionVariant(builder, completionState, o);
        }
    }

    protected static void addVariantInner(ErrorState state, Frame frame, int pos, Object o) {
        Variant variant = state.VARIANTS.alloc().init(pos, o);
        if (state.predicateSign) {
            state.variants.add(variant);
            if (frame.lastVariantAt < pos) {
                frame.lastVariantAt = pos;
            }
        } else {
            state.unexpected.add(variant);
        }
    }

    protected static void addCompletionVariant(@NotNull PsiBuilder builder, @NotNull CompletionState completionState, Object o) {
        int offset = builder.getCurrentOffset();
        if (!builder.eof() && offset == builder.rawTokenTypeStart(1)) return; // suppress for zero-length tokens
        String text = completionState.convertItem(o);
        int length = text == null ? 0 : text.length();
        boolean add = length != 0 && completionState.prefixMatches(builder, text);
        add = add && length > 1 && !(text.charAt(0) == '<' && text.charAt(length - 1) == '>') &&
                !(text.charAt(0) == '\'' && text.charAt(length - 1) == '\'' && length < 5);
        if (add) {
            completionState.addItem(builder, text);
        }
    }

    public static boolean isWhitespaceOrComment(@NotNull PsiBuilder builder, @Nullable IElementType type) {
        return ((PsiBuilderImpl) ((Builder) builder).getDelegate()).whitespaceOrComment(type);
    }

    private static boolean wasAutoSkipped(@NotNull PsiBuilder builder, int steps) {
        for (int i = -1; i >= -steps; i--) {
            if (!isWhitespaceOrComment(builder, builder.rawLookup(i))) return false;
        }
        return true;
    }

    // simple enter/exit methods pair that doesn't require frame object
    public static PsiBuilder.Marker enter_section_(PsiBuilder builder) {
        ErrorState state = ErrorState.get(builder);
        reportFrameError(builder, state);
        state.level++;
        return builder.mark();
    }

    public static void exit_section_(PsiBuilder builder,
                                     PsiBuilder.Marker marker,
                                     @Nullable IElementType elementType,
                                     boolean result) {
        ErrorState state = ErrorState.get(builder);
        close_marker_impl_(state.currentFrame, marker, elementType, result);
        if (state.currentFrame.errorReportedAt == -1 && state.completionState != null)
            state.completionState.errorOccured = false;
        run_hooks_impl_(builder, state, result ? elementType : null);
        state.level--;
    }

    // complex enter/exit methods pair with frame object
    public static PsiBuilder.Marker enter_section_(PsiBuilder builder, int level, int modifiers, String frameName) {
        return enter_section_(builder, level, modifiers, null, frameName);
    }

    public static PsiBuilder.Marker enter_section_(PsiBuilder builder, int level, int modifiers) {
        return enter_section_(builder, level, modifiers, null, null);
    }

    public static PsiBuilder.Marker enter_section_(PsiBuilder builder, int level, int modifiers, IElementType elementType, String frameName) {
        reportFrameError(builder, ErrorState.get(builder));
        PsiBuilder.Marker marker = builder.mark();
        enter_section_impl_(builder, level, modifiers, elementType, frameName);
        return marker;
    }

    protected static void enter_section_impl_(PsiBuilder builder, int level, int modifiers, IElementType elementType, String frameName) {
        ErrorState state = ErrorState.get(builder);
        state.level++;
        Frame frame = state.FRAMES.alloc().init(builder, state, level, modifiers, elementType, frameName);
        if (((frame.modifiers & _LEFT_) | (frame.modifiers & _LEFT_INNER_)) != 0) {
            PsiBuilder.Marker left = (PsiBuilder.Marker) builder.getLatestDoneMarker();
            if (invalid_left_marker_guard_(builder, left, frameName)) {
                frame.leftMarker = left;
            }
        }
        state.currentFrame = frame;
        if ((modifiers & _AND_) != 0) {
            if (state.predicateCount == 0 && !state.predicateSign) {
                throw new AssertionError("Incorrect false predicate sign");
            }
            state.predicateCount++;
        } else if ((modifiers & _NOT_) != 0) {
            state.predicateSign = state.predicateCount != 0 && !state.predicateSign;
            state.predicateCount++;
        }
    }

    public static void exit_section_(PsiBuilder builder,
                                     int level,
                                     PsiBuilder.Marker marker,
                                     boolean result,
                                     boolean pinned,
                                     @Nullable Parser eatMore) {
        exit_section_(builder, level, marker, null, result, pinned, eatMore);
    }

    public static void exit_section_(PsiBuilder builder,
                                     int level,
                                     PsiBuilder.Marker marker,
                                     @Nullable IElementType elementType,
                                     boolean result,
                                     boolean pinned,
                                     @Nullable Parser eatMore) {
        ErrorState state = ErrorState.get(builder);

        Frame frame = state.currentFrame;
        state.currentFrame = frame == null ? null : frame.parentFrame;
        if (frame != null && frame.elementType != null) elementType = frame.elementType;
        if (frame == null || level != frame.level) {
            LOG.error("Unbalanced error section: got " + frame + ", expected level " + level);
            if (frame != null) state.FRAMES.recycle(frame);
            close_marker_impl_(frame, marker, elementType, result);
            return;
        }

        close_frame_impl_(state, frame, builder, marker, elementType, result, pinned);
        exit_section_impl_(state, frame, builder, elementType, result, pinned, eatMore);
        run_hooks_impl_(builder, state, pinned || result ? elementType : null);
        state.FRAMES.recycle(frame);
        state.level--;
    }

    public static <T> void register_hook_(PsiBuilder builder, Hook<T> hook, T param) {
        ErrorState state = ErrorState.get(builder);
        state.hooks = Hooks.concat(hook, param, state.level, state.hooks);
    }

    @SafeVarargs
    public static <T> void register_hook_(PsiBuilder builder, Hook<T[]> hook, T... param) {
        ErrorState state = ErrorState.get(builder);
        state.hooks = Hooks.concat(hook, param, state.level, state.hooks);
    }

    protected static void run_hooks_impl_(PsiBuilder builder, ErrorState state, @Nullable IElementType elementType) {
        if (state.hooks == null) return;
        PsiBuilder.Marker marker = elementType == null ? null : (PsiBuilder.Marker) builder.getLatestDoneMarker();
        if (elementType != null && marker == null) {
            builder.mark().error("No expected done marker at offset " + builder.getCurrentOffset());
        }
        while (state.hooks != null && state.hooks.level >= state.level) {
            if (state.hooks.level == state.level) {
                marker = ((Hook<Object>) state.hooks.hook).run(builder, marker, state.hooks.param);
            }
            state.hooks = state.hooks.next;
        }
    }

    private static void exit_section_impl_(ErrorState state,
                                           Frame frame,
                                           PsiBuilder builder,
                                           @Nullable IElementType elementType,
                                           boolean result,
                                           boolean pinned,
                                           @Nullable Parser eatMore) {
        int initialPos = builder.rawTokenIndex();
        replace_variants_with_name_(state, frame, builder, elementType, result, pinned);
        int lastErrorPos = frame.lastVariantAt < 0 ? initialPos : frame.lastVariantAt;
        if (!state.suppressErrors && eatMore != null) {
            state.suppressErrors = true;
            boolean eatMoreResult = eatMore.parse(builder, frame.level + 1);
            //my changes
            final boolean eatMoreFlagOnce = !builder.eof() && eatMoreResult;
            if (!eatMoreResult) checkRecoveryForCompletion((Builder) builder, frame);
            boolean eatMoreFlag = eatMoreFlagOnce || !result && frame.position == initialPos && lastErrorPos > frame.position;

            PsiBuilderImpl.ProductionMarker latestDoneMarker =
                    (pinned || result) && (state.altMode || elementType != null) &&
                            eatMoreFlagOnce ? getLatestExtensibleDoneMarker(builder) : null;
            // advance to the last error pos
            // skip tokens until lastErrorPos. parseAsTree might look better here...
            int parenCount = 0;
            while ((eatMoreFlag || parenCount > 0) && builder.rawTokenIndex() < lastErrorPos) {
                IElementType tokenType = builder.getTokenType();
                if (state.braces != null) {
                    if (tokenType == state.braces[0].getLeftBraceType()) parenCount++;
                    else if (tokenType == state.braces[0].getRightBraceType()) parenCount--;
                }
                if (!(builder.rawTokenIndex() < lastErrorPos)) break;
                state.tokenAdvancer.parse(builder, frame.level + 1);
                eatMoreFlag = eatMore.parse(builder, frame.level + 1);
                if (!eatMoreFlag) checkRecoveryForCompletion((Builder) builder, frame);
            }
            boolean errorReported = frame.errorReportedAt == initialPos || !result && frame.errorReportedAt >= frame.position;
            if (errorReported || eatMoreFlag) {
                if (!errorReported) {
                    errorReported = reportError(builder, state, frame, false, true, true);
                } else if (eatMoreFlag) {
                    state.tokenAdvancer.parse(builder, frame.level + 1);
                }
                if (eatMore.parse(builder, frame.level + 1)) {

                    parseAsTree(state, builder, frame.level + 1, DUMMY_BLOCK, true, state.tokenAdvancer, eatMore);
                } else {
                    checkRecoveryForCompletion((Builder) builder, frame);
                }
            } else if (eatMoreFlagOnce || !result && frame.position != builder.rawTokenIndex() || frame.errorReportedAt > initialPos) {
                errorReported = reportError(builder, state, frame, false, true, false);
            } else if (!result && pinned && frame.errorReportedAt < 0) {
                errorReported = reportError(builder, state, frame, elementType != null, false, false);
            }
            // whitespace prefix makes the very first frame offset bigger than marker start offset which is always 0
            if (latestDoneMarker != null &&
                    frame.position >= latestDoneMarker.getStartIndex() &&
                    frame.position <= latestDoneMarker.getEndIndex()) {
                extend_marker_impl((PsiBuilder.Marker) latestDoneMarker);
            }
            state.suppressErrors = false;
            if (errorReported || result) {
                state.clearVariants(true, 0);
                state.clearVariants(false, 0);
                frame.lastVariantAt = -1;
                for (Frame f = frame; f != null && f.variantCount > 0; f = f.parentFrame) f.variantCount = 0;
            }
        } else if (!result && pinned && frame.errorReportedAt < 0) {
            // do not report if there are errors beyond current position
            if (lastErrorPos == initialPos) {
                // do not force, inner recoverRoot might have skipped some tokens
                reportError(builder, state, frame, elementType != null, false, false);
            } else if (lastErrorPos > initialPos) {
                // set error pos here as if it is reported for future reference
                frame.errorReportedAt = lastErrorPos;
            }
        }
        // propagate errorReportedAt up the stack to avoid duplicate reporting
        if (state.currentFrame != null) {
            if (state.currentFrame.errorReportedAt < frame.errorReportedAt) {
                state.currentFrame.errorReportedAt = frame.errorReportedAt;
            }
            if (state.currentFrame.lastVariantAt < frame.lastVariantAt) {
                state.currentFrame.lastVariantAt = frame.lastVariantAt;
            }
        }
    }

    public static void checkRecoveryForCompletion(Builder builder, Frame frame) {
        if (ErrorState.get(builder).completionState != null) {
            ErrorState.get(builder).completionState.errorOccured = false;
        }
    }

    protected static void close_frame_impl_(ErrorState state,
                                            Frame frame,
                                            PsiBuilder builder,
                                            PsiBuilder.Marker marker,
                                            IElementType elementType,
                                            boolean result,
                                            boolean pinned) {
        if (((frame.modifiers & _AND_) | (frame.modifiers & _NOT_)) != 0) {
            boolean resetLastPos = !state.suppressErrors && frame.lastVariantAt < 0 && frame.position < builder.rawTokenIndex();
            close_marker_impl_(frame, marker, null, false);
            state.predicateCount--;
            if ((frame.modifiers & _NOT_) != 0) state.predicateSign = !state.predicateSign;
            marker = elementType != null && marker != null && (result || pinned) ? builder.mark() : null;
            if (resetLastPos) frame.lastVariantAt = builder.rawTokenIndex();
        }
        if (elementType != null && marker != null) {
            if (result || pinned) {
                if ((frame.modifiers & _COLLAPSE_) != 0) {
                    PsiBuilderImpl.ProductionMarker last = (PsiBuilderImpl.ProductionMarker) builder.getLatestDoneMarker();
                    if (last != null &&
                            last.getStartIndex() == frame.position &&
                            state.typeExtends(last.getTokenType(), elementType) &&
                            wasAutoSkipped(builder, builder.rawTokenIndex() - last.getEndIndex())) {
                        elementType = last.getTokenType();
                        ((PsiBuilder.Marker) last).drop();
                    }
                }
                if ((frame.modifiers & _UPPER_) != 0) {
                    marker.drop();
                    for (Frame f = frame.parentFrame; f != null; f = f.parentFrame) {
                        if (f.elementType == null) continue;
                        f.elementType = elementType;
                        break;
                    }
                } else if ((frame.modifiers & _LEFT_INNER_) != 0 && frame.leftMarker != null) {
                    marker.done(elementType);
                    extend_marker_impl(frame.leftMarker);
                } else if ((frame.modifiers & _LEFT_) != 0 && frame.leftMarker != null) {
                    marker.drop();
                    frame.leftMarker.precede().done(elementType);
                } else {
                    if (frame.level == 0) builder.eof(); // skip whitespaces
                    marker.done(elementType);
                }
            } else {
                close_marker_impl_(frame, marker, null, false);
            }
        } else if (result || pinned) {
            if (marker != null) marker.drop();
            if ((frame.modifiers & _LEFT_INNER_) != 0 && frame.leftMarker != null) {
                extend_marker_impl(frame.leftMarker);
            }
        } else {
            close_marker_impl_(frame, marker, null, false);
        }
    }

    protected static void extend_marker_impl(PsiBuilder.Marker marker) {
        PsiBuilder.Marker precede = marker.precede();
        IElementType elementType = ((LighterASTNode) marker).getTokenType();
        if (elementType == TokenType.ERROR_ELEMENT) {
            precede.error(notNullize(PsiBuilderImpl.getErrorMessage((LighterASTNode) marker)));
        } else {
            precede.done(elementType);
        }
        marker.drop();
    }

    protected static void close_marker_impl_(Frame frame, PsiBuilder.Marker marker, IElementType elementType, boolean result) {
        if (marker == null) return;
        if (result) {
            if (elementType != null) {
                marker.done(elementType);
            } else {
                marker.drop();
            }
        } else {
            if (frame != null) {
                int position = ((PsiBuilderImpl.ProductionMarker) marker).getStartIndex();
                if (frame.errorReportedAt > position) {
                    frame.errorReportedAt = frame.parentFrame == null ? -1 : frame.parentFrame.errorReportedAt;

                }
            }
            marker.rollbackTo();
        }
    }

    protected static void replace_variants_with_name_(ErrorState state,
                                                      Frame frame,
                                                      PsiBuilder builder,
                                                      IElementType elementType,
                                                      boolean result,
                                                      boolean pinned) {
        int initialPos = builder.rawTokenIndex();
        boolean willFail = !result && !pinned;
        if (willFail && initialPos == frame.position && frame.lastVariantAt == frame.position &&
                frame.name != null && state.variants.size() >= frame.variantCount + (elementType == null ? 0 : 2)) {
            state.clearVariants(true, frame.variantCount);
            addVariantInner(state, frame, initialPos, frame.name);
        }
    }

    public static boolean report_error_(PsiBuilder builder, boolean result) {
        if (!result) report_error_(builder, ErrorState.get(builder), false);
        return result;
    }

    public static void report_error_(PsiBuilder builder, ErrorState state, boolean advance) {
        Frame frame = state.currentFrame;
        if (frame == null) {
            LOG.error("unbalanced enter/exit section call: got null");
            return;
        }
        int position = builder.rawTokenIndex();
        if (frame.errorReportedAt < position && frame.lastVariantAt > -1 && frame.lastVariantAt <= position) {
            reportError(builder, state, frame, false, true, advance);
        }
    }

    @Nullable
    protected static PsiBuilderImpl.ProductionMarker getLatestExtensibleDoneMarker(@NotNull PsiBuilder builder) {
        PsiBuilderImpl.ProductionMarker marker = ContainerUtil.getLastItem(((Builder) builder).getProductions());
        return marker == null || marker.getTokenType() == null || !(marker instanceof PsiBuilder.Marker) ? null : marker;
    }

    protected static boolean reportError(PsiBuilder builder,
                                         ErrorState state,
                                         Frame frame,
                                         boolean inner,
                                         boolean force,
                                         boolean advance) {
        int position = builder.rawTokenIndex();
        StringBuilder sb = new StringBuilder();
        state.appendExpected(sb, position, true);
        boolean empty = sb.length() == 0;
        if (!force && empty && !advance) return false;

        String actual = trim(builder.getTokenText());
        if (isEmpty(actual)) {
            sb.append(empty ? "unmatched input" : " expected");
        } else {
            if (!empty) sb.append(" expected, got ");
            sb.append("'").append(first(actual, MAX_ERROR_TOKEN_TEXT, true)).append("'");
            if (empty) sb.append(" unexpected");
        }
        String message = sb.toString();
        if (advance) {
            PsiBuilder.Marker mark = builder.mark();
            state.tokenAdvancer.parse(builder, frame.level + 1);
            mark.error(message);
        } else if (inner) {
            PsiBuilderImpl.ProductionMarker latestDoneMarker = getLatestExtensibleDoneMarker(builder);
            builder.error(message);
            if (latestDoneMarker != null &&
                    frame.position >= latestDoneMarker.getStartIndex() &&
                    frame.position <= latestDoneMarker.getEndIndex()) {
                extend_marker_impl((PsiBuilder.Marker) latestDoneMarker);
            }
        } else {
            builder.error(message);
        }
        builder.eof(); // skip whitespaces
        if (state.completionState != null) {
            state.completionState.errorOccured = true;
        }
        frame.errorReportedAt = builder.rawTokenIndex();
        return true;
    }

    protected static void reportFrameError(PsiBuilder builder, ErrorState state) {
        if (state.currentFrame == null || state.suppressErrors) return;
        Frame frame = state.currentFrame;
        int pos = builder.rawTokenIndex();
        if (frame.errorReportedAt > pos) {
            // report error for previous unsuccessful frame
            LighterASTNode marker = builder.getLatestDoneMarker();
            int endOffset = marker != null ? ((PsiBuilderImpl.ProductionMarker) marker).getEndIndex() : pos + 1;
            while (endOffset <= pos && isWhitespaceOrComment(builder, builder.rawLookup(endOffset - pos))) endOffset++;
            boolean inner = endOffset == pos;
            builder.eof();
            reportError(builder, state, frame, inner, true, false);
        }
    }

    public static PsiBuilder adapt_builder_(IElementType root, PsiBuilder builder, PsiParser parser) {
        return adapt_builder_(root, builder, parser, null);
    }

    public static PsiBuilder adapt_builder_(IElementType root, PsiBuilder builder, PsiParser parser, TokenSet[] extendsSets) {
        ErrorState state = new ErrorState();
        ErrorState.initState(state, builder, root, extendsSets);
        return new Builder(builder, state, parser);
    }

    private static void checkSiblings(IElementType chunkType,
                                      ArrayDeque<Pair<PsiBuilder.Marker, PsiBuilder.Marker>> parens,
                                      ArrayDeque<Pair<PsiBuilder.Marker, Integer>> siblings) {
        main:
        while (!siblings.isEmpty()) {
            Pair<PsiBuilder.Marker, PsiBuilder.Marker> parenPair = parens.peek();
            int rating = siblings.getFirst().second;
            int count = 0;
            for (Pair<PsiBuilder.Marker, Integer> pair : siblings) {
                if (pair.second != rating || parenPair != null && pair.first == parenPair.second) break main;
                if (++count >= MAX_CHILDREN_IN_TREE) {
                    PsiBuilder.Marker parentMarker = pair.first.precede();
                    parentMarker.setCustomEdgeTokenBinders(WhitespacesBinders.GREEDY_LEFT_BINDER, null);
                    while (count-- > 0) {
                        siblings.removeFirst();
                    }
                    parentMarker.done(chunkType);
                    siblings.addFirst(Pair.create(parentMarker, rating + 1));
                    continue main;
                }
            }
            break;
        }
    }

    public static boolean parseAsTree(ErrorState state, PsiBuilder builder, int level,
                                      IElementType chunkType, boolean checkBraces,
                                      Parser parser, Parser eatMoreCondition) {
        ArrayDeque<Pair<PsiBuilder.Marker, PsiBuilder.Marker>> parens = new ArrayDeque<>(4);
        ArrayDeque<Pair<PsiBuilder.Marker, Integer>> siblings = new ArrayDeque<>();
        PsiBuilder.Marker marker = null;

        IElementType lBrace = checkBraces && state.braces != null && state.braces.length > 0 ? state.braces[0].getLeftBraceType() : null;
        IElementType rBrace = lBrace != null ? state.braces[0].getRightBraceType() : null;
        int totalCount = 0;
        int tokenCount = 0;
        if (lBrace != null) {
            int tokenIdx = -1;
            while (builder.rawLookup(tokenIdx) == TokenType.WHITE_SPACE) tokenIdx--;
            LighterASTNode doneMarker = builder.rawLookup(tokenIdx) == lBrace ? builder.getLatestDoneMarker() : null;
            if (doneMarker != null && doneMarker.getStartOffset() == builder.rawTokenTypeStart(tokenIdx) && doneMarker.getTokenType() == TokenType.ERROR_ELEMENT) {
                parens.add(Pair.create(((PsiBuilder.Marker) doneMarker).precede(), null));
            }
        }
        int c = current_position_(builder);
        while (true) {
            IElementType tokenType = builder.getTokenType();
            if (lBrace != null && (tokenType == lBrace || tokenType == rBrace && !parens.isEmpty())) {
                if (marker != null) {
                    marker.done(chunkType);
                    siblings.addFirst(Pair.create(marker, 1));
                    marker = null;
                    tokenCount = 0;
                }
                if (tokenType == lBrace) {
                    Pair<PsiBuilder.Marker, Integer> prev = siblings.peek();
                    parens.addFirst(Pair.create(builder.mark(), Pair.getFirst(prev)));
                }
                checkSiblings(chunkType, parens, siblings);
                state.tokenAdvancer.parse(builder, level);
                if (tokenType == rBrace) {
                    Pair<PsiBuilder.Marker, PsiBuilder.Marker> pair = parens.removeFirst();
                    pair.first.done(chunkType);
                    // drop all markers inside parens
                    while (!siblings.isEmpty() && siblings.getFirst().first != pair.second) {
                        siblings.removeFirst();
                    }
                    siblings.addFirst(Pair.create(pair.first, 1));
                    checkSiblings(chunkType, parens, siblings);
                }
            } else {
                if (marker == null) {
                    marker = builder.mark();
                    marker.setCustomEdgeTokenBinders(WhitespacesBinders.GREEDY_LEFT_BINDER, null);
                }
                //MY CHANGES
                boolean resultForCompletion = eatMoreCondition.parse(builder, level + 1);
                if (!resultForCompletion)
                    checkRecoveryForCompletion((Builder) builder, ErrorState.get(builder).currentFrame);
                boolean result = (!parens.isEmpty() || resultForCompletion) &&
                        parser.parse(builder, level + 1);
                if (result) {
                    tokenCount++;
                    totalCount++;
                } else {
                    break;
                }
            }

            if (tokenCount >= MAX_CHILDREN_IN_TREE) {
                marker.done(chunkType);
                siblings.addFirst(Pair.create(marker, 1));
                checkSiblings(chunkType, parens, siblings);
                marker = null;
                tokenCount = 0;
            }
            if (!empty_element_parsed_guard_(builder, "parseAsTree", c)) break;
            c = current_position_(builder);
        }
        if (marker != null) marker.drop();
        for (Pair<PsiBuilder.Marker, PsiBuilder.Marker> pair : parens) {
            pair.first.drop();
        }
        return totalCount != 0;
    }

    public interface Parser {
        boolean parse(PsiBuilder builder, int level);
    }

    public interface Hook<T> {

        @Contract("_,null,_->null")
        PsiBuilder.Marker run(PsiBuilder builder, PsiBuilder.Marker marker, T param);

    }

    public static class CompletionState implements Function<Object, String> {
        public final int offset;
        public final Collection<String> items = new THashSet<>();
        public boolean errorOccured;

        public CompletionState(int offset_) {
            errorOccured = false;
            offset = offset_;
        }

        @Nullable
        public String convertItem(Object o) {
            return o instanceof Object[] ? join((Object[]) o, this, " ") : o.toString();
        }

        @Override
        public String fun(Object o) {
            return convertItem(o);
        }

        public void addItem(@NotNull PsiBuilder builder, @NotNull String text) {
            items.add(text);
        }

        public boolean prefixMatches(@NotNull PsiBuilder builder, @NotNull String text) {
            int builderOffset = builder.getCurrentOffset();
            int diff = offset - builderOffset;
            int length = text.length();
            if (diff == 0) {
                return true;
            } else if (diff > 0 && diff <= length) {
                CharSequence fragment = builder.getOriginalText().subSequence(builderOffset, offset);
                return prefixMatches(fragment.toString(), text);
            } else if (diff < 0) {
                for (int i = -1; ; i--) {
                    IElementType type = builder.rawLookup(i);
                    int tokenStart = builder.rawTokenTypeStart(i);
                    if (isWhitespaceOrComment(builder, type)) {
                        diff = offset - tokenStart;
                    } else if (type != null && tokenStart < offset) {
                        CharSequence fragment = builder.getOriginalText().subSequence(tokenStart, offset);
                        if (prefixMatches(fragment.toString(), text)) {
                            diff = offset - tokenStart;
                        }
                        break;
                    } else break;
                }
                return diff >= 0 && diff < length;
            }
            return false;
        }

        public boolean prefixMatches(@NotNull String prefix, @NotNull String variant) {
            boolean matches = new CamelHumpMatcher(prefix, false).prefixMatches(variant.replace(' ', '_'));
            if (matches && isWhiteSpace(prefix.charAt(prefix.length() - 1))) {
                return startsWithIgnoreCase(variant, prefix);
            }
            return matches;
        }
    }

    public static class Builder extends PsiBuilderAdapter {
        public final ErrorState state;
        public final PsiParser parser;

        public Builder(PsiBuilder builder, ErrorState state_, PsiParser parser_) {
            super(builder);
            state = state_;
            parser = parser_;
        }

        public Lexer getLexer() {
            return ((PsiBuilderImpl) myDelegate).getLexer();
        }

        @Nullable
        public List<PsiBuilderImpl.ProductionMarker> getProductions() {
            return ((PsiBuilderImpl) myDelegate).getProductions();
        }
    }

    public static class ErrorState {

        final LimitedPool<Variant> VARIANTS = new LimitedPool<>(VARIANTS_POOL_SIZE, () -> new Variant());
        final LimitedPool<Frame> FRAMES = new LimitedPool<>(FRAMES_POOL_SIZE, () -> new Frame());
        public Frame currentFrame;
        public CompletionState completionState;
        public PairProcessor<IElementType, IElementType> altExtendsChecker;
        public BracePair[] braces;
        public Parser tokenAdvancer = TOKEN_ADVANCER;
        public boolean altMode;
        MyList<Variant> variants = new MyList<>(INITIAL_VARIANTS_SIZE);
        MyList<Variant> unexpected = new MyList<>(INITIAL_VARIANTS_SIZE / 10);
        int predicateCount;
        int level;
        boolean predicateSign = true;
        boolean suppressErrors;
        Hooks<?> hooks;
        TokenSet[] extendsSets;
        private boolean caseSensitive;

        public static ErrorState get(PsiBuilder builder) {
            return ((Builder) builder).state;
        }

        public static void initState(ErrorState state, PsiBuilder builder, IElementType root, TokenSet[] extendsSets) {
            state.extendsSets = extendsSets;
            PsiFile file = builder.getUserData(FileContextUtil.CONTAINING_FILE_KEY);
            state.completionState = file == null ? null : file.getUserData(COMPLETION_STATE_KEY);
            Language language = file == null ? root.getLanguage() : file.getLanguage();
            state.caseSensitive = language.isCaseSensitive();
            PairedBraceMatcher matcher = LanguageBraceMatching.INSTANCE.forLanguage(language);
            state.braces = matcher == null ? null : matcher.getPairs();
            if (state.braces != null && state.braces.length == 0) state.braces = null;
        }

        public void appendExpected(@NotNull StringBuilder sb, int position, boolean expected) {
            MyList<Variant> list = expected ? variants : unexpected;
            String[] strings = new String[list.size()];
            long[] hashes = new long[strings.length];
            Arrays.fill(strings, "");
            int count = 0;
            loop:
            for (Variant variant : list) {
                if (position == variant.position) {
                    String text = String.valueOf(variant.object);
                    long hash = StringHash.calc(text);
                    for (int i = 0; i < count; i++) {
                        if (hashes[i] == hash) continue loop;
                    }
                    hashes[count] = hash;
                    strings[count] = text;
                    count++;
                }
            }
            Arrays.sort(strings);
            count = 0;
            for (String s : strings) {
                if (s.length() == 0) continue;
                if (count++ > 0) {
                    if (count > MAX_VARIANTS_TO_DISPLAY) {
                        sb.append(" and ...");
                        break;
                    } else {
                        sb.append(", ");
                    }
                }
                char c = s.charAt(0);
                String displayText = c == '<' || isJavaIdentifierStart(c) ? s : '\'' + s + '\'';
                sb.append(displayText);
            }
            if (count > 1 && count < MAX_VARIANTS_TO_DISPLAY) {
                int idx = sb.lastIndexOf(", ");
                sb.replace(idx, idx + 1, " or");
            }
        }

        public void clearVariants(Frame frame) {
            clearVariants(true, frame == null ? 0 : frame.variantCount);
            if (frame != null) frame.lastVariantAt = -1;
        }

        void clearVariants(boolean expected, int start) {
            MyList<Variant> list = expected ? variants : unexpected;
            if (start < 0 || start >= list.size()) return;
            for (int i = start, len = list.size(); i < len; i++) {
                VARIANTS.recycle(list.get(i));
            }
            list.setSize(start);
        }

        public boolean typeExtends(IElementType child, IElementType parent) {
            if (child == parent) return true;
            if (extendsSets != null) {
                for (TokenSet set : extendsSets) {
                    if (set.contains(child) && set.contains(parent)) return true;
                }
            }
            return altExtendsChecker != null && altExtendsChecker.process(child, parent);
        }
    }

    public static class Frame {
        public Frame parentFrame;
        public IElementType elementType;

        public int offset;
        public int position;
        public int level;
        public int modifiers;
        public String name;
        public int variantCount;
        public int errorReportedAt;
        public boolean withError;
        public int lastVariantAt;
        public PsiBuilder.Marker leftMarker;

        public Frame() {
        }

        public Frame init(PsiBuilder builder,
                          ErrorState state,
                          int level_,
                          int modifiers_,
                          IElementType elementType_,
                          String name_) {
            parentFrame = state.currentFrame;
            elementType = elementType_;

            offset = builder.getCurrentOffset();
            position = builder.rawTokenIndex();
            level = level_;
            modifiers = modifiers_;
            name = name_;
            variantCount = state.variants.size();
            errorReportedAt = -1;
            lastVariantAt = -1;
            withError = false;
            leftMarker = null;
            return this;
        }

        @Override
        public String toString() {
            String mod = modifiers == _NONE_ ? "_NONE_, " :
                    ((modifiers & _COLLAPSE_) != 0 ? "_CAN_COLLAPSE_, " : "") +
                            ((modifiers & _LEFT_) != 0 ? "_LEFT_, " : "") +
                            ((modifiers & _LEFT_INNER_) != 0 ? "_LEFT_INNER_, " : "") +
                            ((modifiers & _AND_) != 0 ? "_AND_, " : "") +
                            ((modifiers & _NOT_) != 0 ? "_NOT_, " : "") +
                            ((modifiers & _UPPER_) != 0 ? "_UPPER_, " : "");
            return String.format("{%s:%s:%d, %d, %s%s, %s}", offset, position, level, errorReportedAt, mod, elementType, name);
        }
    }

    private static class Variant {
        int position;
        Object object;

        public Variant init(int pos, Object o) {
            position = pos;
            object = o;
            return this;
        }

        @Override
        public String toString() {
            return "<" + position + ", " + object + ">";
        }
    }

    private static class Hooks<T> {
        final Hook<T> hook;
        final T param;
        final int level;
        final Hooks<?> next;

        Hooks(Hook<T> hook, T param, int level, Hooks next) {
            this.hook = hook;
            this.param = param;
            this.level = level;
            this.next = next;
        }

        static <E> Hooks<E> concat(Hook<E> hook, E param, int level, Hooks<?> hooks) {
            return new Hooks<>(hook, param, level, hooks);
        }
    }

    private static class DummyBlockElementType extends IElementType implements ICompositeElementType {
        DummyBlockElementType() {
            super("DUMMY_BLOCK", Language.ANY);
        }

        @NotNull
        @Override
        public ASTNode createCompositeNode() {
            return new DummyBlock();
        }
    }

    public static class DummyBlock extends CompositePsiElement {
        DummyBlock() {
            super(DUMMY_BLOCK);
        }

        @NotNull
        @Override
        public PsiReference[] getReferences() {
            return PsiReference.EMPTY_ARRAY;
        }

        @NotNull
        @Override
        public Language getLanguage() {
            return getParent().getLanguage();
        }
    }

    private static class MyList<E> extends ArrayList<E> {
        MyList(int initialCapacity) {
            super(initialCapacity);
        }

        protected void setSize(int fromIndex) {
            removeRange(fromIndex, size());
        }

        @Override
        public boolean add(E e) {
            int size = size();
            if (size >= MAX_VARIANTS_SIZE) {
                removeRange(MAX_VARIANTS_SIZE / 4, size - MAX_VARIANTS_SIZE / 4);
            }
            return super.add(e);
        }
    }
}

