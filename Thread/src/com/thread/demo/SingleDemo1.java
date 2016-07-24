package com.thread.demo;

class Single {
	private Single() {
	}

	private static Single s = null;

	public static Single getInstance() {
		if (s == null) {
			synchronized (Single.class) {
				if (s == null) {
					s = new Single();
				}
			}
		}
		return s;
	}
}

class Demo3 implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread().getName() + "获取的对象是" + Single.getInstance());
	}
}

public class SingleDemo1 {

	public static void main(String[] args) {
		Demo3 d = new Demo3();
		new Thread(d).start();
		new Thread(d).start();
	}

}
