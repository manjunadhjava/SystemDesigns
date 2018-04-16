package com.avuthu.inventorymanagement.action;

import com.avuthu.inventorymanagement.Product;

/**
 * Whenever Mr. X wants to add a new item to his store he issues a create
 * command. This command creates a new item in the inventory with the given cost
 * price and selling price. The prices are rounded off to two decimal places.
 * 
 * <pre>
 * command:
 * create itemName costPrice sellingPrice
 * </pre>
 * 
 * @author ASR
 *
 */
public class Create extends InventoryAction {
	
	@Override
	public void execute(String[] commandTokens) {
		if(commandTokens != null && commandTokens.length !=4) {
			throw new IllegalArgumentException("Invalid command for creating a product");
		}
		
		Product product = new Product();
		product.setName(commandTokens[1]);
		product.setCostPrice(Double.parseDouble(commandTokens[2]));
		product.setSellPrice(Double.parseDouble(commandTokens[3]));
		inventory.createProduct(product);
	}

}
