/*
This code is provided to give you a
starting place. It should be modified.
No further imports are needed.
To earn full credit, you must also
answer the following question:

Q1: One of the goals of multi-threading
is to minimize the resource usage, such
as memory and processor cycles. In three
sentences, explain how multi-threaded
code accomplishes this goal. Consider
writing about blocking on I/O, multicore 
machines, how sluggish humans are,
threads compared to processes, etcetera,
and connect these issues to 
multi-threading.

*/
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		File inputFile = new File(args[0]);
		Scanner fileReader = null;
		
		try {
			fileReader = new Scanner(inputFile);
		}
		catch (IOException e) {
			
		}
		
		int rows = fileReader.nextInt();
		int cols = fileReader.nextInt();
		
		
	
		int[][] matrix1 = new int[1][1];
		int[][] matrix2 = new int[1][1];
		
		ThreadOperation thread0 = new ThreadOperation(matrix1, matrix2, Quadrant.AA);
		ThreadOperation thread1 = new ThreadOperation(matrix1, matrix2, Quadrant.AB);
		ThreadOperation thread2 = new ThreadOperation(matrix1, matrix2, Quadrant.BA);
		ThreadOperation thread3 = new ThreadOperation(matrix1, matrix2, Quadrant.BB);
		
		thread0.start();
		thread1.start();
		thread2.start();
		thread3.start();
		
		try {
			thread0.join();
			thread1.join();
			thread2.join();
			thread3.join();
		}
		catch (InterruptedException e) {
			
		}
		
		
		int[][] test = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		
		print2dArray(test);
		
		
		/*
		For part 1 you need to create both of the above classes.

		6.	Read in the number of rows and columns and save these in local variables in main.

		7.	Read in the first and second matrices (two-dimensional arrays) from the file. I recommend writing a method to accomplish this task and calling the method twice (once for each matrix). Consider using this method header: 


		public static int[][] matrixFromFile(int rows, int columns, Scanner file_reader)

		NOTE: if you are using a static scanner or an object-oriented approach then you may not need to pass these arguments to the method.


		*/
		
		
		
	}
	
	public static void print2dArray(int[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				System.out.printf("%3d", array[row][col]);
			}
			System.out.println();
		}
	}

}