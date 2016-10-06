import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Moto {
	private static int Xmoto;
	private static int Ymoto;
	
	private ImageIcon imagenmoto = new ImageIcon(this.getClass().getResource("/Imagenes/moto c.png"));
	
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
	
	public void dibujar(Graphics g, int x, int y, int type){
		if
		g.drawImage(imagenmoto.getImage(), x, y,16,15,null);
	}
}

