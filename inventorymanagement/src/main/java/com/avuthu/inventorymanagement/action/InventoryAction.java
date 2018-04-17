package com.avuthu.inventorymanagement.action;

import com.avuthu.inventorymanagement.InventoryRepository;

public abstract class InventoryAction {
	protected InventoryRepository inventory;
	public static final String SPACE = " ";
	
	InventoryAction() {
		inventory = InventoryRepository.getInstance();
	}
	
	protected String[] getCommandTokens(String command) {
		return command.split(SPACE);
	}
	
	public abstract void execute(String[] commandTokens);
}