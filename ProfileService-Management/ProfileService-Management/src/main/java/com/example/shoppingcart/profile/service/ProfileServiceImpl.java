package com.example.shoppingcart.profile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shoppingcart.profile.exception.ProfileNotFoundException;
import com.example.shoppingcart.profile.models.UserProfile;
import com.example.shoppingcart.profile.repository.ProfileRepository;


@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired 
	ProfileRepository profileRepository;

	
	@Override
	public List<UserProfile> getAllProfiles() {
		return profileRepository.findAll();
	}

	@Override
	public UserProfile getByProfileId(int profileId) {
		Optional<UserProfile> findByProfileId = profileRepository.findById(profileId);
		UserProfile p= null;
		if(findByProfileId.isPresent()) {
			p=findByProfileId.get();
			return p;
		}
		else
		{
			throw new ProfileNotFoundException("id:"+profileId+" not found");
		}
	}
	
	@Override
	public UserProfile addNewCustomerProfile(UserProfile userProfile) {
		return profileRepository.insert(userProfile);
	}
	

	@Override
	public UserProfile updateProfile(UserProfile userProfile) {
		return profileRepository.save(userProfile);
	}
	
	@Override 
	  public UserProfile addNewMerchantProfile(UserProfile userProfile) {
	   return profileRepository.insert(userProfile);
	  
	  }
	  
	 @Override 
	  public UserProfile addNewDeliveryProfile(UserProfile userProfile) {
	  return profileRepository.insert(userProfile);
	  
	  }

	 @Override
		public void deleteProfile(int profileId) {
		 if(profileRepository.existsById(profileId))
		 {
			profileRepository.deleteById(profileId);
		}
		 else
		 {
			 throw new ProfileNotFoundException("ProfileId:"+profileId+" not found");
		 }
	 }
	
}


