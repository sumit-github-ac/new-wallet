package com.giit.wallet.datatransferobject;

import java.math.BigDecimal;
import java.util.Date;

public class AccountDTO {

	private Long id;
	private String userName;
	private String sex;
	private Date dateCreated;
	private BigDecimal balance;

	public AccountDTO() {
	}

	public AccountDTO(AccountDTOBuilder builder) {
		id = builder.id;
		userName = builder.userName;
		sex = builder.sex;
		dateCreated = builder.dateCreated;
		balance = builder.balance;
	}

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public static class AccountDTOBuilder {

		private Long id;
		private String userName;
		private String sex;
		private Date dateCreated;
		private BigDecimal balance;

		public AccountDTOBuilder setId(Long id) {
			this.id = id;
			return this;
		}

		public AccountDTOBuilder setUserName(String userName) {
			this.userName = userName;
			return this;
		}

		public AccountDTOBuilder setSex(String sex) {
			this.sex = sex;
			return this;
		}

		public AccountDTOBuilder setDateCreated(Date dateCreated) {
			this.dateCreated = dateCreated;
			return this;
		}

		public AccountDTOBuilder setBalance(BigDecimal balance) {
			this.balance = balance;
			return this;
		}

		public AccountDTO build() {
			return new AccountDTO(this);
		}

	}
}
