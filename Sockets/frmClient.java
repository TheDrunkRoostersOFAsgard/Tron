package sockets.gui.prueba;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import javax.swing.*;
import java.io.*;

public class frmClient extends JFrame implements ActionListener{
	JTextField txtPlayer,txtPort,txtIp;
	JButton btnConect,btnConfig,btnAbout,btnPlay;
	JLabel Lplayer,Lport,Lip;
	static JTextArea txtMsjs;
	DataOutputStream salida;
	Socket cliente;
	public frmClient() {
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
		add(Lplayer);
		
		Lport=new JLabel();
		Lport.setText("Gameport:");
		Lport.setBounds(35,340,70,25);
		add(Lport);
		
		Lip=new JLabel();
		Lip.setText("IP address:");
		Lip.setBounds(30,370,70,25);
		add(Lip);
		
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
		btnConfig.setText("Controls");
		btnConfig.setBounds(310, 220, 110, 25);
		btnConfig.addActionListener(this);
		add(btnConfig);
		
		btnAbout = new JButton();
		btnAbout.setText("About");
		btnAbout.setBounds(310, 250, 110, 25);
		btnAbout.addActionListener(this);
		add(btnAbout);
		
		btnPlay = new JButton();
		btnPlay.setText("Play Game");
		btnPlay.setBounds(310, 370, 110, 25);
		btnPlay.addActionListener(this);
		add(btnPlay);
		
		setLayout(null);
		setSize(450,650);
		setVisible(true);
		setLocationRelativeTo(null);
		setBackground(Color.BLACK);
	}

	public static void main(String[] args) {
		new frmClient();
		txtMsjs.append("***Bienvenido a TRON***"+"\n");
		txtMsjs.append("Por favor ingrese su nombre de jugador, la ip del servidor"+"\n"+" y el puerto al que desea conectarse."+"\n");
		txtMsjs.append("Si desea continuar, presione 'Conectar' para"+"\n"+" establecer comunicación con el servidor."+"\n");
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==btnConect){
			try{
				String ipaddress = txtIp.getText();
				cliente = new Socket(ipaddress,Integer.parseInt(txtPort.getText()));
				txtMsjs.append("Estableciendo la conexión...");
				salida = new DataOutputStream(cliente.getOutputStream());
				salida.writeUTF(txtPlayer.getText()+" se ha unido a la partida."+"\n");
				txtMsjs.append("Conexión completada con éxito."+"\n"+"Presione 'Iniciar Juego' para unirse a la partida."+"\n");
				cliente.close();
			}catch(Exception e2){
				System.out.println("Error en cliente "+e2.getMessage());
			}
		} else if(arg0.getSource()==btnAbout){
			
		}
		
	}

}
