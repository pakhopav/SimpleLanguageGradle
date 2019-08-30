package com.intellij.docker.composeFile;

import com.intellij.testFramework.TestDataPath;

@TestDataPath("$CONTENT_ROOT/testData/completion/keys")
public class SimpleLanguageCompletionTest extends SimpleLanguageCompletionTestBase {
    public SimpleLanguageCompletionTest() {
    super("/completion/keys");
    }


    public void testEntitiesAtStart() {
        checkHasCompletions("entity", "entity2");
        checkDoesnotContain("property", "property2", "test");
    }

    public void testEntityInTheMiddle() {
        checkHasCompletions("entity", "entity2");
        checkDoesnotContain("property", "property2", "test");
    }

    public void testPropertiesOutOfEntity() {
        checkHasCompletions("property", "property2");
        checkDoesnotContain("entity", "entity2", "test");
    }

    public void testInEntityBody() {
        checkHasCompletions("property", "property2");
        checkDoesnotContain("entity", "entity2", "test");
    }

    public void testAllResolvesAtStart() {
        checkHasCompletions("entity", "entity2", "property", "property2", "test");
    }

    public void testAllResolvesInMiddle() {
        checkHasCompletions("entity", "entity2", "property", "property2", "test");
    }

    public void testAllResolvesInEnd() {
        checkHasCompletions("entity", "entity2", "property", "property2", "test");
    }

    public void testAfterEntityKeyword() {
        checkHasCompletions("ID", "ID2");
        checkDoesnotContain("entity", "entity2", "property", "property2", "test");

    }

    public void testAfterPropertyKeyword() {
        checkHasCompletions("ID", "ID2");
        checkDoesnotContain("entity", "entity2", "property", "property2", "test");

    }
}
