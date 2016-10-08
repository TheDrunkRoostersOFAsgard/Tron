package Logic;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import javax.swing.*;
import java.io.*;
import javazoom.jl.player.Player;
import javazoom.jl.decoder.*;

public class Client extends JFrame implements ActionListener,Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField txtPlayer,txtPort,txtIp;
	JButton btnConect,btnConfig,btnAbout,btnPlay;
	JLabel Lplayer,Lport,Lip,Ltitle,Ltitle2;
	JTextArea txtMsjs;
	JPanel contentpane;
	static DataInputStream entrada; 
	static DataOutputStream salida; 
	Socket cliente;
	public Client() {
		
		contentpane = new JPanel(); 
		setContentPane(contentpane);
        contentpane.setLayout(null);
        contentpane.setBackground(Color.DARK_GRAY);
		txtPlayer = new JTextField();
		txtPlayer.setBounds(110,310,150,25);
		add(txtPlayer);
		
		txtPort=new JTextField();
		txtPort.setBounds(110,340,150,25);
		add(txtPort);
		
		txtIp=new JTextField();
		txtIp.setBounds(110,370,150,25);
		add(txtIp);
		
		Lplayer = new JLabel();
		Lplayer.setBounds(10,310,100,25);
		Lplayer.setText("Name of player:");
		Lplayer.setForeground(Color.CYAN); 
		add(Lplayer);
		
		Lport=new JLabel();
		Lport.setText("Gameport:");
		Lport.setForeground(Color.CYAN); 
		Lport.setBounds(35,340,70,25);
		add(Lport);
		
		Lip=new JLabel();
		Lip.setText("IP address:");
		Lip.setForeground(Color.CYAN); 
		Lip.setBounds(30,370,70,25);
		add(Lip);
		
		Ltitle = new JLabel();
		Ltitle.setText("TRoN");
		Ltitle.setFont(new Font("Star Jedi", Font.BOLD, 54));
		Ltitle.setForeground(Color.CYAN); 
		Ltitle.setBounds(130,10,400,100);
		add(Ltitle);
		Ltitle2 = new JLabel();
		Ltitle2.setText("The Game");
		Ltitle2.setForeground(Color.CYAN); 
		Ltitle2.setFont(new Font("Star Jedi", Font.BOLD, 34));
		Ltitle2.setBounds(115,50,400,100);
		add(Ltitle2);
		
		txtMsjs=new JTextArea();
		txtMsjs.setBounds(18, 420, 400,170 );
		txtMsjs.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		add(txtMsjs);
		
		btnConect = new JButton();
		btnConect.setText("Conect");
		btnConect.setBounds(310, 340, 110, 25);
		btnConect.addActionListener(this);
		add(btnConect);
		
		btnConfig = new JButton();
		btnConfig.setText("Settings");
		btnConfig.setBounds(160, 160, 110, 25);
		btnConfig.addActionListener(this);
		add(btnConfig);
		
		btnAbout = new JButton();
		btnAbout.setText("About");
		btnAbout.setBounds(160, 190, 110, 25);
		btnAbout.addActionListener(this);
		add(btnAbout);
		
		btnPlay = new JButton();
		btnPlay.setText("Play Game");
		btnPlay.setBounds(310, 370, 110, 25);
		btnPlay.addActionListener(this);
		add(btnPlay);
		
		
		setTitle("TRON");
		setSize(450,650);
		setVisible(true);
		setLocationRelativeTo(null);
		txtMsjs.append("***Bienvenido a TRON***"+"\n");
		txtMsjs.append("Por favor ingrese su nombre de jugador, la ip del servidor"+"\n"+" y el puerto al que desea conectarse."+"\n");
		txtMsjs.append("Si desea continuar, presione 'Conectar' para"+"\n"+" establecer comunicación con el servidor."+"\n");
	}

	public static void main(String[] args) throws Throwable {
		new Client();
		try{
			FileInputStream fis;
			Player player;
			fis=new FileInputStream("C:\\Users\\Juan D\\Desktop\\CE - TEC\\II Semestre\\Datos I\\com.datos.Tron\\src\\Imagenes\\Tittle BGM.mp3");
			BufferedInputStream bis = new BufferedInputStream(fis);
			player= new Player(bis);
			player.play();
		}catch(JavaLayerException e){
			e.printStackTrace();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==btnConect){
			try{
				String ipaddress = txtIp.getText();
				cliente = new Socket(ipaddress,Integer.parseInt(txtPort.getText()));
				txtMsjs.append("Estableciendo la conexión...");
				salida = new DataOutputStream(cliente.getOutputStream());
				salida.writeUTF(txtPlayer.getText());
				txtMsjs.append("Conexión completada con éxito."+"\n"+"Presione 'Iniciar Juego' para unirse a la partida."+"\n");
			}catch(Exception e2){
				System.out.println("Error en cliente "+e2.getMessage());
			}
		} else if(arg0.getSource()==btnAbout){
			frmAbout Vabout = new frmAbout();
			Vabout.setVisible(true);
		}else if(arg0.getSource()==btnConfig){
			frmSettings Vconfig = new frmSettings();
			Vconfig.setVisible(true);
		}else if(cliente.isConnected()==true && arg0.getSource()==btnPlay){
			Thread hilo = new Process("Moto");
	    	hilo.start();
	    	Thread hiloMusic = new Backsound();
	    	hiloMusic.start();
			}else if(cliente.isConnected()==false && arg0.getSource()==btnPlay){
				txtMsjs.append("Aun no se ha conectado con el servidor"+"\n");
			}
	}
	@Override
	public void run() {	
}
class EntradaServidor implements Runnable{
	DataInputStream entrada;
	public EntradaServidor (DataInputStream entrada) {
		this.entrada=entrada;
	}
	@Override
	public void run() {
			try {
			} catch (Exception e) {
				e.printStackTrace();
			}	
	}
}}

