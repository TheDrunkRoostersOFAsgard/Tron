import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//libreria necesaria para poder utilizar JFrame



public class Window extends JFrame{
	

	ImageIcon cuadrito = new ImageIcon(this.getClass().getResource("/Imagenes/cuadrito c.png"));
	ImageIcon Icono = new ImageIcon(this.getClass().getResource("/Imagenes/icono.png"));
	ImageIcon Bomb = new ImageIcon(this.getClass().getResource("/Imagenes/Bomb.png"));
	private JPanel contentPane;
	public int X, Y;
	private Matrix M = new Matrix(20,20);
	private Moto moto= new Moto(8,9);
	private Items Items = new Items();
	private Items Items;
	
	public void setMatrix(Matrix pMatrix){
		for (int I = 0; I < M.GetWidth(); ++I) {
            for (int J = 0; J < M.GetHeight(); ++J) {
            	M.SetValue(I, J, pMatrix.GetValue(I, J));
            }
		}
	}
	
	public Window(){ //para poder crear la ventana
		setTitle("TRON"); //Nombrar la ventana
		setSize(640,650); //Asignar taman-o de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Hacer que la ventana se cierre cuando se presiona (x)
        contentPane = new JPanel(); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setBounds(0,0,800,700);
        M.create();
        setIconImage(Icono.getImage());
        setResizable(false);
        setLocationRelativeTo(null);
        
        Teclado tecla = new Teclado();
    	addKeyListener(tecla);
        
        
	}
	
	
	
	public void paint (Graphics g){ //para pintar una figura en la ventana (JPanel)
        super.paint(g);
        int posx=13, posy=25;
        
	        for (int I = 0; I < M.GetHeight()-1; ++I) {
	        	posx=13;
	            for (int J = 0; J < M.GetWidth(); ++J) {
	            	if (M.GetValue(I, J)==0){
	            		g.drawImage(cuadrito.getImage(), posx, posy,16,15,null);
	            		posx+=16;
	            	}else if(M.GetValue(I, J)==1){
	            			moto.dibujar(g,posx ,posy, );
	            			posx+=16;
	            	}else if (M.GetValue(I, J)==2){
	            		if(Items.getPoder()==1);
	            		g.drawImage(Bomb.getImage(), posx,posy ,16,15,null);
	            		posx+=16;
	            	}
	            }
	       }
	           posy+=15;
	}

class Teclado implements KeyListener{
	

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code==38){
			System.out.println(code);
			Moto.setYmoto(Moto.getYmoto()-1);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
	
}
}
