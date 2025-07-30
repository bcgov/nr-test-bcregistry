package ca.bc.gov.bc_registry_test.configuration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties("ca.bc.gov.nrs")
public class TestAppConfiguration {

  @NestedConfigurationProperty
  private BcRegistryConfiguration bcregistry;

  /**
   * The BC Registry configuration.
   */
  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class BcRegistryConfiguration {

    private String uri;
    private String apiKey;
    private String accountId;
  }

}
