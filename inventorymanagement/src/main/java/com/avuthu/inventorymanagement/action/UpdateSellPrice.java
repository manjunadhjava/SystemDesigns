package com.avuthu.inventorymanagement.action;

/**
 * 
 * Mr. X is now happy with the current system, however at times some goods are
 * not selling out faster than expected. In this case he wants to change the
 * initial selling price of that item. So he wants a new command. This command
 * will update the sellingPrice of the specified item.
 * 
 * <pre>
 * command:
 * updateSellPrice itemName newSellPrice
 * </pre>
 * 
 * @author SravaniKarasani
 *
 */
public class UpdateSellPrice extends InventoryAction {

	@Override
	public void execute(String[] commandTokens) {
		if(commandTokens != null && commandTokens.length !=3) {
			throw new IllegalArgumentException("Invalid command for updating the price of a product");
		}
		inventory.updateSellPrice(commandTokens[1], Double.parseDouble(commandTokens[2]));
	}

}
