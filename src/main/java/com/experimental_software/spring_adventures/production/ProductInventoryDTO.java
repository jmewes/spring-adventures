package com.experimental_software.spring_adventures.production;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ProductInventory")
public record ProductInventoryDTO(
    ProductDTO product, LocationDTO location, @Schema(example = "364") int quantity) {}
