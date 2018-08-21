package com.billing.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

public class ItemCategoryMaster {
  @Id
  private String id;
  private List<ItemCategory> itemCategories;
  private String masterName;

  public ItemCategoryMaster(List<ItemCategory> itemCategories, String masterName) {
    super();
    this.itemCategories = itemCategories;
    this.masterName = masterName;
  }

  public String getMasterName() {
    return masterName;
  }

  public void setMasterName(String masterName) {
    this.masterName = masterName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<ItemCategory> getItemCategories() {
    return itemCategories;
  }

  public void setItemCategories(List<ItemCategory> itemCategories) {
    this.itemCategories = itemCategories;
  }

  public static class ItemCategory {
    private String categoryCode;
    private List<Item> itemList;

    public ItemCategory(String categoryCode, List<Item> itemList) {
      super();
      this.categoryCode = categoryCode;
      this.itemList = itemList;
    }

    public String getCategoryCode() {
      return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
      this.categoryCode = categoryCode;
    }

    public List<Item> getItemList() {
      return itemList;
    }

    public void setItemList(List<Item> itemList) {
      this.itemList = itemList;
    }

    @Override
    public String toString() {
      return "ItemCategory [categoryCode=" + categoryCode + ", itemList=" + itemList + "]";
    }

  }

  @Override
  public String toString() {
    return "ItemCategoryMaster [id=" + id + ", itemCategories=" + itemCategories + ", masterName=" + masterName + "]";
  }

}
