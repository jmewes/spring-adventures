package com.experimental_software.spring_adventures.production;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ProductInventoryControllerTest {

  @Autowired private MockMvc mockMvc;

  /*
  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  @BeforeEach
  public void setUp() {
      mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }
   */

  @Test
  @DisplayName("should get product inventories")
  void test_getProductInventories_happy_path() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("/api/product-inventories").accept("application/json"))
        .andDo(print())
        .andExpect(status().isOk());
  }
}
