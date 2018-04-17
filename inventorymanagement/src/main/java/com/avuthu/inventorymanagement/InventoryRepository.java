package com.avuthu.inventorymanagement;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InventoryRepository {
	private static final Logger LOG = LoggerFactory.getLogger(InventoryRepository.class.getName());

	private InventoryRepository() {
	}

	private static final InventoryRepository instance = new InventoryRepository();
	private Map<String, Product> productMap = new TreeMap<>();

	private double profitSinceLastReport;

	public static InventoryRepository getInstance() {
		return instance;
	}
	
	public void createProduct(Product product) {
		if (productMap.get(product.getName()) != null) {
			throw new IllegalStateException("product already present in inventory");
		}
		productMap.put(product.getName(), product);
	}

	public void deleteProduct(String productName) {
		if (productMap.get(productName) == null) {
			throw new IllegalStateException("product is not present in the inventory to delete");
		}
		Product product = productMap.remove(productName);
		profitSinceLastReport -= (product.getCostPrice() * product.getQuantity());
		
	}

	public void updateBuy(String productName, int quantity) {
		Product product = productMap.get(productName);
		if (product == null) {
			throw new IllegalStateException("product is not present to update inventory");
		}

		product.setQuantity(product.getQuantity() + quantity);
	}

	public void updateSell(String productName, int quantity) {
		Product product = productMap.get(productName);
		if (product == null) {
			throw new IllegalStateException("product is not present to update inventory");
		}
		profitSinceLastReport += ((product.getSellPrice() - product.getCostPrice()) * quantity);
		product.setQuantity(product.getQuantity() - quantity);
	}

	public void updateSellPrice(String productName, double newSellPrice) {
		Product product = productMap.get(productName);
		if (product == null) {
			throw new IllegalStateException("product is not present to update inventory");
		}
		product.setSellPrice(newSellPrice);
	}

	public double getProfitSinceLastReport() {
		return profitSinceLastReport;
	}

	/**
	 * <pre>
	 * Expected Output
	 * INVENTORY REPORT
	 * Item Name Bought At Sold At AvailableQty Value
	 * -- -- -- -- - -- -- -- -- - -- -- -- - -- -- -- -- -- - -- -- -- -
	 * Book01 10.50 13.79 100 1050.00
	 * Food01 1.47 3.98 498 732.06
	 * Med01 30.63 34.29 100 3063.00
	 * Tab01 57.00 84.98 96 5472.00
	 * -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -
	 * Total value 10317.06
	 * Profit since previous report 116.94
	 * </pre>
	 */
	public void report() {
		double totalValue = 0;
		for (Product product : productMap.values()) {
			double total = product.getCostPrice() * product.getQuantity();
			String details = String.format("%-20s %-20s %-20s %-20d  %-20s%n ", product.getName()
					, new BigDecimal(product.getCostPrice()).setScale(2, BigDecimal.ROUND_HALF_UP).toString()
					, new BigDecimal(product.getSellPrice()).setScale(2, BigDecimal.ROUND_HALF_UP).toString()
					, product.getQuantity()
					, new BigDecimal(total).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
			totalValue += total;
			System.out.println(details);
		}
		System.out.println("Total value "+new BigDecimal(totalValue).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		System.out.println("Profit since previous report "+ new BigDecimal(profitSinceLastReport).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		
		//reset
		profitSinceLastReport = 0;
	}
}