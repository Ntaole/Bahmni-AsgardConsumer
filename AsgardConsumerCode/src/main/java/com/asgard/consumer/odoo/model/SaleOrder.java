package com.asgard.consumer.odoo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sale_order")
public class SaleOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "origin")
    private String origin;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "write_uid")
    private Integer writeUid;

    @Column(name = "team_id")
    private Integer teamId;

    @Column(name = "client_order_ref")
    private String clientOrderRef;

    @Column(name = "date_order")
    private Date dateOrder;

    @Column(name = "partner_id")
    private Integer partnerId;

    @Column(name = "note")
    private String note;

    @Column(name = "procurement_group_id")
    private Integer procurementGroupId;

    @Column(name = "amount_untaxed")
    private double amountUntaxed;

    @Column(name = "message_last_post")
    private Date messageLastPost;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "amount_tax")
    private double amountTax;

    @Column(name = "state")
    private String state;

    @Column(name = "pricelist_id")
    private Integer pricelistId;

    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "create_uid")
    private Integer createUid;

    @Column(name = "confirmation_date")
    private Date confirmationDate;

    @Column(name = "validity_date")
    private Date validityDate;

    @Column(name = "payment_term_id")
    private Integer paymentTermId;

    @Column(name = "write_date")
    private Date writeDate;

    @Column(name = "partner_invoice_id")
    private Integer partnerInvoiceId;

    @Column(name = "fiscal_position_id")
    private Integer fiscalPositionId;

    @Column(name = "amount_total")
    private double amountTotal;

    @Column(name = "invoice_status")
    private String invoiceStatus;

    @Column(name = "name")
    private String name;

    @Column(name = "partner_shipping_id")
    private Integer partnerShippingId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "picking_policy")
    private String pickingPolicy;

    @Column(name = "incoterm")
    private Integer incoterm;

    @Column(name = "warehouse_id")
    private Integer warehouseId;

    @Column(name = "provider_name")
    private String providerName;

    @Column(name = "location_id")
    private Integer locationId;

    @Column(name = "care_setting")
    private String careSetting;

    @Column(name = "discount_percentage")
    private Double discountPercentage;

    @Column(name = "amount_round_off")
    private Double amountRoundOff;

    @Column(name = "chargeable_amount")
    private Double chargeableAmount;

    @Column(name = "default_quantity")
    private Integer defaultQuantity;

    @Column(name = "partner_village")
    private Integer partnerVillage;

    @Column(name = "discount_type")
    private String discountType;

    @Column(name = "disc_acc_id")
    private Integer discAccId;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "dispensed")
    private Boolean dispensed;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "shop_id")
    private Integer shopId;

    @Column(name = "partner_uuid")
    private String partnerUuid;

    @PrePersist
    protected void onCreate() {
    dateOrder = new java.sql.Date(System.currentTimeMillis());
} 

    public SaleOrder(Integer customerid,String name,Integer userid,String providername, String caresetting, String useruud){
        this.partnerId = customerid;
        this.name = name;
        this.userId = userid;
        this.providerName = providername;
        this.careSetting = caresetting;
        this.partnerUuid = useruud;

        this.origin = "ASGARDIAN SYNC";
        this.writeUid =1;
        this.teamId=1;
        this.amountUntaxed = 1.00;
        this.companyId = 1;
        this.amountTax =0.0;
        this.state = "draft";
        this.pricelistId = 1;
        this.createUid=1;
        this.paymentTermId=3;
        this.partnerInvoiceId = customerid;
        this.amountTotal = 0.0;
        this.partnerShippingId = customerid;
        this.pickingPolicy = "direct";
        this.warehouseId =1;
        this.discountType ="none";
        this.shopId = 1;
        

    }

}
