import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

/**
 * @author jin.wang
 *
 */
public class JSONUtils {
	
	private static final String UNDERLINE = "_";
	
	/**
	 * 查找json数据中指定key的value
	 * @param json
	 * @param key
	 * @return
	 */
	public static String findValueByKey(String json,String key){
		Pattern compile = Pattern.compile("\""+key+"\":([^,|^\\}]*)");
		Matcher matcher = compile.matcher(json);
		if(matcher.find()) {
			return processResult(matcher.group(1));
		}
		return null;
	}
	
	private static String processResult(String result){
		Pattern compile = Pattern.compile("^\"(.*)\"$");
		Matcher matcher = compile.matcher(result);
		if(matcher.find()){
			return matcher.group(1);
		}
		return result;
	}
	
	/**
	 * 
	 * 使用驼峰命名方式取出json数据中匹配到的值，仅支持Long类型和字符串类型
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T  jsonStr2Bean(String json,Class<T> clazz,String... ignoreProperties) {
		if (StringUtils.isBlank(json))
			throw new IllegalArgumentException("json data error");
		List<String> ignoreList = (ignoreProperties != null ? Arrays.asList(ignoreProperties) : null);
		T bean = BeanUtils.instantiate(clazz);
		PropertyDescriptor[] propertys = BeanUtils.getPropertyDescriptors(clazz);
		if (propertys==null || propertys.length==0)
			return bean;
		for (PropertyDescriptor property : propertys) {
			String key = camelToUnderline(property.getName());
			Object value = findValueByKey(json, key);
			if (value == null || ignoreList != null && ignoreList.contains(key))
				continue;
			if(property.getPropertyType().equals(Long.class)) {
				value = Long.valueOf(value.toString());
			}
			//处理json数据中的\转义
			if(property.getPropertyType().equals(String.class)) {
				value = value.toString().replace("\\", "");
			}
			try {
				property.getWriteMethod().invoke(bean, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bean;
	}
	
	/**
	 * 驼峰格式字符串转换为下划线格式字符串
	 * @param param
	 * @return
	 */
	private static String camelToUnderline(String param) {
		if (StringUtils.isBlank(param))
			return "";
		int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
	}
	
}
