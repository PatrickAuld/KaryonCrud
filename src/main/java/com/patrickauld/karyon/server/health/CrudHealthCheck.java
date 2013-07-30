package com.patrickauld.karyon.server.health;

import com.google.inject.Inject;
import com.netflix.karyon.spi.HealthCheckHandler;
import com.patrickauld.karyon.service.CrudService;

public class CrudHealthCheck implements HealthCheckHandler {

  private final CrudService service;
  
  @Inject
  public CrudHealthCheck(CrudService service) {
    super();
    this.service = service;
  }

  @Override
  public int getStatus() {
    return this.service.isOk() ? 200 : 500;
  }

}
