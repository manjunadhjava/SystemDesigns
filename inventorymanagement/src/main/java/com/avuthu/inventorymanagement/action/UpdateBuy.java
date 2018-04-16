package com.avuthu.inventorymanagement.action;

/**
 * 
 * Whenever Mr. X purchases additional quantity of the mentioned item, then he
 * issues a updateBuy command. This command should increase the quantity of the
 * mentioned item.
 * 
 * <pre>
 * updateBuy itemName quantity
 * </pre>
 * 
 * @author ASR
 *
 */
public class UpdateBuy extends InventoryAction {

	@Override
	public void execute(String[] commandTokens) {
		if(commandTokens != null && commandTokens.length !=3) {
			throw new IllegalArgumentException("Invalid command for updating the quatity of a product");
		}
		inventory.updateBuy(commandTokens[1], Integer.parseInt(commandTokens[2]));
	}
}