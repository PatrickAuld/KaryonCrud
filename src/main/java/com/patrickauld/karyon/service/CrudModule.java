package com.patrickauld.karyon.service;

import com.google.inject.AbstractModule;
import com.netflix.governator.configuration.ArchaiusConfigurationProvider;
import com.netflix.governator.configuration.ConfigurationProvider;

public class CrudModule extends AbstractModule {

  @Override
  protected void configure() {
    //Bind our service used by the Jersey Resource
    bind(CrudService.class).to(InMemCrudService.class);
    
    //Bind a configuration provider that the InMemCrudService uses
    bind(ConfigurationProvider.class).to(ArchaiusConfigurationProvider.class);
  }

}
