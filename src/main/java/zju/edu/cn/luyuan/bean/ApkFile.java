package zju.edu.cn.luyuan.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ApkFile {
    private int id;
    private int type;
    private int version;
    private String note;
    private long date;

    private String dates;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
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
    public long getDate() {
        return date;
    }
    public void invert() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dates=df.format(this.date);
    }
    public String getDates() {
        return dates;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
