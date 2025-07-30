package ca.bc.gov.bc_registry_test.dto.bcregistry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;
import lombok.With;

@With
@JsonIgnoreProperties(ignoreUnknown = true)
public record BcRegistryFacetRequestBodyDto(
    BcRegistryFacetRequestQueryDto query,
    Map<String, List<String>> categories,
    int rows,
    int start
) {

}
