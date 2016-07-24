package com.thread.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyLock implements Runnable
{
	int ticket = 100 ; 
	private final Lock lock = new ReentrantLock();
	public void run() {
		while(true)
		{
			lock.lock();//获取锁对象
			try{
			if(ticket>0)
			{
				System.out.println(Thread.currentThread().getName()+"窗口卖出了第"+ticket+"票");
				ticket--;
			}
		}finally{//使用try finally组合使得锁对象一定会得到释放
			lock.unlock();//释放锁对象
		}
		}
	}
	}

public class MyLockDemo1 {

	public static void main(String[] args) {
		MyLock t = new MyLock();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
