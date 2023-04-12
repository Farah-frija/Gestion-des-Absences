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


public class Adminannuler extends JFrame {

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
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Adminannuler() {
		setBounds(100, 100, 1019, 601);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idetudiant = new JLabel("Id etudiant:");
		idetudiant.setForeground(new Color(0, 0, 0));
		idetudiant.setFont(new Font("Tahoma", Font.PLAIN, 12));
		idetudiant.setBounds(237, 144, 167, 20);
		contentPane.add(idetudiant);
		
		JLabel idenseignat = new JLabel("Id enseigant:");
		idenseignat.setForeground(new Color(0, 0, 0));
		idenseignat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		idenseignat.setBounds(65, 203, 167, 30);
		contentPane.add(idenseignat);
		
		JLabel idmatiere = new JLabel("Id matiére:");
		idmatiere.setForeground(new Color(0, 0, 0));
		idmatiere.setFont(new Font("Tahoma", Font.PLAIN, 12));
		idmatiere.setBounds(242, 203, 167, 30);
		contentPane.add(idmatiere);
		
		numseance = new JTextField();
		numseance.setBackground(SystemColor.controlHighlight);
		numseance.setBounds(55, 174, 157, 30);
		contentPane.add(numseance);
		numseance.setColumns(10);
		
		idet = new JTextField();
		idet.setForeground(Color.BLACK);
		idet.setBackground(SystemColor.controlHighlight);
		idet.setColumns(10);
		idet.setBounds(237, 174, 157, 30);
		contentPane.add(idet);
		
		idenseign = new JTextField();
		idenseign.setBackground(SystemColor.control);
		idenseign.setColumns(10);
		idenseign.setBounds(55, 231, 157, 36);
		contentPane.add(idenseign);
		
		textField_3 = new JTextField();
		textField_3.setBackground(SystemColor.control);
		textField_3.setColumns(10);
		textField_3.setBounds(237, 235, 157, 29);
		contentPane.add(textField_3);
		//// le bouton d'ajout ////
		JButton supprimer = new JButton("supprimer");
		supprimer.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				        String Numséance=numseance.getText().toString();
				        String idetud=idet.getText().toString();
				        String idenseigant=idenseign.getText().toString();
				        String dat=date.getText().toString();
				        String idmat=textField_3.getText().toString();
				        String sql="delete from  absence where numseance=? and la_date=? and id_etudiant=? and id_enseignant=? and id_matière=?";
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
								 JOptionPane.showMessageDialog(null, "Absence supprimée");
								 
							}
							else
								 JOptionPane.showMessageDialog(null, "vous avez oublié de remplir un champs!");
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							 JOptionPane.showMessageDialog(null, e1.getMessage());
						}
				        
			}
			});
		supprimer.setForeground(SystemColor.textInactiveText);
		supprimer.setBackground(SystemColor.textHighlightText);
		supprimer.setBounds(257, 297, 129, 30);
		contentPane.add(supprimer);
		
		JLabel lblNewLabel = new JLabel("Num séance:");
		lblNewLabel.setBounds(65, 146, 80, 17);
		contentPane.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblDateSance = new JLabel("Date séance:\r\n");
		lblDateSance.setBounds(65, 278, 167, 17);
		contentPane.add(lblDateSance);
		lblDateSance.setForeground(new Color(0, 0, 0));
		lblDateSance.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		date = new JTextField();
		date.setBackground(SystemColor.control);
		date.setColumns(10);
		date.setBounds(55, 297, 157, 30);
		contentPane.add(date);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(439, 147, 470, 405);
		contentPane.add(scrollPane);
		
		table1 = new JTable();
		table1.setBorder(new LineBorder(new Color(78, 46, 103)));
		table1.setEnabled(false);
		table1.setBackground(new Color(255, 255, 255));
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
		refresh.setBounds(498, 106, 319, 30);
		contentPane.add(refresh);
		
		JLabel lblNewLabel_1 = new JLabel("                                        Gestion des absences");
		lblNewLabel_1.setBounds(-40, 23, 889, 61);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 32));
		lblNewLabel_1.setBackground(Color.GRAY);
		
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

