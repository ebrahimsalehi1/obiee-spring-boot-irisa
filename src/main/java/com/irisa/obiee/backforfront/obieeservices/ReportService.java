package com.irisa.obiee.backforfront.obieeservices;

import org.springframework.stereotype.Service;

import java.util.List;

public interface ReportService {

    public List<Report> changeReports(List<Report> reports);

}
