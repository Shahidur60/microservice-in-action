package com.optimagrowth.license.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "person")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "DOB")
    private String DOB;

//    @OneToMany(mappedBy="person",fetch = FetchType.EAGER)
//    private Set<Organization> organizations;

    @ManyToMany(fetch = FetchType.LAZY,cascade =CascadeType.MERGE, mappedBy = "people")
    @JsonBackReference
    List<Organization> organizationSet = new ArrayList<>();

    public Person() {

    }

}
