package com.thread.demo;

class Demo4 implements Runnable {
	//��������������A��B
	private Object lock_A = new Object();
	private Object lock_B = new Object();
	//���岼������flag���ý����л�����ִ��
	boolean flag = false;

	public void run() {
		if (flag) {
			while (true) {
				synchronized (lock_A) {
					System.out.println("[if]" + Thread.currentThread().getName() + "��ȡ����lock_A");
					synchronized (lock_B) {
						System.out.println("[if]" + Thread.currentThread().getName() + "��ȡ����lock_B");
					}
				}
			}
		} else {
			while (true) {
				synchronized (lock_B) {
					System.out.println("[esle]" + Thread.currentThread().getName() + "��ȡ����lock_A");
					synchronized (lock_A) {
						System.out.println("[else]" + Thread.currentThread().getName() + "��ȡ����lock_B");
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
			Thread.sleep(1);//Ϊ���ܹ���cpu�߳�һ�����л���Thread-0�ϣ���Ϊ�������߳�����һ��ʱ��
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d.flag = true;
		new Thread(d).start();
	}

}
