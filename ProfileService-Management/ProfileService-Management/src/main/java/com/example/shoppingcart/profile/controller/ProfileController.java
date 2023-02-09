package com.example.shoppingcart.profile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingcart.profile.models.UserProfile;
import com.example.shoppingcart.profile.service.ProfileService;


@RestController
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	ProfileService profileService;
	public ProfileController(ProfileService profileService)
	{
		this.profileService=profileService;
	}
	public ProfileController()
	{
		
	}
	@GetMapping("/allprofiles")
	public List<UserProfile> getAllProfiles()
	{
		return profileService.getAllProfiles();
	}
	@GetMapping("/{profileId}")
	public UserProfile getProfileById(@PathVariable int profileId)
	{
		return profileService.getByProfileId(profileId);
	}
	
	@PutMapping("/update")
	public UserProfile updateProfile(@RequestBody UserProfile userProfile)
	{
		return profileService.updateProfile(userProfile);
	}
	@PostMapping("/add/customer")
	public UserProfile addNewCustomerProfile(@RequestBody UserProfile userProfile)
	{
		return profileService.addNewCustomerProfile(userProfile);
	}
	@PostMapping("/add/merchant")
	public UserProfile addNewMerchantProfile(@RequestBody UserProfile userProfile)
	{
		 return profileService.addNewMerchantProfile(userProfile);
	}
	@PostMapping("/add/deliveryAgent")
	public UserProfile addNewDeliveryAgentProfile(@RequestBody UserProfile userProfile)
	{
		  return profileService.addNewDeliveryProfile(userProfile);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteProfileById(@PathVariable int id)
	{
		profileService.deleteProfile(id);
	}
}
