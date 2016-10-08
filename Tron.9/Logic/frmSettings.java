package Logic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class frmSettings  extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnBack;
	JLabel Ltecla,Linfo1,Linfo2,Lpower,Linfo3,Linfo4,Linfo5,Lspace;
	JPanel contentpane;
	public frmSettings(){
		contentpane = new JPanel(); 
		setContentPane(contentpane);
        contentpane.setLayout(null);
        contentpane.setBackground(Color.DARK_GRAY);
		
		Ltecla = new JLabel();
		Ltecla.setBounds(40, 10, 150, 150);
		ImageIcon tecla=new ImageIcon(this.getClass().getResource("/Imagenes/teclas.png"));
		ImageIcon icono1=new ImageIcon(tecla.getImage().getScaledInstance(Ltecla.getWidth(), Ltecla.getHeight(),Image.SCALE_DEFAULT));
		Ltecla.setIcon(icono1);
		add(Ltecla);
		Linfo1 = new JLabel();
		Linfo1.setText("Use the arrows");
		Linfo1.setFont(new Font("Verdana", Font.BOLD, 18));
		Linfo1.setForeground(Color.CYAN); 
		Linfo1.setBounds(210, 60, 300, 25);
		add(Linfo1);
		Linfo2 = new JLabel();
		Linfo2.setText("to move the bike of light.");
		Linfo2.setFont(new Font("Verdana", Font.BOLD, 18));
		Linfo2.setForeground(Color.CYAN); 
		Linfo2.setBounds(210, 90, 300, 25);
		add(Linfo2);
		Lpower = new JLabel();
		Lpower.setBounds(40, 160, 150, 150);
		ImageIcon powers=new ImageIcon(this.getClass().getResource("/Imagenes/Bomb Item.png"));
		ImageIcon icono2=new ImageIcon(powers.getImage().getScaledInstance(Ltecla.getWidth(), Ltecla.getHeight(),Image.SCALE_DEFAULT));
		Lpower.setIcon(icono2);
		add(Lpower);
		Linfo3 = new JLabel();
		Linfo3.setText("Pick up the powers and");
		Linfo3.setFont(new Font("Verdana", Font.BOLD, 18));
		Linfo3.setForeground(Color.CYAN); 
		Linfo3.setBounds(210, 190, 300, 25);
		add(Linfo3);
		Linfo4 = new JLabel();
		Linfo4.setText("use them to get buffs.");
		Linfo4.setFont(new Font("Verdana", Font.BOLD, 18));
		Linfo4.setForeground(Color.CYAN); 
		Linfo4.setBounds(210, 210, 300, 25);
		add(Linfo4);
		Lspace = new JLabel();
		Lspace.setBounds(90, 320, 320, 70);
		ImageIcon space=new ImageIcon(this.getClass().getResource("/Imagenes/space.png"));
		ImageIcon icono3=new ImageIcon(space.getImage().getScaledInstance(300, 100,Image.SCALE_DEFAULT));
		Lspace.setIcon(icono3);
		add(Lspace);
		Linfo5 = new JLabel();
		Linfo5.setText("Use the space bar to activate the powers.");
		Linfo5.setFont(new Font("Verdana", Font.BOLD, 18));
		Linfo5.setForeground(Color.CYAN); 
		Linfo5.setBounds(30, 400, 500, 25);
		add(Linfo5);
		
		btnBack = new JButton();
		btnBack.setText("Back");
		btnBack.setBounds(370, 470, 100, 25);
		btnBack.addActionListener(this);
		add(btnBack);
		
		setTitle("Control settings of TRON");
		setSize(500,550);
		setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent arg0){
		if (arg0.getSource()==btnBack){
			this.dispose();
		}
	}
}
