package com.example.shopping.wallet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.shopping.wallet.models.Ewallet;
import com.example.shopping.wallet.models.Statement;

@Service
public interface EwalletService {

	public List<Ewallet> getWallets();
	//public Ewallet addWallet(Ewallet ewallet);
	public void addMoney(int profileId,double amount);
	public Ewallet addWalletForProfile(Ewallet ewallet,int profileId);
	//public void updateWallet(Ewallet ewallet,double amount,String statement,int id);
	public Ewallet getWalletById(int id);
	public List<Statement> getStatementById(int statementId);
	public List<Statement> getAllStatements();
	public String deleteWalletById(int id);
	public  void doTransaction(int profileId,double amount);
}
