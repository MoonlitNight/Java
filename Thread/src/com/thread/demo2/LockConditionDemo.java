package com.thread.demo2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author � ���ڶԵ�һ�����������ߵ�������ʵ��
 */
// ��Resource2����������Դ
class Resource2 {
	private String name;
	private double price;
	public Resource2() {
		// TODO Auto-generated constructor stub
	}
	public Resource2(String name, double price) {
		super();
		setName(name);
		setPrice(price);
	}
	// ��ȡLock�ӿڶ���
	Lock lock = new ReentrantLock();
	// ���������������̵߳�Condition���������̵߳ȴ��ͻ��ѣ��͵�ǰLock�ӿ�ʵ����
	Condition pro = lock.newCondition();
	// ���������������̵߳�Condition���������̵߳ȴ��ͻ��ѣ��͵�ǰLock�ӿ�ʵ����
	Condition con = lock.newCondition();
	public boolean flag = false;// ���ڱ�ǲ�Ʒ�Ƿ�������ɣ�Ĭ��falseû���������

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return "[" + name + "]" + "---[�۸�]" + price;
	}
}

// ��Producer2��������������
class Producer2 implements Runnable {
	private Resource2 r;
	int x = 0;// ���

	Producer2(Resource2 r) {
		this.r = r;
	}

	public void run() {	
		// whileѭ��ʹ�����߲�ͣ������
		while (true) {
			// ��ȡ������
			r.lock.lock();
			try {
				// �ж�����в�Ʒ�������ߵȴ������������ѹ����ٴ�ִ��
				if (r.flag != false) {
					try {
						r.pro.await();// �̵߳ȴ�
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				r.setName("ƻ��");
				r.setPrice(2.5);
				System.out.println(Thread.currentThread().getName() + "�����˱��" + x + "��" + r.toString());
				r.flag = true;// �������flag��ֵΪtrue��ʾ�������
				x++;// ��ż�һ
				r.con.signal();// �����������߳�
			} finally {
				r.lock.unlock();// �ͷ�������
			}
		}
	}
}

// ��Consumer2��������������
class Consumer2 implements Runnable {
	private Resource2 r;
	// ��ű�����������ѵ���Դ����
	int x = 0;

	Consumer2(Resource2 r) {
		this.r = r;
	}

	public void run() {
		// �������߲�ͣ������
		while (true) {
			r.lock.lock();// ��ȡ������
			// ͬ������飬������̵߳����ݰ�ȫ����
			try {
				// �ж������Դδ���������������ߵȴ���������������ִ�г���
				if (r.flag == false) {
					try {
						r.con.await();// �̵߳ȴ�
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + "�����˱��" + x + "��" + r.toString());
				x++;// ��ż�һ
				r.flag = false;// �������flag��ֵΪfalse��ʾ�������
				r.pro.signal();// ���ѵȴ��������ߵ��߳�
			} finally {
				r.lock.unlock();// ִ������ͷ�������
			}
		}
	}
}

public class LockConditionDemo {

	public static void main(String[] args) {
		Resource2 r = new Resource2();// ������Դ����
		Producer2 p = new Producer2(r);// ���������߶���
		Consumer2 c = new Consumer2(r);// ���������߶���
		Thread t1 =new Thread(p);
		Thread t2 =new Thread(c);
		t1.start();// �����߳�
		t2.start();// �����߳�
	}

}
