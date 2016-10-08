package Logic;

import GUI.Window;

public class Process extends Thread{

	public Process(String msg){
		super(msg);
	}
	
	public void run(){
		Window frame = new Window();
		frame.setVisible(true);
		
		while(true){
			
			try {
				Thread.sleep(120);
				frame.repaint();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			}
		}	
}