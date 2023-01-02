package com.Drawing;

public class Customer {
	private long customerId;
	private String customerName;
	private String customerContact;
	private Address customerAddress;
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	public Address getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}
	
  public void customerDetails()
  {
	  System.out.println("CustomerId="+this.customerId+" CustomerName="+this.customerName+" CustomerContact="+this.customerContact+" CustomerAddress=(" +getCustomerAddress().getCity() +","+getCustomerAddress().getCountry() +","+getCustomerAddress().getState() +","+getCustomerAddress().getStreet() +","+getCustomerAddress().getZip() +")");
	  System.out.println("CustomerAddress=(" +getCustomerAddress().getStreet() +","+getCustomerAddress().getCity() +","+getCustomerAddress().getState() +","+getCustomerAddress().getCountry() +","+getCustomerAddress().getZip() +")");
	  
  }
}
