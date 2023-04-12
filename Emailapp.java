package page1;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.MessagingException;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import java.util.*;
import javax.mail.*;



public class Emailapp extends JFrame {

	private JPanel contentPane;
	private JTextField msg;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Emailapp() {
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 102));
		panel.setBounds(108, 88, 519, 421);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("EMAIL BOX");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel_2.setBounds(220, 11, 198, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Message");
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(116, 181, 113, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("To");
		lblNewLabel_3_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1.setBounds(83, 56, 113, 14);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("From");
		lblNewLabel_3_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_2.setBounds(71, 99, 113, 14);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Subject");
		lblNewLabel_3_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_3.setBounds(60, 148, 113, 14);
		panel.add(lblNewLabel_3_3);
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(116, 206, 320, 170);
		panel.add(scrollPane);
		
		msg = new JTextField();
		scrollPane.setViewportView(msg);
		msg.setColumns(10);
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tomail=to.getText();
				final String frommail=from.getText().toString();
				final String password="lrnftnmtogrpxuex";
				String subjects=subject.getText();
				Properties properties=new Properties();
				properties.put("mail.smtp.auth", "true");
				properties.put("mail.smtp.ssl.enable", "true");
				properties.put("mail.smtp.host", "smtp.gmail.com");
				properties.put("mail.smtp.socketFactory.port", "465");
				properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				properties.put("mail.smtp.port", "465");
				Session session= Session.getDefaultInstance(properties, new javax.mail.Authenticator()
						{
					protected PasswordAuthentication getPasswordAuthentication() {
						
						return new PasswordAuthentication(frommail, password);
						
					}
					
				
			
		});
				
				try {Message message=new MimeMessage(session);
					message.setFrom(new InternetAddress(frommail));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(tomail));
					message.setSubject(subjects);
					message.setText(msg.getText());
					Transport.send(message);
					 JOptionPane.showMessageDialog(null, "envoyé!");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					 JOptionPane.showMessageDialog(null, e1.getMessage());
				} 
				
				}});
		
		btnNewButton.setForeground(SystemColor.window);
		btnNewButton.setBackground(new Color(9, 3, 99));
		btnNewButton.setBounds(220, 387, 89, 23);
		panel.add(btnNewButton);
	}
}
