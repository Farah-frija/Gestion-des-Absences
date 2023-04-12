package page1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Admin extends JFrame {

	private JPanel contentPane;


	/**

	/**
	 * Create the frame.
	 */
	public Admin() {
		setBounds(100, 100, 764, 517);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		panel.setBackground(new Color(204, 255, 204));
		panel.setBounds(10, 0, 728, 83);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("                                        Gestion des absences");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 32));
		lblNewLabel_1.setBackground(Color.GRAY);
		lblNewLabel_1.setBounds(-161, 11, 889, 61);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(UIManager.getColor("textHighlight")));
		panel_1.setBackground(new Color(102, 153, 102));
		panel_1.setBounds(103, 112, 541, 332);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton consulter = new JButton("Consulter absences");
		consulter.setForeground(UIManager.getColor("CheckBox.focus"));
		consulter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		consulter.setBackground(UIManager.getColor("TextArea.inactiveBackground"));
		consulter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   Etudiant etd=new Etudiant();
				   etd.setVisible(true);
			}
		});
		consulter.setBounds(172, 135, 211, 74);
		panel_1.add(consulter);
		
		JButton graphe = new JButton("Générer Graphes");
		graphe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Graphe gr=new Graphe();
				 gr.setVisible(true);
			}
		});
		graphe.setForeground(UIManager.getColor("CheckBox.focus"));
		graphe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		graphe.setBackground(UIManager.getColor("TextArea.inactiveBackground"));
		graphe.setBounds(172, 227, 211, 75);
		panel_1.add(graphe);
		
		JButton annuler = new JButton("Anuuler absence");
		annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Adminannuler ad=new Adminannuler();
				  ad.setVisible(true);
			}
		});
		
		annuler.setForeground(UIManager.getColor("CheckBox.focus"));
		annuler.setFont(new Font("Tahoma", Font.PLAIN, 15));
		annuler.setBackground(UIManager.getColor("TextPane.inactiveBackground"));
		annuler.setBounds(172, 43, 211, 71);
		panel_1.add(annuler);
		
		JLabel lblNewLabel = new JLabel("Faculté des sciences de Tunis");
		lblNewLabel.setForeground(SystemColor.inactiveCaptionText);
		lblNewLabel.setBounds(495, 464, 203, 14);
		contentPane.add(lblNewLabel);
	}

}
