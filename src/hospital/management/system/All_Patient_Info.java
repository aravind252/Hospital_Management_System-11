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

public class All_Patient_Info extends JFrame {
	
	All_Patient_Info(){
		
		JPanel panal= new JPanel();
		panal.setBounds(5,5,890,590);
		panal.setBackground(new Color(173,216,230));
		panal.setLayout(null);
		add(panal);
		
		JTable table= new JTable();
		table.setBounds(10,40,900,450);
		table.setBackground(new Color(173,216,230));
		table.setFont(new Font("Tahoma", Font.BOLD,11));
		panal.add(table);
		
		try {
			conn c = new conn();
			String q = "select * from patent_info";
			ResultSet resultSet = c.statement.executeQuery(q);
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		JLabel label1 = new JLabel("ID");
		label1.setBounds(16,11,100,14);
		label1.setFont(new Font("Tahoma", Font.BOLD,14));
		panal.add(label1);
		
		
		JLabel label2 = new JLabel("Number");
		label2.setBounds(124,11,100,14);
		label2.setFont(new Font("Tahoma", Font.BOLD,14));
		panal.add(label2);
		
		JLabel label3 = new JLabel("Name");
		label3.setBounds(235,11,100,14);
		label3.setFont(new Font("Tahoma", Font.BOLD,14));
		panal.add(label3);
		
		JLabel label4 = new JLabel("Gender");
		label4.setBounds(348,11,100,14);
		label4.setFont(new Font("Tahoma", Font.BOLD,14));
		panal.add(label4);
		
		JLabel label5 = new JLabel("Disease");
		label5.setBounds(458,11,100,14);
		label5.setFont(new Font("Tahoma", Font.BOLD,14));
		panal.add(label5);
		
		JLabel label6 = new JLabel("Room No");
		label6.setBounds(573,11,100,14);
		label6.setFont(new Font("Tahoma", Font.BOLD,14));
		panal.add(label6);
		
		JLabel label7 = new JLabel("Time");
		label7.setBounds(685,11,100,14);
		label7.setFont(new Font("Tahoma", Font.BOLD,14));
		panal.add(label7);
		
		JLabel label8 = new JLabel("Deposit");
		label8.setBounds(800,11,100,14);
		label8.setFont(new Font("Tahoma", Font.BOLD,14));
		panal.add(label8);
		
		JButton back = new JButton("Back");
		back.setBounds(450, 500, 120, 30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		panal.add(back);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		setUndecorated(true);
		setSize(900,600);
		setLayout(null);
		setLocation(430,100);
		setVisible(true);
		
	}

	
	
	
	
	public static void main(String[] args) {
		new All_Patient_Info();
	}

}
