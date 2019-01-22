package zju.edu.cn.luyuan.netchat;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class DataUpload extends Thread{

    List<String> versionList=new ArrayList<String>();
    List<String> idList=new ArrayList<>();
    String Chip="芯片型号：";
    String DeviceType="版本功能：";
    String Type="程序类型：";
    String Version="程序版本：";
    String CloudVersion="云端现存版本：(点击下载)";


//    @Override
//    public void run() {
//        try {
////                            socket=new Socket("192.168.0.9",10002);
////                            socket=new Socket("192.168.43.80",10002);
//            socket=new Socket("47.99.58.169",10002);//fuwuqi
//            osw = new OutputStreamWriter(socket.getOutputStream());
//            rw = new BufferedWriter(osw);
//            JSONObject sendMsg=new JSONObject();
//            sendMsg.put("type",33);	//消息类型
//            sendMsg.put("devicechip",4);	//传输设备信息
//            sendMsg.put("devicetype",82);//aa5552//pathIntent.getIntExtra("DeviceType",0));
//            rw.write(sendMsg.toString()+"\n");
//            rw.flush();
//            socket.setSoTimeout(2000);
//            isr=new InputStreamReader(socket.getInputStream());
//            br=new BufferedReader(isr);
//            String str=br.readLine();
//            JSONObject message=new JSONObject(str);
//            if(message.getInt("type")==33){
//                for(int i=0;i<message.getInt("num");i++){
//                    JSONObject pinfo=message.getJSONObject("programeInfo"+i);
//                    versionList.add("V"+pinfo.getString("Version"));
//                    idList.add(pinfo.getString("ID"));
//                }
//            }
////                            versionList.add(CloudVersion);
//            Message msg = mHandler
//                    .obtainMessage(1);
////                            Bundle bundle = new Bundle();
////                            bundle.putString("", msgStr);
////                            msg.setData(bundle);
//            mHandler.sendMessage(msg);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
