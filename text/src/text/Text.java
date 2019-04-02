package text;

import java.io.*;

public class Text {

    public static void main(String[] args) throws IOException {


        InputStreamReader isr = new InputStreamReader(new FileInputStream("/src/acmerInfo.txt"),"gbk") ;

        //读数据
        //一次读取一个字符数组
        char[] chs = new char[1024] ;
        int len = 0 ;
        while((len=isr.read(chs))!=-1) {
            System.out.println(new String(chs,0,len));
        }
    }
}
