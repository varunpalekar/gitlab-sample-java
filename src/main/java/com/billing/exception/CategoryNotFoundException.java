package com.billing.exception;

public class CategoryNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 826854334554544901L;

  public CategoryNotFoundException(String message) {
    super(message);
  }
}
