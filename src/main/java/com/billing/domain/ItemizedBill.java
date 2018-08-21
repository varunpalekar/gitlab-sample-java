package com.billing.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ItemizedBill implements Serializable {

  private static final long serialVersionUID = 225674518728508634L;
  private List<Item> itemsList;
  private Integer totalBillAmount;
  private Date billDate;
  public ItemizedBill(List<Item> itemsList, Integer totalBillAmount, Date billDate) {
    super();
    this.itemsList = itemsList;
    this.totalBillAmount = totalBillAmount;
    this.billDate = billDate;
  }
  public List<Item> getItemsList() {
    return itemsList;
  }
  public Integer getTotalBillAmount() {
    return totalBillAmount;
  }
  public Date getBillDate() {
    return billDate;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((billDate == null) ? 0 : billDate.hashCode());
    result = prime * result + ((itemsList == null) ? 0 : itemsList.hashCode());
    result = prime * result + ((totalBillAmount == null) ? 0 : totalBillAmount.hashCode());
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
    ItemizedBill other = (ItemizedBill) obj;
    if (billDate == null) {
      if (other.billDate != null)
        return false;
    } else if (!billDate.equals(other.billDate))
      return false;
    if (itemsList == null) {
      if (other.itemsList != null)
        return false;
    } else if (!itemsList.equals(other.itemsList))
      return false;
    if (totalBillAmount == null) {
      if (other.totalBillAmount != null)
        return false;
    } else if (!totalBillAmount.equals(other.totalBillAmount))
      return false;
    return true;
  }
  @Override
  public String toString() {
    return "ItemizedBill [itemsList=" + itemsList.toString() + ", totalBillAmount=" + totalBillAmount + ", billDate=" + billDate
        + "]";
  }
  

}
