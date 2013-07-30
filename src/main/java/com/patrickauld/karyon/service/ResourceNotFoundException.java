package com.patrickauld.karyon.service;

public class ResourceNotFoundException extends Exception {
  private static final long serialVersionUID = -7028912544134787868L;

  public ResourceNotFoundException(String id) {
    super("Resource " + id + " + not found");
  }

}
