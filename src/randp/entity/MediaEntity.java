package randp.entity;

import javax.persistence.*;

/**
 * Created by dyh on 2018/5/10.
 */
@Entity
@Table(name = "media", schema = "randp", catalog = "")
public class MediaEntity {
    private long mid;
    private int mtype;
    private String crname;
    private String video;
    private String mcomment;
    private String vname;

    @Id
    @Column(name = "mid")
    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
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
    @Column(name = "mtype")
    public int getMtype() {
        return mtype;
    }

    public void setMtype(int mtype) {
        this.mtype = mtype;
    }

    @Basic
    @Column(name = "video")
    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @Basic
    @Column(name = "mcomment")
    public String getMcomment() {
        return mcomment;
    }

    public void setMcomment(String mcomment) {
        this.mcomment = mcomment;
    }

    @Basic
    @Column(name = "vname")
    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MediaEntity that = (MediaEntity) o;

        if (mid != that.mid) return false;
        if (mtype != that.mtype) return false;
        if (crname != null ? !crname.equals(that.crname) : that.crname != null) return false;
            if (vname != null ? !vname.equals(that.vname) : that.vname != null) return false;
        if (video != null ? !video.equals(that.video) : that.video != null) return false;
        if (mcomment != null ? !mcomment.equals(that.mcomment) : that.mcomment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (mid ^ (mid >>> 32));
        result = 31 * result + mtype;
        result = 31 * result + (crname != null ? crname.hashCode() : 0);
        result = 31 * result + (vname != null ? vname.hashCode() : 0);
        result = 31 * result + (video != null ? video.hashCode() : 0);
        result = 31 * result + (mcomment != null ? mcomment.hashCode() : 0);
        return result;
    }
}
