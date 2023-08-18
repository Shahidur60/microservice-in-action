package com.optimagrowth.hr.service;

import com.optimagrowth.hr.model.Hr;
import com.optimagrowth.hr.repository.HrRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HrService {

    private HrRepository hrRepository;

    public Hr findById(String organizationId) {
        Optional<Hr> opt = hrRepository.findById(organizationId);
        return (opt.isPresent()) ? opt.get() : null;
    }
}
