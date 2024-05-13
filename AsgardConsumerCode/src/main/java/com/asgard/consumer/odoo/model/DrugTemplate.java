package com.asgard.consumer.odoo.model;
import java.sql.Date;
import java.sql.Timestamp;

import com.asgard.consumer.Tempdrug;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name= "product_template")
public class DrugTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "warranty")
    private Double warranty;

    @Column(name = "list_price")
    private Double listPrice;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "sequence")
    private Integer sequence;

    @Column(name = "color")
    private Integer color;

    @Column(name = "write_uid")
    private Integer writeUid;

    @Column(name = "uom_id")
    private Integer uomId;

    @Column(name = "description_purchase")
    private String descriptionPurchase;

    @Column(name = "default_code")
    private String defaultCode;

    @Column(name = "create_date")
    private Timestamp createDate;

    @Column(name = "create_uid")
    private Integer createUid;

    @Column(name = "sale_ok")
    private Boolean saleOk;

    @Column(name = "purchase_ok")
    private Boolean purchaseOk;

    @Column(name = "message_last_post")
    private java.sql.Timestamp messageLastPost;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "uom_po_id")
    private Integer uomPoId;

    @Column(name = "description_sale")
    private String descriptionSale;

    @Column(name = "description")
    private String description;

    @Column(name = "volume")
    private int volume;

    @Column(name = "write_date")
    private Date writeDate;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "categ_id")
    private Integer categId;

    @Column(name = "name")
    private String name;

    @Column(name = "rental")
    private Boolean rental;

    @Column(name = "type")
    private String type;

    @Column(name = "sale_line_warn")
    private String saleLineWarn;

    @Column(name = "sale_line_warn_msg")
    private String saleLineWarnMsg;

    @Column(name = "track_service")
    private String trackService;

    @Column(name = "invoice_policy")
    private String invoicePolicy;

    @Column(name = "expense_policy")
    private String expensePolicy;

    @Column(name = "tracking")
    private String tracking;

    @Column(name = "location_id")
    private Integer locationId;

    @Column(name = "description_picking")
    private String descriptionPicking;

    @Column(name = "warehouse_id")
    private Integer warehouseId;

    @Column(name = "sale_delay")
    private Double saleDelay;

    @Column(name = "use_time")
    private Integer useTime;

    @Column(name = "life_time")
    private Integer lifeTime;

    @Column(name = "removal_time")
    private Integer removalTime;

    @Column(name = "alert_time")
    private Integer alertTime;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "dhis2_code")
    private String dhis2Code;

    @Column(name = "manufacturer")
    private Integer manufacturer;

    @Column(name = "drug")
    private String drug;

    @Column(name = "mrp")
    private Double mrp;

    @Column(name = "purchase_line_warn_msg")
    private String purchaseLineWarnMsg;

    @Column(name = "purchase_method")
    private String purchaseMethod;

    @Column(name = "purchase_line_warn")
    private String purchaseLineWarn;

    @Column(name = "pos_categ_id")
    private Integer posCategId;

    @Column(name = "to_weight")
    private Boolean toWeight;

    @Column(name = "available_in_pos")
    private Boolean availableInPos;
    @PrePersist
    protected void onCreate() {
    createDate = new java.sql.Timestamp(System.currentTimeMillis());
    writeDate = new java.sql.Date(System.currentTimeMillis());
} 

public DrugTemplate(Tempdrug tempdrug){
    if(tempdrug.getStrength()!=null){
        this.name = tempdrug.getName() + tempdrug.getStrength();

    }
    else{
        this.name = tempdrug.getName();

    }

    this.uuid = tempdrug.getUuid();
    this.drug = tempdrug.getName();
    this.saleLineWarn="no-message";
    this.purchaseLineWarn="no-message";
    this.categId = 3;
    this.listPrice = 0.00;
    this.weight = 0.00;
    this.sequence = 1;
    this.writeUid = 1;
    this.uomId =1;
    this.createUid = 1;
    this.saleOk = true;
    this.purchaseOk = true;
    this.companyId = 1;
    this.uomPoId = 1;
    this.volume=0;
    this.active = true;
    this.rental=false;
    this.type="product";
    this.saleLineWarnMsg="no-message";
    this.trackService = "manual";
    this.invoicePolicy = "order";
    this.expensePolicy = "no";
    this.tracking = "none";
    this.saleDelay = 0.0;
    this.mrp = 0.0;
    this.purchaseMethod="receive";
    this.purchaseLineWarnMsg = "no-message";
    this.toWeight=false;
    this.availableInPos=true;
    

}

}
