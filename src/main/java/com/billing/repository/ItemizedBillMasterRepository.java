package com.billing.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import com.billing.domain.ItemCategoryEnum;

@Repository
public class ItemizedBillMasterRepository implements InitializingBean {
  private final Map<String, ConcurrentHashMap<String, Integer>> itemCategoryMasterMap = new HashMap<String, ConcurrentHashMap<String, Integer>>();

  public Map<String, ConcurrentHashMap<String, Integer>> getItemCategoryMasterMap() {
    return itemCategoryMasterMap;
  }

  /**
   * Utility Method for adding more categories for future enhancements
   * @param category
   * @param itemCode
   * @param price
   */
  public void addItemInMaster(String category, String itemCode, Integer price) {
    if(itemCategoryMasterMap.get(category)==null) {
      ConcurrentHashMap<String, Integer> newMap = new ConcurrentHashMap<>();
      newMap.put(itemCode, price);
      itemCategoryMasterMap.put(category, newMap);
    }
    else {
      itemCategoryMasterMap.get(category).put(itemCode, price);
    }
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    ConcurrentHashMap<String, Integer> teaMap = new ConcurrentHashMap<>();
    teaMap.put("TM", 10);
    teaMap.put("TM", 15);
    teaMap.put("TM", 15);

    ConcurrentHashMap<String, Integer> coffeeMap = new ConcurrentHashMap<>();
    coffeeMap.put("CC", 10);
    coffeeMap.put("CL", 15);
    coffeeMap.put("CM", 15);

    ConcurrentHashMap<String, Integer> coldDrinkMap = new ConcurrentHashMap<>();
    coldDrinkMap.put("CDC", 10);
    coldDrinkMap.put("CDP", 15);
    coldDrinkMap.put("CDS", 15);

    itemCategoryMasterMap.put(ItemCategoryEnum.TEA.getItemType(), teaMap);
    itemCategoryMasterMap.put(ItemCategoryEnum.COFFEE.getItemType(), coffeeMap);
    itemCategoryMasterMap.put(ItemCategoryEnum.COLDDRINKS.getItemType(), coldDrinkMap);
  }

}
