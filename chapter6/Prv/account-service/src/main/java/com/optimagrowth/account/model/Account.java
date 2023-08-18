package com.optimagrowth.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString
@Entity
@Table(name="accounts")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account extends RepresentationModel<Account> {
	@Id
	@Column(name = "account_id", nullable = false)
	private String accountId;
	@Column(name = "num_of_account", nullable = false)
	private String numOfAccounts;
	@Column(name = "message", nullable = false)
	private String message;
}