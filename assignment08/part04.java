package assignment10;

public class part04 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		Device device = new Device();//also start the device
		Sensor heat = new Sensor(device);
		Sensor pressure = new Sensor(device);
		 
		
		Controller controller = new  Controller(device,heat,pressure);
		controller.start();
		heat.start();
		pressure.start();
		
		
		
		

	}
	
/*	Write a class Controller (extends Thread) that can poll the sensors
	concurrently to running the device. 
	
	You should implement its run() method
	such that it starts the device and then monitors it by waiting for and
	examining any new sensor values. 
	
	The controller shuts down the device if
	the heat sensor exceeds the value 70 or the pressure sensor the value
	100.
	 
	 Also complete the run() method in the class Sensor which calls
	updateValue() continuously and signals the controller if its value has
	changed.
	
	 You can print the heat and pressure value to console in the run()
	method of Controllerto check.*/
	
/*	class Device {
		public void startup() {   } // print to console that device		is starting
		public void shutdown() {   } 
		// print to console that device		is shutting down and exit
	}*/
	
/*	
	Sample output
	Device started
	heat -> 0.00 , pressure -> 0.00
	heat -> 0.80 , pressure -> 2.10
	heat -> 15.50 , pressure -> 15.40
	heat -> 30.30 , pressure -> 31.10
	heat -> 66.40 , pressure -> 68.90
	heat -> 68.70 , pressure -> 132.60
	Device shutting down due to maintenance
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
