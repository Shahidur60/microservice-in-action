package com.optimagrowth.license.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.optimagrowth.license.model.Organization;
import com.optimagrowth.license.model.Person;
import com.optimagrowth.license.service.OrganizationService;
import com.optimagrowth.license.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("org")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/orgs")
    public List<Organization> getOrganizations() {
        return organizationService.getOrganization();
    }

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello";
    }


    @GetMapping("/{id}")
    public Organization
    organizationById(@PathVariable("id") Long orgId) {
        return organizationService.organizationById(orgId);
    }

    @PostMapping("/orgPost")
    @ResponseStatus(HttpStatus.CREATED)
    public Organization createOrganization(@RequestBody Organization organization) {
        return organizationService.createOrganization(organization);
    }

    @GetMapping("/orgDetails/{id}")
    public ObjectNode getDetails(@PathVariable("id") Long orgId) {
        return  organizationService.getDetails(orgId);
    }

    @GetMapping("/orgDetails/all")
    public List<ObjectNode> getDetails() {
        return  organizationService.getOrgDetails();
    }

    @DeleteMapping("/{id}")
    public void deleteOrganization(@PathVariable("id") Long id) {
        organizationService.deleteOrganization(id);
    }
}


