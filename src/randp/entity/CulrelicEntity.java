package randp.entity;

import javax.persistence.*;

/**
 * Created by dyh on 2018/5/10.
 */
@Entity
@Table(name = "culrelic", schema = "randp", catalog = "")
public class CulrelicEntity {
    private long crid;
    private String crname;
    private String crnum;
    private String crmeq;
    private String crtimes;
    private int crlevel;
    private String crhouse;
    private String crcome;
    private String crcom;

    @Id
    @Column(name = "crid")
    public long getCrid() {
        return crid;
    }

    public void setCrid(long crid) {
        this.crid = crid;
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
    @Column(name = "crnum")
    public String getCrnum() {
        return crnum;
    }

    public void setCrnum(String crnum) {
        this.crnum = crnum;
    }

    @Basic
    @Column(name = "crmeq")
    public String getCrmeq() {
        return crmeq;
    }

    public void setCrmeq(String crmeq) {
        this.crmeq = crmeq;
    }

    @Basic
    @Column(name = "crtimes")
    public String getCrtimes() {
        return crtimes;
    }

    public void setCrtimes(String crtimes) {
        this.crtimes = crtimes;
    }

    @Basic
    @Column(name = "crlevel")
    public int getCrlevel() {
        return crlevel;
    }

    public void setCrlevel(int crlevel) {
        this.crlevel = crlevel;
    }

    @Basic
    @Column(name = "crhouse")
    public String getCrhouse() {
        return crhouse;
    }

    public void setCrhouse(String crhouse) {
        this.crhouse = crhouse;
    }

    @Basic
    @Column(name = "crcome")
    public String getCrcome() {
        return crcome;
    }

    public void setCrcome(String crcome) {
        this.crcome = crcome;
    }

    @Basic
    @Column(name = "crcom")
    public String getCrcom() {
        return crcom;
    }

    public void setCrcom(String crcom) {
        this.crcom = crcom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CulrelicEntity that = (CulrelicEntity) o;

        if (crid != that.crid) return false;
        if (crlevel != that.crlevel) return false;
        if (crname != null ? !crname.equals(that.crname) : that.crname != null) return false;
        if (crnum != null ? !crnum.equals(that.crnum) : that.crnum != null) return false;
        if (crmeq != null ? !crmeq.equals(that.crmeq) : that.crmeq != null) return false;
        if (crtimes != null ? !crtimes.equals(that.crtimes) : that.crtimes != null) return false;
        if (crhouse != null ? !crhouse.equals(that.crhouse) : that.crhouse != null) return false;
        if (crcome != null ? !crcome.equals(that.crcome) : that.crcome != null) return false;
        if (crcom != null ? !crcom.equals(that.crcom) : that.crcom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (crid ^ (crid >>> 32));
        result = 31 * result + (crname != null ? crname.hashCode() : 0);
        result = 31 * result + (crnum != null ? crnum.hashCode() : 0);
        result = 31 * result + (crmeq != null ? crmeq.hashCode() : 0);
        result = 31 * result + (crtimes != null ? crtimes.hashCode() : 0);
        result = 31 * result + crlevel;
        result = 31 * result + (crhouse != null ? crhouse.hashCode() : 0);
        result = 31 * result + (crcome != null ? crcome.hashCode() : 0);
        result = 31 * result + (crcom != null ? crcom.hashCode() : 0);
        return result;
    }
}
