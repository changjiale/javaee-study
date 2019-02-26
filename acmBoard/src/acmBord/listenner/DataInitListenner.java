package acmBord.listenner;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.struts2.views.xslt.ArrayAdapter;

import acmBord.bean.AcmerInfo;
import acmBord.bean.AcmerInfoByFile;
import acmBord.bean.ProbleResult;

public class DataInitListenner implements ServletContextListener {

    public static Map<String, AcmerInfo> map = new HashMap<String, AcmerInfo>();

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub


    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("acmerInfo.txt");
        InputStreamReader reader;
        BufferedReader bufferedReader;
        String str = null;
        try {
            BufferedInputStream bin = new BufferedInputStream(inputStream);
            int p = (bin.read() << 8) + bin.read();
            String code = null;
            switch (p) {
                case 0xefbb:
                    code = "UTF-8";
                    break;
                case 0xfffe:
                    code = "Unicode";
                    break;
                case 0xfeff:
                    code = "UTF-16BE";
                    break;
                default:
                    code = "GBK";
                    break;
            }
            reader = new InputStreamReader(inputStream, code);//"GBK"
            bufferedReader = new BufferedReader(reader);

            while ((str = bufferedReader.readLine()) != null) {
                String[] acmInfos = str.split(",");
                List<ProbleResult> probleResults = new ArrayList<>();
                AcmerInfo acmerInfoByFile = new AcmerInfo(null, "1", acmInfos[0], acmInfos[2], "0", "0", acmInfos[1], probleResults, "0/0", Integer.parseInt(acmInfos[3]), Integer.parseInt(acmInfos[4]));
                map.put(acmInfos[0], acmerInfoByFile);
                System.out.println("-->" + acmInfos[2]);
            }

            try {
                inputStream.close();
                reader.close();
                bufferedReader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


    }


}
