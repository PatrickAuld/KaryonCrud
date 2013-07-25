package com.patrickauld.karyon.service;

import com.google.inject.AbstractModule;

public class CrudModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(CrudService.class).to(InMemCrudService.class);
  }

}
