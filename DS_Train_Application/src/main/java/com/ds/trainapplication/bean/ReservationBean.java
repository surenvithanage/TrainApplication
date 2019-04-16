package com.ds.trainapplication.bean;

import java.util.Date;

public class ReservationBean {
	private Integer id;
	private String customer;
	private Date date;
	private Integer seatsReserved;
	private String receiptNumber;
	
	public ReservationBean() {

	}

	public ReservationBean(Integer id, String customer, Date date, Integer seatsReserved, String receiptNumber) {
		super();
		this.id = id;
		this.customer = customer;
		this.date = date;
		this.seatsReserved = seatsReserved;
		this.receiptNumber = receiptNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getSeatsReserved() {
		return seatsReserved;
	}

	public void setSeatsReserved(Integer seatsReserved) {
		this.seatsReserved = seatsReserved;
	}

	public String getReceiptNumber() {
		return receiptNumber;
	}

	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

}
