package com.optimagrowth.license.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "ORGANIZATION")
public class Organization implements Serializable {
    @Id
    @GeneratedValue
    private Long orgId;

    private String name;

    private final Category category;

    public Organization() {

        this.category = null;
    }

    public static enum Category {
        SPORTS, FITNESS, ARTS, LITERATURE
    }

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
//    @Column(name = "establishmentDate")
    private String establishment_Date;

    @ManyToOne
    @JoinColumn(name="person_Id", nullable=false)
    private Person person;

    @ManyToMany
    @JoinTable(
            name = "members",
            joinColumns = @JoinColumn(name = "org_Id"),
            inverseJoinColumns = @JoinColumn(name = "person_Id"))
    Set<Person> people;

//    @ManyToOne
//    @JoinColumn(name = "teamId")
//    private Team memberJoinedInTeams;
//
//    @Column(name = "personType")
//    private final Type type;
//    public static enum Type {
//        CONTESTANT, COACH
//    }
//
//    public Person() {
//        type = null;
//    }



}