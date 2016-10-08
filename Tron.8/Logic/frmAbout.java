package Logic;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class frmAbout extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel Linfo1,Linfo2,Linfo3,Linfo4;
	JLabel Linfo5,Linfo6,Linfo7,Linfo8,Linfo9;
	JButton btnBack;
	JPanel contentpane;
	
	public frmAbout(){
		contentpane = new JPanel(); 
		setContentPane(contentpane);
        contentpane.setLayout(null);
        contentpane.setBackground(Color.DARK_GRAY);
		
		btnBack = new JButton();
		btnBack.setText("Back");
		btnBack.setBounds(270, 370, 100, 25);
		btnBack.addActionListener(this);
		add(btnBack);
		
		Linfo1 = new JLabel();
		Linfo1.setText("I.T.C.R.");
		Linfo1.setFont(new Font("Verdana", Font.BOLD, 16));
		Linfo1.setForeground(Color.CYAN); 
		Linfo1.setBounds(10, 10, 350, 25);
		add(Linfo1);
		
		Linfo2 = new JLabel();
		Linfo2.setText("Computer Engineering");
		Linfo2.setFont(new Font("Verdana", Font.BOLD, 16));
		Linfo2.setForeground(Color.CYAN); 
		Linfo2.setBounds(10, 40, 350, 25);
		add(Linfo2);
		
		Linfo3 = new JLabel();
		Linfo3.setText("CE-1103.");
		Linfo3.setFont(new Font("Verdana", Font.BOLD, 16));
		Linfo3.setForeground(Color.CYAN); 
		Linfo3.setBounds(10, 70, 150, 25);
		add(Linfo3);
		
		Linfo4 = new JLabel();
		Linfo4.setText("Teacher: Isaac Ramírez.");
		Linfo4.setFont(new Font("Verdana", Font.BOLD, 16));
		Linfo4.setForeground(Color.CYAN); 
		Linfo4.setBounds(10, 100, 350, 25);
		add(Linfo4);
		
		Linfo5 = new JLabel();
		Linfo5.setText("Students:");
		Linfo5.setFont(new Font("Verdana", Font.BOLD, 16));
		Linfo5.setForeground(Color.CYAN); 
		Linfo5.setBounds(10, 130, 150, 25);
		add(Linfo5);
		
		Linfo6 = new JLabel();
		Linfo6.setText("Gerardo Zeledón M.");
		Linfo6.setFont(new Font("Verdana", Font.BOLD, 16));
		Linfo6.setForeground(Color.CYAN); 
		Linfo6.setBounds(30, 160, 350, 25);
		add(Linfo6);
		
		Linfo7 = new JLabel();
		Linfo7.setText("Juan Daniel Esquivel R.");
		Linfo7.setFont(new Font("Verdana", Font.BOLD, 16));
		Linfo7.setForeground(Color.CYAN); 
		Linfo7.setBounds(30, 190, 350, 25);
		add(Linfo7);
		
		Linfo8 = new JLabel();
		Linfo8.setText("Luis Ramírez M.");
		Linfo8.setFont(new Font("Verdana", Font.BOLD, 16));
		Linfo8.setForeground(Color.CYAN); 
		Linfo8.setBounds(30, 220, 350, 25);
		add(Linfo8);
		
		Linfo9 = new JLabel();
		Linfo9.setText("Gerardo Padilla.");
		Linfo9.setFont(new Font("Verdana", Font.BOLD, 16));
		Linfo9.setForeground(Color.CYAN); 
		Linfo9.setBounds(30, 250, 350, 25);
		add(Linfo9);
		
		
		setTitle("About of TRON");
		setSize(400,450);
		setLocationRelativeTo(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource()==btnBack){
			this.dispose();	
		}
	}
}
