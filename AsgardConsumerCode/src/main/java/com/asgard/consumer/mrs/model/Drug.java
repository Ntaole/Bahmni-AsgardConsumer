package com.asgard.consumer.mrs.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "drug")
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drug_id")
    private Integer drugId;

    @Column(name = "concept_id")
    private Integer conceptId;

    @Column(name = "name")
    private String name;

    @Column(name = "combination")
    private Boolean combination;

    @Column(name = "dosage_form")
    private Integer dosageForm;

    @Column(name = "maximum_daily_dose")
    private Double maximumDailyDose;

    @Column(name = "minimum_daily_dose")
    private Double minimumDailyDose;

    @Column(name = "route")
    private Integer route;

    @Column(name = "creator")
    private Integer creator;

    @Column(name = "date_created")
    private java.sql.Date dateCreated;

    @Column(name = "retired")
    private Boolean retired;

    @Column(name = "changed_by")
    private Integer changedBy;

    @Column(name = "date_changed")
    private java.sql.Date dateChanged;

    @Column(name = "retired_by")
    private Integer retiredBy;

    @Column(name = "date_retired")
    private java.sql.Date dateRetired;

    @Column(name = "retire_reason")
    private String retireReason;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "strength")
    private String strength;

    @Column(name = "dose_limit_units")
    private Integer doseLimitUnits;

}
