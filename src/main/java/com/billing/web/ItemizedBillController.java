package com.billing.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.billing.domain.ItemCategoryMaster;
import com.billing.service.BillService;

/**
 * Web Controller to expose the billing logic as a restful service
 * 
 * @author vg461191
 *
 */
@RestController
@RequestMapping("/item")
@CrossOrigin(origins= "*", methods= {RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.PUT})
public class ItemizedBillController {

	@Autowired
	BillService itemizedBillService;

	@GetMapping(path = "/master")
	public ItemCategoryMaster getItemCategoryMaster() {
		return itemizedBillService.getItemCategoryMaster();
	}

	@PutMapping(path = "/master")
	public void putItemCategoryMaster() {
		System.out.println("In the PUT method");
	}
}
