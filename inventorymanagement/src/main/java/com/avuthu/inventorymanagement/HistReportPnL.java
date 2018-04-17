package com.avuthu.inventorymanagement;

import java.util.Date;

public class HistReportPnL {
	private Date runTime;
	private double profit;
	
	public HistReportPnL(Date runTime, double profit) {
		this.runTime = runTime;
		this.profit = profit;
	}
	public Date getRunTime() {
		return runTime;
	}
	public double getProfit() {
		return profit;
	}
}