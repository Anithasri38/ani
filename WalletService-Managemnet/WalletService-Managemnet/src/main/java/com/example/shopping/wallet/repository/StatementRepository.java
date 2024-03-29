package com.example.shopping.wallet.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.shopping.wallet.models.Statement;

@Repository
public interface StatementRepository extends MongoRepository<Statement,Integer>{
  
	public List<Statement> findByStatementId(int statementId);
}
