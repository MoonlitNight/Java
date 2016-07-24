package com.boundedbuffer.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class BoundedBuffer {
	// ��ȡ������
	final Lock lock = new ReentrantLock();
	// ��ȡlock��Ӧ��Condition�������ڶ��������̵߳ĵȴ��ͻ��Ѳ���
	final Condition pro = lock.newCondition();
	// ��ȡlock��Ӧ��Condition�������ڶ��������̵߳ĵȴ��ͻ��Ѳ���
	final Condition con = lock.newCondition();
	// ����Object�������ڱ�����������Դ
	final Object[] items = new Object[100];
	// ����count�������ڼ��������е���Դ��
	int count;
	// �����Ž���������Դ�ĽǱ�
	int put;
	// ����ȥ��������Դ�����еĽǱ�
	int get;

	public void put(Object obj) throws InterruptedException {
		lock.lock();// ��ȡ��
		try {
			while (count == items.length) // �ж����Ԫ��������������������������ߵȴ�
			{
				pro.await();
			}
			items[put] = obj;// �����Դ
			if (++put == items.length)
				put = 0;// �ж���������������һ��λ�ã����ŽǱ긳ֵΪ0
			++count;// ���һ����������һ
			con.signal();// ����������
		} finally {
			lock.unlock();// �ͷ�������
		}
	}

	public Object get() throws InterruptedException {
		lock.lock();// ��ȡ������
		try {
			while(count == 0) // �ж������Դ��Ϊ0�������ߵȴ�
			{
				con.await();// �������̵߳ȴ�
			}
			Object x = items[get];// ȡ��Ԫ��
			if (++get == items.length)
				get = 0;// �ж���������������һ��λ�õ�Ԫ�أ�ȡ��������ʼ��Ϊ0
			--count;// ȡ��һ����Դ����������һ
			pro.signal();// ����������
			return x;// ����ȡ����Ԫ��
		} finally {
			lock.unlock();
		}
	}
	public void show(){
		System.out.println("��Դ��Ϊ"+count);
	}
}

// ��Resource����������Դ
class Resource {
	private String name;
	private double price;

	public Resource(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
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
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return "[" + name + "]" + "---[�۸�]" + price;
	}
}

// ��Producer2��������������
class Producer implements Runnable {
	private BoundedBuffer bb;
	int x = 0;// ���

	Producer(BoundedBuffer bb) {
		this.bb = bb;
	}

	public void run() {
		// whileѭ��ʹ�����߲�ͣ������
		while (true) {
			try {
				Resource r = new Resource("ƻ��", 2.5);
				bb.put(r);
				System.out.println(Thread.currentThread().getName() + "�����˱��" + x + "��" + r.getName());
				x++;// ��ż�һ
			} catch (InterruptedException e) {
			}
		}
	}
}

// ��Consumer��������������
class Consumer implements Runnable {
	private BoundedBuffer bb;
	// ��ű�����������ѵ���Դ����
	int x = 0;

	Consumer(BoundedBuffer bb) {
		this.bb = bb;
	}

	public void run() {
		// �������߲�ͣ������
		while (true) {
			try {
				System.out.println(Thread.currentThread().getName() + "�����˱��" + x + "��" + bb.get());
				x++;// ��ż�һ
			} catch (InterruptedException e) {
			}

		}
	}
}

public class ThreadDemo1 {

	public static void main(String[] args) {
		BoundedBuffer r = new BoundedBuffer();// ������Դ����
		Producer p = new Producer(r);// ���������߶���
		Consumer c = new Consumer(r);// ���������߶���
		new Thread(p).start();// �����߳�
		new Thread(p).start();// �����߳�
		new Thread(c).start();// �����߳�
		new Thread(c).start();// �����߳�
		while(true){
		r.show();
		}
	}

}