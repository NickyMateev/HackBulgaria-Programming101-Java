package TheOne;

public class Grayscale implements MatrixOperation{

	@Override
	public Pixel withPixel(int x, int y, Pixel[][] matrix) {
	
		Pixel pixel = matrix[x][y];
		int avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
		
		return new Pixel(avg, avg, avg);
	}

}
