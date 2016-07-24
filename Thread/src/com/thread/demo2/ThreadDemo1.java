package com.thread.demo2;

/**
 * 
 * @author 瑾 用于对单一消费者生产者的描述及实例
 */
// 类Resource用于描述资源
class Resource1 {
	private String name;
	private double price;
	public boolean flag = false;// 用于标记产品是否生产完成，默认false没有生产完成
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
		return "[" + name + "]" + "---[价格]" + price;
	}
}

// 类Producer1用于描述生产者
class Producer1 implements Runnable {
	private Resource1 r;
	int x = 0;// 编号

	Producer1(Resource1 r) {
		this.r = r;
	}

	public void run() {
		// while循环使生产者不停的生产
		while (true) {
			// 同步代码块，解决多线程的数据安全问题
			synchronized (r) {
				// 判断如果有产品则生产者等待，消费者消费过后再次执行
				if (r.flag != false) {
					try {
						r.wait();// 线程等待
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				r.setName("苹果");
				r.setPrice(2.5);
				System.out.println(Thread.currentThread().getName() + "生产了编号" + x + "：" + r.toString());
				r.flag = true;// 生产完成flag赋值为true表示生产完成
				x++;// 编号加一
				r.notify();// 唤醒等待中的线程
			}
		}
	}
}

// 类Consumer1用于描述消费者
class Consumer1 implements Runnable {
	private Resource1 r;
	// 编号标记消费者消费的资源数量
	int x = 0;

	Consumer1(Resource1 r) {
		this.r = r;
	}

	public void run() {
		// 让消费者不停的消费
		while (true) {
			// 同步代码块，解决多线程的数据安全问题
			synchronized (r) {
				// 判断如果资源未生产出来则消费者等待，生产完成则继续执行程序
				if (r.flag == false) {
					try {
						r.wait();// 线程等待
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + "消费了编号" + x + "：" + r.toString());
				x++;// 标号加一
				r.flag = false;// 生产完成flag赋值为false表示消费完成
				r.notify();// 唤醒等待中的线程
			}
		}
	}
}

public class ThreadDemo1 {

	public static void main(String[] args) {
		Resource1 r = new Resource1();// 创建资源对象
		Producer1 p = new Producer1(r);// 创建生产者对象
		Consumer1 c = new Consumer1(r);// 创建消费者对象
		new Thread(p).start();// 开启线程
		new Thread(c).start();// 开启线程
	}

}
