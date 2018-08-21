package com.billing.domain;

public enum BillFormat {
  TEXT("TEXT"), HTML("HTML");
  private String format;
  private BillFormat(String format) {
    this.format = format;
  }
  public String getFormat() {
    return format;
  }
}
