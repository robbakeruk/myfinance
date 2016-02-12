package org.myfinance.repository.unit.test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.myfinance.entity.Transaction;
import org.myfinance.dao.TransactionDao;
import org.myfinance.entity.Category;
import org.myfinance.repository.TransactionRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

/**
 * Created by Owner on 12/01/2016.
 */
public class TransactionRepositoryTest {

    @Mock
    private TransactionDao transactionDao;

    @InjectMocks
    private TransactionRepository transactionRepository;

    @BeforeMethod
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test(){
        Transaction transaction = new Transaction();
        transaction.setId(1);
        Category category = new Category();
        category.setId(1);
        category.setName("RobTest");
        transaction.setCategory(category);
        when(transactionDao.getTransaction(1)).thenReturn(transaction);

        org.myfinance.domain.Transaction domainTransaction = transactionRepository.find(1);

        Assert.assertTrue(domainTransaction.getId() == 1);
        Assert.assertTrue(domainTransaction.getCategoryId() == 1);
    }
}
