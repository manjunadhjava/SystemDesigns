package com.avuthu.inventorymanagement.action;

/**
 * If Mr. X decides not to sell an item anymore, then he simply issues a delete
 * command. This command will remove the item from the inventory.
 * 
 * <pre>
 * command:
 * delete itemName
 * </pre>
 * 
 * @author ASR
 *
 */
public class Delete extends InventoryAction {

	@Override
	public void execute(String[] commandTokens) {
		if(commandTokens != null && commandTokens.length !=2) {
			throw new IllegalArgumentException("Invalid command for deleting a product");
		}
		inventory.deleteProduct(commandTokens[1]);

	}

}
