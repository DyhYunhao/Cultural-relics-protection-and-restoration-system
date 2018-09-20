package randp.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by dyh on 2018/5/10.
 */
@Entity
@Table(name = "repairlog", schema = "randp", catalog = "")
public class RepairlogEntity {
    private long rlid;
    private long rpid;
    private String rlpep;
    private Timestamp rltime;
    private String rlpls;
    private String rltool;
    private String rldecon;
    private String rlchange;
    private Timestamp rlctime;
    private String rlcname;

    @Id
    @Column(name = "rlid")
    public long getRlid() {
        return rlid;
    }

    public void setRlid(long rlid) {
        this.rlid = rlid;
    }

    @Basic
    @Column(name = "rpid")
    public long getRpid() {
        return rpid;
    }

    public void setRpid(long rpid) {
        this.rpid = rpid;
    }

    @Basic
    @Column(name = "rlpep")
    public String getRlpep() {
        return rlpep;
    }

    public void setRlpep(String rlpep) {
        this.rlpep = rlpep;
    }

    @Basic
    @Column(name = "rltime")
    public Timestamp getRltime() {
        return rltime;
    }

    public void setRltime(Timestamp rltime) {
        this.rltime = rltime;
    }

    @Basic
    @Column(name = "rlpls")
    public String getRlpls() {
        return rlpls;
    }

    public void setRlpls(String rlpls) {
        this.rlpls = rlpls;
    }

    @Basic
    @Column(name = "rltool")
    public String getRltool() {
        return rltool;
    }

    public void setRltool(String rltool) {
        this.rltool = rltool;
    }

    @Basic
    @Column(name = "rldecon")
    public String getRldecon() {
        return rldecon;
    }

    public void setRldecon(String rldecon) {
        this.rldecon = rldecon;
    }

    @Basic
    @Column(name = "rlchange")
    public String getRlchange() {
        return rlchange;
    }

    public void setRlchange(String rlchange) {
        this.rlchange = rlchange;
    }

    @Basic
    @Column(name = "rlctime")
    public Timestamp getRlctime() {
        return rlctime;
    }

    public void setRlctime(Timestamp rlctime) {
        this.rlctime = rlctime;
    }

    @Basic
    @Column(name = "rlcname")
    public String getRlcname() {
        return rlcname;
    }

    public void setRlcname(String rlcname) {
        this.rlcname = rlcname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RepairlogEntity that = (RepairlogEntity) o;

        if (rlid != that.rlid) return false;
        if (rpid != that.rpid) return false;
        if (rlpep != null ? !rlpep.equals(that.rlpep) : that.rlpep != null) return false;
        if (rltime != null ? !rltime.equals(that.rltime) : that.rltime != null) return false;
        if (rlpls != null ? !rlpls.equals(that.rlpls) : that.rlpls != null) return false;
        if (rltool != null ? !rltool.equals(that.rltool) : that.rltool != null) return false;
        if (rldecon != null ? !rldecon.equals(that.rldecon) : that.rldecon != null) return false;
        if (rlchange != null ? !rlchange.equals(that.rlchange) : that.rlchange != null) return false;
        if (rlctime != null ? !rlctime.equals(that.rlctime) : that.rlctime != null) return false;
        if (rlcname != null ? !rlcname.equals(that.rlcname) : that.rlcname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (rlid ^ (rlid >>> 32));
        result = 31 * result + (int) (rpid ^ (rpid >>> 32));
        result = 31 * result + (rlpep != null ? rlpep.hashCode() : 0);
        result = 31 * result + (rltime != null ? rltime.hashCode() : 0);
        result = 31 * result + (rlpls != null ? rlpls.hashCode() : 0);
        result = 31 * result + (rltool != null ? rltool.hashCode() : 0);
        result = 31 * result + (rldecon != null ? rldecon.hashCode() : 0);
        result = 31 * result + (rlchange != null ? rlchange.hashCode() : 0);
        result = 31 * result + (rlctime != null ? rlctime.hashCode() : 0);
        result = 31 * result + (rlcname != null ? rlcname.hashCode() : 0);
        return result;
    }
}
