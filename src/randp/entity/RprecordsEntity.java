package randp.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by dyh on 2018/5/10.
 */
@Entity
@Table(name = "rprecords", schema = "randp", catalog = "")
public class RprecordsEntity {
    private long rpid;
    private String crname;
    private String bssize;
    private double bsweight;
    private String bspicture;
    private String bssave;
    private String disde;
    private String dispic;
    private String assize;
    private double asweight;
    private String aspicture;
    private String assave;
    private Timestamp astime;

    @Id
    @Column(name = "rpid")
    public long getRpid() {
        return rpid;
    }

    public void setRpid(long rpid) {
        this.rpid = rpid;
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
    @Column(name = "bssize")
    public String getBssize() {
        return bssize;
    }

    public void setBssize(String bssize) {
        this.bssize = bssize;
    }

    @Basic
    @Column(name = "bsweight")
    public double getBsweight() {
        return bsweight;
    }

    public void setBsweight(double bsweight) {
        this.bsweight = bsweight;
    }

    @Basic
    @Column(name = "bspicture")
    public String getBspicture() {
        return bspicture;
    }

    public void setBspicture(String bspicture) {
        this.bspicture = bspicture;
    }

    @Basic
    @Column(name = "bssave")
    public String getBssave() {
        return bssave;
    }

    public void setBssave(String bssave) {
        this.bssave = bssave;
    }

    @Basic
    @Column(name = "disde")
    public String getDisde() {
        return disde;
    }

    public void setDisde(String disde) {
        this.disde = disde;
    }

    @Basic
    @Column(name = "dispic")
    public String getDispic() {
        return dispic;
    }

    public void setDispic(String dispic) {
        this.dispic = dispic;
    }

    @Basic
    @Column(name = "assize")
    public String getAssize() {
        return assize;
    }

    public void setAssize(String assize) {
        this.assize = assize;
    }

    @Basic
    @Column(name = "asweight")
    public double getAsweight() {
        return asweight;
    }

    public void setAsweight(double asweight) {
        this.asweight = asweight;
    }

    @Basic
    @Column(name = "aspicture")
    public String getAspicture() {
        return aspicture;
    }

    public void setAspicture(String aspicture) {
        this.aspicture = aspicture;
    }

    @Basic
    @Column(name = "assave")
    public String getAssave() {
        return assave;
    }

    public void setAssave(String assave) {
        this.assave = assave;
    }

    @Basic
    @Column(name = "astime")
    public Timestamp getAstime() {
        return astime;
    }

    public void setAstime(Timestamp astime) {
        this.astime = astime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RprecordsEntity that = (RprecordsEntity) o;

        if (rpid != that.rpid) return false;
        if (crname != that.crname) return false;
        if (bssize != null ? !bssize.equals(that.bssize) : that.bssize != null) return false;
        if (Double.compare(that.bsweight, bsweight) != 0) return false;
        if (assize != null ? !assize.equals(that.assize) : that.assize != null) return false;
        if (Double.compare(that.asweight, asweight) != 0) return false;
        if (bspicture != null ? !bspicture.equals(that.bspicture) : that.bspicture != null) return false;
        if (bssave != null ? !bssave.equals(that.bssave) : that.bssave != null) return false;
        if (disde != null ? !disde.equals(that.disde) : that.disde != null) return false;
        if (dispic != null ? !dispic.equals(that.dispic) : that.dispic != null) return false;
        if (aspicture != null ? !aspicture.equals(that.aspicture) : that.aspicture != null) return false;
        if (assave != null ? !assave.equals(that.assave) : that.assave != null) return false;
        if (astime != null ? !astime.equals(that.astime) : that.astime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (rpid ^ (rpid >>> 32));
        result = 31 * result + (crname != null ? crname.hashCode() : 0);
        result = 31 * result + (bssize != null ? bssize.hashCode() : 0);
        temp = Double.doubleToLongBits(bsweight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (bspicture != null ? bspicture.hashCode() : 0);
        result = 31 * result + (bssave != null ? bssave.hashCode() : 0);
        result = 31 * result + (disde != null ? disde.hashCode() : 0);
        result = 31 * result + (dispic != null ? dispic.hashCode() : 0);
        result = 31 * result + (assize != null ? assize.hashCode() : 0);
        temp = Double.doubleToLongBits(asweight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (aspicture != null ? aspicture.hashCode() : 0);
        result = 31 * result + (assave != null ? assave.hashCode() : 0);
        result = 31 * result + (astime != null ? astime.hashCode() : 0);
        return result;
    }
}
