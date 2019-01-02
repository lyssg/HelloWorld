package zju.edu.cn.luyuan.bean;

import java.util.Date;

public class EhtFile {
    private int id;
    private int jixing;
    private int xinpian;
    private int gongneng;
    private int dianji;
    private int version;
    private String note;
    private long bdate;
    private Date bddate;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getJixing() {
        return jixing;
    }
    public void setJixing(int jixing) {
        this.jixing = jixing;
    }
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public long getBdate() {
        return bdate;
    }
    public void setBdate(long bdate) {
        this.bdate = bdate;
    }
    public Date getBddate() {
        return bddate;
    }
    public void setBddate(Date bddate) {
        this.bddate = bddate;
    }
}
