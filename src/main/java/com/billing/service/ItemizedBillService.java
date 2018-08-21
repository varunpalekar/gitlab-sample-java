package com.billing.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billing.domain.Item;
import com.billing.domain.ItemCategoryEnum;
import com.billing.domain.ItemCategoryMaster;
import com.billing.domain.ItemizedBill;
import com.billing.exception.CategoryNotFoundException;
import com.billing.exception.ItemNotFoundException;
import com.billing.repository.ItemizedBillMasterRepository;

@Service
public class ItemizedBillService implements BillService {

  ItemizedBillMasterRepository itemizedBillMasterRepository;

  Logger log = LoggerFactory.getLogger(ItemizedBillService.class);

  @Autowired
  public ItemizedBillService(ItemizedBillMasterRepository itemizedBillMasterRepository) {
    this.itemizedBillMasterRepository = itemizedBillMasterRepository;
  }

  @Autowired
  WriteServiceFacade writeServiceFacade;

  @Override
  public ItemCategoryMaster getItemCategoryMaster() {
    return itemizedBillMasterRepository.getItemizedCategoryMaster();
  }

  /*
   * Generates the Itemized Bill for the passed Items list as parameter Parameter:
   * List of Items Return: Itemized Bill object
   * 
   * @see com.billing.service.BillService#generateBill(java.util.List)
   */
  @Override
  public ItemizedBill generateBill(List<Item> items, String format, String path) throws ItemNotFoundException {
    Map<String, ConcurrentHashMap<String, Integer>> itemMasterCategoryMap = getItemMasterMap();
    List<Item> itemsList = new ArrayList<Item>();
    List<Integer> priceList = new ArrayList<Integer>();

    items.forEach(item -> {
      if (!ItemCategoryEnum.contains(item.getItemCategory())) {
        log.error("Category not Present in system");
        // the category is not among TEA, COFFEE, COLDDRINKS
        throw new CategoryNotFoundException(new StringBuilder().append(item.getItemCode())
            .append("'s does not have a valid Category: ").append(item.getItemCategory()).toString());

      } else if (itemMasterCategoryMap.get(item.getItemCategory()).get(item.getItemCode()) == null) {
        // category is present in the system but it does not have the mentioned item
        // code
        log.error("Item Code not Present in system");
        throw new ItemNotFoundException(new StringBuilder().append(item.getItemCode())
            .append(" is not available in category ").append(item.getItemCategory()).toString());
      } else {
        Integer price = itemMasterCategoryMap.get(item.getItemCategory()).get(item.getItemCode());
        priceList.add(price);
        item.setItemPrice(price);
        itemsList.add(item);
      }
    });

    Integer totalAmount = priceList.stream().reduce(0, Integer::sum);

    ItemizedBill bill = new ItemizedBill(itemsList, totalAmount, new Date());
    writeServiceFacade.writeBill(bill, format, path);
    return bill;
  }

  @Override
  public Map<String, ConcurrentHashMap<String, Integer>> getItemMasterMap() {
    return itemizedBillMasterRepository.getItemCategoryMasterMap();
  }

}
