package com.capgemini.cart.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="products")
public class Product {

	 /*This helps ignoring the field by not mapping it to the database*/
		@Transient
		public  static final String sequenceName="ProductSequence";
		
		/*Providing all variables required */
	    /*Setting up the below variable as primary key in the collection*/
		@Id
		private int productId;
		
		@NotEmpty(message="ProductType is empty")
		private String productType;
		@NotEmpty(message="Product Name is empty")
		private String productName;
		private String category;
		

		private String rating;
		
		private String review;
		private String image;
		
		@NotNull
		private double price;
		private String description;
		
		private String specification;

		public static String getSequencename() {
			return sequenceName;
		}
		
       
}
