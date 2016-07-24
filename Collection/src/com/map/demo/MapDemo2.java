package com.map.demo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*把Map集合中存储的数据以字符串形式表示并输出
[
要求：使用嵌套Map完成
使用第一个Map存储key=”101”、value=第二个Map对象
  使用第二个Map存储key=”name” 、value=”张三”，
key=”age”、    value=20
]
{{key=”101”,value=[name=”张三”,age=20]},{key=”102”,value=[姓名=”李四”,age=22]},
{key=”103”,value=[ userName=”王五”,age=19]}}
*/
public class MapDemo2 {
	public static void main(String[] args) {
		Map<Integer, Map> map = new LinkedHashMap<>();
		Map<String, String> p1 = new LinkedHashMap<>();
		Map<String, String> p2 = new LinkedHashMap<>();
		Map<String, String> p3 = new LinkedHashMap<>();
		p1.put("name", "张三");
		p1.put("age", "20");
		p2.put("name", "李四");
		p2.put("age", "22");
		p3.put("userName", "王五");
		p3.put("age", "19");
		map.put(101, p1);
		map.put(102, p2);
		map.put(103, p3);
		String str = mapToString(map);// 调用方法转换为字符串
		System.out.println(str);// 打印
		System.out.println(p1);

	}

	public static String mapToString(Map<Integer, Map> map) {
		StringBuilder sb = new StringBuilder();// 创建字符串缓冲区对象
		sb.append("{");// 添加字符串
		// 获取Map集合中的key-value映射关系，并遍历
		for (Entry<Integer, Map> en : map.entrySet()) {
			Integer key = en.getKey();// 获取Map集合中key-value映射关系的key
			LinkedHashMap value = (LinkedHashMap) en.getValue();// 获取Map集合中key-value映射关系的value
			sb.append("{key=\"" + key + "\",value=");// 添加字符串
			Set<String> s = value.keySet();// 获取value对象中key2的set集合
			int count = 1;// 计数，用于判断是否遍历了两次
			for (String key2 : s) {
				String value2 = (String) value.get(key2);// 获取value对象key2所对应的value2值
				if (count != value.size()) // 判断是否是第二次遍历
				{
					sb.append("[" + key2 + "=\"" + value2 + "\",");
					count++;
				} else {
					sb.append(key2 + "=" + value2 + "]},");
				}
			}
		}
		sb.setCharAt(sb.length() - 1, '}');// 集合遍历结束后多个逗号，少个大括号，将其替换
		return sb.toString();// 返回字符串
	}
}
