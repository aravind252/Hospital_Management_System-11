package hospital.management.system;
import java.util.Date;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class patient_discharge extends JFrame {
	
	
	public patient_discharge() {
		
		JPanel panal = new JPanel();
		panal.setBounds(5,5,790,390);
		panal.setBackground(new Color(173,216,230));
		panal.setLayout(null);
		add(panal);
		
		
		JLabel label1 =new JLabel("Check Out");
		label1.setBounds(100,20,150,20);
		label1.setFont(new Font("Tahoma", Font.BOLD,20));
		label1.setForeground(Color.black);
		panal.add(label1);
		
		JLabel label2 =new JLabel("Customer Id");
		label2.setBounds(30,80,150,20);
		label2.setFont(new Font("Tahoma", Font.BOLD,14));
		label2.setForeground(Color.black);
		panal.add(label2);
		
		
		Choice choice = new Choice();
		choice.setBounds(200,80,150,25);
		panal.add(choice);
		
		try {
			
		conn c = new conn();
		ResultSet resultSet = c.statement.executeQuery("select * from patent_info");
		while(resultSet.next()) {
			choice.add(resultSet.getString("number"));
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel label3 =new JLabel("Room Number");
		label3.setBounds(30,130,150,20);
		label3.setFont(new Font("Tahoma", Font.BOLD,14));
		label3.setForeground(Color.black);
		panal.add(label3);
		
		JLabel RNO =new JLabel();
		RNO.setBounds(200,130,150,20);
		RNO.setFont(new Font("Tahoma", Font.BOLD,14));
		RNO.setForeground(Color.black);
		panal.add(RNO);
		
		JLabel label4 =new JLabel("In Time");
		label4.setBounds(30,180,150,20);
		label4.setFont(new Font("Tahoma", Font.BOLD,14));
		label4.setForeground(Color.black);
		panal.add(label4);
		
		JLabel INTime =new JLabel();
		INTime.setBounds(200,180,250,20);
		INTime.setFont(new Font("Tahoma", Font.BOLD,14));
		INTime.setForeground(Color.black);
		panal.add(INTime);
		
		JLabel label5 =new JLabel("Out Time");
		label5.setBounds(30,230,250,20);
		label5.setFont(new Font("Tahoma", Font.BOLD,14));
		label5.setForeground(Color.black);
		panal.add(label5);
		
		Date date = new Date();
		
		JLabel OUTTime =new JLabel(""+date);
		OUTTime.setBounds(200,230,250,20);
		OUTTime.setFont(new Font("Tahoma", Font.BOLD,14));
		OUTTime.setForeground(Color.black);
		panal.add(OUTTime);
		
		
		JButton discharge = new JButton("Discharge");
		discharge.setBounds(30,300,120,30);
		discharge.setBackground(Color.white);
		discharge.setForeground(Color.black);
		panal.add(discharge);
		discharge.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				conn c = new conn();
				try {
					
					c.statement.executeUpdate("delete from patent_info where number='"+choice.getSelectedItem()+"'");
					c.statement.executeUpdate("UPDATE room SET Avaliability = 'Availabil' WHERE room_number = '"+RNO.getText()+"'");

					JOptionPane.showMessageDialog(null,"DONE");
					setVisible(false);
					
					
				} catch (Exception E) {
					E.printStackTrace();
				}
				
				
			}
		});
		
		
		
		JButton Check = new JButton("Check");
		Check.setBounds(167,300,120,30);
		Check.setBackground(Color.white);
		Check.setForeground(Color.black);
		panal.add(Check);
		Check.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				conn c =new conn();
				try {
					ResultSet resultSet=c.statement.executeQuery("select * from patent_info where number ='"+choice.getSelectedItem()+"'");
					while(resultSet.next()) {
						RNO.setText(resultSet.getString("Room_Number"));
						INTime.setText(resultSet.getString("Time"));
					}
				} catch (Exception E) {
					E.printStackTrace();
				}
				
			}
		});
		
		
		JButton Back = new JButton("Back");
		Back.setBounds(300,300,120,30);
		Back.setBackground(Color.white);
		Back.setForeground(Color.black);
		panal.add(Back);
		Back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		setUndecorated(true);
		setSize(800,400);
		setLayout(null);
		setLocation(400,250);
		setVisible(true);
	}

	public static void main(String[] args) {
		new patient_discharge();

	}

}
