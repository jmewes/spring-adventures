package com.experimental_software.spring_adventures;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

/**
 * @see <a href="https://youtu.be/05x0_1y9l_8?si=vPvkyk72aXBhZ9c4">youtube.com</a>
 */
class ModuleVerificationsTest {

  @Test
  void testModules() {
    ApplicationModules.of(SpringAdventuresApplication.class).verify();
  }
}
