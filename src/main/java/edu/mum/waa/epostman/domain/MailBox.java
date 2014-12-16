package edu.mum.waa.epostman.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
	/*@Min(1)
	@Max(999)*/
	@Column(name = "NUMBER", nullable = false)
	private Integer mNumber;

	@Column(name = "STATUS", nullable = false)
	private Character Status;
	@NotEmpty
	@Column(name = "CODE")
	private String code;

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

	public Character getStatus() {
		return Status;
	}

	public void setStatus(Character status) {
		Status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
