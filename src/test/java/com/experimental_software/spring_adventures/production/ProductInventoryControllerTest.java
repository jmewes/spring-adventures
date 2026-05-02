package com.experimental_software.spring_adventures.production;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.experimental_software.spring_adventures.PostgresTestcontainerConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Import(PostgresTestcontainerConfig.class)
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
  @DisplayName("should get top3 product inventories")
  void test_getTop3ProductInventories_happy_path() throws Exception {
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/api/product-inventories/top3").accept("application/json"))
        .andDo(print())
        .andExpect(status().isOk());
  }
}
