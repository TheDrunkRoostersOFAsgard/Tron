package Game;

import java.awt.Graphics;
import javax.swing.ImageIcon;


public class Item {
		private int Xitem;
		private int Yitem;
		
		private ImageIcon Gas = new ImageIcon(this.getClass().getResource("/Imagenes/Gas Item.png"));
		private ImageIcon Bomb = new ImageIcon(this.getClass().getResource("/Imagenes/Bomb Item.png"));
		
		public Item(int x, int y){
			setXitem(x);
			setYitem(y);
		}

		public int getXitem() {
			return Xitem;
		}

		public void setXitem(int xitem) {
			Xitem = xitem;
		}

		public int getYitem() {
			return Yitem;
		}

		public void setYitem(int yitem) {
			Yitem = yitem;
		}

		public void dibujar1(Graphics g, int x, int y,int type){
			if(type==1){
				g.drawImage(Gas.getImage(), x, y,40,40,null);
			}
			else if(type==2){
				g.drawImage(Bomb.getImage(), x, y,15,15,null);
			}
		}
			
			
}
		


