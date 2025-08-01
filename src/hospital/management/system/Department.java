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

public class Department extends JFrame {
    
        Department() {
		
		JPanel panal = new JPanel();
		panal.setBounds(5,5,690,490);
		panal.setLayout(null);
		panal.setBackground(new Color(173,216,230));
		add(panal);
		
		JTable table = new JTable();
		table.setBounds(0,40,700,350);
		table.setBackground(new Color(173,216,230));
		table.setFont(new Font("Tahoma", Font.BOLD,14));
		panal.add(table);
		
		
		try {
			conn c= new conn();
			String q = "select * from department";
			ResultSet resultset = c.statement.executeQuery(q);
			table.setModel(DbUtils.resultSetToTableModel(resultset));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel label1 =new JLabel("Department");
		label1.setBounds(250,15,118,15);
		label1.setFont(new Font("Tahoma", Font.BOLD,14));
		panal.add(label1);
		
		JLabel label2 =new JLabel("Phone.NO");
		label2.setBounds(470,15,118,15);
		label2.setFont(new Font("Tahoma", Font.BOLD,14));
		panal.add(label2);
		
		JButton back = new JButton("BACK");
		back.setBounds(400, 410, 130, 30);
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
		setSize(700,500);
		setLayout(null);
		setLocation(350,250);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Department();

	}

}
