package zju.edu.cn.luyuan.bean;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private int id;
    private String name;
    private String password;
    private int type;
    private String phone;
    private String email;
    private String note;

    private String description;

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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDescription() {
        return description;
    }

    public void invert() {
        if(type==1){
            this.description = "这是管理员账户";
        }else if(type==3) {
            if(this.note!=null) {
                JSONObject jsonObject = new JSONObject(this.note);
                String dates = jsonObject.getString("regdate");
                this.description = "注册时间：" + dates;
            }else {
                this.description = "无备注";
            }
        }

    }
}
