package com.asgard.consumer.mrs.model;


import java.util.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "birthdate_estimated")
    private Boolean birthdateEstimated;

    @Column(name = "dead")
    private boolean dead;

    @Column(name = "death_date")
    private Date deathDate;

    @Column(name = "cause_of_death")
    private Integer causeOfDeath;

    @Column(name = "creator")
    private Integer creator;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "changed_by")
    private Integer changedBy;

    @Column(name = "date_changed")
    private Date dateChanged;

    @Column(name = "voided")
    private Boolean voided;

    @Column(name = "voided_by")
    private Integer voidedBy;

    @Column(name = "date_voided")
    private Date dateVoided;

    @Column(name = "void_reason")
    private String voidReason;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "deathdate_estimated")
    private Boolean deathdateEstimated;

    @Column(name = "birthtime")
    private java.sql.Timestamp birthtime;

    @Column(name = "cause_of_death_non_coded")
    private String causeOfDeathNonCoded;

    // Getters and setters (omitted for brevity)
}
