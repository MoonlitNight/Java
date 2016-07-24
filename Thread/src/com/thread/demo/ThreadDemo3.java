package com.thread.demo;

class Ticket implements Runnable
{
	int ticket = 100 ; 
	private Object lock = new Object();
	public void run() {
		while(true)
		{
			synchronized(lock)
			{
			if(ticket>0)
			{
				System.out.println(Thread.currentThread().getName()+"窗口卖出了第"+ticket+"票");
				ticket--;
			}
		}
		}
	}
	}

public class ThreadDemo3 {

	public static void main(String[] args) {
		Ticket2 t = new Ticket2();
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
