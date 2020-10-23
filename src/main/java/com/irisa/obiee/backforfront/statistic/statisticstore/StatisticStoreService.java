package com.irisa.obiee.backforfront.statistic.statisticstore;

import java.util.Date;
import java.util.List;

public interface StatisticStoreService {
    public StatisticStore save(StatisticStore statisticStore);

    public List<StatisticStore> searchByUser(Date startDate,Date endDate);
    public List<StatisticStore> searchByReportBI(Date startDate,Date endDate);
    public List<StatisticStore> searchByReportDashboard(Date startDate,Date endDate);
    public List<StatisticStore> searchByReportVA(Date startDate,Date endDate);
    public List<StatisticStore> searchByApprole(Date startDate,Date endDate);
}
