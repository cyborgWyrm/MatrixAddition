

public class ThreadOperation extends Thread {
	
	// instance variables
	private String quadrant;
	private int[][] matrix1;
	private int[][] matrix2;
	private int[][] resultMatrix;
	
	// constructor
	public ThreadOperation(int[][] matrix1, int[][] matrix2, String quadrant, int[][] resultMatrix) {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.quadrant = quadrant;
		this.resultMatrix = resultMatrix;
	}
	
	// run
	public void run() {
		
		int xstart = 0;
		int ystart = 0;
		int xend = matrix1[0].length/2;
		int yend = matrix1.length/2;
		
		if (quadrant.charAt(0) == 'B') {
			ystart = matrix1.length/2;
			yend = matrix1.length;
		}
		if (quadrant.charAt(1) == 'B') {
			xstart = matrix1[0].length/2;
			xend = matrix1[0].length;
		}
		
		
		for (int row = ystart; row < yend; row++) {
			for (int col = xstart; col < xend; col++) {
				resultMatrix[row][col] = matrix1[row][col] + matrix2[row][col];
			}
		}
		
	}
	
	
	
	
}