package page1;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;

public class Graphe extends JFrame {

	private JPanel contentPane;
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement stm=null;

	/**
	 * Launch the application
	 */

	/**
	 * Create the frame.
	 */
	public Graphe( ) {
		setBounds(100, 100, 893, 497);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" Graphe représentant le taux d'absences de chaque matière");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 25));
		lblNewLabel_1.setBackground(Color.GRAY);
		lblNewLabel_1.setBounds(87, 0, 780, 53);
		contentPane.add(lblNewLabel_1);

		
	 
     con=ConnexionSqlServer.connecterBD();
	String query="SELECT  COUNT(*) as nb ,id_matière into temp  from absence group by id_matière\r\n"
			+ "select nb,libelle from  temp inner join matière  \r\n"
			+ "on  matière.id_matière = temp.id_matière "
			+ "drop table temp";
	 try {
		stm=con.prepareStatement(query);
		 this.rs=stm.executeQuery();

		 
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	 int[] t= new int[5];
	 String[] array2=new String[5];
	int  i=-1;
	 
	 try {
		while(rs.next()) {
			i++;
          t[i]=rs.getInt(1);
          array2[i]=rs.getString(2);}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 int max =t[0];
     int s=0;
	 for (int j = 0; j < t.length; j++) {
	     if (t[j] > max) {
	         max = t[j];
	     }
	     s+=t[j];
	     
	 }

	 JLabel[] array1= new JLabel[5];
	   for(int f=0;f<5;f++)
	   {     array1[f]=new JLabel(array2[f]+" \n"+100*t[f]/s+"%");
	         array1[f].setForeground(new Color(255, 255, 255));
	         array1[f].setFont(new Font("Tahoma", Font.PLAIN, 12));
	   contentPane.add(array1[f]);
		    array1[f].setBounds(40+f*160, 497-(int)(450*t[f]/max),140,(int)(450*t[f]/max));
		   array1[f].setBackground(new Color(0, 0, 0));
		  array1[f].setOpaque(true);
	
	   }
	   
	 
	     
   }
}
