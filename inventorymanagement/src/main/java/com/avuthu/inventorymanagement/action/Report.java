package com.avuthu.inventorymanagement.action;

/**
 * 
 * Whenever Mr. X wants to view his inventory list he issues the report command.
 * This command should print the current inventory details in the specified
 * format sorted by alphabetical order. Apart from printing the inventory it has
 * to report on the profit made by Mr. X since last report generation. Where
 * profit is calculated by: ∑ (sellingPrice-costPrice) of the sold items
 * multiplied by no. of items sold- costPrice of the deleted items.
 * 
 * <pre>
 * command:
 * report
 * </pre>
 * 
 * @author SravaniKarasani
 *
 */
public class Report extends InventoryAction {

	@Override
	public void execute(String[] commandTokens) {
		if(commandTokens != null && commandTokens.length !=1) {
			throw new IllegalArgumentException("Invalid command for displaying the report");
		}
		inventory.report();
	}

}
