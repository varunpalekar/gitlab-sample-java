package com.billing.domain;

import java.io.Serializable;

public class Item implements Serializable {
  private static final long serialVersionUID = 2900865465838112985L;
  private Long id;
  private String itemCode;
  private String itemDescription;
  private Integer itemPrice;
  private Integer quantity;
  private String itemCategory;

  public Item(final Long id, final String itemCode, final String itemDescription, final Integer itemPrice,
      final Integer quantity, String itemCategory) {
    super();
    this.id = id;
    this.itemCode = itemCode;
    this.itemDescription = itemDescription;
    this.itemPrice = itemPrice;
    this.quantity = quantity;
    this.itemCategory = itemCategory;
  }

  public Long getId() {
    return id;
  }

  public String getItemCode() {
    return itemCode;
  }

  public String getItemDescription() {
    return itemDescription;
  }

  public Integer getItemPrice() {
    return itemPrice;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public String getItemCategory() {
    return itemCategory;
  }

  public void setItemCode(String itemCode) {
    this.itemCode = itemCode;
  }

  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }

  public void setItemPrice(Integer itemPrice) {
    this.itemPrice = itemPrice;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public void setItemCategory(String itemCategory) {
    this.itemCategory = itemCategory;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((itemCategory == null) ? 0 : itemCategory.hashCode());
    result = prime * result + ((itemCode == null) ? 0 : itemCode.hashCode());
    result = prime * result + ((itemDescription == null) ? 0 : itemDescription.hashCode());
    result = prime * result + ((itemPrice == null) ? 0 : itemPrice.hashCode());
    result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Item other = (Item) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (itemCategory == null) {
      if (other.itemCategory != null)
        return false;
    } else if (!itemCategory.equals(other.itemCategory))
      return false;
    if (itemCode == null) {
      if (other.itemCode != null)
        return false;
    } else if (!itemCode.equals(other.itemCode))
      return false;
    if (itemDescription == null) {
      if (other.itemDescription != null)
        return false;
    } else if (!itemDescription.equals(other.itemDescription))
      return false;
    if (itemPrice == null) {
      if (other.itemPrice != null)
        return false;
    } else if (!itemPrice.equals(other.itemPrice))
      return false;
    if (quantity == null) {
      if (other.quantity != null)
        return false;
    } else if (!quantity.equals(other.quantity))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Item [id=" + id + ", itemCode=" + itemCode + ", itemDescription=" + itemDescription + ", itemPrice="
        + itemPrice + ", quantity=" + quantity + ", itemCategory=" + itemCategory + "]";
  }

}
