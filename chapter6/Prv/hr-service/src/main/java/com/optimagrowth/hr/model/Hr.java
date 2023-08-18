package com.optimagrowth.hr.model;

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
@Table(name="hrs")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Hr extends RepresentationModel<Hr> {

	@Id
	@Column(name = "hr_id", nullable = false)
	private String hrId;
	@Column(name = "account_id", nullable = false)
	private String accountId;
	@Column(name = "man_power", nullable = false)
	private String manPower;
	@Column(name = "message_Hr", nullable = true)
	private String messageHr;
}