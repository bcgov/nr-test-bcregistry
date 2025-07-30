package ca.bc.gov.bc_registry_test.dto.bcregistry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.With;

@With
@JsonIgnoreProperties(ignoreUnknown = true)
public record BcRegistryDocumentAccessTypeDto(
    @JsonProperty("type")
    String documentType
) {
}
