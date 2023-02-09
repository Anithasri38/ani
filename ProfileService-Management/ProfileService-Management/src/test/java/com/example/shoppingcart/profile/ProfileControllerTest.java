package com.example.shoppingcart.profile;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.example.shoppingcart.profile.exception.ProfileNotFoundException;
import com.example.shoppingcart.profile.models.Address;
import com.example.shoppingcart.profile.models.UserProfile;
import com.example.shoppingcart.profile.repository.ProfileRepository;
import com.example.shoppingcart.profile.service.ProfileService;


@SpringBootTest
public class ProfileControllerTest {

	@Autowired
	private ProfileService profileService;
	
	@MockBean
	private ProfileRepository profileRepository;
	@Test
	public void getAllProfilesTest()
	{
	    Address address=new Address(8987,"hs","has","ajh","hsud",89765);
		when(profileRepository.findAll()).thenReturn(Stream.of(new UserProfile(4,"fuu","","sni@gmial.com",7364839873L,"hsgd",LocalDate.of(2000, 03, 19),"Male","customer","hsgd",address),new UserProfile(5,"fuu","","sni@gmial.com",7364839873L,"hsgd",LocalDate.of(2000, 03, 19),"Male","customer","hsgd",address),new UserProfile(6,"fuu","","sni@gmial.com",7364839873L,"hsgd",LocalDate.of(2000, 03, 19),"Male","customer","hsgd",address)).collect(Collectors.toList()));
		assertEquals(3,profileService.getAllProfiles().size());
		
	}
	@Test
	public void addNewCustomerTest()
	{
		Address address=new Address(6789,"GaneshStreet","SvnColony","Guntur","AndhraPradesh",89765);
		UserProfile userProfile=new UserProfile(7,"Anisri","","ani@gmial.com",7364839897L,"Foodie",LocalDate.of(2001, 06, 27),"Female","customer","",address);
		when(profileRepository.insert(userProfile)).thenReturn(userProfile);
		assertEquals(userProfile,profileService.addNewCustomerProfile(userProfile));
	  
	}
	@Test
	public void addNewMerchantProfileTest()
	{
		Address address=new Address(7865,"MallakStreet","ParakshColony","Bellandhur","Bangalore",56789);
		UserProfile userProfile=new UserProfile(8,"Surya","","surya@gmail.com",9364839897L,"Love Travelling",LocalDate.of(1999, 01, 17),"Male","merchant","",address);
		when(profileRepository.insert(userProfile)).thenReturn(userProfile);
		assertEquals(userProfile,profileService.addNewMerchantProfile(userProfile));
	}
	@Test
	public void addNewDeliveryAgentProfileTest()
	{
		Address address=new Address(2098,"BandarStreet","MallakColony","Marthali","Bangalore",56788);
		UserProfile userProfile=new UserProfile(9,"Sandeep","","sandeep@gmail.com",9634839897L,"Fassion is wt we like",LocalDate.of(1998, 10, 18),"Male","deliveryAgent","",address);
		when(profileRepository.insert(userProfile)).thenReturn(userProfile);
		assertEquals(userProfile,profileService.addNewDeliveryProfile(userProfile));
	}
	@Test
	public void getByProfileIdTest()
	{
		Address address=new Address(2098,"BandarStreet","MallakColony","Marthali","Bangalore",56788);
		Optional<UserProfile> userProfile=Optional.of(new UserProfile(9,"Sandeep","","sandeep@gmail.com",9634839897L,"Fassion is wt we like",LocalDate.of(1998, 10, 18),"Male","deliveryAgent","",address));
		int id=9;
		when(profileRepository.findById(id)).thenReturn(userProfile);
		UserProfile profile=profileService.getByProfileId(id);
		assertEquals(userProfile.get(),profile);
	}
	@Test
	public void ProfileNotFoundExceptionTest()
	{
		Address address=new Address(2098,"BandarStreet","MallakColony","Marthali","Bangalore",56788);
		Optional<UserProfile> userProfile=Optional.of(new UserProfile(9,"Sandeep","","sandeep@gmail.com",9634839897L,"Fassion is wt we like",LocalDate.of(1998, 10, 18),"Male","deliveryAgent","",address));
		int id=9;
		when(profileRepository.findById(id)).thenReturn(userProfile);
		assertThrows(ProfileNotFoundException.class,()->{
			profileService.getByProfileId(10);
		});
	}
	@Test
	public void updateProfileTest()
	{
		Address address=new Address(2098,"BandarStreet","MallakColony","Marthali","Bangalore",56788);
		UserProfile userProfile=new UserProfile(9,"Sandeep","","sandeep@gmail.com",9634839897L,"Fassion is wt we like",LocalDate.of(1998, 10, 18),"Male","deliveryAgent","",address);
		when(profileRepository.save(userProfile)).thenReturn(userProfile);
		assertEquals(userProfile,profileService.updateProfile(userProfile));
	}
	@Test
	public void deleteByProfileIdTest()
	{
		Address address=new Address(2098,"BandarStreet","MallakColony","Marthali","Bangalore",56788);
		UserProfile userProfile=new UserProfile(9,"Sandeep","","sandeep@gmail.com",9634839897L,"Fassion is wt we like",LocalDate.of(1998, 10, 18),"Male","deliveryAgent","",address);
		int id=9;
		
		profileRepository.deleteById(id);
	
	}
	@Test
	public void deleteByProfileIdExceptionTest()
	{
		Address address=new Address(2098,"BandarStreet","MallakColony","Marthali","Bangalore",56788);
		UserProfile userProfile=new UserProfile(9,"Sandeep","","sandeep@gmail.com",9634839897L,"Fassion is wt we like",LocalDate.of(1998, 10, 18),"Male","deliveryAgent","",address);
		assertThrows(ProfileNotFoundException.class,()->{
			profileService.getByProfileId(10);
		});
	}
	@Test
	public void ProfileConstructor_test() {
		Address address=new Address(2098,"BandarStreet","MallakColony","Marthali","Bangalore",56788);
		UserProfile userProfile=new UserProfile(9,"Sandeep","","sandeep@gmail.com",9634839897L,"Fassion is wt we like",LocalDate.of(1998, 10, 18),"Male","deliveryAgent","",address);
		userProfile.setId(9);
		userProfile.setDateOfBirth(LocalDate.of(1998, 10, 18));
		userProfile.setAddress(address);
		userProfile.setAbout("");
		userProfile.setMobileNumber(7890293478L);
		userProfile.setPassword("pass");
		userProfile.setRole("user");
		userProfile.setImage(null);
		userProfile.setGender("female");
		userProfile.setFullName("Sri");
		userProfile.setEmailId("sri@gmail.com");
	}
	
	@Test
	public void ProfileDefault_Constructor_test() {
		Address address=new Address(2098,"BandarStreet","MallakColony","Marthali","Bangalore",56788);
		UserProfile userProfile=new UserProfile();
		userProfile.setId(9);
		userProfile.setDateOfBirth(LocalDate.of(1998, 10, 18));
		userProfile.setAddress(address);
		userProfile.setAbout("");
		userProfile.setMobileNumber(7890293478L);
		userProfile.setPassword("pass");
		userProfile.setRole("user");
		userProfile.setImage(null);
		userProfile.setGender("female");
		userProfile.setFullName("Sri");
		userProfile.setEmailId("sri@gmail.com");
	}
	
}
