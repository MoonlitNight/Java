package com.thread.demo;

class Ticket2 extends Thread
{
	static int ticket = 100 ; 
	 private static Object lock = new Object();
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

public class ThreadDemo4 {

	public static void main(String[] args) {
		Ticket2 t1 = new Ticket2();
		Ticket2 t2 = new Ticket2();
		Ticket2 t3 = new Ticket2();
		Ticket2 t4 = new Ticket2();
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
