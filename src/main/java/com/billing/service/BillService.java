package com.billing.service;

import com.billing.domain.Item;
import com.billing.domain.ItemizedBill;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface BillService {

  public ItemizedBill generateBill(List<Item> items, String format, String path);
  
  public Map<String, ConcurrentHashMap<String, Integer>> getItemMasterMap();
}
