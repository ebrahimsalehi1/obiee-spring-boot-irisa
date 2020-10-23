package com.irisa.obiee.backforfront.statistic.statisticstore;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StatisticStoreServiceImpl implements StatisticStoreService {
    @Override
    public StatisticStore save(StatisticStore statisticStore) {
        return null;
    }

    @Override
    public List<StatisticStore> searchByUser(Date startDate, Date endDate) {
        return null;
    }

    @Override
    public List<StatisticStore> searchByReportBI(Date startDate, Date endDate) {
        return null;
    }

    @Override
    public List<StatisticStore> searchByReportDashboard(Date startDate, Date endDate) {
        return null;
    }

    @Override
    public List<StatisticStore> searchByReportVA(Date startDate, Date endDate) {
        return null;
    }

    @Override
    public List<StatisticStore> searchByApprole(Date startDate, Date endDate) {
        return null;
    }
}
