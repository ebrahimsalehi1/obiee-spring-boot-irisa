package com.irisa.obiee.backforfront.log.logstore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FND_LOG_STORES")
public class LogStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUM_LOG_ID")
    private long id;

    @Column(name="DAT_REG_LOGST",nullable = false)
    private Date datReg;

    @Column(name="DES_KEY_LOGST",nullable = false)
    private String key;

    @Column(name="DES_VAL_LOGST",nullable = false)
    private String val;

    public LogStore() {
    }

    public LogStore(Date datReg, String key, String val) {
        this.datReg = datReg;
        this.key = key;
        this.val = val;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDatReg() {
        return datReg;
    }

    public void setDatReg(Date datReg) {
        this.datReg = datReg;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}

