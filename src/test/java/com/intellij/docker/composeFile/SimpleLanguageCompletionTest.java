package com.intellij.docker.composeFile;

import com.intellij.testFramework.TestDataPath;

@TestDataPath("$CONTENT_ROOT/testData/completion/keys")
public class SimpleLanguageCompletionTest extends SimpleLanguageCompletionTestBase {
  public SimpleLanguageCompletionTest() {
    super("/completion/keys");
  }


  public void testEntitiesAtStart(){checkHasCompletions("entity", "entity2");}
  public void testEntityInTheMiddle(){checkHasCompletions("entity", "entity2");}
  public void testPropertyOrProperty2InEntity(){checkHasCompletions("property", "property2");}
  public void testPropertiesOutOfEntity(){checkHasCompletions("property", "property2");}
  public void testEntityOrEntity2AfterKwTestEmptySymbol(){checkHasCompletions("entity", "entity2");}
  public void testAllResolvesAtStart(){checkHasCompletions("entity","entity2","property", "property2", "test");}
  public void testAllResolvesInMiddle(){checkHasCompletions("entity","entity2","property", "property2", "test");}
  public void testAllResolvesInEnd(){checkHasCompletions("entity","entity2","property", "property2", "test");}

}
