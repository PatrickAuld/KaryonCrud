package com.patrickauld.karyon.service;

import com.netflix.hystrix.HystrixCommand;

import com.netflix.hystrix.HystrixCommandGroupKey;

public class HystrixCrudServiceDecorator implements CrudService {

  private static final HystrixCommand.Setter setter = 
      HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("CrudService"));
  
  private final CrudService deligate;

  public HystrixCrudServiceDecorator(@CrudServiceImpl CrudService deligate) {
    super();
    this.deligate = deligate;
  }

  @Override
  public String get(final String id) {
    return new HystrixCommand<String>(setter) {
      @Override
      protected String run() throws Exception {
        return deligate.get(id);
      }
    }.execute();
  }

  @Override
  public void create(final String id, final String value) throws DuplicateResourceExistsException {
    new HystrixCommand<Void>(setter) {
      @Override
      protected Void run() throws Exception {
        deligate.create(id, value);
        return null;
      }
    }.execute();
  }

  @Override
  public void update(final String id, final String value) throws ResourceNotFoundException {
    new HystrixCommand<Void>(setter) {
      @Override
      protected Void run() throws Exception {
        deligate.update(id, value);
        return null;
      }
    }.execute();
  }

  @Override
  public void delete(final String id) {
    new HystrixCommand<Void>(setter) {
      @Override
      protected Void run() throws Exception {
        deligate.delete(id);
        return null;
      }
    }.execute();
  }

  @Override
  public boolean isOk() {
    return new HystrixCommand<Boolean>(setter) {
      @Override
      protected Boolean run() throws Exception {
        return deligate.isOk();
      }
    }.execute();
  }

}
