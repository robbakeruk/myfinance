package org.myfinance.service.dao.integration.test;

import org.myfinance.dao.TransactionDao;
import org.myfinance.entity.Category;
import org.myfinance.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;

/**
 * Created by Owner on 11/01/2016.
 */
@ContextConfiguration(locations = {"classpath:spring-test-context.xml"})
public class TransactionDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TransactionDao transactionDao;

    @Test
    public void getTransaction_simple_test(){

        Transaction transaction = transactionDao.getTransaction(5);

        Assert.assertFalse(transaction == null);
    }

    @Test
    public void getTransactions_simple_test(){

        Collection<Transaction> transactions = transactionDao.getTransactions();

        Assert.assertFalse(transactions == null);
    }

    @Test
    public void saveTransaction_simple_test(){

        Transaction transaction = transactionDao.getTransaction(1);
        Category cat = new Category();
        cat.setId(2);
        transaction.setCategory(cat);
        transactionDao.saveTransaction(transaction);

        transaction = transactionDao.getTransaction(1);

        Assert.assertTrue(transaction.getCategory().getId() == 2);
    }
}
