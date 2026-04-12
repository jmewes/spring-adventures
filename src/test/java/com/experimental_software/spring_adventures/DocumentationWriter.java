package com.experimental_software.spring_adventures;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

/**
 * Writes docs to "target/spring-modulith-docs"
 *
 * @see <a href="https://youtu.be/05x0_1y9l_8?si=E4bQxpA84NSG-QVb&t=730>youtube.com</a>
 */
class DocumentationWriter {

  @Test
  @Disabled
  void writeDocumentationSnippets() {
    ApplicationModules modules = ApplicationModules.of(SpringAdventuresApplication.class);
    new Documenter(modules).writeDocumentation();
  }
}
