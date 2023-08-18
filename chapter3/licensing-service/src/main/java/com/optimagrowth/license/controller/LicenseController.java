package com.optimagrowth.license.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.optimagrowth.license.model.License;
import com.optimagrowth.license.service.LicenseService;

@RestController
@RequestMapping(value="v1/organization/{organizationId}/license")
public class LicenseController {

	@Autowired
	private LicenseService licenseService;

	@GetMapping(value="/withoutLocale/{licenseId}")
	public ResponseEntity<String> getLicenseWithoutLocale(
			@PathVariable("organizationId") String organizationId,
			@PathVariable("licenseId") String licenseId,
	@RequestHeader(value = "Accept-Language",required = false) Locale locale) {
//		License license = licenseService
//				.getLicense(licenseId,organizationId,locale);
		return ResponseEntity.ok(licenseService.getLicense(licenseId,organizationId,locale));
	}

	@PutMapping(value="/withoutLocale")
	public ResponseEntity<String> updateLicenseWithoutLocale(
			@PathVariable("organizationId")
					String organizationId,
			@RequestBody License request) {
		return ResponseEntity.ok(licenseService.updateLicenseWithoutLocale(request,
				organizationId));
	}

	@PostMapping(value="/withoutLocale")
	public ResponseEntity<String> createLicenseWithoutLocale(
			@PathVariable("organizationId") String organizationId,
			@RequestBody License request) {
		return ResponseEntity.ok(licenseService.createLicenseWithoutLocale(request,
				organizationId));
	}

	@DeleteMapping(value="/withoutLocale/{licenseId}")
	public ResponseEntity<String> deleteLicenseWithoutLocale(
			@PathVariable("organizationId") String organizationId,
			@PathVariable("licenseId") String licenseId) {
		return ResponseEntity.ok(licenseService.deleteLicenseWithoutLocale(licenseId,
				organizationId));
	}

	// ------------------- Use Local ---------------------//
		@PostMapping
	public ResponseEntity<String> createLicense
			(@PathVariable("organizationId") String organizationId,
			 @RequestBody License request,
			@RequestHeader(value = "Accept-Language",required = false) Locale locale) {
		return ResponseEntity.ok(licenseService.createLicense(request, organizationId, locale));
	}

	@PutMapping
	public ResponseEntity<String> updateLicense
			(@PathVariable("organizationId") String organizationId, @RequestBody License request,
			 @RequestHeader(value = "Accept-Language",required = false) Locale locale) {
		return ResponseEntity.ok(licenseService.updateLicense(request, organizationId, locale));
	}

	@DeleteMapping(value="/{licenseId}")
	public ResponseEntity<String> deleteLicense
			(@PathVariable("organizationId") String organizationId,
			 @PathVariable("licenseId") String licenseId,
			 @RequestHeader(value = "Accept-Language",required = false) Locale locale) {
		return ResponseEntity.ok(licenseService.deleteLicense(licenseId, organizationId, locale));
	}

	@RequestMapping(value="/{licenseId}",method = RequestMethod.GET)
	public ResponseEntity<String> getLicense( @PathVariable("organizationId") String organizationId,
			@PathVariable("licenseId") String licenseId,
		@RequestHeader(value = "Accept-Language",required = false) Locale locale) {

//		License license = licenseService.getLicense(licenseId, organizationId, locale);
//		license.add(
//				linkTo(methodOn(LicenseController.class).getLicense(organizationId, license.getLicenseId(), null)).withSelfRel(),
//				linkTo(methodOn(LicenseController.class).createLicense(organizationId, license, null)).withRel("createLicense"),
//				linkTo(methodOn(LicenseController.class).updateLicense(organizationId, license, null)).withRel("updateLicense"),
//				linkTo(methodOn(LicenseController.class).deleteLicense(organizationId, license.getLicenseId(), null)).withRel("deleteLicense")
//		);

		return ResponseEntity.ok(licenseService.getLicense(licenseId,organizationId,locale));
	}

}
