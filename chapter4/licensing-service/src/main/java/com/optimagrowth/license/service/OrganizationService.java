package com.optimagrowth.license.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.optimagrowth.license.model.Organization;
import com.optimagrowth.license.model.Person;
import com.optimagrowth.license.repository.OrganizationRepository;
import com.optimagrowth.license.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrganizationService {

    private OrganizationRepository organizationRepository;
    private PersonRepository personRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository, PersonRepository personRepository){
        this.organizationRepository = organizationRepository;
        this.personRepository = personRepository;
    }

    public List<Organization> getOrganization() {
        return this.organizationRepository.findAll();
    }

    public Organization createOrganization( Organization organization){
        return this.organizationRepository.save(organization);
    }

    public Organization organizationById(@PathVariable("id") Long id) {
        Optional<Organization> optionalOrganization = organizationRepository.findById(id);
        if (optionalOrganization.isPresent()) {
            return optionalOrganization.get();
        }
        return null;
    }

    public ObjectNode getDetails(Long orgId) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();
        Optional<Organization> optionalOrganization = organizationRepository.findById(orgId);

        if (optionalOrganization.isPresent()) {
            List<Person> personSet = optionalOrganization.get().getPeople();
            objectNode.put("Organization Name", optionalOrganization.get().getName());
            objectNode.put("Organization Category", optionalOrganization.get().getCategory().name());
            objectNode.put("Total Student", personSet.size());
        }

        return objectNode;
    }

    public List<ObjectNode> getOrgDetails() {
        List<ObjectNode> objectNodeList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();
        List<Organization> optionalOrganization = organizationRepository.findAll();

        for (Organization orgs:optionalOrganization
             ) {
            List<Person> personSet = orgs.getPeople();
            objectNode.put("Organization Name", orgs.getName());
            objectNode.put("Organization Category", orgs.getCategory().name());
            objectNode.put("Total Student", personSet.size());
            objectNodeList.add(objectNode);
        }
        return objectNodeList;
    }

    public void deleteOrganization(Long id) {
        organizationRepository.deleteById(id);
    }
}
