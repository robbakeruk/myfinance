package org.myfinance.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Owner on 11/01/2016.
 */
public class Category {

    private int id;
    private String name;
    private Set<Transaction> transactions = new HashSet<Transaction>();

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

    public Set<Transaction> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
}