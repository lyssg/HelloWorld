package zju.edu.cn.luyuan.bean;

import org.json.JSONObject;
import zju.edu.cn.luyuan.Value.AppType;
import zju.edu.cn.luyuan.Value.EventType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {
    private int id;
    private int type;
    private int mid=0;
    private int oid=0;
    private int did=0;
    private String note;
    private String phone=new String();
    private long date;

    private String dates;
    private String types;
    private String description;

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

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
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

    public void setDate(long date) {
        this.date = date;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dates=df.format(date);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void invert(){
        JSONObject jsonObject=new JSONObject(this.note);
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        Date d= new Date();
        dates = sdf.format(d);
        switch (this.type){
            case EventType.SEND_YZM_MSG:
                String yzm=jsonObject.get("yzm").toString();
                this.description="发送短信验证码"+yzm+"给"+phone;
                this.types="发送短信验证码";
                break;
            case EventType.USER_REG_SUCCESS:
                this.description="号码为"+phone+"的用户注册成功,id为"+this.oid;
                this.types="用户注册";
                break;
            case EventType.USER_ADD_SUCCESS:
                String phoneadd=jsonObject.get("phone").toString();
                this.description="增加号码为"+phoneadd+"的用户成功,id为"+this.oid;
                this.types="用户添加";
                break;
            case EventType.APK_ADD_SUCCESS:
                int type=jsonObject.getInt("type");
                String version=jsonObject.get("version").toString();
                this.description="增加APP"+translateAppType(type)+",版本为"+version+"，id为"+this.oid;
                this.types="添加APP";
                break;
        }
    }

    public String getDescription(){
        return description;
    }

    public String getDates() {
        return dates;
    }

    public String getTypes() {
        return types;
    }

    private String translateAppType(int type){
        String apptype=new String();
        switch (type){
            case AppType.APP_TYPE_LJSEW:
                apptype=AppType.LJSEWAPP;
            break;
            case AppType.APP_TYPE_NBSEW:
                apptype=AppType.NBSEWAPP;
                break;
        }
        return apptype;
    }
}
