package assignment10;

//import assignment10.part04.Sensor;

public class Controller extends Thread{

	private Device device;
	private Sensor heat;
	private Sensor pressure;
	
	private double tmp,pre;
	
	public Controller(Device device, Sensor heat, Sensor pressure) {
		this.device = device;
		this.heat = heat;
		this.pressure = pressure;
		// TODO Auto-generated constructor stub
	}

	 
	public void startup() {
		// TODO Auto-generated method stub
		
	}

 
	public void shutdown() {
		
	}


	
	public void run() {//or
		device.start();
		try {
			check(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void check(int ckf) throws InterruptedException {// check frequency
		double h,p;
		while(tmp<70 && pre <100) {// this should be a new thread
			sleep(ckf);
			this.tmp = heat.getC();
			this.pre = pressure.getP();
			System.out.println("heat -> "+tmp+", "+"  pressure ->"+pre );
	   }
		//System.out.println("over shuting down device");
		device.shutdown();
		heat.stopSensor();
		pressure.stopSensor();
		this.stop();
		
	}
	

}
