package com.patrickauld.karyon.service;

public interface CrudService {

  String get(String id);
  
  void create(String id, String value) throws DuplicateResourceExistsException;
  
  void update(String id, String value) throws ResourceNotFoundException;
  
  void delete(String id);
  
  boolean isOk();
}
