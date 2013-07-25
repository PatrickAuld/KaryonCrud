package com.patrickauld.karyon.app;

import com.netflix.governator.guice.LifecycleInjectorBuilder;
import com.netflix.karyon.server.ServerBootstrap;
import com.patrickauld.karyon.jersey.CrudJerseyModule;
import com.patrickauld.karyon.service.CrudModule;

public class CrudServerBootStrap extends ServerBootstrap {

  @Override
  protected void beforeInjectorCreation(LifecycleInjectorBuilder builder) {
    builder.withAdditionalModules(new CrudModule(), new CrudJerseyModule() );
  }

}
