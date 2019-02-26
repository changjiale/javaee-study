package acmBord.testpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import acmBord.bean.AcmerInfo;

public class datesources {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        InputStream is = datesources.class.getClassLoader().getResourceAsStream("date.txt");

        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bufReader = new BufferedReader(isr);

        String line = null;

        try {
            while ((line = bufReader.readLine()) != null) {
                String[] simleInfo = line.split(",");
                AcmerInfo acmerInfo = new AcmerInfo();
                acmerInfo.setRealRank(simleInfo[0]);
                acmerInfo.setRank(simleInfo[1]);
                System.out.println(acmerInfo);

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            is.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            isr.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            bufReader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
