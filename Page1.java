package page1;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.sql.*;

public class Page1  {

	JFrame frame;
	private JTextField txtEntrezTexte;
	private JPasswordField passwordField;
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement stm=null;
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Page1() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 153, 102));
		frame.setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 920, 546);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(SystemColor.controlDkShadow, 0, true));
		panel_5.setBackground(new Color(102, 153, 102));
		panel_5.setBounds(29, 405, 840, 60);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(308, 97, 313, 284);
		frame.getContentPane().add(panel_4);
		panel_4.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		panel_4.setBackground(new Color(102, 153, 102));
		panel_4.setLayout(null);
		
		
		///////////// bouton texte identifiant///////////////////
		JLabel lblNewLabel_2 = new JLabel("Identifiant\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(117, 30, 110, 29);
		panel_4.add(lblNewLabel_2);
		///////////// bouton identifiant ////////////////////
		txtEntrezTexte = new JTextField();
		txtEntrezTexte.setText("Entrez texte");
		txtEntrezTexte.setBackground(new Color(234, 232, 238));
		txtEntrezTexte.setForeground(Color.BLACK);
		txtEntrezTexte.setBounds(79, 70, 167, 35);
		panel_4.add(txtEntrezTexte);
		txtEntrezTexte.setColumns(10);
		
		
		
		
		///////////////texte mot de passe////////////////////
		JLabel lblNewLabel_2_1 = new JLabel("Mot de passe\r\n");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(117, 116, 99, 29);
		panel_4.add(lblNewLabel_2_1);
		//////////////////////bouton mot de passe/////////////////////
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Entrez mdp");
		passwordField.setBackground(SystemColor.controlHighlight);
		passwordField.setBounds(79, 146, 167, 29);
		panel_4.add(passwordField);
	    //////////// choix personne /////////////
				final JComboBox choisirpersonne = new JComboBox();
				choisirpersonne.setBounds(105, 215, 122, 20);
				panel_4.add(choisirpersonne);
				choisirpersonne.setBackground(UIManager.getColor("activeCaptionBorder"));
				choisirpersonne.setFont(new Font("Tahoma", Font.PLAIN, 13));
				choisirpersonne.setMaximumRowCount(4);
				choisirpersonne.setToolTipText("");
				choisirpersonne.setSelectedItem("selectionnez une option");
				choisirpersonne.addItem("Administrateur");
				choisirpersonne.addItem("Enseigant");
				choisirpersonne.addItem("Etudiant");
			
			JLabel lblNewLabel = new JLabel("                                        Gestion des absences");
			lblNewLabel.setBounds(-47, 11, 1023, 64);
			frame.getContentPane().add(lblNewLabel);
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setBackground(Color.GRAY);
			lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 32));
		
		
		//bouton de connexion
		final JButton connexion = new JButton("Se connecter");
		connexion.setBounds(91, 250, 155, 23);
		panel_4.add(connexion);
		//back bouton
		connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				
			
			  con=ConnexionSqlServer.connecterBD();
			
				
				  if(choisirpersonne.getSelectedItem().toString()=="Administrateur")
					   
						{
						
					
								
					
								String query= "SELECT * FROM Responsable WHERE login=? and pwd=? ";
								 stm=con.prepareStatement(query);
								 stm.setString(1, txtEntrezTexte.getText());
								   String s= new  String(passwordField.getPassword());
								 stm.setString(2, s);
								 ResultSet rs=stm.executeQuery();
								 if(rs.next())
								 {
									 JOptionPane.showMessageDialog(connexion,"Vous pouvez accédez à votre compte en tant que Administrateur "+rs.getString("login") );
									  Admin a=new Admin();
									  a.setVisible(true);
									
									  
									  
								 }
								 else
									 JOptionPane.showMessageDialog(connexion,"échec de connexion \n vérifiez le login ou le mot de passe entré "  ); 
								 
							
						
						 
						
					
					}
				  else if(choisirpersonne.getSelectedItem().toString()=="Enseigant")
				  {
						
							
							
				
							String query= "SELECT * FROM enseignant WHERE login=? and pwd=? ";
							 PreparedStatement pst=con.prepareStatement(query);
							 pst.setString(1, txtEntrezTexte.getText());
							   String s= new  String(passwordField.getPassword());
							 pst.setString(2, s);
							 ResultSet rs=pst.executeQuery();
							 if(rs.next())
							 {
								 JOptionPane.showMessageDialog(connexion,"Vous pouvez accédez à votre compte en tant que Enseigant "+rs.getString("login") );
								  Enseignant ens1=new Enseignant();
								  ens1.setVisible(true);
								
								  
								  
							 }
							 else
								 JOptionPane.showMessageDialog(connexion,"échec de connexion \n vérifiez le login ou le mot de passe entré"  ); 
							 
							 
						
				  }
				  else
				  {
					 
						
							
				
							String query= "SELECT * FROM Etudiant WHERE login=? and pwd=? ";
							 PreparedStatement pst=con.prepareStatement(query);
							 pst.setString(1, txtEntrezTexte.getText());
							   String s= new  String(passwordField.getPassword());
							 pst.setString(2, s);
							 ResultSet rs=pst.executeQuery();
							 if(rs.next())
							 {
								 JOptionPane.showMessageDialog(connexion,"Vous pouvez accédez à votre compte en tant que Etudiant "+rs.getString("login") );
								  Etudiant t=new Etudiant();
								  t.setVisible(true);
								
								  
								  
							 }
							 else
								 JOptionPane.showMessageDialog(connexion,"échec de connexion \n vérifiez le login ou le mot de passe entré"  ); 
							 
							 
						
				  }
				}
			
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}});
		
		
		connexion.setForeground(Color.DARK_GRAY);
		connexion.setBackground(SystemColor.scrollbar);
		connexion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		/////////////////////////////////////////////////////////////////////////////////////
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Vous vous connectez en tant que");
		lblNewLabel_1.setBounds(53, 186, 216, 18);
		panel_4.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(Color.GRAY);
		lblNewLabel_1.setForeground(SystemColor.desktop);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		/////////////////////////////////////////////////////////////////////////////////////////////////////
	  
		
		
	
		
	}
}
