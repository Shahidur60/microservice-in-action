package com.optimagrowth.license.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "organization")
public class Organization implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "orgId")
    private Long orgId;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private final Category category;

    public Organization() {

        this.category = null;
    }

    public static enum Category {
        SPORTS, FITNESS, ARTS, LITERATURE
    }

    @Column(name = "establishment_Date")
    private String establishment_Date;

    @ManyToMany(fetch = FetchType.LAZY, cascade =CascadeType.MERGE)
    @JoinTable(name = "members",
            joinColumns = { @JoinColumn(name = "fk_orgId") },
            inverseJoinColumns = { @JoinColumn(name = "fk_personId") })
    List<Person> people = new ArrayList<>();




    //    @JoinTable(
//            name = "members",
//            joinColumns = {
//                    @JoinColumn(name = "fk_orgId", referencedColumnName = "orgId",
//                            nullable = false, updatable = false)
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "fk_id", referencedColumnName = "id", nullable = false, updatable = false)
//            })

}