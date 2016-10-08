package Logic;

import javax.swing.*;
import java.net.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Server  extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JTextArea txtMensajes;
	JButton btnIniConec,btnStart;
	JLabel Ltitle;
	JPanel contentpane;
	static DataInputStream entrada;
	static DataOutputStream salida;
	static ServerSocket server;
	static Socket cliente;
	Users []users=new Users[3];
	public Server() {
		contentpane = new JPanel(); 
		setContentPane(contentpane);
        contentpane.setLayout(null);
        contentpane.setBackground(Color.DARK_GRAY);
		txtMensajes=new JTextArea();
		txtMensajes.setBounds(10, 80, 360,300 );
		txtMensajes.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		add(txtMensajes);
		
		Ltitle = new JLabel();
		Ltitle.setBounds(10, 55, 150, 25);
		Ltitle.setText("Tron Server:");
		Ltitle.setForeground(Color.CYAN); 
		add(Ltitle);
		
		btnIniConec=new JButton();
		btnIniConec.setBounds(240, 40, 130, 30);
		btnIniConec.setText("Start Conection");
		btnIniConec.addActionListener(this);
		add(btnIniConec);
		
		setTitle("TRON Server");
		setSize(400,500);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new Server();
		try {
			txtMensajes.append("Iniciando servidor ..."+"\n");
			server = new ServerSocket(8080);
			txtMensajes.append("......"+"\n");
			txtMensajes.append("Servidor iniciado."+"\n");
			txtMensajes.append("Se necesita al menos un jugador para iniciar una partida."+ "\n");
			txtMensajes.append("Esperando jugadores..."+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource()== btnIniConec){
				try {
					for(int i=0;i<1;i++){
						cliente=server.accept();
						entrada=new DataInputStream(cliente.getInputStream());
						salida = new DataOutputStream(cliente.getOutputStream());
						String player = entrada.readUTF();
						txtMensajes.append(cliente.getInetAddress() +" se ha conectado "+"\n");
						txtMensajes.append(player+" se ha unido a la partida"+"\n");
						if (users[i]==null){
							users[i]=new Users(users,player, salida, entrada);
						}
					}
					txtMensajes.append("Ya hay jugadores conectados."+"\n");
					txtMensajes.append("Puede iniciar el juego."+"\n");
					}
					catch (IOException e) {
					e.printStackTrace();
					}
				}
			}
}
class Users implements Runnable{
	Users[] users=new Users[3];
	DataOutputStream salida;
	DataInputStream entrada;
	public Users(Users[]users,String player,DataOutputStream salida,DataInputStream entrada){
		this.users=users;
		this.salida=salida;
		this.entrada=entrada;
	}
	@Override
	public void run() {
		try {
			for(int i=0; i<3;i++){
				if(users[i]!=null){
					//enviar y recibir datos aqui.
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
