package GUI;

import Logic.*;

import java.util.Random;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author Gerardo
 * @author Hernaldo
 * 
 *
 */
public class Window extends JFrame{
	Random  Random = new Random();
	private static final long serialVersionUID = 1L;
	ImageIcon Icono = new ImageIcon(this.getClass().getResource("/Imagenes/icono.png"));
	ImageIcon Fondo = new ImageIcon(this.getClass().getResource("/Imagenes/Fondo.png"));
	private JPanel contentPane;
	public int Code,cola,temp;
	public static int Direc,codigo,distance;
	public static Matrix M = new Matrix(38,38);
	public static Moto moto= new Moto(5,6);
	public static Item Invensible=null;
	public static Item Speed=null;
	public static Item Bomb=null;
	public static Item Gas=null;
	public static Item Gas1=null;
	public void gameover(){
		JOptionPane.showMessageDialog(this,"Out Of Fuel", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
 	public static int getCode(int code){
		codigo = code;
		return codigo;
	}
	public Window(){//para poder crear la ventana
		Invensible=new Item(Random.nextInt(M.GetWidth()-1), Random.nextInt(M.GetHeight()-1));
		Speed=new Item(Random.nextInt(M.GetWidth()-1), Random.nextInt(M.GetHeight()-1));
		Bomb=new Item(Random.nextInt(M.GetWidth()-1), Random.nextInt(M.GetHeight()-1));
		Gas=new Item(Random.nextInt(M.GetWidth()-1), Random.nextInt(M.GetHeight()-1));
		Gas1=new Item(Random.nextInt(M.GetWidth()-1), Random.nextInt(M.GetHeight()-1));
		setTitle("TRON"); //Nombrar la ventana
		setSize(640,650); //Asignar taman-o de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Hacer que la ventana se cierre cuando se presiona (x)
		
        contentPane = new JPanel(); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.DARK_GRAY);
        setBackground(Color.cyan);
        setBounds(0,0,610,610);
        M.create();
        setIconImage(Icono.getImage());
        setResizable(false);
        setLocationRelativeTo(null);
        
        Teclado tecla = new Teclado();
        addKeyListener(tecla);  
	}

	
	public static void PosMoto(){
		if(codigo==38){
        	codigo = 0;
        	Direc=0;
        	distance=distance+1;
        	if(Moto.getXmoto()!=0){
        		M.SetValue(Moto.getXmoto(), Moto.getYmoto(), 3);
            	Moto.setXmoto(Moto.getXmoto()-1);
            	M.SetValue(Moto.getXmoto(), Moto.getYmoto(), 1);
        	}
        	
        }
		else if(codigo==37){
        	codigo = 0;
        	Direc=1;
        	distance=distance+1;
        	if(Moto.getYmoto()!=0){
        		M.SetValue(Moto.getXmoto(), Moto.getYmoto(), 3);
            	Moto.setYmoto(Moto.getYmoto()-1);
            	M.SetValue(Moto.getXmoto(), Moto.getYmoto(), 1);
        	}
        	
		}
		else if(codigo==39){
        	codigo = 0;
        	Direc=2;
        	distance=distance+1;
        	if(Moto.getYmoto()!=36){
        		M.SetValue(Moto.getXmoto(), Moto.getYmoto(), 3);
            	Moto.setYmoto(Moto.getYmoto()+1);
            	M.SetValue(Moto.getXmoto(), Moto.getYmoto(), 1);
        	}
		}
		else if(codigo==40){
			
        	codigo = 0;
        	Direc=3;
        	distance=distance+1;
        	if(Moto.getXmoto()!=36){
        		M.SetValue(Moto.getXmoto(), Moto.getYmoto(), 3);
            	Moto.setXmoto(Moto.getXmoto()+1);
            	M.SetValue(Moto.getXmoto(), Moto.getYmoto(), 1);
        	}
		}
	}
	
	
	public void paint (Graphics g){ //para pintar una figura en la ventana (JPanel)
		PosMoto();
		System.out.println(moto.collision());
		//System.out.println(temp);
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(Fondo.getImage(), 0, 0, null);
        
        
        int posx=0, posy=11,PosFuel=100;
	        for (int I = 0; I < M.GetHeight()-1; ++I) {
	        	posx=4;
	            for (int J = 0; J < M.GetWidth(); ++J) {
	            	posx+=16;
	            	if(M.GetValue(I, J)==3){
	            		g2d.setColor(Color.CYAN);
	            		g2d.drawRect(posx, posy+6, 10, 10);
	            		g2d.fillRect(posx, posy+6, 10, 10);
	            		cola = cola+1;
	            		if(cola==6){
	            			if(M.GetValue(I, J)==3){
	            				for(int i=0; i<M.GetWidth()-1;++i){
	            					for(int j=0;j<M.GetHeight()-1; ++j){
	            						M.SetValue(I, J, 0);
	            						cola=0;
	            					}
	            				}
	            	        }
	            	            
	            	           
	            		}
	            	}
	            	
	            	if (M.GetValue(I, J)==4){
	            		Invensible.dibujar1(g,((Invensible.getXitem()*610)/38),((Invensible.getYitem()*610)/30),2);    		
	            		Speed.dibujar1(g,((Speed.getXitem()*610)/38),((Speed.getYitem()*610)/38),3);
	            		Bomb.dibujar1(g,((Bomb.getXitem()*610)/38),((Bomb.getYitem()*610)/34),1);
	            		Gas.dibujar1(g,((Gas.getXitem()*610)/38),((Gas.getYitem()*610)/20),0);
	            		Gas1.dibujar1(g,((Gas1.getXitem()*610)/38),((Gas1.getYitem()*610)/30),0);
	            		
	            		
	            	}
	            	if(M.GetValue(I, J)==1){
	            		if(Direc == 0){
	            			moto.dibujar2(g2d, posx, posy);
	            		}
	            		else if(Direc == 1){
	            			moto.dibujar1(g2d, posx, posy);
	            		}
	            		else if(Direc==2){
	            			moto.dibujar3(g2d, posx, posy);
	            		}
	            		else if(Direc==3){
	            			moto.dibujar4(g2d, posx, posy);
	            		}
	            	}
	            	
	            }
	            posy+=15;
	            
	        }
	        for(int i=0;i<moto.getFuel();i=i+10){
	        	g2d.setColor(Color.RED);
            	g2d.drawRect(10, PosFuel, 20, 10);
            	g2d.fillRect(10, PosFuel, 20, 10);
            	PosFuel+=15;
            	if(distance==5){
            		distance=0;
            		if(Moto.getXmoto()==0 || Moto.getXmoto()==36 || Moto.getYmoto()==0 || Moto.getYmoto()==36){
            			moto.setFuel(moto.getFuel());
            		}
            		else{
            			moto.setFuel(moto.getFuel()-10);
            		}
            		g2d.setColor(Color.DARK_GRAY);
                	g2d.drawRect(300, PosFuel, 20, 10);
            		PosFuel=PosFuel-15;
            		if(moto.getFuel()==0){
            			gameover();
            		}
            	}
	        }
        }      
	
	
class Teclado implements KeyListener{

	
	public void keyPressed(KeyEvent e) {
		Window.getCode(e.getKeyCode());	
	}
	public void keyReleased(KeyEvent e) {	
	}
	public void keyTyped(KeyEvent e) {
	}
	
}
}