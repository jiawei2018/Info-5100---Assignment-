package assignment10;

public class Sensor extends Thread{
	private int s =0;
	 
		private final Device device;
		private double temperature;
		private double step;
		private double pressure;
		
		private boolean st = true;
		
		public Sensor(Device device) {
			this.device = device;
		}
		
		public double getC() {
			return this.temperature;
		}
		public double getP() {
			return this.pressure;
		}
		
 	    public void setStep( double step) {  // my function
			this.step= step;
			
		} 
		
		public void updateP( ) {// modified only for me
			this.pressure = device.getP();
			//this.value += step; // you check with other values here		and see how it works
		}
		
		public void updateC() {
			this.temperature = device.getC();
		}
//	 	public void start() {
//			// TODO Auto-generated method stub
//			
//		} 
	 	
		public void stopSensor() {
			
			this.st =false;
			this.stop(); 
		}
		
	 	public void run() {
	 		int i=0;
	 		while(st) {
					try {
						//System.out.println(st);
						Thread.sleep(10);
						this.updateC();
						this.updateP();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}//?ehy thread.sleeep
				 
	 		}
	 	}

	
	

}
