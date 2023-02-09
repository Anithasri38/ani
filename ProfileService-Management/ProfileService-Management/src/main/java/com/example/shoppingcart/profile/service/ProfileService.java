package com.example.shoppingcart.profile.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.shoppingcart.profile.models.UserProfile;



@Service
public interface ProfileService {

	public List<UserProfile> getAllProfiles();

	public UserProfile getByProfileId(int profileId);

	public UserProfile addNewCustomerProfile(UserProfile userProfile);

	public UserProfile updateProfile(UserProfile userProfile);

	public UserProfile addNewMerchantProfile(UserProfile userProfile);

	public UserProfile addNewDeliveryProfile(UserProfile userProfile);

	public void deleteProfile(int profileId);
	
}
