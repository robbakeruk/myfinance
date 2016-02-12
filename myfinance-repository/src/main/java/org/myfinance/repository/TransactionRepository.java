package org.myfinance.repository;

import org.myfinance.domain.Transaction;
import org.myfinance.dao.TransactionDao;
import org.myfinance.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Owner on 11/01/2016.
 */
@Repository
public class TransactionRepository {

    @Autowired
    private TransactionDao _transactionDao;


    public Transaction find(Integer id) {
        org.myfinance.entity.Transaction transactionEntity = _transactionDao.getTransaction(id);

        return convertTransaction(transactionEntity);
    }

    public Collection<Transaction> findAll() {
        Collection<org.myfinance.entity.Transaction> transactionEntities = _transactionDao.getTransactions();
        Collection<Transaction> transactions = new ArrayList<Transaction>();

        for (org.myfinance.entity.Transaction transactionEntity : transactionEntities) {
            transactions.add(convertTransaction(transactionEntity));
        }

        return transactions;
    }

    public void save(Transaction transaction) {

        _transactionDao.saveTransaction(convertTransaction(transaction));
    }

    private org.myfinance.entity.Transaction convertTransaction(Transaction transaction) {
        org.myfinance.entity.Transaction transactionEntity = new org.myfinance.entity.Transaction();
        transactionEntity.setId(transaction.getId());
        transactionEntity.setDescription(transaction.getDescription());
        transactionEntity.setDate(transaction.getDate());
        transactionEntity.setSource(transaction.getSource());
        transactionEntity.setSourceId(transaction.getSourceId());
        transactionEntity.setAmount(transaction.getAmount());

        if (transaction.getCategoryId() > 0) {
            Category category = new Category();
            category.setId(transaction.getCategoryId());
            transactionEntity.setCategory(category);
        }

        return transactionEntity;
    }

    private Transaction convertTransaction(org.myfinance.entity.Transaction transactionEntity) {
        Transaction transaction = new Transaction();
        transaction.setId(transactionEntity.getId());
        transaction.setDescription(transactionEntity.getDescription());
        transaction.setDate(transactionEntity.getDate());
        transaction.setSource(transactionEntity.getSource());
        transaction.setSourceId(transactionEntity.getSourceId());
        transaction.setAmount(transactionEntity.getAmount());

        if (transactionEntity.getCategory() != null) {
            transaction.setCategoryId(transactionEntity.getCategory().getId());
            transaction.setCategoryName(transactionEntity.getCategory().getName());
        }

        return transaction;
    }
}
