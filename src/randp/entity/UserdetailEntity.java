package randp.entity;

import javax.persistence.*;

/**
 * Created by dyh on 2018/5/10.
 */
@Entity
@Table(name = "userdetail", schema = "randp", catalog = "")
public class UserdetailEntity {
    private long udid;
    private long uid;
    private String phone;
    private String post;
    private String typeid;
    private String unit;
    private String address;
    private String idcard;

    @Id
    @Column(name = "udid")
    public long getUdid() {
        return udid;
    }

    public void setUdid(long udid) {
        this.udid = udid;
    }

    @Basic
    @Column(name = "uid")
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "post")
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Basic
    @Column(name = "typeid")
    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    @Basic
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "idcard")
    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserdetailEntity that = (UserdetailEntity) o;

        if (udid != that.udid) return false;
        if (uid != that.uid) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (post != null ? !post.equals(that.post) : that.post != null) return false;
        if (typeid != null ? !typeid.equals(that.typeid) : that.typeid != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (idcard != null ? !idcard.equals(that.idcard) : that.idcard != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (udid ^ (udid >>> 32));
        result = 31 * result + (int) (uid ^ (uid >>> 32));
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (post != null ? post.hashCode() : 0);
        result = 31 * result + (typeid != null ? typeid.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (idcard != null ? idcard.hashCode() : 0);
        return result;
    }
}
