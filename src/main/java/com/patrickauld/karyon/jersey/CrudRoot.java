package com.patrickauld.karyon.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class CrudRoot {
  
  @GET
  public String hello() {
    return "Hello World!";
  }

}
