package Game;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Moto {
	public static int Xmoto;
	public static int Ymoto;
	private int Fuel=200;
	
	
	private ImageIcon imagenmoto = new ImageIcon(this.getClass().getResource("/Imagenes/MTron1.png"));
	private ImageIcon imagenmoto2 = new ImageIcon(this.getClass().getResource("/Imagenes/MTron2.png"));
	private ImageIcon imagenmoto3 = new ImageIcon(this.getClass().getResource("/Imagenes/MTron3.png"));
	private ImageIcon imagenmoto4 = new ImageIcon(this.getClass().getResource("/Imagenes/MTron4.png"));
	private ImageIcon Speed1 = new ImageIcon(this.getClass().getResource("/Imagenes/Speed_1.png"));
	private ImageIcon Speed2 = new ImageIcon(this.getClass().getResource("/Imagenes/Speed_2.png"));
	//private ImageIcon Super1 = new ImageIcon(this.getClass().getResource("/Imagenes/Super_1.png"));
	//private ImageIcon Super2 = new ImageIcon(this.getClass().getResource("/Imagenes/Super_2.png"));
	
	
	public Moto(int x, int y){
		setXmoto(x);
		setYmoto(y);
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
	
	public boolean Destroy(int Fuel){
		if (Fuel == 0){
			return true;
		}
		return false;
	}

	public void dibujar1(Graphics g, int x, int y){
		g.drawImage(imagenmoto.getImage(), x, y,30,15,null);
		
	}
	public void dibujar2(Graphics g, int x, int y){
		g.drawImage(imagenmoto2.getImage(), x, y,15,30,null);
		
	}
	public void dibujar3(Graphics g, int x, int y){
		g.drawImage(imagenmoto3.getImage(), x, y,30,15,null);
		
	}
	public void dibujar4(Graphics g, int x, int y){
		g.drawImage(imagenmoto4.getImage(), x, y,15,30,null);
		
	}
}