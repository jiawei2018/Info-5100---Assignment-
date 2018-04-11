package assignment10;

public  class Device extends Thread{// i think this is
	private double heat,pressure;
	private boolean running = true;
	
/*	public Device() throws InterruptedException {
		this.startup();
	}*/
	public void startup() throws InterruptedException{
		Thread c = new Thread(()-> {
			try {
				this.heat();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} );
		Thread p = new Thread(()->{
			try {
				this.pressure();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		c.start();
		p.start();
		System.out.println("device is started");
	}
	
	
	public double getC() {
		return heat;
	}
	public double getP() {
		return pressure;
	}
	
	
	
	 void heat() throws InterruptedException {//must be a thread
		while(running) {
		 sleep(100);
		  heat += Math.random()*5;
		}
	}
	
	 void pressure() throws InterruptedException {//must be a thread
		while(running){
		 sleep(100);
		  pressure += Math.random()*7;
		}
	}
	
	
	
	public void shutdown(){
		running = false;
		System.out.println("Device shutting down due to maintenance");
		this.stop();
		return;
		
	};// // print to console that device	is shutting down and exit
	// device should have heat and pressure  increasing continuely
	
	
	public void run() {
		try {
			this.startup();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
