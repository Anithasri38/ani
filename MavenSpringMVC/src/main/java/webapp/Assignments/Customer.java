package webapp.Assignments;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Customer {
	@NotEmpty(message="Name Cannot be Empty")
	@Pattern(regexp="[A-Za-z0-9]{8,20}",message="Must be Alghanumeric and should have atleast 8 to 20")
	private String username;
	
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&.])[A-Za-z\\d$@$!%*?&.]{8,20}",message="Password should contain at least one upper-case letter one lower case letter,a digit or special character(_,$,#,.,@).Password should be 8 to 20 characters long.")
	private String password;
	@Email(message="enter valid email")
	private String email;
	private long contact;
	private String city;
	@Pattern(regexp="[0-9]{6}",message="Zipcode must be 6")
	private String zipcode;
	public Customer()
	{
		
	}
	
	public Customer(String username, String password, String email, long contact, String city, String zipcode) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.contact = contact;
		this.city = city;
		this.zipcode = zipcode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}
