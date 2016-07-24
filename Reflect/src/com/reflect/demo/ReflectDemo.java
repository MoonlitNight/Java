package com.reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {

	public static void main(String[] args) throws Exception {
		Class c = Class.forName("com.reflect.demo.Person");
		System.out.println(c);
		Class c2 = Person.class;
		System.out.println(c2);
		Person pp = new Person();
		Class c3 = pp.getClass();
		System.out.println(c3);
		Constructor p =  c.getDeclaredConstructor(String.class);
		p.setAccessible(true);
		Object p1 = p.newInstance("jjj");
		System.out.println(p1);
		p = c.getConstructor(String.class,int.class,char.class);
		Object p2 = p.newInstance("kk",12,'h') ;
		System.out.println(p2);
		Field f = c.getDeclaredField("sex");
		System.out.println(f.get(p2));
		Field f2 = c.getField("phone");
		System.out.println(f2.get(null));
		Method m =c.getMethod("show",null);
		m.invoke(p2,null);
		Method m2 = c.getDeclaredMethod("show2", int.class);
		m2.setAccessible(true);
		m2.invoke(p2, 1);
		Method m3 = c.getDeclaredMethod("show3", null);
		m3.invoke(null, null);
	}

}
