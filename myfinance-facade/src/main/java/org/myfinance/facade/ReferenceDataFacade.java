package org.myfinance.facade;

import org.myfinance.domain.Category;
import org.myfinance.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by Owner on 18/12/2015.
 */
@Path("reference-data")
@Service
public class ReferenceDataFacade {

    @Autowired
    private CategoryRepository _categoryRepository;

    @GET
    @Path("/categories")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Category> getCategories() {
        System.out.format("Getting categories");
        return _categoryRepository.findAll();
    }
}
