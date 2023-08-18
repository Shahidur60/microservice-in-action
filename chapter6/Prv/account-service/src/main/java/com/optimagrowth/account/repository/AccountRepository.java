package com.optimagrowth.account.repository;

import com.optimagrowth.account.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account,String>  {
//    public List<Company> findByHrIdId(String hrId);
//    public Company findByOrganizationIdAndLicenseId(String hrId,String companyId);
}
