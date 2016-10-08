package Logic;

import GUI.Window;
import java.io.*;
import javazoom.jl.player.Player;
import javazoom.jl.decoder.*;

public class Process extends Thread{

	public Process(String msg){
		super(msg);
	}
	
	public void run(){
		Window frame = new Window();
		frame.setVisible(true);
		while(true){
			try {
				Thread.sleep(120);
				frame.repaint();	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		}	
}
class Backsound extends Thread{
	public Backsound(){
	}
	public void run(){
		while(true){
			try{
			FileInputStream fis;
			Player player;
			fis=new FileInputStream("C:\\Users\\Juan D\\Desktop\\CE - TEC\\II Semestre\\Datos I\\com.datos.Tron\\src\\Imagenes\\Game BGM.mp3");
			BufferedInputStream bis = new BufferedInputStream(fis);
			player= new Player(bis);
			player.play();
		}catch(JavaLayerException e){
			e.printStackTrace();
		}catch(FileNotFoundException e){
			e.printStackTrace();
	}
	}
}
}