package com.irisa.obiee.backforfront.webservices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface WebServiceRepository extends JpaRepository<WebService,Long>, PagingAndSortingRepository<WebService,Long> {
    @Override
    List<WebService> findAll();

}
