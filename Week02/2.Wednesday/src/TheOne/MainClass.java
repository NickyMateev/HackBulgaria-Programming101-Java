package TheOne;

public class MainClass {

	public static void main(String[] args) {

		Pixel[][] pixels = new Pixel[][] {
		{ new Pixel(30, 123, 160), new Pixel(213, 153, 64), new Pixel(30, 13, 140) },
		{ new Pixel(180, 134, 54), new Pixel(170, 145, 160), new Pixel(186, 198, 104)},
		{ new Pixel(90, 4, 102), new Pixel(230, 203, 102), new Pixel(237, 230, 190)}
		};
		
		PixelMatrix matrix = new PixelMatrix(pixels);
		
		System.out.println("Original matrix: \n" + matrix); // original matrix
		
		matrix.operate(new BrightnessReduce(50));
		System.out.println("Matrix after applying Brightness reduction: \n" + matrix);
		
		matrix.operate(new Grayscale());
		System.out.println("Matrix after applying Grayscale effect: \n" + matrix);
				
	}

}
