package com.irisa.obiee.backforfront.statistic.statisticstore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface StatisticStoreRepository extends JpaRepository<StatisticStore,Long> {
    @Override
    StatisticStore save(StatisticStore statisticStore);
}

