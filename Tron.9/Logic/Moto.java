package Logic;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Moto {
	public static int Xmoto;
	public static int Ymoto;
	private int Fuel=300;
	public int Estela=6,IDcarpet=2;
	
	
	
	private ImageIcon Dead = new ImageIcon(this.getClass().getResource("/Imagenes/Moto/Moto1/Dead.png"));
	
	
	public Moto(int x, int y){
		setXmoto(x);
		setYmoto(y);
	}
	
	public static Rectangle getBounds(){
		return new Rectangle(Xmoto,Ymoto,30,30);
	}
	
	public boolean collision(){
		return Item.getBounds().intersects(getBounds());
	}

	public static int getXmoto() {
		return Xmoto;
	}

	public static void setXmoto(int posx) {
		Xmoto=posx;
	}

	public static int getYmoto() {
		return Ymoto;
	}

	public static void setYmoto(int posy) {
		Ymoto=+posy;
	}
	
	
	public int getFuel() {
		return Fuel;
	}

	public void setFuel(int fuel) {
		Fuel = fuel;
	}
	
	public void Power(int item){
		if (item == 0 || item==4){
			Fuel+=10;
		}
		else if(item==1){
			Fuel = 0;
		}
		else if(item==5){
			Estela+=2;
		}
		
	}
	public void Super(int active){
		if(active==1){
			IDcarpet=2;
		}
		else{
			IDcarpet=1;
		}
		
	}
	
	private ImageIcon imagenmoto1 = new ImageIcon(this.getClass().getResource("/Imagenes/Moto/Moto"+IDcarpet+"/MTron1.png"));
	private ImageIcon imagenmoto2 = new ImageIcon(this.getClass().getResource("/Imagenes/Moto/Moto"+IDcarpet+"/MTron2.png"));
	private ImageIcon imagenmoto3 = new ImageIcon(this.getClass().getResource("/Imagenes/Moto/Moto"+IDcarpet+"/MTron3.png"));
	private ImageIcon imagenmoto4 = new ImageIcon(this.getClass().getResource("/Imagenes/Moto/Moto"+IDcarpet+"/MTron4.png"));

	public void dibujar1(Graphics g, int x, int y){
		g.drawImage(imagenmoto1.getImage(), x, y,35,20,null);
		
	}
	public void dibujar2(Graphics g, int x, int y){
		g.drawImage(imagenmoto2.getImage(), x, y,20,35,null);
		
	}
	public void dibujar3(Graphics g, int x, int y){
		g.drawImage(imagenmoto3.getImage(), x, y,35,20,null);
		
	}
	public void dibujar4(Graphics g, int x, int y){
		g.drawImage(imagenmoto4.getImage(), x, y,20,35,null);
		
	}
	public void dibujar5(Graphics g, int x, int y){
		g.drawImage(Dead.getImage(), x, y,50,50,null);
		
	}
}