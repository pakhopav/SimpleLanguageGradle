package com.intellij.docker.composeFile;

import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;
import org.jetbrains.annotations.NotNull;

import java.util.List;

abstract class SimpleLanguageCompletionTestBase extends LightPlatformCodeInsightFixtureTestCase {

    private final String myDataFolder;

    SimpleLanguageCompletionTestBase(@NotNull String dataFolder) {
    myDataFolder = dataFolder;
    }

    @Override
    protected final String getTestDataPath() {
    return getBasePath();
    }

    @Override
    protected final String getBasePath() {
    return AllComposeTests.getTestDataRoot() + myDataFolder;
    }

    protected String getCurrentInputFileName() {
    return getTestName(true) + ".simple";
    }

    protected List<String> getCompletionVariants() {
        String input = getCurrentInputFileName();
        List<String> result = myFixture.getCompletionVariants(input);
        assertNotEmpty(result);
        return result;
    }

    protected void checkHasCompletions(String... completions) {
        List<String> variants = getCompletionVariants();
        assertContainsElements(variants, completions);
    }

    protected void checkDoesnotContain(String... completions) {
        List<String> variants = getCompletionVariants();
        assertDoesntContain(variants, completions);
    }

    protected void checkEmptyResolve() {
        String input = getCurrentInputFileName();
        List<String> variants = myFixture.getCompletionVariants(input);
        assertEmpty(variants);

    }
}
