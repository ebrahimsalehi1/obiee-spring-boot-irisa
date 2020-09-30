package com.irisa.obiee.backforfront.obieeservices;

import com.irisa.obiee.backforfront.cache.userprofiles.CacheStore;
import com.irisa.obiee.backforfront.cache.userprofiles.CacheStoreService;
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

    @Value("${is-cashe-enable}")
    private boolean isCacheEnable;

    @Autowired
    CacheStoreService cacheStoreService;

    private String callPost(String userName, String searchWord, String url) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        Map<String,String> inputParameters = new HashMap<>();
        inputParameters.put("user",userName);
        inputParameters.put("searchWord",searchWord);

        HttpEntity<?> httpEntity = new HttpEntity<>(inputParameters,httpHeaders);
        return restTemplate.exchange(url, HttpMethod.POST,httpEntity,String.class).getBody();
    }

    private String callChashableService(String userName, String searchWord, String url) {
        String result = null;

        if(isCacheEnable){

            if(cacheStoreService.isExist(url))
                result = cacheStoreService.getByKey(url);
            else{
                result = callPost(userName, searchWord, url);
                cacheStoreService.add(new CacheStore(url,result));
            }

        }
        else{
            result = callPost(userName, searchWord, url);
        }

        return result;
    }

    @Override
    public String getReportListTransactional(String userName,String searchWord) {

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/Reports";

        return callChashableService(userName, searchWord, url);

    }


    @Override
    public String getReportListDashboard(String userName, String searchWord) {
        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/assitanceandmydashboards";

        return callChashableService(userName, searchWord, url);
    }

    @Override
    public String getReportListAnalyser(String userName, String searchWord) {
        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/AnalyserProjects";

        return callChashableService(userName, searchWord, url);

    }
}
