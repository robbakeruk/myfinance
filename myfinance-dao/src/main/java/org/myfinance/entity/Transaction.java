package org.myfinance.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Owner on 11/01/2016.
 */
@Entity
@Table(name = "transaction")
@org.hibernate.annotations.Entity(
        dynamicUpdate = true
)
public class Transaction {

    private int id;
    private Date date;
    private String description;
    private String source;
    private String sourceId;
    private double amount;
    private Category category;

    @Id
    @Column(nullable = false, unique=true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = true)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}