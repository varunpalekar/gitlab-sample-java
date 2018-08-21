package com.billing.exception;

public class UnSupportedBillFormatException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 7075313887990110398L;

  public UnSupportedBillFormatException(String message) {
    super(message);
  }

}
