package com.billing.exception;

public class FileWriteException extends RuntimeException {

  private static final long serialVersionUID = -2050723223715564237L;

  public FileWriteException(String message) {
    super(message);
  }
}
