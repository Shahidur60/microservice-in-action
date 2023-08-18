package com.optimagrowth.license.repository;

import com.optimagrowth.license.model.Organization;
import com.optimagrowth.license.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
