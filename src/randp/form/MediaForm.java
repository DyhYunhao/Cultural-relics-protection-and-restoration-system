package randp.form;

/**
 * Created by dyh on 2018/5/19.
 */
public class MediaForm {
    private String crname;
    private String vedio;
    private String vname;
    private String mcomment;
    private int mtype;

    public int getMtype() {
        return mtype;
    }

    public void setMtype(int mtype) {
        this.mtype = mtype;
    }

    public String getCrname() {
        return crname;
    }

    public void setCrname(String crname) {
        this.crname = crname;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVedio() {
        return vedio;
    }

    public void setVedio(String vedio) {
        this.vedio = vedio;
    }

    public String getMcomment() {
        return mcomment;
    }

    public void setMcomment(String mcomment) {
        this.mcomment = mcomment;
    }
}
