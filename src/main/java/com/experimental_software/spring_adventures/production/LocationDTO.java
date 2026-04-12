package com.experimental_software.spring_adventures.production;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Location")
public record LocationDTO(@Schema(example = "50") @JsonProperty("_id") int id) {}
