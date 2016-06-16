package TheOne;

public class PixelMatrix {

	private Pixel[][] matrix;
	private int rows;
	private int cols;
	
	public PixelMatrix(int rows, int cols){
		
		matrix = new Pixel[rows][cols];
		this.rows = rows;
		this.cols = cols;
		
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				matrix[i][j] = new Pixel();
	}
	
	public PixelMatrix(Pixel[][] otherMatrix){
		
		rows = otherMatrix.length;
		cols = otherMatrix[0].length;
		
		matrix = new Pixel[rows][cols];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				matrix[i][j] = new Pixel(otherMatrix[i][j]);
				
	}	
	
	public void operate(MatrixOperation op){
	
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				matrix[i][j] = op.withPixel(i, j, matrix);
		
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(j != cols - 1)
					sb.append(String.format("%-15s | ", matrix[i][j]));
				else
					sb.append(matrix[i][j] + "\n");
			}
		}
		
		return sb.toString();
	}
	
}
