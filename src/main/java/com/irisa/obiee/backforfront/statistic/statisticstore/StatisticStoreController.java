package com.irisa.obiee.backforfront.statistic.statisticstore;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin
@RequestMapping(value = "/obiee-bff",produces = MediaType.APPLICATION_JSON_VALUE)
public class StatisticStoreController {

    @Autowired
    StatisticStoreService statisticStoreService;

    @GetMapping(value="/statistic/traffic")
    public ResponseEntity<?> traffic(){


        return new ResponseEntity<>(
                new JSONObject()
                    .put("value",1545)
                    .put("percent",45)
                    .toString()
                , HttpStatus.OK);

    }

    @GetMapping(value="/statistic/analytic")
    public ResponseEntity<?> analytic(){

        JSONArray jsonArray = new JSONArray();

        jsonArray.put(new JSONObject().put("month","تیر").put("count",3650 ));
        jsonArray.put(new JSONObject().put("month","مرداد").put("count",1920));
        jsonArray.put(new JSONObject().put("month","شهریور").put("count",1580));
        jsonArray.put(new JSONObject().put("month","مهر").put("count",1015));

        return new ResponseEntity<>(jsonArray.toString(), HttpStatus.OK);

    }

    @GetMapping(value="/statistic/visualAnalyser")
    public ResponseEntity<?> visualAnalyser(){

        JSONArray jsonArray = new JSONArray();

        jsonArray.put(new JSONObject().put("month","تیر").put("count",1000));
        jsonArray.put(new JSONObject().put("month","مرداد").put("count",2920));
        jsonArray.put(new JSONObject().put("month","شهریور").put("count",1650));
        jsonArray.put(new JSONObject().put("month","مهر").put("count",1075));

        return new ResponseEntity<>(jsonArray.toString(), HttpStatus.OK);

    }

    @GetMapping(value="/statistic/biPublisher")
    public ResponseEntity<?> biPublisher(){

        JSONArray jsonArray = new JSONArray();

        jsonArray.put(new JSONObject().put("month","تیر").put("count",1700));
        jsonArray.put(new JSONObject().put("month","مرداد").put("count",3125));
        jsonArray.put(new JSONObject().put("month","شهریور").put("count",4256));
        jsonArray.put(new JSONObject().put("month","مهر").put("count",3951));

        return new ResponseEntity<>(jsonArray.toString(), HttpStatus.OK);

    }

    @GetMapping(value="/statistic/all")
    public ResponseEntity<?> all(){

        JSONArray jsonArray = new JSONArray();

        jsonArray.put(new JSONObject().put("name","ANALYTIC").put("value",1700));
        jsonArray.put(new JSONObject().put("name","VISUAL_ANALYSER").put("value",3125));
        jsonArray.put(new JSONObject().put("name","BI_PUBLISHER").put("value",4256));

        return new ResponseEntity<>(jsonArray.toString(), HttpStatus.OK);

    }

    @GetMapping(value="/statistic/approle")
    public ResponseEntity<?> approle(){

        JSONArray jsonArray = new JSONArray();

        jsonArray.put(new JSONObject().put("name","برنامه ریزی و حمل محصول").put("count",1700));
        jsonArray.put(new JSONObject().put("name","رئیس اتوماسیون و ابزار دقیق مرکزی").put("count",3125));
        jsonArray.put(new JSONObject().put("name","رئیس آزمایشگاه های فولادسازی و مرکزی").put("count",4256));
        jsonArray.put(new JSONObject().put("name","مدیر انرژی و سیالات").put("count",3521));
        jsonArray.put(new JSONObject().put("name","معاون مالی").put("count",4256));
        jsonArray.put(new JSONObject().put("name","معاون منابع انسانی").put("count",2659));

        return new ResponseEntity<>(jsonArray.toString(), HttpStatus.OK);

    }

    @PostMapping(value="/statistic/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody StatisticStore statisticStore){

        statisticStore.toString();

        try {
            statisticStoreService.save(statisticStore);
            return new ResponseEntity<>(new JSONArray().put(true), HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new JSONArray().put(false), HttpStatus.EXPECTATION_FAILED);
        }

    }

}
