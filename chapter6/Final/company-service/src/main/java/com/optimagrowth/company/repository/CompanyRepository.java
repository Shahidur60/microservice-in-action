package com.optimagrowth.company.repository;

import java.util.List;

import com.optimagrowth.company.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company,String>  {
//    public List<Company> findByHrIdId(String hrId);
    public Company findByHrIdAndAndCompanyId(String hrId,String companyId);
}
