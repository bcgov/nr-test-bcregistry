package ca.bc.gov.bc_registry_test.dto.bcregistry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BcRegistryIdentificationDto(
    BcRegistryBusinessDto business,
    BcRegistryBusinessAdressesDto businessOffice
) {
}
