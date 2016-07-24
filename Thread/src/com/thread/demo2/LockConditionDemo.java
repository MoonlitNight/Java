package com.thread.demo2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author 瑾 用于对单一消费者生产者的描述及实例
 */
// 类Resource2用于描述资源
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
	// 获取Lock接口对象
	Lock lock = new ReentrantLock();
	// 创建负责生产者线程的Condition对象用于线程等待和唤醒，和当前Lock接口实例绑定
	Condition pro = lock.newCondition();
	// 创建负责消费者线程的Condition对象用于线程等待和唤醒，和当前Lock接口实例绑定
	Condition con = lock.newCondition();
	public boolean flag = false;// 用于标记产品是否生产完成，默认false没有生产完成

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
		return "[" + name + "]" + "---[价格]" + price;
	}
}

// 类Producer2用于描述生产者
class Producer2 implements Runnable {
	private Resource2 r;
	int x = 0;// 编号

	Producer2(Resource2 r) {
		this.r = r;
	}

	public void run() {	
		// while循环使生产者不停的生产
		while (true) {
			// 获取锁对象
			r.lock.lock();
			try {
				// 判断如果有产品则生产者等待，消费者消费过后再次执行
				if (r.flag != false) {
					try {
						r.pro.await();// 线程等待
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				r.setName("苹果");
				r.setPrice(2.5);
				System.out.println(Thread.currentThread().getName() + "生产了编号" + x + "：" + r.toString());
				r.flag = true;// 生产完成flag赋值为true表示生产完成
				x++;// 编号加一
				r.con.signal();// 唤醒消费者线程
			} finally {
				r.lock.unlock();// 释放锁对象
			}
		}
	}
}

// 类Consumer2用于描述消费者
class Consumer2 implements Runnable {
	private Resource2 r;
	// 编号标记消费者消费的资源数量
	int x = 0;

	Consumer2(Resource2 r) {
		this.r = r;
	}

	public void run() {
		// 让消费者不停的消费
		while (true) {
			r.lock.lock();// 获取锁对象
			// 同步代码块，解决多线程的数据安全问题
			try {
				// 判断如果资源未生产出来则消费者等待，生产完成则继续执行程序
				if (r.flag == false) {
					try {
						r.con.await();// 线程等待
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + "消费了编号" + x + "：" + r.toString());
				x++;// 标号加一
				r.flag = false;// 生产完成flag赋值为false表示消费完成
				r.pro.signal();// 唤醒等待中生产者的线程
			} finally {
				r.lock.unlock();// 执行完毕释放锁对象
			}
		}
	}
}

public class LockConditionDemo {

	public static void main(String[] args) {
		Resource2 r = new Resource2();// 创建资源对象
		Producer2 p = new Producer2(r);// 创建生产者对象
		Consumer2 c = new Consumer2(r);// 创建消费者对象
		Thread t1 =new Thread(p);
		Thread t2 =new Thread(c);
		t1.start();// 开启线程
		t2.start();// 开启线程
	}

}
