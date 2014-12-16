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

	@Column(unique = true, nullable = false, name = "LOGINID")
	private String loginId;

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
	@NotEmpty
	private Character gender;

	@Column(name = "CONTACT_NUMBER")
	@Pattern(regexp = "\\d(\\d{3}\\)\\d{3}-\\d{4}")
	private Character contactNumber;

	@Column(name = "STATUS" ,nullable = false, length = 1)
	@NotEmpty
	private Character status;

	@Column(name = "EMAIL")
	@Email
	private String email;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "LASTLOGINDATE",nullable=false)
	private Date lastLoginDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
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

	@Transient
	private Collection<GrantedAuthority> authorities;

	// ~ Methods for spring-security
	// ========================================================================================================

	public void eraseCredentials() {
		this.loginPassword = null;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public String getPassword() {
		return getLoginPassword();
	}

	public String getUsername() {
		return getLoginId();
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

}
