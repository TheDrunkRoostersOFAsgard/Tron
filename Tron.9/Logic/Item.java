package Logic;


import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Item {
		private static int Xitem;
		private static int Yitem;
		public int Y;
		public int X;

		private ImageIcon Gas = new ImageIcon(this.getClass().getResource("/Imagenes/Gas Item.png"));
		private ImageIcon Bomb = new ImageIcon(this.getClass().getResource("/Imagenes/Bomb Item.png"));
		private ImageIcon Invensible = new ImageIcon(this.getClass().getResource("/Imagenes/Invensible.png"));
		private ImageIcon Speed = new ImageIcon(this.getClass().getResource("/Imagenes/Speed.png"));
		
		
		public static Rectangle getBounds(){
			return new Rectangle(Xitem,Yitem,30,30);
		} 
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

		public int getYitem(){
			return Yitem;
		}

		public void setYitem(int yitem) {
			Yitem = yitem;
		}

		public void dibujar1(Graphics g, int x, int y,int type){
			this.Y=y;
			this.X=x;
			if(type==0){
				g.drawImage(Gas.getImage(), x, y,20,20,null);
			}
			else if(type==1){
				g.drawImage(Bomb.getImage(), x, y,20,20,null);
			}
			else if (type==2){
				g.drawImage(Invensible.getImage(), x, y,20,20,null);
			}
			else if(type==3){
				g.drawImage(Speed.getImage(), x, y,20,20,null);
			}
		}
			
			
}
		


