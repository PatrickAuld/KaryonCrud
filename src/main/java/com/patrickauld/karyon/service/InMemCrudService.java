package com.patrickauld.karyon.service;

import java.util.HashMap;
import java.util.Map;

final class InMemCrudService implements CrudService {

  private final Map<String, String> resources = new HashMap<String, String>();
  
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

}
