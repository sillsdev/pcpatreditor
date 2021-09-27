# pcpatreditor
Editor for smart handling of PC-PATR grammar files

Uses Java 17 (including JavaFX) via Azul Zulu (cf., https://www.azul.com/downloads/?package=jdk&show-old-builds=true, the "Download Azul Zulu Builds of OpenJDK" section)

Currently under development.  The roadmap is as follows:

1. Create a basic editor that knows about basic syntax, automatically iserts closing item when an opening item is keyed, has a way to show matching items.  *This is done.*
2. Create an ANTLR grammar to check validity of the PC-PATR grammar.  Show any errors in the grammar.
3. Create ability to produce a report showing the feature system implied in the grammar.
1. Create ability to show a context menu showing current features available at this point in editing based on the generated feature system.
