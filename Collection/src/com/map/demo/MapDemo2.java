package com.map.demo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*��Map�����д洢���������ַ�����ʽ��ʾ�����
[
Ҫ��ʹ��Ƕ��Map���
ʹ�õ�һ��Map�洢key=��101����value=�ڶ���Map����
  ʹ�õڶ���Map�洢key=��name�� ��value=����������
key=��age����    value=20
]
{{key=��101��,value=[name=��������,age=20]},{key=��102��,value=[����=�����ġ�,age=22]},
{key=��103��,value=[ userName=�����塱,age=19]}}
*/
public class MapDemo2 {
	public static void main(String[] args) {
		Map<Integer, Map> map = new LinkedHashMap<>();
		Map<String, String> p1 = new LinkedHashMap<>();
		Map<String, String> p2 = new LinkedHashMap<>();
		Map<String, String> p3 = new LinkedHashMap<>();
		p1.put("name", "����");
		p1.put("age", "20");
		p2.put("name", "����");
		p2.put("age", "22");
		p3.put("userName", "����");
		p3.put("age", "19");
		map.put(101, p1);
		map.put(102, p2);
		map.put(103, p3);
		String str = mapToString(map);// ���÷���ת��Ϊ�ַ���
		System.out.println(str);// ��ӡ
		System.out.println(p1);

	}

	public static String mapToString(Map<Integer, Map> map) {
		StringBuilder sb = new StringBuilder();// �����ַ�������������
		sb.append("{");// ����ַ���
		// ��ȡMap�����е�key-valueӳ���ϵ��������
		for (Entry<Integer, Map> en : map.entrySet()) {
			Integer key = en.getKey();// ��ȡMap������key-valueӳ���ϵ��key
			LinkedHashMap value = (LinkedHashMap) en.getValue();// ��ȡMap������key-valueӳ���ϵ��value
			sb.append("{key=\"" + key + "\",value=");// ����ַ���
			Set<String> s = value.keySet();// ��ȡvalue������key2��set����
			int count = 1;// �����������ж��Ƿ����������
			for (String key2 : s) {
				String value2 = (String) value.get(key2);// ��ȡvalue����key2����Ӧ��value2ֵ
				if (count != value.size()) // �ж��Ƿ��ǵڶ��α���
				{
					sb.append("[" + key2 + "=\"" + value2 + "\",");
					count++;
				} else {
					sb.append(key2 + "=" + value2 + "]},");
				}
			}
		}
		sb.setCharAt(sb.length() - 1, '}');// ���ϱ��������������ţ��ٸ������ţ������滻
		return sb.toString();// �����ַ���
	}
}
