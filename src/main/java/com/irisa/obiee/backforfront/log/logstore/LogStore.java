package com.irisa.obiee.backforfront.log.logstore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FND_LOG_STORES", schema = "obiee_crsplatform")
public class LogStore {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FND_LOG_STORE_SEQ")
    @SequenceGenerator(name = "FND_LOG_STORE_SEQ", sequenceName = "FND_LOG_STORE_SEQ", allocationSize = 1)
    @Column(name = "NUM_LOG_ID",length = 15)
    private long id;

    @Column(name="DAT_REG_LOGST",nullable = false)
    private Date datReg;

    @Column(name="DES_KEY_LOGST",length = 4000,nullable = false)
    private String key;

    @Column(name="DES_VAL_LOGST",nullable = false)
    @Lob
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

