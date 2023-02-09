package com.example.shopping.wallet.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping.wallet.models.Ewallet;
import com.example.shopping.wallet.models.Statement;
import com.example.shopping.wallet.models.TransactionType;
import com.example.shopping.wallet.repository.EwalletRepository;
import com.example.shopping.wallet.repository.StatementRepository;

@Service
public class EwalletServiceImpl implements EwalletService{
     @Autowired
	EwalletRepository ewalletRepository;
	
     @Autowired
       StatementRepository statementRepository;

	@Override
	public List<Ewallet> getWallets() {
		
		return ewalletRepository.findAll();
	}

	@Override
	public void addMoney(int profileId, double amount) {
		 
		Ewallet ewallet=ewalletRepository.findByProfileId(profileId);
		double totalBal=amount+ewallet.getCurrentBalance();
		ewallet.setCurrentBalance(totalBal);
		ewalletRepository.save(ewallet);
		Statement stmt=new Statement(profileId,TransactionType.CREDIT,amount,LocalDateTime.of(LocalDate.now(),LocalTime.now()),ewallet);
		statementRepository.save(stmt);
		
	}

	@Override
	public Ewallet addWalletForProfile(Ewallet ewallet,int profileId) {
		
		//Ewallet newWallet=new Ewallet(ewalletprofileId,0,new ArrayList<String>());
		return ewalletRepository.save(ewallet);
	}

	@Override
	public Ewallet getWalletById(int id) {
		
		return ewalletRepository.findByProfileId(id);
	}

	@Override
	public List<Statement> getStatementById(int statementId)
	{
		return statementRepository.findByStatementId(statementId);
	}

	@Override
	public List<Statement> getAllStatements() {
		
		return statementRepository.findAll();
	}

	@Override
	public String deleteWalletById(int id) {
	
		 Ewallet ewallet=ewalletRepository.findByProfileId(id);
		 ewallet.setCurrentBalance(0);
		 ewalletRepository.save(ewallet);
		 ewalletRepository.delete(ewallet);
		return "Wallet deleted";
	}

	@Override
	public void doTransaction(int profileId, double amount) {
		
		Ewallet ewallet=ewalletRepository.findByProfileId(profileId);
		double totalbal=ewallet.getCurrentBalance()-amount;
		ewallet.setCurrentBalance(totalbal);
		ewalletRepository.save(ewallet);
		Statement stmt=new Statement(ewallet.getProfileId(),TransactionType.DEBIT,amount,LocalDateTime.of(LocalDate.now(),LocalTime.now()),ewallet);
		statementRepository.save(stmt);
	}
	
}
