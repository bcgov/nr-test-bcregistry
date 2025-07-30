package ca.bc.gov.bc_registry_test.health;

import org.springframework.boot.actuate.health.HealthIndicator;

public interface ManualHealthIndicator extends HealthIndicator {

  void isHealthy(boolean healthy, Throwable error);


}
