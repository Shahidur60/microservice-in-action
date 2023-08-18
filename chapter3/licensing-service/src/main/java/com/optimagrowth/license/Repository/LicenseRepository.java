package com.optimagrowth.license.Repository;

import com.optimagrowth.license.model.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends JpaRepository<License, Integer> {
    public License findByLicenseId(String licenseId);
    public License findByOrganizationId(String organizationId);
    public void deleteByLicenseId(String licenseId);
}
