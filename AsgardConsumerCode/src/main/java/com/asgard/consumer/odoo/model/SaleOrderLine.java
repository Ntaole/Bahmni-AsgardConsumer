package com.asgard.consumer.odoo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "sale_order_line")
public class SaleOrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "product_uom")
    private Integer productUom;

    @Column(name = "price_unit")
    private Double priceUnit;

    @Column(name = "product_uom_qty")
    private Double productUomQty;

    @Column(name = "price_subtotal")
    private Double priceSubtotal;

    @Column(name = "write_uid")
    private Integer writeUid;

    @Column(name = "currency_id")
    private Integer currencyId;

    @Column(name = "price_reduce_taxexcl")
    private Double priceReduceTaxexcl;

    @Column(name = "create_uid")
    private Integer createUid;

    @Column(name = "price_tax")
    private Double priceTax;

    @Column(name = "qty_to_invoice")
    private Double qtyToInvoice;

    @Column(name = "customer_lead")
    private Double customerLead;

    @Column(name = "layout_category_sequence")
    private Integer layoutCategorySequence;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "state")
    private String state;

    @Column(name = "order_partner_id")
    private Integer orderPartnerId;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "qty_invoiced")
    private Double qtyInvoiced;

    @Column(name = "sequence")
    private Integer sequence;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "write_date")
    private Date writeDate;

    @Column(name = "price_reduce")
    private Double priceReduce;

    @Column(name = "qty_delivered")
    private Double qtyDelivered;

    @Column(name = "layout_category_id")
    private Integer layoutCategoryId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "price_reduce_taxinc")
    private Double priceReduceTaxinc;

    @Column(name = "price_total")
    private Double priceTotal;

    @Column(name = "invoice_status")
    private String invoiceStatus;

    @Column(name = "name")
    private String name;

    @Column(name = "salesman_id")
    private Integer salesmanId;

    @Column(name = "product_packaging")
    private Integer productPackaging;

    @Column(name = "route_id")
    private Integer routeId;

    @Column(name = "lot_id")
    private Integer lotId;

    @Column(name = "external_order_id")
    private String externalOrderId;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @Column(name = "order_uuid")
    private String orderUuid;

    @Column(name = "dispensed")
    private Boolean dispensed;

    @Column(name = "external_id")
    private String externalId;

    public SaleOrderLine(Integer customerid,Integer saleorderid,Integer productid,String name){

        this.productUom = 1;
        this.priceUnit=1.00;
        this.productUomQty=1.000;
        this.priceSubtotal=1.0;
        this.writeUid =1;
        this.currencyId =21;
        this.priceReduceTaxexcl =1.00;
        this.createUid = 1;
        this.priceTax=0.0;
        this.qtyToInvoice = 0.00;
        this.customerLead =0.0;
        this.companyId = 1;
        this.state ="draft";
        this.orderPartnerId = customerid;
        this.orderId =saleorderid;
        this.sequence = 10;
        this.discount =0.00;
        this.priceReduce = 1.0;
        this.qtyDelivered= 0.00;
        this.productId = productid;
        this.priceReduceTaxinc = 1.0;
        this.priceTotal = 1.0;
        this.invoiceStatus = "no";
        this.name = name;
        this.salesmanId=1;
        this.dispensed = false;


    }

}
