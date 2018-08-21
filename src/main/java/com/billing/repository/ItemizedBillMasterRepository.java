package com.billing.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.billing.domain.Item;
import com.billing.domain.ItemCategoryEnum;
import com.billing.domain.ItemCategoryMaster;
import com.billing.domain.ItemCategoryMaster.ItemCategory;

@Repository
public class ItemizedBillMasterRepository implements InitializingBean {

  Logger log = LoggerFactory.getLogger(ItemizedBillMasterRepository.class);

  @Autowired
  private ItemCategoryMasterRepository itemCategoryMasterRepository;

  private final Map<String, ConcurrentHashMap<String, Integer>> itemCategoryMasterMap = new HashMap<String, ConcurrentHashMap<String, Integer>>();

  public Map<String, ConcurrentHashMap<String, Integer>> getItemCategoryMasterMap() {
    return itemCategoryMasterMap;
  }

  public ItemCategoryMaster getItemizedCategoryMaster() {
    return itemCategoryMasterRepository.findByMasterName("CafeBilling");
  }

  /**
   * Utility Method for adding more categories for future enhancements
   * 
   * @param category
   * @param itemCode
   * @param price
   */
  public void addItemInMaster(String category, String itemCode, Integer price) {
    if (itemCategoryMasterMap.get(category) == null) {
      ConcurrentHashMap<String, Integer> newMap = new ConcurrentHashMap<>();
      newMap.put(itemCode, price);
      itemCategoryMasterMap.put(category, newMap);
    } else {
      itemCategoryMasterMap.get(category).put(itemCode, price);
    }
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    log.info("TOTALCOUNT :: " + itemCategoryMasterRepository.count());
    if (itemCategoryMasterRepository.count() == 0) {
      // TODO Auto-generated method stub
      List<ItemCategory> itemCategories = new ArrayList<ItemCategory>();
      List<Item> teaItems = new ArrayList<Item>();
      teaItems.add(new Item.Itembuilder("TM", 10).buildItem());
      teaItems.add(new Item.Itembuilder("TG", 15).buildItem());
      teaItems.add(new Item.Itembuilder("GT", 15).buildItem());
      ItemCategory tea = new ItemCategory(ItemCategoryEnum.TEA.getItemType(), teaItems);
      itemCategories.add(tea);
      List<Item> coffeeItems = new ArrayList<Item>();
      coffeeItems.add(new Item.Itembuilder("CC", 10).buildItem());
      coffeeItems.add(new Item.Itembuilder("CL", 15).buildItem());
      coffeeItems.add(new Item.Itembuilder("CM", 15).buildItem());
      ItemCategory coffee = new ItemCategory(ItemCategoryEnum.COFFEE.getItemType(), coffeeItems);
      itemCategories.add(coffee);
      List<Item> coldItems = new ArrayList<Item>();
      coldItems.add(new Item.Itembuilder("CDC", 10).buildItem());
      coldItems.add(new Item.Itembuilder("CDP", 15).buildItem());
      coldItems.add(new Item.Itembuilder("CDS", 15).buildItem());
      ItemCategory colddrinks = new ItemCategory(ItemCategoryEnum.COLDDRINKS.getItemType(), coldItems);
      itemCategories.add(colddrinks);
      ItemCategoryMaster master = new ItemCategoryMaster(itemCategories, "CafeBilling");
      itemCategoryMasterRepository.save(master);
    }
 // Remove below later
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
