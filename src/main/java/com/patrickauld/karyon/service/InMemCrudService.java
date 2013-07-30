package com.patrickauld.karyon.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.netflix.governator.annotations.Configuration;

final class InMemCrudService implements CrudService {

  /*
   * Governator injects this using the ArchaiusConfigurationProvider 
   * binding from the CrudModule 
   */
  @Configuration("com.patrickauld.immem.map-init-size")
  private int initMapSize;
  
  private Map<String, String> resources;

  /**
   * Public constructor for Guice
   */
  public InMemCrudService() {}
  
  /**
   * Another constructor for use in unit tests when field injection is not used
   * @param initMapSize
   */
  public InMemCrudService(int initMapSize) {
    this.initMapSize = initMapSize;
  }
  
  /**
   * Part of the Governator lifecycle
   */
  @PostConstruct
  public void init() {
    this.resources = new HashMap<String, String>(this.initMapSize);
  }
  
  @Override
  public String get(String id) {
    return this.resources.get(id);
  }

  @Override
  public void create(String id, String value) throws DuplicateResourceExistsException {
    if( this.resources.containsKey(id) ) {
     throw new DuplicateResourceExistsException(id); 
    }
    this.resources.put(id, value);
  }

  @Override
  public void update(String id, String value) throws ResourceNotFoundException {
    if( !this.resources.containsKey(id) ) {
      throw new ResourceNotFoundException(id);
    }
    this.resources.put(id, value);
  }

  @Override
  public void delete(String id) {
    this.resources.remove(id);
  }

  @Override
  public boolean isOk() {
    return this.resources != null;
  }

}
