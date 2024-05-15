package com.asgard.consumer.mrs.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
@Getter
@Setter
@Entity
@Table(name = "encounter")
public class Encounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "encounter_id")
    private Integer encounterId;

    @Column(name = "encounter_type")
    private Integer encounterType;

    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "location_id")
    private Integer locationId;

    @Column(name = "form_id")
    private Integer formId;

    @Column(name = "encounter_datetime")
    private Date encounterDatetime;

    @Column(name = "creator")
    private Integer creator;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "voided")
    private Boolean voided;

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

    @Column(name = "visit_id")
    private Integer visitId;

    @Column(name = "uuid")
    private String uuid;
}
