package com.example.order.entity;

public class Order {

	private long id;
	private long orderId;
	private float amount;
	private String currency;
	private String comment;
	private String filename;
	private float line;

	public void setId(long id) {
		this.id = id;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "{ id=" + id + ", orderId=" + orderId + ", amount=" + amount + ", currency=" + currency + ", comment="
				+ comment + ", filename=" + filename + ", line=" + line + ", result=" + result + "}";
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setLine(float line) {
		this.line = line;
	}

	public void setResult(String result) {
		this.result = result;
	}

	private String result;

	public long getId() {
		return id;
	}

	public long getOrderId() {
		return orderId;
	}

	public float getAmount() {
		return amount;
	}

	public String getComment() {
		return comment;
	}

	public String getFilename() {
		return filename;
	}

	public float getLine() {
		return line;
	}

	public String getResult() {
		return result;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
