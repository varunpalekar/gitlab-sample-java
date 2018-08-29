// package com.billing.service;

// import static org.assertj.core.api.Assertions.assertThat;
// import static org.junit.Assert.fail;

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.concurrent.ConcurrentHashMap;

// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit4.SpringRunner;

// import com.billing.domain.Item;
// import com.billing.domain.ItemCategoryEnum;
// import com.billing.domain.ItemizedBill;
// import com.billing.exception.CategoryNotFoundException;
// import com.billing.exception.ItemNotFoundException;
// import com.billing.exception.UnSupportedBillFormatException;

// @RunWith(SpringRunner.class)
// @SpringBootTest

// public class ItemizedBillingServiceTest {

//   Logger log =  LoggerFactory.getLogger(ItemizedBillingServiceTest.class);
  
//   private Map<String, ConcurrentHashMap<String, Integer>> masterItemDataMap = new HashMap<String, ConcurrentHashMap<String, Integer>>();

//   @Autowired
//   BillService itemizedBillService;
  
//   @Value("${test.billpath}")
//   private String path;

//   @Before
//   public void init() {
//     // itemizedBillService = new ItemizedBillService(mockItemMasterRepository);
//     ConcurrentHashMap<String, Integer> teaMap = new ConcurrentHashMap<>();
//     teaMap.put("TM", 10);
//     teaMap.put("TM", 15);
//     teaMap.put("TM", 15);

//     ConcurrentHashMap<String, Integer> coffeeMap = new ConcurrentHashMap<>();
//     coffeeMap.put("CC", 10);
//     coffeeMap.put("CL", 15);
//     coffeeMap.put("CM", 15);

//     ConcurrentHashMap<String, Integer> coldDrinkMap = new ConcurrentHashMap<>();
//     coldDrinkMap.put("CDC", 10);
//     coldDrinkMap.put("CDP", 15);
//     coldDrinkMap.put("CDS", 15);

//     masterItemDataMap.put(ItemCategoryEnum.TEA.getItemType(), teaMap);
//     masterItemDataMap.put(ItemCategoryEnum.COFFEE.getItemType(), coffeeMap);
//     masterItemDataMap.put(ItemCategoryEnum.COLDDRINKS.getItemType(), coldDrinkMap);
//   }

//   @Test
//   public void generateItemizedBill() {
//     ItemizedBill bill = itemizedBillService.generateBill(prepareItemList(),"TEXT", path);
//     // Printing the output of the itemized bill here
//     log.info(bill.toString());
//     assertThat(bill.getTotalBillAmount()).isEqualTo(35);
//   }

//   @Test
//   public void generateItemizedBill_categoryNotFound() {
//     List<Item> items = prepareItemList();
//     items.add(new Item(4l, "TM", "MasalaTea", null, 1, "MOJITO"));
//     try {
//       itemizedBillService.generateBill(items,"TEXT", path);
//       fail("Should have failed when Category is not found");
//     } catch (CategoryNotFoundException ex) {
//       assertThat(ex.getMessage()).isEqualTo("TM's does not have a valid Category: MOJITO");
//     }
//   }

//   @Test
//   public void generateItemizedBill_itemNotFound() {
//     List<Item> items = prepareItemList();
//     items.add(new Item(4l, "TMZ", "MasalaTea", null, 1, "TEA"));
//     try {
//       itemizedBillService.generateBill(items,"TEXT", path);
//       fail("Should have failed when Category is not found");
//     } catch (ItemNotFoundException ex) {
//       assertThat(ex.getMessage()).isEqualTo("TMZ is not available in category TEA");
//     }
//   }
  
//   @Test
//   public void generateItemizedBill_UnsupportedFormatExceptionJPG() {
//     List<Item> items = prepareItemList();
//     items.add(new Item(4l, "TM", "MasalaTea", null, 1, "TEA"));
//     try {
//       itemizedBillService.generateBill(items,"JPG", path);
//       fail("Should have failed when Category is not found");
//     } catch (UnSupportedBillFormatException ex) {
//       assertThat(ex.getMessage()).isEqualTo("The mentioned format is not supported");
//     }
//   }

//   private List<Item> prepareItemList() {
//     List<Item> itemsList = new ArrayList<Item>();
//     itemsList.add(new Item(1l, "TM", "MasalaTea", null, 1, "TEA"));
//     itemsList.add(new Item(2l, "CC", "COFFEE", null, 1, "COFFEE"));
//     itemsList.add(new Item(3l, "CDC", "COLDDRINKS", null, 1, "COLDDRINKS"));
//     return itemsList;
//   }

// }
