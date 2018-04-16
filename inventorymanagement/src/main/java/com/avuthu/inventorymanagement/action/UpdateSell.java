package com.avuthu.inventorymanagement.action;

/**
 * Whenever Mr. X sells some item, then he issues a updateSell command. This
 * command should deduct the quantity of the mentioned item.
 * 
 * <pre>
 * command:
 * updateSell itemName quantity
 * </pre>
 * 
 * @author SravaniKarasani
 *
 */
public class UpdateSell extends InventoryAction {

	@Override
	public void execute(String[] commandTokens) {
		if(commandTokens != null && commandTokens.length !=3) {
			throw new IllegalArgumentException("Invalid command for updating the quatity of a product");
		}
		inventory.updateSell(commandTokens[1], Integer.parseInt(commandTokens[2]));
	}
}