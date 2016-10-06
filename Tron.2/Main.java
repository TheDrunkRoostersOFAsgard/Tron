import java.awt.EventQueue;

import Gráfica.FirstWindow;

public class Main {
    public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable() {
    		
    		public void run() {
    			Window frame = new Window();
                frame.setVisible(true);
    		}
        });
    }
}
