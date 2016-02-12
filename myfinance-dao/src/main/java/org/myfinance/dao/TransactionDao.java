package org.myfinance.dao;

import org.myfinance.entity.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Owner on 18/12/2015.
 */
@Component
public class TransactionDao {

    @PersistenceContext(unitName = "punit")
    private EntityManager entityManager;

    @Transactional
    public Transaction getTransaction(Integer id) {

        return entityManager.find(Transaction.class, id);
    }

    @Transactional
    public Collection<Transaction> getTransactions() {
        Query query = entityManager.createQuery("SELECT e FROM Transaction e");
        return (Collection<Transaction>) query.getResultList();
    }

    @Transactional
    public void saveTransaction(Transaction transaction) {
        entityManager.merge(transaction);
    }
}