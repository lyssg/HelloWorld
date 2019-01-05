package zju.edu.cn.luyuan.bean;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EhtFile {
    private int id;
    private int chip;
    private String stype;
    private int sversion;
    private String sdate;
    private String htype;
    private String note;
    private String remarks;
    private long date;

    private String chips;
    private String dates;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getChip() {
        return chip;
    }
    public void setChip(int chip) {
        this.chip = chip;
    }

    public String getStype() {
        return stype;
    }
    public void setStype(String stype) {
        this.stype = stype;
    }

    public int getSversion() {
        return sversion;
    }
    public void setSversion(int version) {
        this.sversion = version;
    }

    public String getSdate() {
        return sdate;
    }
    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getHtype() {
        return htype;
    }
    public void setHtype(String htype) {
        this.htype = htype;
    }

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public long getDate() {
        return date;
    }
    public void setDate(long date) {
        this.date = date;
    }

    public String getDates() {
        return dates;
    }
    public void setDates(String dates) {
        this.dates = dates;
    }

    public void invert() {
        chips=getChipName(chip);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        dates = sdf.format(d);
    }

    private String getChipName(int chip){
        String chipname=new String();
        switch(chip){
            case 2801: chipname="TMS320F2801"; break;
            case 2802: chipname="TMS320F2802"; break;
            case 2806: chipname="TMS320F2806";  break;

            case 28030: chipname="TMS320F28030"; break;
            case 28031: chipname="TMS320F28031"; break;
            case 28033: chipname="TMS320F28033";  break;
            case 28035: chipname="TMS320F28035";  break;
            default:chipname="unknown";
                break;
        }
        return chipname;
    }

    private String getChipName2(int chip){
        String chipname=new String();
        switch(chip){
            case 0x2C: chipname="TMS320F2801"; break;
            case 0x24: chipname="TMS320F2802"; break;
            case 0x34: chipname="TMS320F2806";  break;

            case 0xA9: chipname="TMS320F28030RSH"; break;
            case 0xAA: chipname="TMS320F28030PAG"; break;
            case 0xAB: chipname="TMS320F28030PN";  break;

            case 0xAD: chipname="TMS320F28031RSH"; break;
            case 0xAE: chipname="TMS320F28031PAG"; break;
            case 0xAF: chipname="TMS320F28031PN";  break;

            case 0xB1: chipname="TMS320F28032RSH"; break;
            case 0xB2: chipname="TMS320F28032PAG"; break;
            case 0xB3: chipname="TMS320F28032PN";  break;

            case 0xB5: chipname="TMS320F28033RSH"; break;
            case 0xB6: chipname="TMS320F28033PAG"; break;
            case 0xB7: chipname="TMS320F28033PN";  break;

            case 0xB9: chipname="TMS320F28034RSH"; break;
            case 0xBA: chipname="TMS320F28034PAG"; break;
            case 0xBB: chipname="TMS320F28034PN";  break;

            case 0xBD: chipname="TMS320F28035RSH"; break;
            case 0xBE: chipname="TMS320F28035PAG"; break;
            case 0xBF: chipname="TMS320F28035PN";break;
        }
        return chipname;
    }

    public String getChips() {
        return chips;
    }

    /*
    TMS320F28035PN 0x00BF    80pin
TMS320F28035PAG	0x00BE
TMS320F28035RSH	0x00BD
TMS320F28034PN 0x00BB
TMS320F28034PAG	0x00BA
TMS320F28034RSH	0x00B9
TMS320F28033PN 0x00B7
TMS320F28033PAG	0x00B6
TMS320F28033RSH	0x00B5
TMS320F28032PN 0x00B3
TMS320F28032PAG	0x00B2
TMS320F28032RSH	0x00B1
TMS320F28031PN 0x00AF
TMS320F28031PAG	0x00AE
TMS320F28031RSH	0x00AD
TMS320F28030PN 0x00AB    80pin
TMS320F28030PAG	0x00AA   64pin
TMS320F28030RSH	0x00A9   56pin
     */
}
