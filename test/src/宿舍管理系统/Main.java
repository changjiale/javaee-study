package 宿舍管理系统;


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
    	int [] b = new int[1003];
    	int [] c = new int [1003];
         a[0] = 2;
         a[1] = 3;
         a[2] = 4;
         for (int i=3; i<=m; i++){
          a[i] = a[i-2]+a[i-3];
         }
         //System.out.println(a[m-1]);
         
         a[0] = 2;
         a[1] = 3;
         int sum = 5;
         int q = 1;
         for (int i=2; sum<m; i++){
             	a[i] = a[i-1]+a[i-2];
             	sum = a[i];
             	q = i;
             	
            }
         //System.out.println(q+2019);
         
         
         int max = 0;
         int kk = 0;
         for (int i=0; i<m ;i++) {
        	 int ww = a[i];
        	 int summ = 0;
        	 while (ww>0) {
        		 summ = summ*10+ww%10;
        		 ww = ww/10;
        	 }
        	 //System.out.println(summ);
        	 
        	 c[kk++] = summ;
        	 
         }
         for (int i=0; i<m; i++) {
        	 for (int j=i+1; j<m; j++) {
        		 int wq;
        		 if (c[i]<c[j]) {
        			 wq = c[i];
        			 c[i] = c[j];
        			 c[j] = wq;
        		 }
        	 }
         }
         
		return a[m-1]+","+(q+2019)+","+c[2];
    
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);;
        System.out.println(calculate(m, k));

    }
}