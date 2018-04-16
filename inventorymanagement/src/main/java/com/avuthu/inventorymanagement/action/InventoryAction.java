package com.avuthu.inventorymanagement.action;

import com.avuthu.inventorymanagement.Inventory;

public abstract class InventoryAction {
	protected Inventory inventory;
	public static final String SPACE = " ";
	
	InventoryAction() {
		inventory = Inventory.getInstance();
	}
	
	protected String[] getCommandTokens(String command) {
		return command.split(SPACE);
	}
	
	public abstract void execute(String[] commandTokens);
}