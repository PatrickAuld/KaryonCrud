package com.patrickauld.karyon.server.health;

import com.netflix.karyon.spi.HealthCheckHandler;

public class CrudHealthCheck implements HealthCheckHandler {

  @Override
  public int getStatus() {
    return 200;
  }

}
