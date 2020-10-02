package com.irisa.obiee.backforfront;

import com.irisa.obiee.backforfront.cache.cachestore.CacheStore;
import com.irisa.obiee.backforfront.cache.cachestore.CacheStoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class CacheStoreTests {


    @Autowired
    CacheStoreService cacheStoreService;

    @Test
    public void insertingServiceLayer(){
        List<CacheStore> cacheStoreListMock = mock(List.class) ;
        when(cacheStoreListMock.size()).thenReturn(100);
        for (CacheStore cacheStore: cacheStoreListMock
             ) {
            cacheStoreService.add(cacheStore);
        }
    }
}
