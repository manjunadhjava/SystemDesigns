package com.avuthu.inventorymanagement;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import com.avuthu.inventorymanagement.serice.InventoryService;

public class InventoryTest {
	
	@Test
	public void execute() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("transactions.txt").getFile());

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				new InventoryService().processRequest(scanner.nextLine());
			}
			
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
