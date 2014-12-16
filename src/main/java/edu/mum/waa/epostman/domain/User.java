package edu.mum.waa.epostman.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "USER")
public class User implements UserDetails, CredentialsContainer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(unique = true, nullable = false, name = "USERNAME")
	private String userName;

	@Column(name = "LOGINPASSWORD", nullable = false)
	private String loginPassword;

	@NotEmpty
	@Size(min=2,max=6)
	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "GENDER")
	private Character gender;
	
	@Column(name = "CONTACT_NUMBER")
	private Character contactNumber;

	@Column(name = "STATUS")
	private short status;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "LASTLOGINDATE")
	private Date lastLoginDate;

	@Transient
	private String confirmLoginPassword;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String toString() {
		return getFirstName() + " " + getLastName();
	}

	public String getPassword() {
		return getLoginPassword();
	}

	public String getUsername() {
		return getUserName();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return status == 1;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Character getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Character contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getConfirmLoginPassword() {
		return confirmLoginPassword;
	}

	public void setConfirmLoginPassword(String confirmLoginPassword) {
		this.confirmLoginPassword = confirmLoginPassword;
	}

	public void eraseCredentials() {
		// TODO Auto-generated method stub
		
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
