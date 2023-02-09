package com.example.shoppingcart.profile.models;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@NotNull
	private int houseNumber;
	private String streetName;
	private String colonyName;
	private String city;
	private String state;
	
	@NotNull	
	private int pincode;

}
