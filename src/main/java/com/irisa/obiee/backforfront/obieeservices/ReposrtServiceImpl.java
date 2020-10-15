package com.irisa.obiee.backforfront.obieeservices;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ReposrtServiceImpl implements ReportService {

    @Override
    public List<Report> changeReports(List<Report> reports) {
        List<Report> result = new ArrayList<>();
        AtomicInteger i= new AtomicInteger();
        reports.stream().forEach(obj->{
            Report report = obj;
            report.setId(new Integer(i.incrementAndGet()));
            result.add(report);
        });

        return result;
    }
}
