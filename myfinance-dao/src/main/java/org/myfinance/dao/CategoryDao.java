package org.myfinance.dao;

import org.myfinance.entity.Category;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

/**
 * Created by Owner on 12/01/2016.
 */
@Component
public class CategoryDao {

    @PersistenceContext(unitName = "punit")
    private EntityManager entityManager;

    @Transactional
    public Collection<Category> getCategories() {

        Query query = entityManager.createQuery("SELECT e FROM Category e");
        return (Collection<Category>) query.getResultList();
    }

}
