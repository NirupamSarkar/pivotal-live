package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stock {
		
	
	
	public Stock() {
		// TODO Auto-generated constructor stub
	}
	@Id
	private String ticker;
	private Double price;
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Stock(String ticker, Double price) {
		super();
		this.ticker = ticker;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Stock [ticker=" + ticker + ", price=" + price + ", getTicker()=" + getTicker() + ", getPrice()="
				+ getPrice() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
