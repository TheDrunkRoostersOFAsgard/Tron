package sockets.gui.prueba;

import javax.swing.*;

import java.net.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class frmServer extends JFrame implements ActionListener{
	static JTextArea txtMensajes;
	JButton btnIniConec,btnStart;
	JLabel Ltitle;
	static DataInputStream entrada;
	static ServerSocket server;
	static Socket cliente;
	Users []users=new Users[3];
	public frmServer() {
		txtMensajes=new JTextArea();
		txtMensajes.setBounds(10, 80, 360,300 );
		txtMensajes.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		add(txtMensajes);
		
		Ltitle = new JLabel();
		Ltitle.setBounds(10, 55, 150, 25);
		Ltitle.setText("Tron Server:");
		add(Ltitle);
		
		btnIniConec=new JButton();
		btnIniConec.setBounds(240, 40, 130, 30);
		btnIniConec.setText("Start Conection");
		btnIniConec.addActionListener(this);
		add(btnIniConec);
		
		btnStart=new JButton();
		btnStart.setBounds(240, 420, 130, 30);
		btnStart.setText("Start game");
		btnStart.addActionListener(this);
		add(btnStart);
		
		setLayout(null);
		setSize(400,500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new frmServer();
		try {
			txtMensajes.append("Iniciando servidor ..."+"\n");
			server = new ServerSocket(8080);
			txtMensajes.append("......"+"\n");
			txtMensajes.append("Servidor iniciado."+"\n");
			txtMensajes.append("Solo se permiten partidas de tres jugadores."+ "\n");
			txtMensajes.append("Esperando a los jugadores..."+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource()== btnIniConec){
				try {
					for(int i=0;i<3;i++){
						cliente=server.accept();
						entrada=new DataInputStream(cliente.getInputStream());
						String player = entrada.readUTF();
						txtMensajes.append(cliente.getInetAddress() +" se ha conectado "+"\n");
						txtMensajes.append(player);
						if (users[i]==null){
							users[i]=new Users(users,player);
						}
					}
					txtMensajes.append("Tres jugadores se han conectado."+"\n");
					txtMensajes.append("Inicie el juego."+"\n");
					}
					catch (IOException e) {
					e.printStackTrace();
					}
				}
			}
			}
class Users implements Runnable{
	Users[] users=new Users[3];
	public Users(Users[]users,String player){
		this.users=users;
	}
	@Override
	public void run() {
	}
}
