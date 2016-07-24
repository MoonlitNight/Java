package com.thread.demo;

class Demo extends Thread
{
	int x=0;
	public void run()
	{
		for(int i=0;i<40;i++)
		{
		x++;
		System.out.println(Thread.currentThread().getName()+"-----"+x);
		}
		}
	
	}
public class ThreadDemo1 {

	public static void main(String[] args) {
		Demo d = new Demo();
		d.start();
		int i=0;
		for(int x=0;x<40;x++)
		{
		i++;
		System.out.println(Thread.currentThread().getName()+"-----"+i);
		}
	}

}
