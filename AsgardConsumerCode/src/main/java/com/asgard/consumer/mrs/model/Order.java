package com.asgard.consumer.mrs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "order_type_id")
    private Integer orderTypeId;

    @Column(name = "concept_id")
    private Integer conceptId;

    @Column(name = "orderer")
    private Integer orderer;

    @Column(name = "encounter_id")
    private Integer encounterId;

    @Column(name = "instructions")
    private String instructions;

    @Column(name = "date_activated")
    private Date dateActivated;

    @Column(name = "auto_expire_date")
    private Date autoExpireDate;

    @Column(name = "date_stopped")
    private Date dateStopped;

    @Column(name = "order_reason")
    private Integer orderReason;

    @Column(name = "order_reason_non_coded")
    private String orderReasonNonCoded;

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

    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "accession_number")
    private String accessionNumber;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "urgency")
    private String urgency;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "previous_order_id")
    private Integer previousOrderId;

    @Column(name = "order_action")
    private String orderAction;

    @Column(name = "comment_to_fulfiller")
    private String commentToFulfiller;

    @Column(name = "care_setting")
    private Integer careSetting;

    @Column(name = "scheduled_date")
    private Date scheduledDate;

    @Column(name = "order_group_id")
    private Integer orderGroupId;

    @Column(name = "sort_weight")
    private Double sortWeight;

    @Column(name = "fulfiller_comment")
    private String fulfillerComment;

    @Column(name = "fulfiller_status")
    private String fulfillerStatus;

    @Column(name = "form_namespace_and_path")
    private String formNamespaceAndPath;

}
