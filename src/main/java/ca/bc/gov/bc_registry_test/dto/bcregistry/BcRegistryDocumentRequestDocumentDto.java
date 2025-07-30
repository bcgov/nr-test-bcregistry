package ca.bc.gov.bc_registry_test.dto.bcregistry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.With;

@With
@JsonIgnoreProperties(ignoreUnknown = true)
public record BcRegistryDocumentRequestDocumentDto(
    String documentKey,
    String documentType,
    String fileName,
    Long id
) {
}
