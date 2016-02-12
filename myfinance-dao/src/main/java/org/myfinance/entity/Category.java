package org.myfinance.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Owner on 11/01/2016.
 */
@Entity
@Table(name = "category")
public class Category {

    private int id;
    private String name;
    private Set<Transaction> transactions = new HashSet<Transaction>();

    @Id
    @Column(nullable = false, unique=true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id")
    public Set<Transaction> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
}