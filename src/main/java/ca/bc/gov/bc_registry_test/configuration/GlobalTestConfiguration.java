package ca.bc.gov.bc_registry_test.configuration;

import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryAddressDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryAlternateNameDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryBusinessAdressesDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryBusinessDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryDocumentAccessRequestDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryDocumentAccessTypeDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryDocumentDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryDocumentRequestBodyDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryDocumentRequestDocumentDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryDocumentRequestResponseDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryExceptionMessageDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryFacetPartyDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryFacetRequestBodyDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryFacetRequestQueryDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryFacetResponseDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryFacetSearchResultEntryDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryFacetSearchResultsDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryIdentificationDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryOfficerDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryOfficesDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryPartyDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryRoleDto;
import ca.bc.gov.bc_registry_test.health.HealthExchangeFilterFunction;
import ca.bc.gov.bc_registry_test.health.ManualHealthIndicator;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RegisterReflectionForBinding({
    BcRegistryAddressDto.class,
    BcRegistryAlternateNameDto.class,
    BcRegistryBusinessAdressesDto.class,
    BcRegistryBusinessDto.class,
    BcRegistryDocumentAccessRequestDto.class,
    BcRegistryDocumentAccessTypeDto.class,
    BcRegistryDocumentDto.class,
    BcRegistryDocumentRequestBodyDto.class,
    BcRegistryDocumentRequestDocumentDto.class,
    BcRegistryDocumentRequestResponseDto.class,
    BcRegistryExceptionMessageDto.class,
    BcRegistryFacetPartyDto.class,
    BcRegistryFacetRequestBodyDto.class,
    BcRegistryFacetRequestQueryDto.class,
    BcRegistryFacetResponseDto.class,
    BcRegistryFacetSearchResultEntryDto.class,
    BcRegistryFacetSearchResultsDto.class,
    BcRegistryIdentificationDto.class,
    BcRegistryOfficerDto.class,
    BcRegistryOfficesDto.class,
    BcRegistryPartyDto.class,
    BcRegistryRoleDto.class
})
public class GlobalTestConfiguration {

  @Bean
  public WebClient bcRegistryApi(
      TestAppConfiguration configuration,
      @Qualifier("bcRegistryApiHealthIndicator") ManualHealthIndicator bcRegistryApiHealthIndicator,
      WebClient.Builder webClientBuilder
  ) {
    return webClientBuilder
        .baseUrl(configuration.getBcregistry().getUri())
        .defaultHeader("x-apikey", configuration.getBcregistry().getApiKey())
        .defaultHeader("Account-Id", configuration.getBcregistry().getAccountId())
        .filter(new HealthExchangeFilterFunction(bcRegistryApiHealthIndicator))
        .build();
  }

}
