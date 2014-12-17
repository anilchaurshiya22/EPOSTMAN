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
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity()
@Table(name = "MAIL_BOX")
public class MailBox {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NUMBER", nullable = false)
	@NotNull
	@Min(1)
	@Max(999)
	private Integer mNumber;

	@Column(name = "STATUS", nullable = false,length=1)
	private String status;

	@Column(name = "CODE")
	@Pattern(regexp="[0-9]{1,2}-[0-9]{1,2}-[0-9]{1,2}",message="{mailbox.code.msg}")
	@NotEmpty
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
