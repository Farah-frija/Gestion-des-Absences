package page1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class Imprimer extends JFrame {

	private JPanel contentPane;
	public Imprimer() {
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\21627\\Desktop\\Farah Frija Lcs2\\imrimente.PNG"));
		btnNewButton.setBounds(260, 130, 205, 184);
		getContentPane().add(btnNewButton);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		 String text = "This is the text that will be written to the file";
	        
	        try {
	            // File path on the desktop
	            File file = new File(System.getProperty("user.home") + "/Desktop/textfile.txt");
	            
	            // Create the file if it doesn't exist
	            if (!file.exists()) {
	                file.createNewFile();
	            }
	            
	            // Writing the text to the file
	            FileWriter fw = new FileWriter(file.getAbsoluteFile());
	            BufferedWriter bw = new BufferedWriter(fw);
	            bw.write(text);
	            bw.close();
	            
	            System.out.println("Text written to file successfully!");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        }
	}


