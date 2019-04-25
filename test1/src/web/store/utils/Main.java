package web.store.utils;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


/** 请完成下面这个函数，实现题目要求的功能 **/
 /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String calculate(int m, int k) {
    	int [] a = new int[1003];
         a[0] = 2;
         a[1] = 3;
         a[2] = 4;
         for (int i=3; i<=m; i++){
          a[i] = a[i-2]+a[i-3];
         }
         System.out.println(a[m]);
		return a[m];
    
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);;
        System.out.println(calculate(m, k));

    }
}