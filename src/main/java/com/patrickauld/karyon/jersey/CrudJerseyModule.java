package com.patrickauld.karyon.jersey;

import java.util.Map;

import com.google.common.collect.Maps;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class CrudJerseyModule extends JerseyServletModule {

  @Override
  protected void configureServlets() {
    Map<String, String> params = Maps.newHashMap();
    params.put("com.sun.jersey.config.property.packages","com.patrickauld.karyon");
    serve("/*").with(GuiceContainer.class, params);
  }
}
