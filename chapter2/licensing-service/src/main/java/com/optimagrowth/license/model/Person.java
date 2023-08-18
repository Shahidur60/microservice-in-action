package com.optimagrowth.license.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "Person")
public class Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long person_Id;
    private String name;
    private String major;
    private String department;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")

    private String DOB;

    private String phone;

    private String email;

    @OneToMany(mappedBy="person",fetch = FetchType.EAGER)
    private Set<Organization> organizations;

    @ManyToMany(mappedBy = "people")
    Set<Organization> organizationSet;

    public Person(String name, String major, String department, String DOB, String phone, String email) {
        this.name = name;
        this.major = major;
        this.DOB = DOB;
        this.department = department;
        this.phone = phone;
        this.email = email;
    }

    public Person() {

    }
}