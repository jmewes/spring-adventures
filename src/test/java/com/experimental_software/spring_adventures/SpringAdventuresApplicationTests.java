package com.experimental_software.spring_adventures;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(PostgresTestcontainerConfig.class)
class SpringAdventuresApplicationTests {

  @Test
  void contextLoads() {}
}
