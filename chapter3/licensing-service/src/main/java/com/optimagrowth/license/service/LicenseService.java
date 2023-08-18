package com.optimagrowth.license.service;

import java.util.Locale;
import java.util.Random;

import com.optimagrowth.license.Repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.optimagrowth.license.model.License;

@Service
public class LicenseService {
	

	private MessageSource messages;
	private LicenseRepository licenseRepository;

	@Autowired
	public LicenseService(LicenseRepository licenseRepository, MessageSource messages) {
		this.licenseRepository = licenseRepository;
		this.messages = messages;
	}

	public String getLicense(String licenseId, String organizationId, Locale locale){
		License license = licenseRepository.findByLicenseId(licenseId);
//		license.setId(new Random().nextInt(1000));
//		license.setLicenseId(licenseId);
//		license.setOrganizationId(organizationId);
//		license.setDescription("Software product");
//		license.setProductName("Ostock");
//		license.setLicenseType("full");

		String responseMessage = null;
		responseMessage = String.format(messages.getMessage("license.get.message", null, locale),licenseId,organizationId,license.getDescription(), license.getProductName());
		return responseMessage;

//		return license;
	}

	public String createLicenseWithoutLocale(License license, String organizationId){
		String responseMessage = null;
		if(license != null) {
			license.setOrganizationId(organizationId);
			responseMessage = String.format("This is the post and the object is: %s",
					license.toString());
		}
		licenseRepository.save(license);

		return responseMessage;
	}

	public String updateLicenseWithoutLocale(License license, String organizationId){
		String responseMessage = null;
		License licenseReq = licenseRepository.findByLicenseId(license.getLicenseId());
		if (license != null) {
			license.setOrganizationId(organizationId);
			responseMessage = String.format("This is the put and the object is: %s", license.toString());
		}
		license.setId(licenseReq.getId());
		licenseRepository.save(license);
		return responseMessage;
	}

	public String deleteLicenseWithoutLocale(String licenseId, String organizationId){
		String responseMessage = null;
		responseMessage = String.format("Deleting license with id %s for the organization %s",licenseId, organizationId);
		License license=licenseRepository.findByLicenseId(licenseId);
		licenseRepository.deleteById(license.getId());
		return responseMessage;
	}

	// -------------------------Use Locale -----------------//

	public String createLicense(License license, String organizationId, Locale locale){
		String responseMessage = null;
		if(!StringUtils.isEmpty(license)) {
			license.setOrganizationId(organizationId);
			responseMessage = String.format
					(messages.getMessage("license.create.message",null,locale),
							license.toString());
		}
		licenseRepository.save(license);
		return responseMessage;
	}

	public String updateLicense(License license, String organizationId, Locale locale){
		String responseMessage = null;
		License licenseReq = licenseRepository.findByLicenseId(license.getLicenseId());
		if(!StringUtils.isEmpty(license)) {
			license.setOrganizationId(organizationId);
			responseMessage = String.format(messages.getMessage("license.update.message", null, locale), license.toString());
		}
		license.setId(licenseReq.getId());
		licenseRepository.save(license);
		return responseMessage;
	}

	public String deleteLicense(String licenseId, String organizationId, Locale locale){
		String responseMessage = null;
		responseMessage = String.format(messages.getMessage("license.delete.message", null, locale),licenseId, organizationId);
		License license=licenseRepository.findByLicenseId(licenseId);
		licenseRepository.deleteById(license.getId());
		return responseMessage;

	}

	// --------------------------------Use Locale End -----------------------//
}
