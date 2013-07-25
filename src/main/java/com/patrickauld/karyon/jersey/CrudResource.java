package com.patrickauld.karyon.jersey;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.patrickauld.karyon.service.CrudService;

@Path("/{id}")
@Singleton
public class CrudResource {
  
  private final CrudService service;

  @Inject
  public CrudResource(CrudService service) {
    this.service = service;
  }

  @GET
  public String getResource(@PathParam("id") String id) {
    return this.service.get(id);
  }
  
  @PUT
  public void createResource(@PathParam("id") String id, String body) {
    this.service.create(id, body);
  }
  
  @POST
  public void updateResource(@PathParam("id") String id, String body) {
    this.service.update(id, body);
  }
  
  @DELETE
  public void deleteResource(@PathParam("id") String id) {
    this.service.delete(id);
  }
}
