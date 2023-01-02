package com.question;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class Customer {
	Address customerAddress1;
	Address customerAddress2;
	Address customerAddress3;
	Address customerAddress4;
	public Address getCustomerAddress1() {
		return customerAddress1;
	}
	@Resource(name="Address1")
	public void setCustomerAddress1(Address customerAddress1) {
		this.customerAddress1 = customerAddress1;
	}

	public Address getCustomerAddress2() {
		return customerAddress2;
	}
	@Required
	public void setCustomerAddress2(Address customerAddress2) {
		this.customerAddress2 = customerAddress2;
	}
	
	public Address getCustomerAddress3() {
		return customerAddress3;
	}
	@Autowired
	public void setCustomerAddress3(Address customerAddress3) {
		this.customerAddress3 = customerAddress3;
	}
	
	public Address getCustomerAddress4() {
		return customerAddress4;
	}
	@Inject
	public void setCustomerAddress4(Address customerAddress4) {
		this.customerAddress4 = customerAddress4;
	}
	public void customerDetails()
	{
	 
		System.out.println("CustomerAddress1=(" +getCustomerAddress1().getCity() +","+getCustomerAddress1().getState() +")");
		System.out.println("CustomerAddress2=(" +getCustomerAddress2().getCity() +","+getCustomerAddress2().getState() +")");
		System.out.println("CustomerAddress3=(" +getCustomerAddress3().getCity() +","+getCustomerAddress3().getState() +")");
		System.out.println("CustomerAddress4=(" +getCustomerAddress4().getCity() +","+getCustomerAddress4().getState() +")");
	}

}
