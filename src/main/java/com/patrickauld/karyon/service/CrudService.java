package com.patrickauld.karyon.service;

public interface CrudService {

  String get(String id);
  
  void create(String id, String value);
  
  void update(String id, String value);
  
  void delete(String id);
}
