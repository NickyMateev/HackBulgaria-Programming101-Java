package TheOne;

public class Pixel {

	private int red;
	private int green;
	private int blue;
	
	public Pixel(){
		
		this.red = 0;
		this.green = 0;
		this.blue = 0;
	}
	
	public Pixel(int red, int green, int blue){
		
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public Pixel(Pixel otherPixel){
		
		this.red = otherPixel.getRed();
		this.green = otherPixel.getGreen();
		this.blue = otherPixel.getBlue();
	}
	
	public int getRed(){
		return red;
	}
	
	public int getGreen(){
		return green;
	}
	
	public int getBlue(){
		return blue;
	}
	
	public void setRed(int red){
		this.red = red;
	}
	
	public void setGreen(int green){
		this.green = green;
	}
	
	public void setBlue(int blue){
		this.blue = blue;
	}
	
	public void setPixel(int red, int green, int blue){
		
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	@Override
	public String toString() {
		return String.format("(%d, %d, %d)", red, green, blue);
	}
}
