package assignment10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class calculator extends JFrame{
	
	private JTextField inputA ,InputB ,result;//really need this? or just make it one textfield
	private JButton one,two,three,four,five ,six ,seven,eight,nine,zero;
	private JButton plus,minus,multiply,divide,dot,clear;
	private JButton A,B;
	private JLabel ina,inb,res;
	
	private  Clistener cl;
	private int lastName;
	
	//private myLis Listener;
	
	
	public calculator() {
		createComponents();
		setLayout();
		addComponents();
		createListener();
		addListener();
		setVisible();
	}
	
	
	
	
 

	
	private void createListener() {
		// TODO Auto-generated method stub
		 cl = new Clistener();
	}







	private void addListener() {
		A.addActionListener(cl);
		B.addActionListener(cl);
		
		plus.addActionListener(cl);
		minus.addActionListener(cl);
		multiply.addActionListener(cl);
		divide.addActionListener(cl);
		dot.addActionListener(cl);
		clear.addActionListener(cl);
		
		one.addActionListener(cl);
		two.addActionListener(cl);
		three.addActionListener(cl);
		four.addActionListener(cl);
		five.addActionListener(cl);
		six.addActionListener(cl);
		seven.addActionListener(cl);
		eight.addActionListener(cl);
		nine.addActionListener(cl);
		zero.addActionListener(cl);
		
		CloseAll ca = new CloseAll();
		this.addWindowListener(ca);
		// TODO Auto-generated method stub
		
	}
	


	
	class Clistener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ag) {
			Object o = ag.getSource();
			
			if( o == clear ) {
				inputA.setText("");
				InputB.setText("");
				result.setText("");
			}
			if( o == A ) lastName = 1;
			if(o == B) lastName = 2;
			
			if(o == plus || o == multiply || o == divide || o == minus) {
				lastName = 0;
				double a = Double.parseDouble(inputA.getText())   ;
				double b =  Double.parseDouble(InputB.getText());
				
				if(o == plus) result.setText(String.valueOf(a+b));
				if(o == minus) result.setText(String.valueOf(a-b));
				if(o == multiply) result.setText(String.valueOf(a*b));
				if(o == divide) result.setText(String.valueOf(a/b));
			}
 
			
				if(lastName == 1) {// while
					if(o == one) num(1,inputA);
					if(o == two) num(2,inputA);
					if(o == three) num(3,inputA);
					if(o == four) num(4,inputA);
					if(o == five) num(5,inputA);
					if(o == six) num(6,inputA);
					if(o == seven) num(7,inputA);
					if(o == eight) num(8,inputA);
					if(o == nine) num(9,inputA);
					if(o == zero) num(0,inputA);
					if( o == dot) this.point(inputA);
					//if(o == dot) num(0,inputA);
				}else if(lastName == 2) {
					if(o == one) num(1,InputB);
					if(o == two) num(2,InputB);
					if(o == three) num(3,InputB);
					if(o == four) num(4,InputB);
					if(o == five) num(5,InputB);
					if(o == six) num(6,InputB);
					if(o == seven) num(7,InputB);
					if(o == eight) num(8,InputB);
					if(o == nine) num(9,InputB);
					if(o == zero) num(0,InputB);
					if( o == dot) this.point(InputB);
				}//else
					


			}//if
		
		
		
		
		
		public void point(JTextField t) {
			String s ;
			if (t.getText().indexOf('.')<0) {
				s = t.getText()+".";
				t.setText(s);
			}
			
		}
 }// class
	
 class CloseAll extends WindowAdapter{
	 @Override
		public void windowClosing(WindowEvent we) {
		 
		 System.exit(0);
		}
 }
		
/*		private void setNums(Object o,int  tName) {
			if(tName ==  1) {
				JTextField t = inputA;
			}else  
				  t = InputB;
			
			
			
			if(o == one) num(1,t);
			if(o == two) num(2,t);
			if(o == three) num(3,t);
			if(o == four) num(4,t);
			if(o == five) num(5,t);
			if(o == six) num(6,t);
			if(o == seven) num(7,t);
			if(o == eight) num(8,t);
			if(o == nine) num(9,t);
			if(o == zero) num(0,t);
		}*/
	//class
	
	
	private void num(int i,JTextField t) {
		String s = String.valueOf(i);
		System.out.println(i);
		//if(end) {
		//	t.setText("0");
		//	end = false;
		//}
		
		if((t.getText()).equals("0")) {
			t.setText(s);
		}else {
			String str = t.getText()+s;
			t.setText(str);
		}
	}
	
	private void setVisible() {
		setSize(1000,300);
		this.setVisible(true);
		//pack();
		
	}

	private void addComponents() {
		Container c = getContentPane();
		this.textControl(c);
		this.inputControl(c);
		

		
	}







	private void inputControl(Container c) {// all buttons
		JPanel p2 = new JPanel(new GridLayout(4,4));
		
		p2.add(seven);//button row 1
		p2.add(eight);
		p2.add(nine);
		p2.add(plus);
		
		p2.add(four);//2
		p2.add(five);
		p2.add(six);
		p2.add(minus);
		
		p2.add(one);//3
		p2.add(two);
		p2.add(three);
		p2.add(multiply);
		
		p2.add(dot);//4
		p2.add(zero);
		p2.add(clear);
		p2.add(divide);
		
		c.add(p2,"Center");
	}

	private void textControl(Container c) {//add textfield
		//JPanel p1 = new JPanel(new GridLayout());
		JPanel p1 = new JPanel(new GridBagLayout());
		
		p1.add(A);
		p1.add(inputA);
		p1.add(B);
		p1.add(InputB);
		p1.add(res);
		p1.add(result);
				c.add(p1,"North");
	}//method




	private void setLayout() {
		Container c = getContentPane();//no 'new' in this line
		c.setLayout(new BorderLayout() );
	}






	private void createComponents() {
		Font ft = new Font("Book Antiqua",Font.BOLD,25);
		Font ft1 = new Font("Book Antiqua",Font.BOLD,20); 
		ina = new JLabel("Number a");
		inb = new JLabel("Number b");
		res = new JLabel("Result");
		inputA = new JTextField(8);
		inputA.setEditable(false); 
		inputA.setText("0");
		inputA.setFont(ft);
	  
		//inputA.s
		inputA.setBackground(Color.white);
		
		
		InputB  = new JTextField(8);
		InputB.setEditable(false);
		InputB.setText("0");
		InputB.setBackground(Color.WHITE);
		InputB.setFont(ft);
		
		
		
		
		result = new JTextField(15);
		result.setEditable(false);
		result.setBackground(Color.cyan); 
		result.setFont(ft);
		
		//make the button font bigger
	
		
		one = new JButton("1");
		one.setFont(ft1);//worked
		two = new JButton("2");
		two.setFont(ft1);
		three = new JButton("3");
		three.setFont(ft1);
		four = new JButton("4");
		four.setFont(ft1);
		five = new JButton("5");
		five.setFont(ft1);
		six = new JButton("6");
		six.setFont(ft1);
		seven = new JButton("7");
		seven.setFont(ft1);
		eight = new JButton("8");
		eight.setFont(ft1);
		nine = new JButton("9");
		nine.setFont(ft1);
		zero = new JButton("0");
		zero.setFont(ft1);
		
		
		plus = new JButton("+");
		plus.setFont(ft);
		minus = new JButton("-");
		minus.setFont(ft);
		multiply = new JButton("*");
		multiply.setFont(ft);
		divide = new JButton("¡Â");
		divide.setFont(ft);
		dot  = new JButton(".");
		clear = new JButton("AC");
		
		
		A = new JButton("Num A:"); 
		B = new JButton("Num B:");
		
	}//method
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculator c = new calculator();
		c.setTitle("my calculator");

	}
	
	
	

}
