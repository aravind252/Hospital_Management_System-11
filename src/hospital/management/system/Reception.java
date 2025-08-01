package hospital.management.system;

import java.awt.Color;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Reception extends JFrame{
	
	Reception(){
		
		JPanel panal =new JPanel();
		panal.setLayout(null);
		panal.setBounds(5,160,1525,670);
		panal.setBackground(new Color(173,216,230));
		add(panal);
		
		JPanel panal1 =new JPanel();
		panal1.setLayout(null);
		panal1.setBounds(5,5,1525,150);
		panal1.setBackground(new Color(173,216,230));
		add(panal1);
		
		ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/AravindH.jpg"));
		Image bgImage = bgIcon.getImage().getScaledInstance(1525, 670, Image.SCALE_SMOOTH);
		ImageIcon scaledBgIcon = new ImageIcon(bgImage);
		JLabel bgLabel = new JLabel(scaledBgIcon);
		bgLabel.setBounds(0, 0, 1525, 670);
		panal.add(bgLabel);

		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/doctor.png"));
		Image image  = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);		
		ImageIcon i2 = new ImageIcon(image);
		JLabel label = new JLabel(i2);
		label.setBounds(1300, 0, 250, 250);
		panal1.add(label);
		
		ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/Road.png"));
		Image image1  = i11.getImage().getScaledInstance(300, 100, Image.SCALE_DEFAULT);		
		ImageIcon i22 = new ImageIcon(image1);
		JLabel label1 = new JLabel(i22);
		label1.setBounds(1000, 50, 300, 100);
		panal1.add(label1);
		
		JButton btn1 =new JButton("Add New Patent");
		btn1.setBounds(30, 15, 200, 30);
		btn1.setBackground(new Color(246,215,118));
		panal1.add(btn1);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			new New_Patient();
				
			}
		});
		
		
		JButton btn2 =new JButton("Room");
		btn2.setBounds(30, 58, 200, 30);
		btn2.setBackground(new Color(246,215,118));
		panal1.add(btn2);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			new Room();
				
			}
		});
		
		
		JButton btn3 =new JButton("Department");
		btn3.setBounds(30, 100, 200, 30);
		btn3.setBackground(new Color(246,215,118));
		panal1.add(btn3);
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			new Department();
				
			}
		});
		
		JButton btn4 =new JButton("All Employee Info");
		btn4.setBounds(270, 15, 200, 30);
		btn4.setBackground(new Color(246,215,118));
		panal1.add(btn4);
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			new Employee_info();
				
			}
		});
		
		JButton btn5 =new JButton("Patent Info");
		btn5.setBounds(270, 58, 200, 30);
		btn5.setBackground(new Color(246,215,118));
		panal1.add(btn5);
		btn5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			new All_Patient_Info();
				
			}
		});
		
		JButton btn6 =new JButton("Patent Discharge");
		btn6.setBounds(270, 100, 200, 30);
		btn6.setBackground(new Color(246,215,118));
		panal1.add(btn6);
		btn6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			new patient_discharge();				
			}
		});
		
		JButton btn7 =new JButton("Update Patent Details");
		btn7.setBounds(510, 15, 200, 30);
		btn7.setBackground(new Color(246,215,118));
		panal1.add(btn7);
		btn7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			new Update_patient_details();
				
			}
		});
		
		JButton btn8 =new JButton("Hospital Ambulence");
		btn8.setBounds(510, 58, 200, 30);
		btn8.setBackground(new Color(246,215,118));
		panal1.add(btn8);
		btn8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			new Ambulance();
				
			}
		});
		
		JButton btn9 =new JButton("Search Room");
		btn9.setBounds(510, 100, 200, 30);
		btn9.setBackground(new Color(246,215,118));
		panal1.add(btn9);
		btn9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			new Search_room();
				
			}
		});
		
		JButton btn10 =new JButton("Logout");
		btn10.setBounds(750, 15, 200, 30);
		btn10.setBackground(new Color(246,215,118));
		panal1.add(btn10);
		btn10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new login();
				
			}
		});
		
		
		setSize(1950, 1090);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new Reception();
		
	}

}