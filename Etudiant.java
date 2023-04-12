package page1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Etudiant extends JFrame {

	private JPanel contentPane;
	
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement stm=null;
	private JTable table1;
	private JTextField txtRecherche;

	public Etudiant() {
			setBounds(100, 100, 1019, 601);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(102, 153, 102));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(276, 146, 410, 243);
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
			
			JButton refresh = new JButton("actualiser\r\n");
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
			refresh.setBounds(304, 89, 335, 27);
			contentPane.add(refresh);
			
			final JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"choisissez", "date", "Num séance", "id étudiant", "id enseignant", "id matière"}));
			comboBox.setBounds(276, 412, 109, 27);
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
			recherche.setBounds(582, 412, 104, 27);
			contentPane.add(recherche);
			
			txtRecherche = new JTextField();
			txtRecherche.setForeground(Color.LIGHT_GRAY);
			txtRecherche.setText("  chercher");
			txtRecherche.setBackground(new Color(204, 255, 204));
			txtRecherche.setBounds(420, 412, 141, 27);
			contentPane.add(txtRecherche);
			txtRecherche.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("                                        Gestion des absences");
			lblNewLabel_1.setForeground(Color.BLACK);
			lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 32));
			lblNewLabel_1.setBackground(new Color(204, 255, 204));
			lblNewLabel_1.setBounds(-53, 0, 889, 66);
			contentPane.add(lblNewLabel_1);
			
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

