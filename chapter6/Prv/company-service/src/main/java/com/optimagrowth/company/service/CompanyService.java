package com.optimagrowth.company.service;

import com.optimagrowth.company.model.Company;
import com.optimagrowth.company.model.Hr;
import com.optimagrowth.company.repository.CompanyRepository;
import com.optimagrowth.company.service.client.HrFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    HrFeignClient hrFeignClient;

    public Hr getLicense(String companyId) {
        Optional<Company> optionalCompany = companyRepository.findById(companyId);

        Hr hr = retrieveHrInfo(optionalCompany.get().getHrId());
        hr.setMessageHR("This call from HR");
        return hr;
    }

    public Hr retrieveHrInfo(String hrId){
        Hr hr = hrFeignClient.getHr(hrId);
        return hr;
    }
}
