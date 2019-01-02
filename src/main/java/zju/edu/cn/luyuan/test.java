package zju.edu.cn.luyuan;

public class test {

    private static void logDataBuf(byte[] buf,String pre) {
        StringBuffer out = new StringBuffer(pre);
        for (int i = 0; i < buf.length; i++) {
            out.append(String.format(",0x%x", buf[i]));
        }
        System.out.println(out.toString());
//		sendStatusReturnToUI(out.toString());
    }

    private static char a='a';
    private static char z='z';
    private static char n0='0';
    private static char n9='9';
    private static char dot='.';
    private static char dot1='\'';
    private static char dot2='"';
    private static char dot3='’';

    private static boolean checkPwdIsLegal(String pwd){
        char[] pwdc=pwd.toCharArray();
        System.out.println("len:"+pwd.length());
        if(pwdc.length>=8&&pwdc.length<=20) {
            for (char aaa : pwdc) {
                if (Character.isDigit(aaa) || Character.isLetter(aaa)||aaa=='.'||aaa=='_') {
                    continue;
                } else
                    return false;
            }
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args){
        //
//        String test1=new String();
//        test1="中卢l愿y";
//        String test2=new String();
//        test2="中";
//        String test3=new String();
//        test3="abc123";
//        String test4=new String();
//        test4="abc123";
//        String test5=new String();
//        test5="abc1assa23";
//
//
//        logDataBuf(test1.getBytes(),"test1:"+test1+" to byte[] "+" is legal:"+checkPwdIsLegal(test1));
//        logDataBuf(test2.getBytes(),"test2:"+test2+" to byte[] "+" is legal:"+checkPwdIsLegal(test2));
//        logDataBuf(test3.getBytes(),"test3:"+test3+" to byte[] "+" is legal:"+checkPwdIsLegal(test3));
//        logDataBuf(test4.getBytes(),"test4:"+test4+" to byte[] "+" is legal:"+checkPwdIsLegal(test4));
//        logDataBuf(test5.getBytes(),"test5:"+test5+" to byte[] "+" is legal:"+checkPwdIsLegal(test5));

        int type=0;
        int[] t1={1,0,1,0,1,0,1,0};
        for(int i=0;i<8;i++){
            type=type|(t1[i]<<(4*(7-i)));
        }
        System.out.println(Integer.toString(type));
        System.out.println(Integer.toHexString(type));
        System.out.println(Integer.toBinaryString(type));

    }

}
