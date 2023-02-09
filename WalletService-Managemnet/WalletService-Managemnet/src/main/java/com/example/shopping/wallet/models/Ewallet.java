package com.example.shopping.wallet.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
//@AllArgsConstructor
@NoArgsConstructor
@Document(collection="ewallet")
public class Ewallet {
     @Id
	private int walletId;
	private int profileId;
	private double currentBalance;
	private List<String> statement;
	public Ewallet(int profileId,double currentBalance,List<String> statements)
	{
		this.profileId=profileId;
		this.currentBalance=currentBalance;
		this.statement=statements;
	}
}
