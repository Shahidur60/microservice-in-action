package com.optimagrowth.company.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import com.optimagrowth.company.model.Hr;
import com.optimagrowth.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="v1/company/{companyId}")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@RequestMapping(value="/feign/{companyId}",method = RequestMethod.GET)
	public Hr getLicensesWithClient(@PathVariable("companyId") String companyId) {

		return companyService.getLicense(companyId);
	}

	@RequestMapping(value="/hello",method = RequestMethod.GET)
	public String hi() {
		return "Hello";
	}



}
