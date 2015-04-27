package com.yuhui.roboc;

public class StockItem {
	public StockItem(String id,int hold,double cost){
		this.id = id;
		this.hold = hold;
		this.cost = cost;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getHold() {
		return hold;
	}
	public void setHold(int hold) {
		this.hold = hold;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	private String id;
	private int hold;
	private double cost;
}
