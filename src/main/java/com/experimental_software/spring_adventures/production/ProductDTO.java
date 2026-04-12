package com.experimental_software.spring_adventures.production;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.jspecify.annotations.NullMarked;

@Builder
@NullMarked
public record ProductDTO(
    @Schema(example = "2") @JsonProperty("_id") int id,
    @Schema(example = "Bearing Ball")
        // @NonNull
        String name) {

  public static ProductDTO noName() {
    return ProductDTO.builder().id(42).name("n/a").build();

    /*
    return ProductDTO.builder()
        .id(42)
        .name(null) // yields compiler error: [NullAway] passing @Nullable parameter 'null' where @NonNull is required
        .build();
     */
  }
}
