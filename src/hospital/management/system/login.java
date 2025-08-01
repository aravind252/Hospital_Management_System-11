package hospital.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.classfile.Attribute;
import java.sql.ResultSet;
import java.text.AttributedString;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class login extends JFrame implements ActionListener 
{
	
	JTextField textField;
	JPasswordField jPasswordField;
	JButton b1,b2;
	
	
	login()
	{
		
		JLabel namelabel = new JLabel("Username");
		namelabel.setBounds(40,20, 100, 30);
		namelabel.setFont(new Font("Tahoma", Font.BOLD,16));
		namelabel.setForeground(Color.black);
		add(namelabel);
		
		JLabel password = new JLabel("password");
		password.setBounds(40,70, 100, 30);
		password.setFont(new Font("Tahoma", Font.BOLD,16));
		password.setForeground(Color.black);
		add(password);
		
		textField = new JTextField();
		textField.setBounds(150, 20, 150, 30);
		textField.setFont(new Font("Tahoma", Font.PLAIN,15));
		textField.setBackground(Color.white);
		add(textField);
		
		jPasswordField = new JPasswordField();
		jPasswordField.setBounds(150, 70, 150, 30);
		jPasswordField.setFont(new Font("Tahoma", Font.PLAIN,15));
		jPasswordField.setBackground(Color.white);
		add(jPasswordField);
		
		ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/arav.png"));
		Image i1 = imageIcon.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
		ImageIcon imageIcon1 = new ImageIcon(i1);
		JLabel label = new JLabel(imageIcon1);
		label.setBounds(320,30, 400, 300);
		add(label);
		
		b1 = new JButton("login");
		b1.setBounds(40, 140,120,30);
		b1.setFont(new Font("serif", Font.BOLD,15));
		b1.setBackground(Color.white);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBounds(180, 140,120,30);
		b2.setFont(new Font("serif", Font.BOLD,15));
		b2.setBackground(Color.white);
		b2.addActionListener(this);
		add(b2);
		
		
		getContentPane().setBackground(new Color(173,216,230));
		setSize(900,400);
		setLocation(400,300);
		setLayout(null);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b1) {
			try {
				
				conn c= new conn();
				String user = textField.getText();
				String Pass = jPasswordField.getText();
				
				String q = "select * from login where ID = '"+user+"' AND  PW='"+Pass+"'";
				ResultSet resultSet= c.statement.executeQuery(q);
				
				if (resultSet.next()) {
					new Reception();
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null,"Invalid");
				}
				
				
			}catch(Exception E) {
				E.printStackTrace();
			}
		}else {
			System.exit(10);
		}
	}
	
	
	
	
	public static void main(String[] args)
	{
	
		new login();
	}

}
