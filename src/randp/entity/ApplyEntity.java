package randp.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by dyh on 2018/5/10.
 */
@Entity
@Table(name = "apply", schema = "randp", catalog = "")
public class ApplyEntity {
    private long aid;
    private String crname;
    private String exname;
    private Timestamp extime;
    private String rtname;
    private Timestamp rttime;
    private String rsname;
    private String apunit;
    private Timestamp aptime;
    private String apnum;

    @Id
    @Column(name = "aid")
    public long getAid() {
        return aid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    @Basic
    @Column(name = "crname")
    public String getCrname() {
        return crname;
    }

    public void setCrname(String crname) {
        this.crname = crname;
    }

    @Basic
    @Column(name = "exname")
    public String getExname() {
        return exname;
    }

    public void setExname(String exname) {
        this.exname = exname;
    }

    @Basic
    @Column(name = "extime")
    public Timestamp getExtime() {
        return extime;
    }

    public void setExtime(Timestamp extime) {
        this.extime = extime;
    }

    @Basic
    @Column(name = "rtname")
    public String getRtname() {
        return rtname;
    }

    public void setRtname(String rtname) {
        this.rtname = rtname;
    }

    @Basic
    @Column(name = "rttime")
    public Timestamp getRttime() {
        return rttime;
    }

    public void setRttime(Timestamp rttime) {
        this.rttime = rttime;
    }

    @Basic
    @Column(name = "rsname")
    public String getRsname() {
        return rsname;
    }

    public void setRsname(String rsname) {
        this.rsname = rsname;
    }

    @Basic
    @Column(name = "apunit")
    public String getApunit() {
        return apunit;
    }

    public void setApunit(String apunit) {
        this.apunit = apunit;
    }

    @Basic
    @Column(name = "aptime")
    public Timestamp getAptime() {
        return aptime;
    }

    public void setAptime(Timestamp aptime) {
        this.aptime = aptime;
    }

    @Basic
    @Column(name = "apnum")
    public String getApnum() {
        return apnum;
    }

    public void setApnum(String apnum) {
        this.apnum = apnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplyEntity that = (ApplyEntity) o;

        if (aid != that.aid) return false;
        if (crname != that.crname) return false;
        if (exname != null ? !exname.equals(that.exname) : that.exname != null) return false;
        if (extime != null ? !extime.equals(that.extime) : that.extime != null) return false;
        if (rtname != null ? !rtname.equals(that.rtname) : that.rtname != null) return false;
        if (rttime != null ? !rttime.equals(that.rttime) : that.rttime != null) return false;
        if (rsname != null ? !rsname.equals(that.rsname) : that.rsname != null) return false;
        if (apunit != null ? !apunit.equals(that.apunit) : that.apunit != null) return false;
        if (aptime != null ? !aptime.equals(that.aptime) : that.aptime != null) return false;
        if (apnum != null ? !apnum.equals(that.apnum) : that.apnum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (aid ^ (aid >>> 32));
        result = 31 * result + (crname != null ? crname.hashCode() : 0);
        result = 31 * result + (exname != null ? exname.hashCode() : 0);
        result = 31 * result + (extime != null ? extime.hashCode() : 0);
        result = 31 * result + (rtname != null ? rtname.hashCode() : 0);
        result = 31 * result + (rttime != null ? rttime.hashCode() : 0);
        result = 31 * result + (rsname != null ? rsname.hashCode() : 0);
        result = 31 * result + (apunit != null ? apunit.hashCode() : 0);
        result = 31 * result + (aptime != null ? aptime.hashCode() : 0);
        result = 31 * result + (apnum != null ? apnum.hashCode() : 0);
        return result;
    }
}
