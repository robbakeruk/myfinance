package org.myfinance.service.dao.integration.test;

import org.myfinance.dao.CategoryDao;
import org.myfinance.entity.Category;
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
public class CategoryDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void test(){

        Collection<Category> categories = categoryDao.getCategories();

        Assert.assertFalse(categories == null);
    }

}
