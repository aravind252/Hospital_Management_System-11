package hospital.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;

public class Room extends JFrame{
	
	JTable Table;
	
	
	Room(){
		JPanel Panal =new JPanel();
		Panal.setBounds(5, 5, 890,590);
		Panal.setBackground(new Color(173,216,230));
		Panal.setLayout(null);
		add(Panal);
		
		ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icons/Room.png"));
		Image image = imageicon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon imageicon1 = new ImageIcon(image);
		JLabel Label= new JLabel(imageicon1);
		Label.setBounds(600, 200, 200, 200);
		Panal.add(Label);
		
		Table = new JTable();
		Table.setBounds(10, 40, 500, 400);
		Table.setBackground(new Color(173,216,230));
		Panal.add(Table);
		
		try {
			
			conn c = new conn();
			String q = "select * from Room";
			Resultset resultset = (Resultset) c.statement.executeQuery(q);
			Table.setModel(DbUtils.resultSetToTableModel((ResultSet) resultset));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel label1 = new JLabel("Room No");
		label1.setBounds(12,15,80,15);
		label1.setFont(new Font("Tahoma", Font.BOLD,14));
		Panal.add(label1);
		
		JLabel label2 = new JLabel("Availability");
		label2.setBounds(110,15,80,15);
		label2.setFont(new Font("Tahoma", Font.BOLD,14));
		Panal.add(label2);
		
		
		JLabel label3 = new JLabel("Price");
		label3.setBounds(210,15,80,15);
		label3.setFont(new Font("Tahoma", Font.BOLD,14));
		Panal.add(label3);
		
		
		JLabel label4 = new JLabel("Bed Type");
		label4.setBounds(310,15,80,15);
		label4.setFont(new Font("Tahoma", Font.BOLD,14));
		Panal.add(label4);
		
		JButton back = new JButton("Back");
		back.setBounds(200, 500, 120, 30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		Panal.add(back);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		
		setUndecorated(true);
		setSize(900,600);
		setLayout(null);
		setLocation(300,230);
		setVisible(true);
	}
public static void main(String args[]) {
	new Room(); 
}
}
