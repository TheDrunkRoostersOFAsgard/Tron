package Game;



public class Process extends Thread{

	public Process(String msg){
		super(msg);
	}
	
	public void run(){
		Window frame = new Window();
		frame.setVisible(true);
		
		while(true){
			
			try {
				Thread.sleep(500);
				frame.repaint();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		}
		
		
		
		
		
}
