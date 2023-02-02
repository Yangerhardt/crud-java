package br.com.crypto.model;

import java.util.Date;

public class Crypto {
	private String name;
	private String symbol;
	private double amount;
	private double priceBought;
	private Date dateBought;
	
	public Crypto(String name, String symbol, double amount, double priceBought, Date dateBought) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.amount = amount;
		this.priceBought = priceBought;
		this.dateBought = new Date();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPriceBought() {
		return priceBought;
	}

	public void setPriceBought(double priceBought) {
		this.priceBought = priceBought;
	}

	public Date getDateBought() {
		return dateBought;
	}

	public void setDateBought(Date dateBought) {
		this.dateBought = dateBought;
	}	
	
}
