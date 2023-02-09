package com.example.shopping.wallet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.shopping.wallet.models.Ewallet;


@Repository
public interface EwalletRepository extends MongoRepository<Ewallet,Integer>{

	 public Ewallet findByProfileId(int profileId);
}
