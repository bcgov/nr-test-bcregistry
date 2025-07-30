package ca.bc.gov.bc_registry_test.controller;

import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryDocumentDto;
import ca.bc.gov.bc_registry_test.dto.bcregistry.BcRegistryFacetSearchResultEntryDto;
import ca.bc.gov.bc_registry_test.service.bcregistry.BcRegistryService;
import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/api/bcregistry", produces = MediaType.APPLICATION_JSON_VALUE)
@Observed
@RequiredArgsConstructor
public class BcRegistryController {

  private final BcRegistryService service;


  @GetMapping("/facets")
  Flux<BcRegistryFacetSearchResultEntryDto> searchByFacets(
      @RequestParam(name = "name", required = false) String name,
      @RequestParam(name = "identifier", required = false) String identifier
  ) {
    return service.searchByFacets(name, identifier);
  }

  @GetMapping("/documents/{identifier}")
  Flux<BcRegistryDocumentDto> getDocument(@PathVariable String identifier) {
    return service.requestDocumentData(identifier);
  }

}
