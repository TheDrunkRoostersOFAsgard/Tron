package Game;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Moto {
	public static int Xmoto;
	public static int Ymoto;
	private int Fuel=100;
	
	
	private ImageIcon imagenmoto = new ImageIcon(this.getClass().getResource("/Imagenes/Moto.png"));
	private ImageIcon imagenmoto2 = new ImageIcon(this.getClass().getResource("/Imagenes/Moto2.png"));
	
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
		g.drawImage(imagenmoto.getImage(), x, y,25,25,null);
		
	}
	public void dibujar2(Graphics g, int x, int y){
		g.drawImage(imagenmoto2.getImage(), x, y,25,25,null);
		
	}
}