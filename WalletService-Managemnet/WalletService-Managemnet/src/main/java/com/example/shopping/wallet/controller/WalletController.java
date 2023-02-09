package com.example.shopping.wallet.controller;
import java.util.List;

import org.json.JSONObject; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping.wallet.models.AuthenticationRequest;
import com.example.shopping.wallet.models.AuthenticationResponse;
import com.example.shopping.wallet.models.Ewallet;
import com.example.shopping.wallet.models.JwtUtil;
import com.example.shopping.wallet.models.Statement;
import com.example.shopping.wallet.models.User1;
import com.example.shopping.wallet.repository.StatementRepository;
import com.example.shopping.wallet.repository.UserRepository;
import com.example.shopping.wallet.service.EwalletService;
import com.example.shopping.wallet.service.MyUserDetailsService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;


@RestController
@RequestMapping("/ewallet")
public class WalletController {

	@Autowired
	  EwalletService ewalletService;
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	 AuthenticationManager authenticationManager;
	@Autowired
	 MyUserDetailsService myUserDetailsService;
	@Autowired
	JwtUtil jwtTokenUtil;
	@Autowired
	  StatementRepository stateRepository;
	
	@GetMapping("/all")
	public List<Ewallet> getWallets()
	{
		return ewalletService.getWallets();
	}
	@PostMapping("/addforProfile/{profileId}")
	public Ewallet addWalletForProfile(@RequestBody Ewallet ewallet,@PathVariable int profileId)
	{
		return ewalletService.addWalletForProfile(ewallet,profileId);
	}
	@PostMapping("/addmoney/{amount}")
	public String onlinePayment(@PathVariable double amount)throws RazorpayException
	{
		double amt=amount;
		System.out.println(amt);
		RazorpayClient client=new RazorpayClient("rzp_live_nfBYZhXVvVbC3V","2T79eCFwFuR5Z0vJ6dqaG5JL");
		JSONObject options=new JSONObject();
		options.put("amount", amt);
		options.put("currency","INR");
		options.put("receipt","txn_123456");
		Order order=client.Orders.create(options);
		System.out.println(order);
		return order.toString();
	}
	@PostMapping("/addMoneyWallet/{amount}/{profileId}")
	public void addWallet(@PathVariable int profileId,@PathVariable double amount)
	{
		ewalletService.addMoney(profileId, amount);
	}
	@PostMapping("/transaction/{amount}/{profileId}")
	public void doTransaction(@PathVariable int profileId,@PathVariable double amount)
	{
		ewalletService.doTransaction(profileId, amount);
	}
	@GetMapping("/getById/{profileId}")
	public Ewallet getWalletById(@PathVariable int profileId)
	{
		return ewalletService.getWalletById(profileId);
	}
	@GetMapping("/statement/byId/{statementId}")
	public List<Statement> getStatementById(@PathVariable int statementId)
	{
		return ewalletService.getAllStatements();
	}
	@GetMapping("/statement/all")
	public List<Statement> getAllStatements()
	{
		return ewalletService.getAllStatements();
	}
	@DeleteMapping("/delete/{ewalletId}")
	public String deleteWalletByEwalletId(@PathVariable int ewalletId)
	{
		return ewalletService.deleteWalletById(ewalletId);
	}
	@DeleteMapping("/deletes/{profileId}")
	public String deleteWalletById(@PathVariable int profileId)
	{
         stateRepository.deleteById(profileId);
         return "done";
	}
	@PostMapping("/registration")
	private ResponseEntity<?> subscribe(@RequestBody AuthenticationRequest request)
	{
	    System.out.println("Sushma Chinthala");
	    String username = request.getUsername();
	    String password = request.getPassword();



	    User1 model = new User1();
	    model.setUsername(username);
	    model.setPassword(password);

  

	    try {
	        userRepository.save(model);
	    } catch (Exception e) {
	        return ResponseEntity.ok(new AuthenticationResponse("Error while subsribing the user with username " + username));
	    }
	        return ResponseEntity.ok(new AuthenticationResponse("client subscribed with username " + username));
	}
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest  authenticationRequest) throws Exception {
	    try
	    {
	    authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
	}
	    catch (BadCredentialsException e) {
	        throw new Exception("Incorrect username or password", e);
	    }




	    final UserDetails userDetails = myUserDetailsService
	            .loadUserByUsername(authenticationRequest.getUsername());



	    final String jwt = jwtTokenUtil.generateToken(userDetails);



	    return ResponseEntity.ok(new AuthenticationResponse(jwt));

	}

}
