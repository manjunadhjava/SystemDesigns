package com.avuthu.inventorymanagement.serice;

import com.avuthu.inventorymanagement.action.Create;
import com.avuthu.inventorymanagement.action.Delete;
import com.avuthu.inventorymanagement.action.Report;
import com.avuthu.inventorymanagement.action.UpdateBuy;
import com.avuthu.inventorymanagement.action.UpdateSell;
import com.avuthu.inventorymanagement.action.UpdateSellPrice;
import com.avuthu.inventorymanagement.enums.ActionType;

public class InventoryService {
	public void processRequest(String command) {
		String[] commandTokens = command.split(" ");
		switch(ActionType.fromString(commandTokens[0])) {
			case CREATE : new Create().execute(commandTokens);
				break;
			case DELETE : new Delete().execute(commandTokens);
				break;
			case UPDATE_BUY : new UpdateBuy().execute(commandTokens);
				break;
			case UPDATE_SELL : new UpdateSell().execute(commandTokens);
				break;
			case UPDATE_SELL_PRICE : new UpdateSellPrice().execute(commandTokens);
				break;
			case REPORT : new Report().execute(commandTokens);
		}
	}
}
