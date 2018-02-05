
public class Human {

	String name;
	int age;
	int heightInInches;
	String eyeColor;
	
	public Human() {
		
	}
	
	public void Speak() {
	   System.out.println("Hello,my name is "+name);
	   System.out.println("I am "+heightInInches+" inches tall.");
	   System.out.println("I am "+age+" years old.");
	   System.out.println("My eyecolor is "+eyeColor);
	   
	}
	
	public void eat() {
		System.out.println("I am eating...");
	}
	
	public void walk() {
		System.out.println("I am walking...");
	}
	
	public void work() {
	    System.out.println("I am working...");	
	}
	
}
