package com.thread.demo;

class Demo2 implements Runnable {

	public void run() {
		int x = 0;
		for (int i = 0; i < 40; i++) {
			x++;
			System.out.println("Demo2---" + x);
		}
	}
}
public class ThreadDemo2 {

	public static void main(String[] args) {
		Demo2 d = new Demo2();
		new Thread(d).start();
		int x = 0;
		for (int i = 0; i < 40; i++) {
			x++;
			System.out.println("main---" + x);
		}
	}

}
