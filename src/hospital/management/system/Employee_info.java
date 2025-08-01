package hospital.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Employee_info extends JFrame {
	
	Employee_info(){
		
		JPanel Panal =new JPanel();
		Panal.setBounds(5, 5, 990,590);
		Panal.setBackground(new Color(173,216,230));
		Panal.setLayout(null);
		add(Panal);
		
		
		JTable table = new JTable();
		table.setBounds(10,34,980,450);
		table.setBackground(new Color(173,216,230));
		table.setFont(new Font("Tahoma", Font.BOLD,12));
		Panal.add(table);
		
		
		try {
			conn c = new conn();
			String q = "select * from EMP_INFO";
			ResultSet resultSet= c.statement.executeQuery(q); 
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		JLabel label1 = new JLabel("Name");
		label1.setBounds(15,11,70,20);
		label1.setFont(new Font("Tahoma", Font.BOLD,14));
		Panal.add(label1);
		
		JLabel label2 = new JLabel("Age");
		label2.setBounds(175,11,70,20);
		label2.setFont(new Font("Tahoma", Font.BOLD,14));
		Panal.add(label2);
		
		
		JLabel label3 = new JLabel("PhoneNo");
		label3.setBounds(340,11,70,20);
		label3.setFont(new Font("Tahoma", Font.BOLD,14));
		Panal.add(label3);
		
		JLabel label4 = new JLabel("Salary");
		label4.setBounds(500,11,70,20);
		label4.setFont(new Font("Tahoma", Font.BOLD,14));
		Panal.add(label4);
		
		JLabel label5 = new JLabel("GmainID");
		label5.setBounds(662,11,70,20);
		label5.setFont(new Font("Tahoma", Font.BOLD,14));
		Panal.add(label5);
		
		JLabel label6 = new JLabel("AadhaarNo");
		label6.setBounds(830,11,70,20);
		label6.setFont(new Font("Tahoma", Font.BOLD,14));
		Panal.add(label6);
		
		JButton back = new JButton("Back");
		back.setBounds(350, 500, 120, 30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		Panal.add(back);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		setSize(1000,600);
		setLocation(350,230);
		setLayout(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Employee_info();

	}

}
