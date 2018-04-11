package assignment10;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import assignment10.calculator.CloseAll;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

public class studentMag extends JFrame  implements MouseListener{
	
	
	 class CloseAll extends WindowAdapter{
		 @Override
			public void windowClosing(WindowEvent we) {
			 System.exit(0);
			}
	 }
	
	
	
	

	public static void main(String args[]) throws Exception {
		new studentMag();
	}
	
	
	
	
	
	
	
	
	
	
	

	private JTable studentTable;
	private StudentsPersistor persistor;
	private List<Student> students;// the arraylist
	private StudentsManager manager;// for the save
	
	//here we start
	private JButton add,delete,update,find,save;
	private JTextField name,gender,grade;
	private JLabel namel,genderl,gradel;
	
	
	private Listener ol;
	
	
	
	
	
	
	
	
	
	
	
	class Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			Object o = ae.getSource();
 
			if(o == add)
				addS();
			
			if(o == delete )
				deleteS();
			
			if(o == update)
				updateS();
			
			if(o == find)
				findS();
			
			if(o == save )
				try {
					saveS();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}//method
	
	
	
	private void addEdit(Container c) {
		JPanel p = new JPanel();
		p.add(add);
		p.add(delete);
		p.add(update);
		p.add(find);
		p.add(save);
		c.add(p,"North");
		//c.add
	
	}
	
	private void addInput(Container c) {
		JPanel p = new JPanel();
		p.add(namel);
		p.add(name);
		p.add(genderl);
		p.add(gender);
		p.add(gradel);
		p.add(grade);
		c.add(p,"South");
		
	}
	
	
	private void setLayout() {
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		//c.setLayout(new GridLayout());

	}
	
	private void myConpoments() {
		//buttons
		  add = new JButton("ADD");
		  delete = new JButton("DELETE");// need  confirm
		  update = new JButton("UPDATE");// never modify the roll number
		  find = new JButton("FIND");
		  save = new JButton("SAVE");
		
		//textfield
		  name = new JTextField(5);
		  gender = new JTextField(5);
		  grade = new JTextField(5);
		
		//label
		namel = new JLabel("NAME");
		genderl = new JLabel("GENDER");
		gradel = new JLabel("GRADE");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private void addS() {
		Student s= new Student();
		int r = students.size();
		s.setName(name.getText());
		s.setGender(gender.getText());
		s.setGrade(grade.getText());
		s.setRoll(String.valueOf(++r));
		students.add(s);
		studentTable.revalidate();//this worked
		studentTable.repaint();
	}
	

	
	
	
	
	
	
	
	private void deleteS() {
		int tmp = theRow;
		
		students.remove(tmp);
		studentTable.revalidate();//this worked
		studentTable.repaint();
		
		//select and delete,show roll nums
		//after delete there will be a empty?
		
	}
	
	
	private void updateS() {
		int tmp = theRow;
		Student s = new Student();
		
		
		s.setName(name.getText());
		s.setGender(gender.getText());
		s.setGrade(grade.getText());
		
		students.remove(tmp);
		students.add(tmp, s);
		
		studentTable.revalidate(); // this is key to real-time reapaint table
		studentTable.repaint();
		//when select show in the text box
		//can modify ,then press button to save the changes 
	}
	
	
	
	
	private void findS() {
		String rollNumber = JOptionPane.showInputDialog("Input the roll number you want ot find:"); 
		System.out.println(rollNumber);
		StudentsManagerImpl s = new StudentsManagerImpl();
		s.students=this.students;
		Student res = s.findStudent(rollNumber);
		
		if (res == null) {
			JOptionPane.showMessageDialog(null, "there is no match ", "there is no match", JOptionPane.ERROR_MESSAGE); 
		}else {
			String r = res.getRoll();
			studentTable.getSelectionModel().setSelectionInterval(Integer.valueOf(r)-1, Integer.valueOf(r)-1);		  //table.getSelectionModel().setSelectionInterval(0,0);
		}
		
	}//find
	
	
	private void saveS() throws Exception {//worked
		StudentsPersistorImpl sp = new StudentsPersistorImpl();
		sp.save(manager);
		//persistor.save(manager);
	}
	
	
	
	

	
	
	
	
	
	private JScrollPane jsp;
	private Container c1;

	public studentMag() throws Exception {
		persistor = new StudentsPersistorImpl();
		manager = persistor.load();//for save 
		students = manager.getStudents();///????
		this.myConpoments();//my part

		StudentTableModel model = new StudentTableModel(students);
		studentTable = new JTable(model);
		
		//studentTable = JTable(StudentTableModel(students));

		  c1 = getContentPane();
		this.setLayout();
		
		this.addEdit(c1);
		this.addInput(c1);
		
		
		   jsp = new JScrollPane(studentTable);//
	
		c1.add(jsp,"Center");
		
		createListener();
		addListener();		
				
		setSize(500, 500);
		setVisible(true);
	}
	
	
	
	
	
	
   public void createListener() {
		 ol = new Listener();
	}

/*     public void createL() {
    	listener = new listener();
     }*/
     
     
     
     
     
	private void addListener() {//worked ,need to format   roll number again??
		CloseAll ca = new CloseAll();
		this.addWindowListener(ca);
		this.studentTable.addMouseListener(this);//worked ,we catch the click events
		this.add.addActionListener(ol);
		delete.addActionListener(ol);
		save.addActionListener(ol);
		update.addActionListener(ol);
		find.addActionListener(ol);
		// TODO Auto-generated method stub
	}

  
	
	
	class StudentTableModel implements TableModel {

		private List<Student> students;

		public StudentTableModel(List<Student> students) {
			this.students = students;
		}

		@Override
		public void addTableModelListener(TableModelListener tl) {
			// TODO Auto-generated method stub
		

		}

		@Override
		public Class<?> getColumnClass(int arg0) {
			return String.class;
		}

		@Override
		public int getColumnCount() {
			return 4;
		}
		
		public void refresh() {
			
		}

		@Override
		public String getColumnName(int c) {
			if (c == 0) {
				return "Roll";
			}
			if (c == 1) {
				return "Name";
			}
			if (c == 2) {
				return "Gender";
			}
			if (c == 3) {
				return "Grade";
			}
			return null;

		}

		@Override
		public int getRowCount() {
			return students.size();
		}

		@Override
		public Object getValueAt(int r, int c) {
			Student s = students.get(r);
			if (c == 0) {
				return s.getRoll();
			}
			if (c == 1) {
				return s.getName();
			}
			if (c == 2) {
				return s.getGender();
			}
			if (c == 3) {
				return s.getGrade();
			}
			return null;
		}

		@Override
		public boolean isCellEditable(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void removeTableModelListener(TableModelListener arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void setValueAt(Object arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub

		}

	}




    private int theRow;
	@Override
	public void mouseClicked(MouseEvent arg0) {//worked now
		theRow = studentTable.getSelectedRow();
		Student s = students.get(theRow);
		 name.setText(s.getName()); 
		 gender.setText(s.getGender()); 
		 grade.setText(s.getGrade());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
	

}
