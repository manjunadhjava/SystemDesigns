package com.avuthu.inventorymanagement;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import com.avuthu.inventorymanagement.action.Create;
import com.avuthu.inventorymanagement.action.Delete;
import com.avuthu.inventorymanagement.action.Report;
import com.avuthu.inventorymanagement.action.UpdateBuy;
import com.avuthu.inventorymanagement.action.UpdateSell;
import com.avuthu.inventorymanagement.action.UpdateSellPrice;
import com.avuthu.inventorymanagement.enums.ActionType;

public class InventoryTest {
	
	@Test
	public void execute() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("transactions.txt").getFile());

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] commandTokens = line.split(" ");
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
			
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
