

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
		// I dont think I'm supposed to write this code until part two
		// although I'm not entirely sure. For now I'll just print out which
		// thread it is
		
		System.out.println("Quadrant " + quadrant + " running");
		
	}
	
	
	
	
}