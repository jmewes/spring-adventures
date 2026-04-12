package com.experimental_software.spring_adventures.production;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "ProductInventory")
@Relation(collectionRelation = "productInventories")
public record ProductInventoryDTO(
    ProductDTO product, LocationDTO location, @Schema(example = "364") int quantity) {}
