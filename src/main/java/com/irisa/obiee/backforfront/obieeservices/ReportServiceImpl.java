package com.irisa.obiee.backforfront.obieeservices;

import com.irisa.obiee.backforfront.cache.cachestore.CacheStore;
import com.irisa.obiee.backforfront.cache.cachestore.CacheStoreService;
import com.irisa.obiee.backforfront.general.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    GeneralService generalService;

    @Override
    public String getReportListTransactional(String userName,String searchWord) {

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/Reports";

        Map<String,Object> inputParameters = new HashMap<>();
        inputParameters.put("user",userName);
        inputParameters.put("searchWord",searchWord);

        return generalService.callChashableService(url,HttpMethod.POST,inputParameters);

    }


    @Override
    public String getReportListDashboard(String userName, String searchWord) {

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/assitanceandmydashboards";

        Map<String,Object> inputParameters = new HashMap<>();
        inputParameters.put("user",userName);
        inputParameters.put("searchWord",searchWord);

        return generalService.callChashableService(url,HttpMethod.POST,inputParameters);

    }

    @Override
    public String getReportListAnalyser(String userName, String searchWord) {

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/AnalyserProjects";

        Map<String,Object> inputParameters = new HashMap<>();
        inputParameters.put("user",userName);
        inputParameters.put("searchWord",searchWord);

        return generalService.callChashableService(url,HttpMethod.POST,inputParameters);

    }

}
