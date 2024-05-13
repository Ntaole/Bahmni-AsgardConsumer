package com.asgard.consumer.mrs.model;

import java.util.Date;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person_name")
public class PersonName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_name_id")
    private Integer personNameId;

    @Column(name = "preferred")
    private boolean preferred;

    @Column(name = "person_id")
    private int personId;

    @Column(name = "prefix")
    private String prefix;

    @Column(name = "given_name")
    private String givenName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "family_name_prefix")
    private String familyNamePrefix;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "family_name2")
    private String familyName2;

    @Column(name = "family_name_suffix")
    private String familyNameSuffix;

    @Column(name = "degree")
    private String degree;

    @Column(name = "creator")
    private int creator;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "voided")
    private boolean voided;

    @Column(name = "voided_by")
    private Integer voidedBy;

    @Column(name = "date_voided")
    private Date dateVoided;

    @Column(name = "void_reason")
    private String voidReason;

    @Column(name = "changed_by")
    private Integer changedBy;

    @Column(name = "date_changed")
    private Date dateChanged;

    @Column(name = "uuid", unique = true)
    private String uuid;

    // Getters and setters (omitted for brevity)
}
