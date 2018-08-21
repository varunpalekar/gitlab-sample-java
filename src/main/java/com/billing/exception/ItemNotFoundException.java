package com.billing.exception;

public class ItemNotFoundException extends RuntimeException{
  private static final long serialVersionUID = -5754416713316216811L;

  public ItemNotFoundException(String message) {
    super(message);
  }
}
