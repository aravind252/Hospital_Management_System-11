  package hospital.management.system;

   import java.awt.Choice;



import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Statement;
   import java.util.Date;
   public class New_Patient extends JFrame implements ActionListener{
	   JComboBox comboBox;
	   
	   JTextField textFieldNumber, textName ,textFieldDisease, textFieldDeposit;
	   
	   JRadioButton r1,r2;
	  

	   
	   Choice c1;
	   
	   JLabel date;
	   
	   JButton b1,b2;
	   
	   
	     New_Patient(){
	    	 
	    	 JPanel panal = new JPanel();
	    	 panal.setBounds(5, 5, 840, 540);
	    	 panal.setBackground(new Color(90,156,163));
	    	 panal.setLayout(null);
	    	 add(panal);
	    	 
	    	 ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/newbed.png"));
	    	 Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
	    	 ImageIcon imageIcon1 =new ImageIcon(image);
	    	 JLabel label =new JLabel(imageIcon1);
	    	 label.setBounds(550, 150, 200, 200);
	    	 panal.add(label);
	    	 
	    	 JLabel labelName = new JLabel("NEW PATIENT FORM");
	    	 labelName.setBounds(118, 11, 260, 53);
	    	 labelName.setFont(new Font("Tahoma", Font.BOLD,20));
	    	 panal.add(labelName);
	    	 
	    	 JLabel labelID = new JLabel("ID:");
	    	 labelID.setBounds(35, 76, 200, 14);
	    	 labelID.setFont(new Font("Tahoma", Font.BOLD,14));
	    	 labelID.setForeground(Color.white);
	    	 panal.add(labelID);	    	 
	    	 
	    	 comboBox = new JComboBox(new String[] {"Adhaar card","voter Id","Driving License"});
	    	 comboBox.setBounds(271, 75, 150, 20);
	    	 comboBox.setBackground(new Color(3,45,48));
	    	 comboBox.setForeground(Color.white);
	    	 comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
	    	 panal.add(comboBox);
	    	 
	    	 JLabel labelnumber = new JLabel("Number:");
	    	 labelnumber.setBounds(35, 111, 200, 14);
	    	 labelnumber.setFont(new Font("Tahoma", Font.BOLD,14));
	    	 labelnumber.setForeground(Color.white);
	    	 panal.add(labelnumber);
	    	 
	    	 
	    	 textFieldNumber = new JTextField();
	    	 textFieldNumber.setBounds(271, 111, 150, 20);
	    	 panal.add(textFieldNumber);
	    	 
	    	 
	    	 JLabel labelname1 = new JLabel("Name:");
	    	 labelname1.setBounds(35, 151, 200, 14);
	    	 labelname1.setFont(new Font("Tahoma", Font.BOLD,14));
	    	 labelname1.setForeground(Color.white);
	    	 panal.add(labelname1);
	    	 
	    	 
	    	 textName = new JTextField();
	    	 textName.setBounds(271, 151, 150, 20);
	    	 panal.add(textName);
	    	 
	    	 
	    	 JLabel labelgender = new JLabel("Gender:");
	    	 labelgender.setBounds(35, 191, 200, 14);
	    	 labelgender.setFont(new Font("Tahoma", Font.BOLD,14));
	    	 labelgender.setForeground(Color.white);
	    	 panal.add(labelgender);
	    	 
	    	 r1 = new JRadioButton("Male");
	    	 r1.setFont(new Font("Tahoma", Font.BOLD,14));
	    	 r1.setForeground(Color.white);
	    	 r1.setBackground(new Color(109,164,170));
	    	 r1.setBounds(271, 191, 80, 12);
	    	 panal.add(r1);
	    	 
	    	 r2 = new JRadioButton("Female");
	    	 r2.setFont(new Font("Tahoma", Font.BOLD,14));
	    	 r2.setForeground(Color.white);
	    	 r2.setBackground(new Color(109,164,170));
	    	 r2.setBounds(350,191, 80, 12);
	    	 panal.add(r2);
	    	 
	    	// Group the radio buttons to allow only one selection at a time
	    	 ButtonGroup genderGroup = new ButtonGroup();
	    	 genderGroup.add(r1);
	    	 genderGroup.add(r2);

	    	 
	    	 JLabel labelDisease = new JLabel("Desease:");
	    	 labelDisease.setBounds(35, 231, 200, 14);
	    	 labelDisease.setFont(new Font("Tahoma", Font.BOLD,14));
	    	 labelDisease.setForeground(Color.white);
	    	 panal.add(labelDisease);
	    	 
	    	 
	    	 textFieldDisease = new JTextField();
	    	 textFieldDisease.setBounds(271, 231, 150, 20);
	    	 panal.add(textFieldDisease);
	    	 
	    	 JLabel labelroom = new JLabel("Room:");
	    	 labelroom.setBounds(35, 274, 200, 14);
	    	 labelroom.setFont(new Font("Tahoma", Font.BOLD,14));
	    	 labelroom.setForeground(Color.white);
	    	 panal.add(labelroom);
	    	 
	    	 
	    	 c1 =new Choice();
	    	 try {
	    		 conn c = new conn();
	    		 ResultSet resultSet =c.statement.executeQuery("select * from room");
	    		 while(resultSet.next()) {
	    			 c1.add(resultSet.getString("room_number"));
	  
	    		 }
	    	 }catch (Exception e) {
				e.printStackTrace();			}
	    	 
	    	 c1.setBounds(271,274,150,20);
	    	 c1.setFont(new Font("Tahoma", Font.BOLD,14));
	    	 c1.setForeground(Color.white);
	    	 c1.setBackground(new Color(3,45,48));
	    	 panal.add(c1);
	    	 
	    	 
	    	 JLabel labeldate = new JLabel("Time:");
	    	 labeldate.setBounds(35, 316, 200, 14);
	    	 labeldate.setFont(new Font("Tahoma", Font.BOLD,14));
	    	 labeldate.setForeground(Color.white);
	    	 panal.add(labeldate);
	    	 
	    	 
	    	Date date1 = new Date();
	    	date = new JLabel(""+date1);
	    	date.setBounds(271, 316, 250, 14);
	    	date.setForeground(Color.white);
	    	date.setFont(new Font("Tahoma", Font.BOLD,14));
	    	panal.add(date);
	    	
	    	JLabel labelDeposit = new JLabel("Deposit:");
	    	labelDeposit.setBounds(35, 359, 200, 17);
	    	labelDeposit.setFont(new Font("Tahoma", Font.BOLD,14));
	    	labelDeposit.setForeground(Color.white);
	    	 panal.add(labelDeposit);
	    	 
	    	 
	    	 textFieldDeposit = new JTextField();
	    	 textFieldDeposit.setBounds(271, 359, 150, 20);
	    	 panal.add(textFieldDeposit); 
	    
	    	b1 = new JButton("Add");
	    	b1.setBounds(100, 430, 120, 30);
	    	b1.setForeground(Color.white);
	    	b1.setBackground(Color.black);
	    	b1.addActionListener(this);
	    	panal.add(b1);
	    	
	    	b2 = new JButton("BACK");
	    	b2.setBounds(260, 430, 120, 30);
	    	b2.setForeground(Color.white);
	    	b2.setBackground(Color.black);
	    	b2.addActionListener(this);
	    	panal.add(b2);
	    	
	    	
	    	 
	    setUndecorated(true);			 
		setSize(850,550);
		setLayout(null);
		setLocation(300, 250);
		setVisible(true);
		
		
	}
	     @Override
	     public void actionPerformed(ActionEvent e) {
	         if (e.getSource() == b1) {
	             String radioBTN = null;
	             if (r1.isSelected()) {
	                 radioBTN = "Male";
	             } else if (r2.isSelected()) {
	                 radioBTN = "Female";
	             }

	             String s1 = (String) comboBox.getSelectedItem();
	             String s2 = textFieldNumber.getText();
	             String s3 = textName.getText();
	             String s4 = radioBTN;
	             String s5 = textFieldDisease.getText();
	             String s6 = c1.getSelectedItem();
	             String s7 = date.getText();
	             String s8 = textFieldDeposit.getText();

	             try {
	                 String q = "INSERT INTO patent_info VALUES ('" + s1 + "', '" + s2 + "', '" + s3 + "', '" + s4 + "', '" + s5 + "', '" + s6 + "', '" + s7 + "', '" + s8 + "')";
	                 String q1 = "UPDATE room SET Avaliability = 'Occupied' WHERE room_number = '" + s6 + "'";

	                 conn c = new conn();
	                 c.statement.executeUpdate(q);
	                 c.statement.executeUpdate(q1);

	                 JOptionPane.showMessageDialog(null, "Added Successfully");
	                 setVisible(false);

	             } catch (Exception e1) {
	                 e1.printStackTrace();
	             }
	         } else if (e.getSource() == b2) {
	             setVisible(false);
	         }
	     }
	    	 
	     	     
   
	public static void main(String[] args) {
		new New_Patient(); 

	}

    }



