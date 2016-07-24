package com.boundedbuffer.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class BoundedBuffer {
	// 获取锁对象
	final Lock lock = new ReentrantLock();
	// 获取lock对应的Condition对象，用于对生产者线程的等待和唤醒操作
	final Condition pro = lock.newCondition();
	// 获取lock对应的Condition对象，用于对消费者线程的等待和唤醒操作
	final Condition con = lock.newCondition();
	// 定义Object数组用于保存生产的资源
	final Object[] items = new Object[100];
	// 定义count变量用于计数数组中的资源数
	int count;
	// 定义存放进数组中资源的角标
	int put;
	// 定义去除数组资源数组中的角标
	int get;

	public void put(Object obj) throws InterruptedException {
		lock.lock();// 获取锁
		try {
			while (count == items.length) // 判断如果元素数量等于数组的容量则生产者等待
			{
				pro.await();
			}
			items[put] = obj;// 存放资源
			if (++put == items.length)
				put = 0;// 判断如果是数组中最后一个位置，则存放角标赋值为0
			++count;// 存放一个，计数加一
			con.signal();// 唤醒消费者
		} finally {
			lock.unlock();// 释放锁对象
		}
	}

	public Object get() throws InterruptedException {
		lock.lock();// 获取锁对象
		try {
			while(count == 0) // 判断如果资源数为0则消费者等待
			{
				con.await();// 消费者线程等待
			}
			Object x = items[get];// 取出元素
			if (++get == items.length)
				get = 0;// 判断如果是数组中最后一个位置的元素，取出索引初始化为0
			--count;// 取出一个资源，计数器减一
			pro.signal();// 唤醒消费者
			return x;// 返回取出的元素
		} finally {
			lock.unlock();
		}
	}
	public void show(){
		System.out.println("资源数为"+count);
	}
}

// 类Resource用于描述资源
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
		return "[" + name + "]" + "---[价格]" + price;
	}
}

// 类Producer2用于描述生产者
class Producer implements Runnable {
	private BoundedBuffer bb;
	int x = 0;// 编号

	Producer(BoundedBuffer bb) {
		this.bb = bb;
	}

	public void run() {
		// while循环使生产者不停的生产
		while (true) {
			try {
				Resource r = new Resource("苹果", 2.5);
				bb.put(r);
				System.out.println(Thread.currentThread().getName() + "生产了编号" + x + "：" + r.getName());
				x++;// 编号加一
			} catch (InterruptedException e) {
			}
		}
	}
}

// 类Consumer用于描述消费者
class Consumer implements Runnable {
	private BoundedBuffer bb;
	// 编号标记消费者消费的资源数量
	int x = 0;

	Consumer(BoundedBuffer bb) {
		this.bb = bb;
	}

	public void run() {
		// 让消费者不停的消费
		while (true) {
			try {
				System.out.println(Thread.currentThread().getName() + "消费了编号" + x + "：" + bb.get());
				x++;// 标号加一
			} catch (InterruptedException e) {
			}

		}
	}
}

public class ThreadDemo1 {

	public static void main(String[] args) {
		BoundedBuffer r = new BoundedBuffer();// 创建资源对象
		Producer p = new Producer(r);// 创建生产者对象
		Consumer c = new Consumer(r);// 创建消费者对象
		new Thread(p).start();// 开启线程
		new Thread(p).start();// 开启线程
		new Thread(c).start();// 开启线程
		new Thread(c).start();// 开启线程
		while(true){
		r.show();
		}
	}

}