package TheOne;

public class BrightnessReduce implements MatrixOperation {

	public static final int REDUCE_VALUE = 40;
	private int reduceValue;
	
	public BrightnessReduce() {
		reduceValue = REDUCE_VALUE;
	}
	
	public BrightnessReduce(int reduceValue){
		
		this.reduceValue = reduceValue;
	}
	
	@Override
	public Pixel withPixel(int x, int y, Pixel[][] matrix) {
	
		Pixel pixel = matrix[x][y];
		Pixel newPixel = new Pixel();
		
		int resultValue = pixel.getRed() - reduceValue;
		newPixel.setRed(resultValue > 0 ? resultValue : 0);
		
		resultValue = pixel.getGreen() - reduceValue;
		newPixel.setGreen(resultValue > 0 ? resultValue : 0);
		
		resultValue = pixel.getBlue() - reduceValue;
		newPixel.setBlue(resultValue > 0 ? resultValue : 0);
		
		return newPixel;
	}

}
