package org.myfinance.service;

import org.myfinance.domain.Category;
import org.myfinance.domain.Summary;
import org.myfinance.domain.Transaction;
import org.myfinance.repository.CategoryRepository;
import org.myfinance.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Owner on 25/01/2016.
 */
@Service
public class SummaryService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Collection<Summary> getSummary(String date) {

        Collection<Transaction> transactions =  transactionRepository.findAll();
        Collection<Category> categories = categoryRepository.findAll();

        Collection<Summary> summaryRows = new ArrayList<Summary>();

        Calendar cal = Calendar.getInstance();
        Integer selectedMonth = Integer.parseInt(date.substring(4));
        Integer selectedYear = Integer.parseInt(date.substring(0, 4));
        int sum;
        for (Category cat: categories) {
            Summary summary = new Summary();
            summary.setCategory(cat.getName());
            sum = 0;
            for (Transaction t: transactions) {
                cal.setTime(t.getDate());
                cal.get(Calendar.MONTH);
                if (cal.get(Calendar.MONTH) == (selectedMonth - 1) && cal.get(Calendar.YEAR) == selectedYear) {
                    if (t.getCategoryId() == cat.getId())
                        sum += t.getAmount();
                }
            }
            summary.setAmount(sum);
            summaryRows.add(summary);
        }

        return summaryRows;
    }

    public HashMap<String, Date> getDates() {

        HashMap<String, Date> dates = new HashMap<String, Date>();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2015);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.MONTH, Calendar.AUGUST);
        Date d = cal.getTime();
        dates.put("201508", d);
        cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
        d = cal.getTime();
        dates.put("201509", d);
        cal.set(Calendar.MONTH, Calendar.OCTOBER);
        d = cal.getTime();
        dates.put("201510", d);
        cal.set(Calendar.MONTH, Calendar.NOVEMBER);
        d = cal.getTime();
        dates.put("201511", d);

        return dates;
    }
}
