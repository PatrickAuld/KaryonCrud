package com.patrickauld.karyon.app;

import com.netflix.governator.guice.BootstrapBinder;
import com.netflix.karyon.server.ServerBootstrap;
import com.patrickauld.karyon.jersey.CrudJerseyModule;
import com.patrickauld.karyon.service.CrudModule;

public class CrudServerBootStrap extends ServerBootstrap {

  @Override
  protected void configureBootstrapBinder(BootstrapBinder bootstrapBinder) {
    bootstrapBinder.install(new CrudModule());
    bootstrapBinder.install(new CrudJerseyModule());
  }
  
}
