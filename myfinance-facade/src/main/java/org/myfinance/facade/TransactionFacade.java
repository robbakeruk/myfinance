package org.myfinance.facade;

import org.myfinance.domain.Transaction;
import org.myfinance.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by Owner on 18/12/2015.
 */
@Path("transactions")
@Service
public class TransactionFacade {

    @Autowired
    private TransactionRepository _transactionRepository;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Transaction> getTransactions() {
        System.out.format("Getting transactions");
        return _transactionRepository.findAll();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction getTransaction(@PathParam("id") Integer id) {
        System.out.format("Getting id: %d\n", id);
        return _transactionRepository.find(id);
    }

    @GET
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction delete(@PathParam("id") Integer id) {
        //return _transactionRepository.removeTransaction(id);
        return null;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateTransaction(@PathParam("id") Integer id, Transaction transaction) {
        System.out.format("Updating transaction: %d\n", id);
        _transactionRepository.save(transaction);
    }

    @POST
    @Path("/transaction")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction addTransaction(Transaction t) {
        System.out.println("Add transaction");
        //_transactionRepository.addPerson(t);
        //return _transactionRepository.getTransaction(t.getId());
        return null;
    }
}
