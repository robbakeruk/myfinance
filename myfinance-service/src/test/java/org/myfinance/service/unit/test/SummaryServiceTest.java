package org.myfinance.service.unit.test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.myfinance.domain.Category;
import org.myfinance.domain.Summary;
import org.myfinance.domain.Transaction;
import org.myfinance.repository.CategoryRepository;
import org.myfinance.repository.TransactionRepository;
import org.myfinance.service.SummaryService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import static org.mockito.Mockito.when;

/**
 * Created by Owner on 01/02/2016.
 */
public class SummaryServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private SummaryService summaryService;

    @BeforeMethod
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test(){

        //Arrange
        Collection<Category> categories = new ArrayList<Category>();
        Category cat = new Category();
        cat.setId(1);
        cat.setName("Test");
        categories.add(cat);

        when(categoryRepository.findAll()).thenReturn(categories);

        Collection<Transaction> transactions = new ArrayList<Transaction>();
        Transaction tran = new Transaction();
        tran.setId(1);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2015);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.MONTH, Calendar.OCTOBER);
        tran.setDate(cal.getTime());
        tran.setAmount(2000.00);
        tran.setCategoryId(1);
        transactions.add(tran);

        when(transactionRepository.findAll()).thenReturn(transactions);

        //Act
        Collection<Summary> summary = summaryService.getSummary("201510");

        //Assert
        Assert.assertTrue(summary.iterator().next().getCategory() == "Test");
        Assert.assertTrue(summary.iterator().next().getAmount() == 2000.00);
    }

    @Test
    public void test2(){

        //Arrange
        Collection<Category> categories = new ArrayList<Category>();
        Category cat = new Category();
        cat.setId(1);
        cat.setName("Test");
        categories.add(cat);

        when(categoryRepository.findAll()).thenReturn(categories);

        Collection<Transaction> transactions = new ArrayList<Transaction>();
        Transaction tran = new Transaction();
        tran.setId(1);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2015);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.MONTH, Calendar.NOVEMBER);
        tran.setDate(cal.getTime());
        tran.setAmount(2000.00);
        tran.setCategoryId(1);
        transactions.add(tran);

        when(transactionRepository.findAll()).thenReturn(transactions);

        //Act
        Collection<Summary> summary = summaryService.getSummary("201510");

        //Assert
        Assert.assertTrue(summary.iterator().next().getCategory() == "Test");
        Assert.assertTrue(summary.iterator().next().getAmount() == 0.00);
    }
}
