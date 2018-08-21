package com.billing.domain;

public enum ItemCategoryEnum {
  TEA("TEA"), COFFEE("COFFEE"), COLDDRINKS("COLDDRINKS");
  ItemCategoryEnum(String itemType) {
    this.itemType = itemType;
  }

  String itemType;

  public String getItemType() {
    return itemType;
  }

  public static boolean contains(String s) {
    for (ItemCategoryEnum choice : values())
      if (choice.name().equals(s))
        return true;
    return false;
  }
}
