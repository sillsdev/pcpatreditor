# pcpatreditor
Editor for smart handling of PC-PATR grammar files

Uses Java 17 (including JavaFX) via Azul Zulu (cf., https://www.azul.com/downloads/?package=jdk&show-old-builds=true, the "Download Azul Zulu Builds of OpenJDK" section)

Currently under development.  The roadmap is as follows:

1. Create a basic editor that knows about basic syntax, automatically inserts closing item when an opening item is keyed, has a way to show matching items.  *This is done.*
1. Add a bookmark capability.  *This is done.*
1. Turn off rules and/or constraints (for debugging).  *Can export selected rules to a new copy of a grammar.*
1. Have a way to quickly find a set of rules for a given non-terminal.
2. Create an ANTLR grammar to check validity of the PC-PATR grammar.  Show any errors in the grammar.
3. Create ability to produce a report showing the feature system implied in the grammar. *This is done.*
1. Create ability to show a context menu showing current features available at this point in editing based on the generated feature system.  *This is partly done: it does not know anything about the current context; it also only inserts feature paths.*
