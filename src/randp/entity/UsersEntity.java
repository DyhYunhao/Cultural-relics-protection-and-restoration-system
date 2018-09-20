package randp.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by dyh on 2018/5/10.
 */
@Entity
@Table(name = "users", schema = "randp", catalog = "")
public class UsersEntity {
    private long uid;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String post;
    private String typeid;
    private String unit;
    private String address;
    private String idcard;
    private Integer type = 0;
    private Integer status;
    private Timestamp ltime;
    private String lip;
    private Integer dcount = 0;

    @Id
    @Column(name = "uid")
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "ltime")
    public Timestamp getLtime() {
        return ltime;
    }

    public void setLtime(Timestamp ltime) {
        this.ltime = ltime;
    }

    @Basic
    @Column(name = "lip")
    public String getLip() {
        return lip;
    }

    public void setLip(String lip) {
        this.lip = lip;
    }

    @Basic
    @Column(name = "dcount")
    public Integer getDcount() {
        return dcount;
    }

    public void setDcount(Integer dcount) {
        this.dcount = dcount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (uid != that.uid) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (post != null ? !post.equals(that.post) : that.post != null) return false;
        if (typeid != null ? !typeid.equals(that.typeid) : that.typeid != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (idcard != null ? !idcard.equals(that.idcard) : that.idcard != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (ltime != null ? !ltime.equals(that.ltime) : that.ltime != null) return false;
        if (lip != null ? !lip.equals(that.lip) : that.lip != null) return false;
        if (dcount != null ? !dcount.equals(that.dcount) : that.dcount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (uid ^ (uid >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (post != null ? post.hashCode() : 0);
        result = 31 * result + (typeid != null ? typeid.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (idcard != null ? idcard.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (ltime != null ? ltime.hashCode() : 0);
        result = 31 * result + (lip != null ? lip.hashCode() : 0);
        result = 31 * result + (dcount != null ? dcount.hashCode() : 0);
        return result;
    }
}
