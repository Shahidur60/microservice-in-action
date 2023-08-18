package com.optimagrowth.license.model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter @Setter @ToString
@Data
@Entity
public class License extends RepresentationModel<License> {
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "licenseId")
	private String licenseId;
	@Column(name = "description")
	private String description;
	@Column(name = "organizationId")
	private String organizationId;
	@Column(name = "productName")
	private String productName;
	@Column(name = "licenseType")
	private String licenseType;

}