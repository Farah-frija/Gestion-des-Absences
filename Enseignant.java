package page1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class Enseignant extends JFrame {

	private JPanel contentPane;
	private JTextField numseance;
	private JTextField idet;
	private JTextField idenseign;
	private JTextField textField_3;
	private JTextField date;
	
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement stm=null;
	private JTable table1;
	private JTextField txtRecherche;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Enseignant() {
		setBounds(100, 100, 1019, 601);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		panel.setBackground(new Color(204, 255, 204));
		panel.setBounds(44, 11, 884, 42);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("                                        Gestion des absences");
		lblNewLabel_1.setBounds(-90, -14, 889, 66);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 32));
		lblNewLabel_1.setBackground(new Color(204, 255, 204));
		
		JLabel idetudiant = new JLabel("Id etudiant:");
		idetudiant.setForeground(new Color(0, 0, 0));
		idetudiant.setFont(new Font("Tahoma", Font.PLAIN, 12));
		idetudiant.setBounds(237, 144, 167, 20);
		contentPane.add(idetudiant);
		
		JLabel idenseignat = new JLabel("Id enseigant:");
		idenseignat.setForeground(new Color(0, 0, 0));
		idenseignat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		idenseignat.setBounds(65, 208, 167, 30);
		contentPane.add(idenseignat);
		
		JLabel idmatiere = new JLabel("Id matiére:");
		idmatiere.setForeground(new Color(0, 0, 0));
		idmatiere.setFont(new Font("Tahoma", Font.PLAIN, 12));
		idmatiere.setBounds(237, 208, 167, 30);
		contentPane.add(idmatiere);
		
		numseance = new JTextField();
		numseance.setBackground(SystemColor.controlHighlight);
		numseance.setBounds(55, 174, 155, 30);
		contentPane.add(numseance);
		numseance.setColumns(10);
		
		idet = new JTextField();
		idet.setForeground(Color.BLACK);
		idet.setBackground(SystemColor.controlHighlight);
		idet.setColumns(10);
		idet.setBounds(234, 175, 155, 30);
		contentPane.add(idet);
		
		idenseign = new JTextField();
		idenseign.setBackground(SystemColor.control);
		idenseign.setColumns(10);
		idenseign.setBounds(55, 233, 155, 30);
		contentPane.add(idenseign);
		
		textField_3 = new JTextField();
		textField_3.setBackground(SystemColor.control);
		textField_3.setColumns(10);
		textField_3.setBounds(234, 234, 155, 29);
		contentPane.add(textField_3);
		//// le bouton d'ajout ////
		JButton ajout = new JButton("Ajouter");
		ajout.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				        String Numséance=numseance.getText().toString();
				        String idetud=idet.getText().toString();
				        String idenseigant=idenseign.getText().toString();
				        String dat=new String(date.getText().toString());
				        String idmat=textField_3.getText().toString();
				        String sql="insert into absence (numseance,la_date,id_etudiant,id_enseignant,id_matière) values (?,?,?,?,?) ";
				        try { con=ConnexionSqlServer.connecterBD();
							stm=con.prepareStatement(sql);
							stm.setString(1, Numséance);
							stm.setString(2, dat);
							stm.setString(3, idetud);
							stm.setString(4, idenseigant);
							stm.setString(5, idmat);
							stm.execute();
							if(!Numséance.equals("") &&  !idetud.equals("") && !idenseigant.equals("") && !dat.equals("") && !idmat.equals(""))
							{
								 JOptionPane.showMessageDialog(null, "Absence ajouté");
								 
							}
							else
								 JOptionPane.showMessageDialog(null, "vous avez oublié de remplir un champs!");
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							 JOptionPane.showMessageDialog(null, "l'id entré n'appartient à aucun élèment");
						}
				        
			}
			});
		ajout.setForeground(SystemColor.textInactiveText);
		ajout.setBackground(SystemColor.textHighlightText);
		ajout.setBounds(250, 297, 129, 30);
		contentPane.add(ajout);
		
		JLabel lblNewLabel = new JLabel("Num séance:");
		lblNewLabel.setBounds(65, 146, 80, 17);
		contentPane.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblDateSance = new JLabel("Date séance:\r\n");
		lblDateSance.setBounds(65, 274, 167, 17);
		contentPane.add(lblDateSance);
		lblDateSance.setForeground(new Color(0, 0, 0));
		lblDateSance.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		date = new JTextField();
		date.setBackground(SystemColor.control);
		date.setColumns(10);
		date.setBounds(55, 302, 155, 30);
		contentPane.add(date);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(505, 147, 404, 405);
		contentPane.add(scrollPane);
		
		table1 = new JTable();
		table1.setBorder(new LineBorder(new Color(78, 46, 103)));
		table1.setEnabled(false);
		table1.setBackground(Color.LIGHT_GRAY);
		table1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Num s\u00E9ance", "date", "id \u00E9tudiant", "id enseignant", "id mati\u00E9re"
			}
		));
		scrollPane.setViewportView(table1);
		
		JButton refresh = new JButton("actualiser");
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					updateTable("select * from absence");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}});
		refresh.setIcon(null);
		refresh.setBounds(65, 511, 309, 27);
		contentPane.add(refresh);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"choisissez", "date", "Num séance", "id étudiant", "id enseignant", "id matière"}));
		comboBox.setBounds(171, 370, 105, 27);
		contentPane.add(comboBox);
	
		
		JButton recherche = new JButton("recherche");
		recherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql=null;
				String text=comboBox .getSelectedItem().toString();

				 con=ConnexionSqlServer.connecterBD();
					 
				try {
				if(text=="date")
					   sql="select * from absence WHERE la_date=?";
				else if(text=="Num séance")
					   sql="select * from absence WHERE numseance=?";
				else if(text=="id étudiant")
					   sql="select * from absence WHERE id_etudiant=?";
				else if(text=="id enseignant")
					   sql="select * from absence WHERE id_enseignant=?";
				else if (text=="id matière")
					   sql="select * from absence WHERE id_matière=?";
				else
					JOptionPane.showMessageDialog(null, "Introuvable");

				
				 stm=con.prepareStatement(sql);
				 stm.setString(1,txtRecherche.getText().toString());
					rs=stm.executeQuery();
				 }catch(Exception f){
					 JOptionPane.showMessageDialog(null, f.getMessage());
				 }
						
				 
			     DefaultTableModel dtm=new DefaultTableModel();
			     String colonne[]= {"numero_séance","Date","idetudiant","idenseignant","idmatiére"};
			      for(int i=0;i<colonne.length;i++)
			      {
			    	  dtm.addColumn(colonne[i]);
			    	  
			      }
			      try {
			    	  while(rs.next()) {
			    		 String numero_séance=rs.getInt(1)+"";
			    		 String Date =rs.getString(2);
			    		 String idetudiant=rs.getInt(3)+"";
			    		 String idenseignant=rs.getInt(4)+"";
			    		 String idmatiére=rs.getInt(5)+"";
			    		 String entree[]= {numero_séance,Date,idetudiant,idenseignant,idmatiére};
			    		 dtm.addRow(entree);
			    		 
			    		 
			    		  
			    	  }
			    	  table1.setModel(dtm);
			}
			catch(Exception f){
				 JOptionPane.showMessageDialog(null, f.getMessage());
			}
				
				
					
			
				
			}});
		recherche.setIcon(null);
		recherche.setBounds(171, 447, 105, 27);
		contentPane.add(recherche);
		
		txtRecherche = new JTextField();
		txtRecherche.setForeground(new Color(51, 51, 51));
		txtRecherche.setText("  chercher");
		txtRecherche.setBackground(new Color(204, 204, 204));
		txtRecherche.setBounds(135, 409, 194, 27);
		contentPane.add(txtRecherche);
		txtRecherche.setColumns(10);
		
	}
		
		public  void updateTable( String sql) throws SQLException

		
		{
		
			
				 con=ConnexionSqlServer.connecterBD();
					stm=con.prepareStatement(sql);
					rs=stm.executeQuery();
			     DefaultTableModel dtm=new DefaultTableModel();
			     String colonne[]= {"numero_séance","Date","idetudiant","idenseignant","idmatiére"};
			      for(int i=0;i<colonne.length;i++)
			      {
			    	  dtm.addColumn(colonne[i]);
			    	  
			      }
			      try {
			    	  while(rs.next()) {
			    		 String numero_séance=rs.getInt(1)+"";
			    		 String Date =rs.getString(2);
			    		 String idetudiant=rs.getString(3);
			    		 String idenseignant=rs.getString(4);
			    		 String idmatiére=rs.getString(5);
			    		 String entree[]= {numero_séance,Date,idetudiant,idenseignant,idmatiére};
			    		 dtm.addRow(entree);
			    		 
			    		 
			    		  
			    	  }
			    	  table1.setModel(dtm);
			}
			catch(Exception e){
				 JOptionPane.showMessageDialog(null, "Erreur");
			}
				

	}
}

