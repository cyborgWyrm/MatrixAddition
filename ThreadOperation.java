

public class ThreadOperation extends Thread {
	
	// instance variables
	private Quadrant quadrant;
	private int[][] matrix1;
	private int[][] matrix2;
	// private int[][] resultMatrix?
	
	// constructor
	public ThreadOperation(int[][] matrix1, int[][] matrix2, Quadrant quadrant) {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.quadrant = quadrant;
	}
	
	// run
	public void run() {
		
		System.out.println(quadrant);
	}
	
	
	
	
}