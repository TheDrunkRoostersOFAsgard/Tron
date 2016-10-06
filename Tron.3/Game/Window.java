package Game;
import java.util.Random;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



//libreria necesaria para poder utilizar JFrame


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
	private JPanel contentPane;
	public static int X,Y;
	public int Code;

	public static int Direc,codigo,distance;

	public int cola;

	public static Matrix M = new Matrix(20,20);
	public static Moto moto= new Moto(5,6);
	public static Moto moto2= new Moto(12,12);
	public Item Pop = null;

	
	
	public static int getCode(int code){
		codigo = code;
		return codigo;
	}
	public Window(){//para poder crear la ventana
		Pop=new Item(Random.nextInt(M.GetWidth()-1), Random.nextInt(M.GetHeight()-1));
		setTitle("TRON"); //Nombrar la ventana
		setSize(640,650); //Asignar taman-o de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Hacer que la ventana se cierre cuando se presiona (x)
		
        contentPane = new JPanel(); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.black);
        setBackground(Color.cyan);
        setBounds(0,0,410,410);
        M.create();
        setIconImage(Icono.getImage());
        setResizable(false);
        setLocationRelativeTo(null);
        
        Teclado tecla = new Teclado();
        addKeyListener(tecla);
        
        
	}
	public static void PosMoto(){
		if(codigo==38){
        	M.SetValue(Moto.getXmoto(), Moto.getYmoto(), 3);
        	Moto.setXmoto(Moto.getXmoto()-1);
        	M.SetValue(Moto.getXmoto(), Moto.getYmoto(), 1);
        	codigo = 0;
        	Direc=1;
        	distance=distance+1;
        }
		else if(codigo==37){
			M.SetValue(Moto.getXmoto(), Moto.getYmoto(), 3);
        	Moto.setYmoto(Moto.getYmoto()-1);
        	M.SetValue(Moto.getXmoto(), Moto.getYmoto(), 1);
        	codigo = 0;
        	Direc=0;
        	distance=distance+1;
		}
		else if(codigo==39){
			M.SetValue(Moto.getXmoto(), Moto.getYmoto(), 3);
        	Moto.setYmoto(Moto.getYmoto()+1);
        	M.SetValue(Moto.getXmoto(), Moto.getYmoto(), 1);
        	codigo = 0;
        	Direc=0;
        	distance=distance+1;
		}
		else if(codigo==40){
			M.SetValue(Moto.getXmoto(), Moto.getYmoto(), 3);
        	Moto.setXmoto(Moto.getXmoto()+1);
        	M.SetValue(Moto.getXmoto(), Moto.getYmoto(), 1);
        	codigo = 0;
        	Direc=1;
        	distance=distance+1;
		}
	}
	
	public void paint (Graphics g){ //para pintar una figura en la ventana (JPanel)
		PosMoto();
		
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        
        int posx=0, posy=11,PosFuel=100;
	        for (int I = 0; I < M.GetHeight()-1; ++I) {
	        	posx=4;
	            for (int J = 0; J < M.GetWidth(); ++J) {
	            	posx+=16;
	            	if (M.GetValue(I, J)==4){
	            		Pop.dibujar1(g,Pop.getXitem(),Pop.getYitem(),2);
	            		System.out.println(Pop.getXitem());
	            		System.out.println(Pop.getYitem());
	            	}
	            	else if(M.GetValue(I, J)==1){
	            		if(Direc==0){
	            			moto.dibujar1(g, posx, posy);
	            		}
	            		else{
	            			moto.dibujar2(g, posx, posy);
	            		}
	            		posx+=16;
	            	}
	            	else if(M.GetValue(I, J)==3){
	            		g2d.setColor(Color.white);
	            		g2d.drawRect(posx, posy+6, 10, 10);
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
	            }
	            posy+=15;
	        }
	        for(int i=0;i<=moto.getFuel();i=i+10){
	        	g2d.setColor(Color.yellow);
            	g2d.drawRect(10, PosFuel, 20, 10);
            	PosFuel+=15;
            	if(distance==5){
            		distance=0;
            		moto.setFuel(moto.getFuel()-10);
            		g2d.setColor(Color.BLACK);
                	g2d.drawRect(300, PosFuel, 20, 10);
            		PosFuel=PosFuel-15;
            	}
            	
	        }
	        
       
        }      
	}

class Maya extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
}
	
class Teclado implements KeyListener{

	
	public void keyPressed(KeyEvent e) {
		
		Window.getCode(e.getKeyCode());	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
