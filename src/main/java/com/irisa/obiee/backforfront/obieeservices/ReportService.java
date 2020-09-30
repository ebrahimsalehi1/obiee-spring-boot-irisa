package com.irisa.obiee.backforfront.obieeservices;

public interface ReportService {
    String getReportListTransactional(String userName,String searchWord);
    String getReportListDashboard(String userName,String searchWord);
    String getReportListAnalyser(String userName,String searchWord);
}
