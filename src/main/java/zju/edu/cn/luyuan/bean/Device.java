package zju.edu.cn.luyuan.bean;

public class Device {
    private int id;
    private String name;
    private int htype;
    private int stype;
    private int mid;
    private int oid;
    private int location;
    private int status;
    private long bdate;
    private String note;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHtype() {
        return htype;
    }

    public void setHtype(int htype) {
        this.htype = htype;
    }
    public int getStype() {
        return stype;
    }
    public void setStype(int stype) {
        this.stype = stype;
    }
    public int getMid() {
        return mid;
    }
    public void setMid(int mid) {
        this.mid = mid;
    }
    public int getOid() {
        return oid;
    }
    public void setOid(int oid) {
        this.oid = oid;
    }
    public int getLocation() {
        return location;
    }
    public void setLocation(int location) {
        this.location = location;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public long getBdate() {
        return bdate;
    }
    public void setBdate(long bdate) {
        this.bdate = bdate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
