package com.thread.demo;

class Demo4 implements Runnable {
	//定义两个锁对象A、B
	private Object lock_A = new Object();
	private Object lock_B = new Object();
	//定义布尔变量flag，让进程切换方法执行
	boolean flag = false;

	public void run() {
		if (flag) {
			while (true) {
				synchronized (lock_A) {
					System.out.println("[if]" + Thread.currentThread().getName() + "获取到了lock_A");
					synchronized (lock_B) {
						System.out.println("[if]" + Thread.currentThread().getName() + "获取到了lock_B");
					}
				}
			}
		} else {
			while (true) {
				synchronized (lock_B) {
					System.out.println("[esle]" + Thread.currentThread().getName() + "获取到了lock_A");
					synchronized (lock_A) {
						System.out.println("[else]" + Thread.currentThread().getName() + "获取到了lock_B");
					}
				}
			}
		}
	}
}

public class DeadLock {

	public static void main(String[] args) {
		Demo4 d = new Demo4();
		new Thread(d).start();
		try {
			Thread.sleep(1);//为了能够让cpu线程一定能切换到Thread-0上，人为得让主线程休眠一段时间
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d.flag = true;
		new Thread(d).start();
	}

}
