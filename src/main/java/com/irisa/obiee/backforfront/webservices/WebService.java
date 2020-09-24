package com.irisa.obiee.backforfront.webservices;

import javax.persistence.*;

@Entity
@Table(name = "FND_WEB_SERVICES")
public class WebService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WEB_SERVICE_ID")
    private Long serviceId;

    @Column(name="DES_URL_WEBSR",columnDefinition = "DES_URL_WEBSR VARCHAR2(300 CHAR) NOT NULL")
    private String url;

    @Column(name="DES_SAMPLE_WEBSR",columnDefinition = "DES_SAMPLE_WEBSR CLOB NOT NULL")
    private String sampleData;

    @Column(name="LKP_TYP_WEBSR",columnDefinition = "LKP_TYP_WEBSR VARCHAR2(30 CHAR) NOT NULL")
    private String typ;

    @Column(name="DES_RANGE_WEBSR",columnDefinition = "DES_RANGE_WEBSR VARCHAR2(500 CHAR) NOT NULL")
    private String range;

    @Column(name="DES_DESCIPTION_WEBSR",columnDefinition = "DES_DESCIPTION_WEBSR CLOB NOT NULL")
    private String description;

    public WebService() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSampleData() {
        return sampleData;
    }

    public void setSampleData(String sampleData) {
        this.sampleData = sampleData;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
