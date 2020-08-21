package com.wellsfargo.coronakit.model;

import java.time.LocalDateTime;
import java.util.Date;

public class CoronaKit {
	
	private String personName;
	private String email;
	private Long contactNumber;
	private Integer totalAmount;
	private String deliveryAddress;
	private LocalDateTime orderDate;
	private boolean orderFinalized;
	
	public CoronaKit() {
		// TODO Auto-generated constructor stub
	}
	
	public CoronaKit(int id, String personName, String email, Long contactNumber, int totalAmount,
			String deliveryAddress, LocalDateTime orderDate, boolean orderFinalized) {
		this.personName = personName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.totalAmount = totalAmount;
		this.deliveryAddress = deliveryAddress;
		this.orderDate = orderDate;
		this.orderFinalized = orderFinalized;
	}
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime localDateTime) {
		this.orderDate = localDateTime;
	}
	public boolean isOrderFinalized() {
		return orderFinalized;
	}
	public void setOrderFinalized(boolean orderFinalized) {
		this.orderFinalized = orderFinalized;
	}

}
