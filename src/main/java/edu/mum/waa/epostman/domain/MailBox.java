package edu.mum.waa.epostman.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity()
@Table(name = "MAIL_BOX")
public class MailBox {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@NotNull
	/*
	 * @Min(1)
	 * 
	 * @Max(999)
	 */
	@Column(name = "NUMBER", nullable = false)
	private Integer mNumber;

	@Column(name = "STATUS", nullable = false)
	@Size(min = 1, max = 1)
	private String status;
	
	@NotEmpty
	@Column(name = "CODE")
	private String code;
	
	@OneToMany
	@JoinColumn(name="MAILBOX_ID", referencedColumnName="ID")
	List<User> users = new ArrayList<User>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getmNumber() {
		return mNumber;
	}

	public void setmNumber(Integer mNumber) {
		this.mNumber = mNumber;
	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
