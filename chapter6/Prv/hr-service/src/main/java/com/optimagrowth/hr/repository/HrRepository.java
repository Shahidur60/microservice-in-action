package com.optimagrowth.hr.repository;

import com.optimagrowth.hr.model.Hr;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HrRepository extends CrudRepository<Hr,String>  {
//    public List<Company> findByHrIdId(String hrId);
//    public Company findByOrganizationIdAndLicenseId(String hrId,String companyId);
}
