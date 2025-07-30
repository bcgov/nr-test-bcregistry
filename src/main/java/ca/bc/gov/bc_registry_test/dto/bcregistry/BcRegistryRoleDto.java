package ca.bc.gov.bc_registry_test.dto.bcregistry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import lombok.With;

@With
@JsonIgnoreProperties(ignoreUnknown = true)
public record BcRegistryRoleDto(
    LocalDate appointmentDate,
    LocalDate cessationDate,
    String roleType
) {
  public boolean active() {
    return cessationDate == null || LocalDate.now().isBefore(cessationDate);
  }
}
