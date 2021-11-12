package com.spring.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
List<Inventory> inventoryList = new ArrayList<Inventory>();

	@GetMapping("/inventory/{productID}")
public Inventory getInventoryDetails(@PathVariable Long productID) {

		Inventory inventory = getInventoryInfo(productID);
	return inventory;
}
	
	private Inventory getInventoryInfo(Long productID) {
		populateInventoryList();
		for(Inventory i:inventoryList) {
			if(productID.equals(i.getProductID())) {
				return i;
			}
		}
		return null;
	}
	private void populateInventoryList() {
		inventoryList.add(new Inventory(301L, 101L,false));
		inventoryList.add(new Inventory(301L, 101L,true));
		inventoryList.add(new Inventory(301L, 101L,false));
		}
}