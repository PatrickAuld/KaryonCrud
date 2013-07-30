package com.patrickauld.karyon.service;

public class DuplicateResourceExistsException extends Exception {
  private static final long serialVersionUID = 2300336022266185191L;

  public DuplicateResourceExistsException(String resourceName) {
    super("Resource " + resourceName + " already exists");
  }

}
