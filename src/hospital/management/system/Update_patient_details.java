package hospital.management.system;

import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Update_patient_details extends JFrame {
	
	Update_patient_details(){
		
		JPanel panal = new JPanel();
		panal.setBounds(5,5,940,490);
		panal.setBackground(new Color(173,216,230));
		panal.setLayout(null);
		add(panal);
		
		ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/Update.png"));
		Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
		ImageIcon imagIcon1 = new ImageIcon(image);
		JLabel label = new JLabel(imagIcon1);
		label.setBounds(500,60,300,300);
		panal.add(label);
		
		JLabel label1 = new JLabel("Update Patient Details");
		label1.setBounds(124,11,246,25);
		label1.setFont(new Font("Tahoma", Font.BOLD,20));
		label1.setForeground(Color.black);
		panal.add(label1);
		
		JLabel label2 = new JLabel("Name");
		label2.setBounds(25,88,136,14);
		label2.setFont(new Font("Tahoma", Font.BOLD,14));
		label2.setForeground(Color.black);
		panal.add(label2);
		
		Choice choice = new Choice();
		choice.setBounds(248,85,150,25);
		panal.add(choice);
		
		try {
			
			conn c = new conn();
			ResultSet resultSet= c.statement.executeQuery("select * from patent_info");
			while (resultSet.next()) {
				choice.add(resultSet.getString("Name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel label3 = new JLabel("Room Number");
		label3.setBounds(25,129,150,14);
		label3.setFont(new Font("Tahoma", Font.BOLD,14));
		label3.setForeground(Color.black);
		panal.add(label3);
		
		JTextField textFieldR = new JTextField();
		textFieldR.setBounds(248,129,140,20);
		panal.add(textFieldR);
		
		JLabel label4 = new JLabel("IN-Time");
		label4.setBounds(25,174,100,14);
		label4.setFont(new Font("Tahoma", Font.BOLD,14));
		label4.setForeground(Color.black);
		panal.add(label4);
		
		JTextField textFieldINT = new JTextField();
		textFieldINT.setBounds(248,174,140,20);
		panal.add(textFieldINT);
		
		JLabel label5 = new JLabel("Amount Paid(Rs)");
		label5.setBounds(25,216,150,14);
		label5.setFont(new Font("Tahoma", Font.BOLD,14));
		label5.setForeground(Color.black);
		panal.add(label5);
		
		JTextField textFieldAmount = new JTextField();
		textFieldAmount.setBounds(248,216,140,20);
		panal.add(textFieldAmount);
		
		JLabel label6 = new JLabel("Pending Amount(Rs)");
		label6.setBounds(25,261,150,14);
		label6.setFont(new Font("Tahoma", Font.BOLD,14));
		label6.setForeground(Color.black);
		panal.add(label6);
		
		JTextField textFieldPending = new JTextField();
		textFieldPending.setBounds(248,261,140,20);
		panal.add(textFieldPending);
		
		JButton check = new JButton("CHECK");
		check.setBounds(281,378,89,23);
		check.setBackground(Color.black);
		check.setForeground(Color.white);
		panal.add(check);
		check.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = choice.getSelectedItem();
				String q = "select * from patent_info where Name= '"+id+"'";
				try {
					
					conn c = new conn();
					ResultSet resultSet = c.statement.executeQuery(q);
					while (resultSet.next()) {
						textFieldR.setText(resultSet.getString("room_number"));
						textFieldINT.setText(resultSet.getString("Time"));
						textFieldAmount.setText(resultSet.getString("Depsoit"));
						
					}
					ResultSet resultSet1 = c.statement.executeQuery("select * from room where room_number = '"+textFieldR.getText()+"'");
					while (resultSet1.next()) {
					    String price = resultSet1.getString("price");
					    int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
					    textFieldPending.setText("" + amountPaid);
					
						
						
						
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		JButton update = new JButton("UPDATE");
		update.setBounds(56,378,89,23);
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		panal.add(update);
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					try {
					    conn c = new conn();

					    // Step 1: Get data from UI fields
					    String q = choice.getSelectedItem();  // selected patient name
					    String room = textFieldR.getText();   // entered room number
					    String time = textFieldINT.getText(); // entered time
					    String newDepositStr = textFieldAmount.getText(); // entered deposit

					    // Step 2: Convert to integer
					    int newDeposit = Integer.parseInt(newDepositStr);

					    // Step 3: Fetch old deposit value (from column 'Depsoit')
					    ResultSet rs = c.statement.executeQuery("SELECT Depsoit FROM patent_info WHERE name = '"+q+"'");
					    int totalDeposit = 0;
					    if (rs.next()) {
					        totalDeposit = rs.getInt("Depsoit");
					    }

					    // Step 4: Add old + new deposit
					    int updatedDeposit = totalDeposit + newDeposit;

					    // Step 5: Update the 'patent_info' table
					    String query = "UPDATE patent_info SET Room_number = '"+room+"', time = '"+time+"', Depsoit = '"+updatedDeposit+"' WHERE name = '"+q+"'";
					    c.statement.executeUpdate(query);

					    // Step 6: Get room price from room table
					    ResultSet resultSet1 = c.statement.executeQuery("SELECT price FROM room WHERE room_number = '"+room+"'");
					    int price = 0;
					    if (resultSet1.next()) {
					        price = resultSet1.getInt("price");
					    }

					    // Step 7: Calculate pending = price - deposit
					    int pending = price - updatedDeposit;

					    // Step 8: Show pending in UI
					    textFieldPending.setText("" + pending);

					    // Step 9: Confirmation
					    JOptionPane.showMessageDialog(null, "Updated Successfully");
					    c.statement.executeUpdate("UPDATE room SET Avaliability = 'Availabil' WHERE room_number = '" + room + "'");

					    setVisible(false);

					} catch (Exception e2) {
					    e2.printStackTrace();
					}

					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		
		
		JButton Back = new JButton("BACK");
		Back.setBounds(168,378,89,23);
		Back.setBackground(Color.black);
		Back.setForeground(Color.white);
		panal.add(Back);
		Back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		setUndecorated(true);
		setSize(950,500);
		setLayout(null);
		setLocation(400,250);
		setVisible(true);
		
		
	}

	public static void main(String[] args) {
	new Update_patient_details();

	}

}
