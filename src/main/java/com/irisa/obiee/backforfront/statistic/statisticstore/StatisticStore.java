package com.irisa.obiee.backforfront.statistic.statisticstore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FND_STATISTIC_STORES")
public class StatisticStore {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "NUM_STATISTIC_ID")
    private Long id;

    @Column(name="NAM_USER_SCSTR",length = 4000)
    private String user;

    @Column(name="NAM_BIP_SCSTR",length = 4000)
    private String reportBIP;

    @Column(name="NAM_VISUAL_ANALYSER_SCSTR",length = 4000)
    private String reportVA;

    @Column(name="NAM_DASHBOARD_SCSTR",length = 4000)
    private String reportDashboard;

    @Column(name="DAT_EXEC_SCSTR",length = 4000)
    private Date date;

    @Column(name="NAM_APPROLES_SCSTR",length = 4000)
    private String appRole;

    @Column(name="TOT_COUNT_SCSTR",length = 4000)
    private Integer count;

    public StatisticStore() {
    }

    public StatisticStore(String user, String reportBIP, String reportVA, String reportDashboard, Date date, String appRole, String appRole1, Integer count) {
        this.user = user;
        this.reportBIP = reportBIP;
        this.reportVA = reportVA;
        this.reportDashboard = reportDashboard;
        this.date = date;
        this.appRole = appRole;
        this.appRole = appRole1;
        this.count = count;
    }

    @Override
    public String toString() {
        return "StatisticStore{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", reportBIP='" + reportBIP + '\'' +
                ", reportVA='" + reportVA + '\'' +
                ", reportDashboard='" + reportDashboard + '\'' +
                ", date=" + date +
                ", appRole='" + appRole + '\'' +
                ", count=" + count +
                '}';
    }
}
