package com.asgard.consumer.odoo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
@Table(name="product_product")
@Entity
public class DrugProduct {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name="create_date")
    public java.sql.Timestamp create_date;

    @Column(name="weight")
    public Long weight;

    @Column(name="default_code")
    public String default_code;

    @Column(name="product_tmpl_id")
    public Integer product_tmpl_id;

    @Column(name="message_last_post")
    public java.sql.Timestamp messageLastPost;

    @Column(name="create_uid")
    public Integer createUid;

    @Column(name="write_uid")
    public Integer writeUid;

    @Column(name="barcode")
    public String barCode;

    @Column(name="volume")
    public Double volume;

    @Column(name="write_date")
    public java.sql.Timestamp write_date;

    @Column(name="active")
    public Boolean active;

    @Column(name="uuid")
    public String uuid;

    @Column(name="mrp")
    public Double mrp;
    @PrePersist
    protected void onCreate() {
    create_date = new java.sql.Timestamp(System.currentTimeMillis());
    write_date = new java.sql.Timestamp(System.currentTimeMillis());
} 

public DrugProduct(String uuidstring,Integer productid){
    this.product_tmpl_id = productid;
    this.uuid = uuidstring;
    this.createUid = 1;
    this.writeUid =1;
    this.active = true;

}

    
    
}
