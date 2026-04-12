package com.experimental_software.spring_adventures.production;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductDTOTest {

  @Test
  @DisplayName("should create product without name")
  void test_noName_happy_path() {
    var result = ProductDTO.noName();
    assertThat(result.name()).isEqualTo("n/a");
  }
}
