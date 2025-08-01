package hospital.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputFilter.Status;
import java.sql.ResultSet;
import java.util.stream.StreamSupport;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Search_room extends JFrame{
	
	Choice choice;
	JTable table;

	Search_room(){
		
		JPanel Panal =new JPanel();
		Panal.setBounds(5, 5, 690,490);
		Panal.setBackground(new Color(173,216,230));
		Panal.setLayout(null);
		add(Panal);
		
		JLabel For = new JLabel("Search For Room");
		For.setBounds(250,11,186,31);
		For.setForeground(Color.black);
		For.setFont(new Font("Tahoma", Font.BOLD,20));
		Panal.add(For);
		
		
		JLabel Status = new JLabel("Status");
		Status.setBounds(70,70,80,20);
		Status.setForeground(Color.black);
		Status.setFont(new Font("Tahoma", Font.BOLD,14));
		Panal.add(Status);
		
		choice= new Choice();
		choice.setBounds(170,70,120,20);
		choice.add("Availabil");
		choice.add("Occupied");
		Panal.add(choice);
		
		
		table = new JTable();
		table.setBounds(0,187,700,210);
		table.setBackground(new Color(173,216,230));
		table.setForeground(Color.black);
		Panal.add(table);
		
		
		try {
			
			
			conn c = new conn();
			String q = "select * from room";
			ResultSet resultSet=c.statement.executeQuery(q);
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		JLabel RoomNo = new JLabel("RoomNo");
		RoomNo.setBounds(23,162,150,20);
		RoomNo.setForeground(Color.black);
		RoomNo.setFont(new Font("Tahoma", Font.BOLD,14));
		Panal.add(RoomNo);
		
		JLabel avaliable = new JLabel("Availability");
		avaliable.setBounds(175,162,150,20);
		avaliable.setForeground(Color.black);
		avaliable.setFont(new Font("Tahoma", Font.BOLD,14));
		Panal.add(avaliable);
		
		JLabel price = new JLabel("Price");
		price.setBounds(458,162,150,20);
		price.setForeground(Color.black);
		price.setFont(new Font("Tahoma", Font.BOLD,14));
		Panal.add(price);
		
		JLabel BED = new JLabel("Bed Type");
		BED.setBounds(580,162,150,20);
		BED.setForeground(Color.black);
		BED.setFont(new Font("Tahoma", Font.BOLD,14));
		Panal.add(BED);
		
		
		JButton search = new JButton("Search");
		search.setBounds(200,420,120,25);
		search.setBackground(Color.black);
		search.setForeground(Color.white);
		Panal.add(search);
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String q = "select * from room where Avaliability = '" + choice.getSelectedItem() + "'";

				try {
					
					conn c = new conn();
					ResultSet resultSet = c.statement.executeQuery(q);
					table.setModel(DbUtils.resultSetToTableModel(resultSet));
					
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		
		
		JButton back = new JButton("Back");
		back.setBounds(380,420,120,25);
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
		setSize(700,500);
		setLayout(null);
		setLocation(450,250);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Search_room();

	}

}
