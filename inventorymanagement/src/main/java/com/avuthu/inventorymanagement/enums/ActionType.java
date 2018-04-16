package com.avuthu.inventorymanagement.enums;

public enum ActionType {

	CREATE("create")
	, DELETE("delete")
	, UPDATE_BUY("updateBuy")
	, UPDATE_SELL("updateSell")
	, UPDATE_SELL_PRICE("updateSellPrice")
	, REPORT("report");
	
	private String commandString;
	
	ActionType(String commandString) {
		this.commandString = commandString;
	}

	public static ActionType fromString(String action) {
		for(ActionType actionType : ActionType.values()) {
			if(actionType.getCommandString().equalsIgnoreCase(action)) {
				return actionType;
			}
		}
		throw new IllegalArgumentException("action type is not supported");
	}
	
	public String getCommandString() {
		return commandString;
	}
}
