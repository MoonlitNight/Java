package com.thread.demo2;

/**
 * 
 * @author � ���ڶԵ�һ�����������ߵ�������ʵ��
 */
// ��Resource����������Դ
class Resource1 {
	private String name;
	private double price;
	public boolean flag = false;// ���ڱ�ǲ�Ʒ�Ƿ�������ɣ�Ĭ��falseû���������
	public Resource1() {
		// TODO Auto-generated constructor stub
	}
	public Resource1(String name, double price) {
		super();
		setName(name);
		setPrice(price);
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

// ��Producer1��������������
class Producer1 implements Runnable {
	private Resource1 r;
	int x = 0;// ���

	Producer1(Resource1 r) {
		this.r = r;
	}

	public void run() {
		// whileѭ��ʹ�����߲�ͣ������
		while (true) {
			// ͬ������飬������̵߳����ݰ�ȫ����
			synchronized (r) {
				// �ж�����в�Ʒ�������ߵȴ������������ѹ����ٴ�ִ��
				if (r.flag != false) {
					try {
						r.wait();// �̵߳ȴ�
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				r.setName("ƻ��");
				r.setPrice(2.5);
				System.out.println(Thread.currentThread().getName() + "�����˱��" + x + "��" + r.toString());
				r.flag = true;// �������flag��ֵΪtrue��ʾ�������
				x++;// ��ż�һ
				r.notify();// ���ѵȴ��е��߳�
			}
		}
	}
}

// ��Consumer1��������������
class Consumer1 implements Runnable {
	private Resource1 r;
	// ��ű�����������ѵ���Դ����
	int x = 0;

	Consumer1(Resource1 r) {
		this.r = r;
	}

	public void run() {
		// �������߲�ͣ������
		while (true) {
			// ͬ������飬������̵߳����ݰ�ȫ����
			synchronized (r) {
				// �ж������Դδ���������������ߵȴ���������������ִ�г���
				if (r.flag == false) {
					try {
						r.wait();// �̵߳ȴ�
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + "�����˱��" + x + "��" + r.toString());
				x++;// ��ż�һ
				r.flag = false;// �������flag��ֵΪfalse��ʾ�������
				r.notify();// ���ѵȴ��е��߳�
			}
		}
	}
}

public class ThreadDemo1 {

	public static void main(String[] args) {
		Resource1 r = new Resource1();// ������Դ����
		Producer1 p = new Producer1(r);// ���������߶���
		Consumer1 c = new Consumer1(r);// ���������߶���
		new Thread(p).start();// �����߳�
		new Thread(c).start();// �����߳�
	}

}
