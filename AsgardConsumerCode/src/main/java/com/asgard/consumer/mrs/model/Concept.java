package com.asgard.consumer.mrs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "concept")
public class Concept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "concept_id")
    private Integer conceptId;

    @Column(name = "retired")
    private Boolean retired;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "description")
    private String description;

    @Column(name = "form_text")
    private String formText;

    @Column(name = "datatype_id")
    private Integer dataTypeId;

    @Column(name = "class_id")
    private Integer classId;

    @Column(name = "is_set")
    private Boolean isSet;

    @Column(name = "creator")
    private Integer creator;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "version")
    private String version;

    @Column(name = "changed_by")
    private Integer changedBy;

    @Column(name = "date_changed")
    private Date dateChanged;

    @Column(name = "retired_by")
    private Integer retiredBy;

    @Column(name = "date_retired")
    private Date dateRetired;

    @Column(name = "retire_reason")
    private String retireReason;

    @Column(name = "uuid")
    private String uuid;
}
