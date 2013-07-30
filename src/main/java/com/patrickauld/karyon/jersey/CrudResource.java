package com.patrickauld.karyon.jersey;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.patrickauld.karyon.service.CrudService;
import com.patrickauld.karyon.service.DuplicateResourceExistsException;
import com.patrickauld.karyon.service.ResourceNotFoundException;

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
    String value = this.service.get(id);
    if( value == null ) {
      throw new WebApplicationException(Status.NOT_FOUND);
    }
    return value;
  }
  
  @PUT
  public void createResource(@PathParam("id") String id, String body) {
    try {
      this.service.create(id, body);
    } catch (DuplicateResourceExistsException e) {
      throw new WebApplicationException(e, Status.BAD_REQUEST);
    }
  }
  
  @POST
  public void updateResource(@PathParam("id") String id, String body) {
    try {
      this.service.update(id, body);
    } catch (ResourceNotFoundException e) {
      throw new WebApplicationException(e, Status.BAD_REQUEST);
    }
  }
  
  @DELETE
  public void deleteResource(@PathParam("id") String id) {
    this.service.delete(id);
  }
}
