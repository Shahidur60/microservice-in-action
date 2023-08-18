package com.optimagrowth.company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString
@Entity
@Table(name="companies")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Company extends RepresentationModel<Company> {

	@Id
	@Column(name = "company_id", nullable = false)
	private String companyId;
	@Column(name = "hr_id", nullable = false)
	private String hrId;
	@Column(name = "company_name", nullable = false)
	private String companyName;
}