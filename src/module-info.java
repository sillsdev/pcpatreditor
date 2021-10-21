module org.sil.pcpatreditor {
	// Exports
	exports org.sil.pcpatreditor;
	exports org.sil.pcpatreditor.view;

	opens org.sil.pcpatreditor.view to javafx.fxml;
	opens org.sil.pcpatreditor.view.fxml to richtextfx.fat;
	// Java
	requires java.desktop;
	requires java.prefs;

	// JavaFX
	requires transitive javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.swing;
	requires javafx.web;

	// JAXB
	requires jakarta.xml.bind;
	requires jakarta.activation;
	opens org.sil.pcpatreditor.model;

	// JUnit
	requires junit;

	// Other modules/libraries
	requires antlr;
	requires controlsfx;
	requires transitive libjavadev;
	requires transitive richtextfx.fat;
	requires javafx.base;
	requires javafx.media;
}
