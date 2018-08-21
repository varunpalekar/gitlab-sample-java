package com.billing.service;

import com.billing.domain.ItemizedBill;

public interface WriteService {
  public void writeBill(ItemizedBill bill, String path);
}
