package web.store.utils;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

public class MyBeanUtils {

	public static void populate(Object obj, Map<String, String[]> map) {
		try {
			//由于BeanUtils将字符串"1992-3-3"向user对象的setBithday(),方法传递参数问题,手动向BeanUtils注册一个
			//时间类型的
			// 1_创建时间类型的转换器
			DateConverter dt = new DateConverter();
			// 2_设置转换格式
			dt.setPattern("yyyy-MM-dd");
			// 3_注册转换器
			ConvertUtils.register(dt, java.util.Date.class);
			
			BeanUtils.populate(obj, map);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public static<T> T  populate(Class<T> clazz, Map<String, String[]> map) {
		try {
			
			T obj=clazz.newInstance();
			
			// 鐢变簬BeanUtils灏嗗瓧绗︿覆"1992-3-3"鍚憉ser瀵硅薄鐨剆etBithday();鏂规硶浼犻�掑弬鏁版湁闂,鎵嬪姩鍚態eanUtils娉ㄥ唽涓�涓椂闂寸被鍨嬭浆鎹㈠櫒
			// 1_鍒涘缓鏃堕棿绫诲瀷鐨勮浆鎹㈠櫒
			DateConverter dt = new DateConverter();
			// 2_璁剧疆杞崲鐨勬牸寮�
			dt.setPattern("yyyy-MM-dd");
			// 3_娉ㄥ唽杞崲鍣�
			ConvertUtils.register(dt, java.util.Date.class);
			
			BeanUtils.populate(obj, map);
			
			return obj;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}
	
}
