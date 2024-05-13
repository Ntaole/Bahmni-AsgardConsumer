package com.asgard.consumer.mrs.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient_identifier")
public class PatientIdentifier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_identifier_id")
    private int patientIdentifierId;

    @Column(name = "patient_id")
    private int patientId;

    @Column(name = "identifier")
    private String identifier;

    @Column(name = "identifier_type")
    private int identifierType;

    @Column(name = "preferred")
    private boolean preferred;

    @Column(name = "location_id")
    private Integer locationId;

    @Column(name = "creator")
    private int creator;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_changed")
    private Date dateChanged;

    @Column(name = "changed_by")
    private Integer changedBy;

    @Column(name = "voided")
    private boolean voided;

    @Column(name = "voided_by")
    private Integer voidedBy;

    @Column(name = "date_voided")
    private Date dateVoided;

    @Column(name = "void_reason")
    private String voidReason;

    @Column(name = "uuid")
    private String uuid;

    // Getters and setters (omitted for brevity)
}
