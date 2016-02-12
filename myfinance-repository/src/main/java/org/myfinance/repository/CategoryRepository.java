package org.myfinance.repository;

import org.myfinance.dao.CategoryDao;
import org.myfinance.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Owner on 11/01/2016.
 */
@Repository
public class CategoryRepository {

    @Autowired
    private CategoryDao _categoryDao;

    public Collection<Category> findAll() {
        Collection<org.myfinance.entity.Category> categoryEntities = _categoryDao.getCategories();
        Collection<Category> categories = new ArrayList<Category>();

        for (org.myfinance.entity.Category categoryEntity : categoryEntities) {
            categories.add(convertCategory(categoryEntity));
        }

        return categories;
    }

    private Category convertCategory(org.myfinance.entity.Category categoryEntity) {
        Category category = new Category();
        category.setId(categoryEntity.getId());
        category.setName(categoryEntity.getName());

        return category;
    }
}
