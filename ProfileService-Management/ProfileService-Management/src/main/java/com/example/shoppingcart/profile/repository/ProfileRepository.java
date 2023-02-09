package com.example.shoppingcart.profile.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.shoppingcart.profile.models.UserProfile;


@Repository
public interface ProfileRepository extends MongoRepository<UserProfile,Integer>{

	public UserProfile findByMobileNumber(Long phnNum);
	public UserProfile findByFullName(String fullName);
}
