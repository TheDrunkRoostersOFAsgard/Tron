import java.util.Random;


public class Items {
	private int x;
	private int y;
	private int poder;
	private Matrix matrix;
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getPoder() {
		return poder;
	}
	public void setPoder(int poder) {
		this.poder = poder;
	}
	
	public void generate(){
		Random Random = new Random();
		this.setX(Random.nextInt(matrix.GetWidth()+1));
		this.setY(Random.nextInt(matrix.GetHeight()+1));
		this.setPoder(Random.nextInt(6));
		
	}
}
