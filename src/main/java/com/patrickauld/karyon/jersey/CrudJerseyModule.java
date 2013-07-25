package com.patrickauld.karyon.jersey;

import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class CrudJerseyModule extends JerseyServletModule {

  @Override
  protected void configureServlets() {
    bind(CrudRoot.class).asEagerSingleton();
    bind(CrudResource.class).asEagerSingleton();

    serve("/*").with(GuiceContainer.class);
  }
}
