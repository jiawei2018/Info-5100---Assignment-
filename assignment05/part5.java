package week05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class part5 extends JFrame implements ActionListener{

	double num1,num2,num3;
	boolean end,add,mul,sub,div;
	JTextField t=new JTextField("0");
	
	
	JButton b1 = new JButton("1");
	JButton b2 = new JButton("2");
	JButton b3 = new JButton("3");
	JButton b4 = new JButton("4");
	JButton b5 = new JButton("5");
	
	JButton b6 = new JButton("6");
	JButton b7 = new JButton("7");
	JButton b8 = new JButton("8");
	JButton b9 = new JButton("9");
	JButton b10 = new JButton("0");
	
	
	JButton b11 = new JButton(".");
	JButton b12 = new JButton("+");
	JButton b13 = new JButton("-");
	JButton b14 = new JButton("*");
	JButton b15 = new JButton("/");
	
	JButton b16 = new JButton("x^2");
	JButton b17 = new JButton("SQR");
	JButton b18 = new JButton("x^3");
	JButton b19 = new JButton("F'to C'");
	JButton b20 = new JButton("FI");
	
	
	JButton b21 = new JButton("C");
	JButton b22 = new JButton("=");
	JButton b23 = new JButton("C'to F'");
	JButton b24 = new JButton("FtoMeter");
	Font ft=new Font("Book Antiqua",Font.BOLD,30);
	Font ft1=new Font("Book Antiqua",Font.BOLD,20);
	Font ft2=new Font("Book Antiqua",Font.BOLD,15);

	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	
	public part5() {
		setTitle("calculator");
		setResizable(false);
		setBounds(100,100,500,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(p1,"North");
		t.setEditable(false);
		t.setHorizontalAlignment(JTextField.CENTER);
		t.setColumns(18);
		t.setHorizontalAlignment(JTextField.RIGHT);
		p1.add(t);
		
		GridLayout I = new GridLayout(6,0);
		I.setVgap(10);
		I.setHgap(10);
		
		p2.setLayout(I);
		add(p2,"Center");
		
		p2.add(b1);
		   b1.setFont(ft);
		p2.add(b2);
		   b2.setFont(ft);
		p2.add(b3);
		   b3.setFont(ft);
		p2.add(b4);
		   b4.setFont(ft);
		p2.add(b5);
		   b5.setFont(ft);
		p2.add(b6);
		   b6.setFont(ft);
		p2.add(b7);
		   b7.setFont(ft);
		p2.add(b8);
		   b8.setFont(ft);
		p2.add(b9);
		   b9.setFont(ft);
		p2.add(b10);
		   b10.setFont(ft);
		p2.add(b11);
		   b11.setFont(ft);
		p2.add(b12);
		   b12.setFont(ft);
		p2.add(b13);
		   b13.setFont(ft);
		p2.add(b14);
		   b14.setFont(ft);
		p2.add(b15);
		   b15.setFont(ft);
		p2.add(b16);
		   b16.setFont(ft);
		p2.add(b17);
		   b17.setFont(ft);
		p2.add(b18);
		   b18.setFont(ft);
		p2.add(b19);
		   b19.setFont(ft1);//smaller...
		
		p2.add(b20);
		   b20.setFont(ft);
		p2.add(b21);
		   b21.setFont(ft);
		p2.add(b22);
		   b22.setFont(ft);
		p2.add(b23);
		   b23.setFont(ft1);
		p2.add(b24);
		   b24.setFont(ft2);//much smaller...
		
		//p2.add(b2);
		//p2.add(b2);
	  JLabel II =  new JLabel();
	  II.setPreferredSize(new Dimension (20,0));
	  add(II,"West");
	  JLabel rl =  new JLabel();
	  rl.setPreferredSize(new Dimension (20,0));
	  add(rl,"East");
	  
	  b1.addActionListener(this);
	  b2.addActionListener(this);
	  b3.addActionListener(this);
	  b4.addActionListener(this);
	  b5.addActionListener(this);
	  b6.addActionListener(this);
	  b7.addActionListener(this);
	  b8.addActionListener(this);
	  b9.addActionListener(this);
	  b10.addActionListener(this);
	  b11.addActionListener(this);
	  b12.addActionListener(this);
	  b13.addActionListener(this);
	  b14.addActionListener(this);
	  b15.addActionListener(this);
	  b16.addActionListener(this);
	  b17.addActionListener(this);
	  b18.addActionListener(this);
	  b19.addActionListener(this);
	  b20.addActionListener(this);
	  b21.addActionListener(this);
	  b22.addActionListener(this);
	  b23.addActionListener(this);
	  b24.addActionListener(this);
	  
	  t.setFont(new Font("Book Antiqua", Font.PLAIN, 30) );
	 // b20.addActionListener(this);
	 // b20.addActionListener(this);
	  setVisible(true);

	}
	
	public void sign(int i) {
		if(i == 1) {
			add = true;
			mul = false;
			sub = false;
			div = false;
		}
		
		if(i == 2) {// need more for minus
			add = false;
			mul = false;
			sub = true;
			div = false;
		}
		
		if(i == 3) {
			add = false;
			mul = true;
			sub = false;
			div = false;
		}
		
		if(i == 4) {
			add = false;
			mul = false;
			sub = false;
			div = true;
		}
		num1 = Double.parseDouble(t.getText())	;
		end = true;
	}
	
	public void point() {
		String s ;
		if (t.getText().indexOf('.')<0) {
			s = t.getText()+".";
			t.setText(s);
		}
		
	}
	
	public void eql() {
         num2 = Double.parseDouble(t.getText());
		
		if(add)
			num3 = num1+num2;
		if(mul)
			num3 = num1*num2;
		if(sub)// need more for minus
			num3 = num1-num2;
		if(div)
			num3 = num1/num2;

		String s = String.valueOf(num3);
		t.setText(s);
		end = true;
	}
	
	public void sq() {
		num1 = Double.parseDouble(t.getText());
		num3 = num1 *num1;
		String s = String.valueOf(num3);
		t.setText(s);
	}
	
	public void sqr() {
		num1 = Double.parseDouble(t.getText());
		String s;
		if(num1<0) {
			s = "error";
		}else {
			num3 = Math.sqrt(num1);
			s = String.valueOf(num3);
		}
		 
		t.setText(s);
	}
	
	public void cube() {
		num1 = Double.parseDouble(t.getText());
		num3 = num1* num1*num1;
		String s = String.valueOf(num3);
		t.setText(s);
	}
	
	public void FtoC() {
/*		if(f<-459.67) {  
			return "error";  // absolute zero error
		}*/
		num1 = Double.parseDouble(t.getText());
		String s;
		if(num1 < -459.67) {
			s = "error! below absolute zero!";
		}else {
			num3 = (num1-32)/1.8;
			s = String.valueOf(num3);
		}
		
		t.setText(s);
	}
	
	public void FtoInch() {
		num1 = Double.parseDouble(t.getText());
		num3 = num1/12 ;
		String s = String.valueOf(num3);
		t.setText(s);
	}
	
	public void FtoMeter() {
		num1 = Double.parseDouble(t.getText());
		num3 = num1*0.3048;
		String s = String.valueOf(num3);
		t.setText(s);
	}
	
	public void CtoF() {
		String s;
		num1 = Double.parseDouble(t.getText());
		if(num1 < -273.15) {
			s = "error! below absolute zero!";
		}else {
			num3 = num1*1.8+32;//	C=(F-32)¡Â1.8
			s = String.valueOf(num3);
		}
		
		 s = String.valueOf(num3);
		 t.setText(s);
	}
	
	public void clear() {
		t.setText("0");
		//num1 = Double.parseDouble(t.getText());
	}
	
	
	public void num(int i) {
		String s = String.valueOf(i);
		if(end) {
			t.setText("0");
			end = false;
		}
		
		if((t.getText()).equals("0")) {
			t.setText(s);
		}else {
			String str = t.getText()+s;
			t.setText(str);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1)
			num(1);
		if(e.getSource() == b2)
			num(2);
		if(e.getSource() == b3)
			num(3);
		if(e.getSource() == b4)
			num(4);
		if(e.getSource() == b5)
			num(5);
		if(e.getSource() == b6)
			num(6);
		if(e.getSource() == b7)
			num(7);
		if(e.getSource() == b8)
			num(8);
		if(e.getSource() == b9)
			num(9);
		if(e.getSource() == b10)
			num(0);
		if(e.getSource() == b11)
			point();
		if(e.getSource() == b12)
			sign(1);
		if(e.getSource() == b13)
			sign(2);
		if(e.getSource() == b14)
			sign(3);
		if(e.getSource() == b15)
			sign(4);
		if(e.getSource() == b16)
			sq();
		if(e.getSource() == b17)
			sqr();
		if(e.getSource() == b18)
			cube();
		if(e.getSource() == b19)
			FtoC();
		if(e.getSource() == b20)
			FtoInch();
		if(e.getSource() == b21)
			clear();
		
		if(e.getSource() == b22)
			eql();
		if(e.getSource() == b23)
			CtoF();
		if(e.getSource() == b24)
			FtoMeter();

	}
	
	
	
	public static void main(String[] args) {
		 		
		part5 f=new part5();

	}

}
