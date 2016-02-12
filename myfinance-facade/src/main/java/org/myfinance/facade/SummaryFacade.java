package org.myfinance.facade;

import org.myfinance.service.SummaryService;
import org.myfinance.domain.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;

/**
 * Created by Owner on 18/01/2016.
 */
@Path("summary")
@Service
public class SummaryFacade {

    @Autowired
    private SummaryService _summaryService;

    @GET
    @Path("/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Summary> getSummary(@PathParam("date") String date) {
        System.out.format("Getting summary");

        return _summaryService.getSummary(date);
    }

    @GET
    @Path("/dates")
    @Produces(MediaType.APPLICATION_JSON)
    public HashMap<String, Date> getDates() {
        System.out.format("Getting summary dates");

        return _summaryService.getDates();
    }
}
