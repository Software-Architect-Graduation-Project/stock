package com.rbittencourt.pa.stock.infrastructure.stock;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "stock_record")
public class StockRecord {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    private long id;

    @Column(name = "order_id")
    private long orderId;

    @Column
    private String products;

    @Column(name = "created_on")
    @CreationTimestamp
    private LocalDateTime createdOn;

    public StockRecord() {
        createdOn = LocalDateTime.now();
    }

    public StockRecord(long orderId, String products) {
        this.orderId = orderId;
        this.products = products;
        this.createdOn = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

}
