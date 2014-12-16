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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
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
	private String username;

	@Column(name = "LOGINPASSWORD", nullable = false)
	private String loginPassword;

	@Column(name = "FIRSTNAME", nullable = false)
	@NotEmpty
	@Size(min = 2, max = 40)
	private String firstName;

	@Column(name = "LASTNAME", nullable = false)
	@NotEmpty
	@Size(min = 2, max = 100)
	private String lastName;

	@Column(name = "GENDER", nullable = false, length = 1)
	private Character gender;

	@Column(name = "CONTACT_NUMBER")
	@Pattern(regexp = "[0-9]{10}", message = "{contact.register.pattern}")
	private String contactNumber;

	@Column(name = "STATUS", nullable = false, length = 1)
	private Character status;

	@Column(name = "EMAIL")
	@Email
	private String email;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "LASTLOGINDATE")
	private Date lastLoginDate;

	@Column(name = "ROLE")
	private int role;

	@Transient
	private String confirmLoginPassword;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
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

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getConfirmLoginPassword() {
		return confirmLoginPassword;
	}

	public void setConfirmLoginPassword(String confirmLoginPassword) {
		this.confirmLoginPassword = confirmLoginPassword;
	}

	public void eraseCredentials() {

	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;

	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;

	}
}
