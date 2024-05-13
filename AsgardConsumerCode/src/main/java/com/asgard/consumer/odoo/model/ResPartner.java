package com.asgard.consumer.odoo.model;


import java.sql.Timestamp;

import com.asgard.consumer.Respartner;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "res_partner")
public class ResPartner {



@Id
@Column(name="id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer id;

@Column(name="name")
public String name;

@Column(name="company_id")
public Integer company_id;

@Column(name="comment")
public String comment;

@Column(name="website")
public String website;

@Column(name="create_date")
public java.sql.Timestamp create_date;

@Column(name="color")
public Integer color;

@Column(name="active")
public Boolean active;

@Column(name="street")
public String street;;

@Column(name="supplier")
public Boolean supplier;

@Column(name="city")
public String city;

@Column(name="display_name")
public String display_name;

@Column(name="zip")
public String zip;

@Column(name="title")
public Integer title;

@Column(name="country_id")
public Integer country_id;

@Column(name="commercial_company_name")
public String commercial_company_name;

@Column(name="parent_id")
public Integer parent_id;

@Column(name="company_name")
public String company_name;

@Column(name="employee")
public Boolean employee;

@Column(name="ref")
public String ref;

@Column(name="email")
public String email;

@Column(name="is_company")
public Boolean is_company;

@Column(name="function")
public String function;

@Column(name="lang")
public String lang;

@Column(name="fax")
public String fax;

@Column(name="street2")
public String street2;

@Column(name="barcode")
public String barcode;

@Column(name="phone")
public String phone;

@Column(name="write_date")
public java.sql.Date write_date;

@Column(name="date")
public java.sql.Date date;

@Column(name="tz")
public String tz;

@Column(name="write_uid")
public Integer write_uid;

@Column(name="customer")
public Boolean customer;

@Column(name="create_uid")
public Integer create_uid;

@Column(name="credit_limit")
public Double credit_limit;

@Column(name="user_id")
public Integer user_id;

@Column(name="mobile")
public String mobile;

@Column(name="type")
public String type;

@Column(name="partner_share")
public Boolean partner_share;

@Column(name="vat")
public String vat;

@Column(name="state_id")
public Integer state_id;

@Column(name="commercial_partner_id")
public Integer commercial_partner_id;

@Column(name="notify_email")
public String notify_email;

@Column(name="message_last_post")
public java.sql.Timestamp message_last_post;

@Column(name="opt_out")
public Boolean opt_out;

@Column(name="message_bounce")
public Integer message_bounce;

@Column(name="signup_type")
public String signup_type;

@Column(name="signup_expiration")
public java.sql.Timestamp  signup_expiration;

@Column(name="signup_token")
public String signup_token;

@Column(name="debit_limit")
public Long debit_limit;

@Column(name="last_time_entries_checked")
public java.sql.Timestamp last_time_entries_checked;

@Column(name="invoice_warn_msg")
public String invoice_warn_msg;

@Column(name="invoice_warn")
public String invoice_warn;

@Column(name="team_id")
public Integer team_id;

@Column(name="sale_warn")
public String sale_warn;

@Column(name="sale_warn_msg")
public String sale_warn_msg;

@Column(name="picking_warn")
public String picking_warn;

@Column(name="picking_warn_msg")
public String picking_warn_msg;

@Column(name="manufacturer")
public Boolean manufacturer;

@Column(name="local_name")
public String local_name;

@Column(name="village_id")
public Integer village_id;

@Column(name="tehsil_id")
public Integer tehsil_id;

@Column(name="district_id")
public Integer district_id = null;

@Column(name="purchase_warn")
public String purchase_warn;

@Column(name="purchase_warn_msg")
public String purchase_warn_msg;

@Column(name="uuid")
public String uuid;

@PrePersist
protected void onCreate() {
    create_date = new java.sql.Timestamp(System.currentTimeMillis());
    write_date = new java.sql.Date(System.currentTimeMillis());
} 

public ResPartner(Respartner res){

    this.id = res.getId();
    this.name = res.getName();
    this.display_name= res.getDisplay_name();
    this.ref =  res.getRef();
    this.uuid = res.getUuid();
    this.company_id = 1;
    this.color = 0;
    this.active  = true;
    this.supplier = false;
    this.employee = false;
    this.is_company = false;
    this.lang  = "en_US";
    this.write_uid = 1;
    this.customer = true;
    this.create_uid =1;
    this.type   ="contact" ;
    this.partner_share = true;
    this.notify_email ="always";
    this.opt_out = false;
    this.invoice_warn ="no-message";
    this.picking_warn = "no-message";
    this.manufacturer = false;
    this.local_name ="-";
    this.purchase_warn = "no-message";
    this.sale_warn= "no-message";
    this.commercial_partner_id = null;
}
    
}


