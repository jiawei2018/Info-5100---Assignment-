package assignment10;

import java.util.ArrayList;

public class part03  {
	
/*	3.Write a program called ReverseHello.java that creates a thread (let's call
			it Thread 1). Thread 1 creates another thread (Thread 2); Thread 2
			creates Thread 3; and so on, up to Thread 50. Each thread should print
			Hello from Thread num!
			but you should structure your program such that the threads print their
			greetings in reverse order. (Score 2)
*/

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		Thread t1 = new TcountDownA(50,0);
		//t1.start();
		//51.start();
	}
	
	int count = 0;
	int limit = 50;
	int len =0;
	ArrayList<Thread> at = new ArrayList<Thread>();
	
/*	Thread johnThread = new Thread(() -> john.askQuestion());
	Thread weiThread = new Thread(() -> wei.askQuestion());
	johnThread.start();
	weiThread.start();*/
	
		
	
	static class TcountDownA extends Thread{
	    int limit;
	    private int count;
	    private String name;
	    public TcountDownA(int limit,int count) throws InterruptedException {
	    	this.limit = limit;
	    	this.count = count;
	    	this.name = String.valueOf(count);
     	if(limit >count) {
	    		Thread a =new TcountDownA(limit,++count);
	    		a.run();
	    		a.join();
	    	} 
	    }
	    @Override
	    public void run(){
 	            System.out.println("hello! this is thread " + name );
	    }
	}	

}
