package live.leer.springmvc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 日期转换器
 * S: source 要转换的原类型
 * T： 目标 要转换成的数据类型
 *
 * @author leer
 */
public class DateConvert implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        // TODO Auto-generated method stub
        Date result = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            result = sdf.parse(source);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

}
