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

Multi threading saves time because other threads can be working while one is
waiting for something. Examples include pulling data from storage, or waiting
for input from a human or another machine. This saves time because work is still
getting done instead of being stuck while waiting for something.


*/
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		// Get file from args
		if (args.length < 1) {
			// error if no file given
			System.out.println("Please provide a file to read");
			System.exit(0);
		}
		File inputFile = new File(args[0]);
		
		
		// Set up file reader
		Scanner fileReader = null;
		try {
			fileReader = new Scanner(inputFile);
		}
		catch (IOException e) {
			// error if file is not found
			System.out.println("File not found.");
			System.exit(0);
		}
		
		
		// find rows and columns of matrixes. Should be the first two numbers in file.
		int rows = fileReader.nextInt();
		int cols = fileReader.nextInt();

		// create matrix variables
		int[][] matrix1 = matrixFromFile(rows,cols,fileReader);
		int[][] matrix2 = matrixFromFile(rows,cols,fileReader);
		int[][] resultMatrix = new int[rows][cols];
		
		// Create all four threads
		ThreadOperation thread0 = new ThreadOperation(matrix1, matrix2, "AA", resultMatrix);
		ThreadOperation thread1 = new ThreadOperation(matrix1, matrix2, "AB", resultMatrix);
		ThreadOperation thread2 = new ThreadOperation(matrix1, matrix2, "BA", resultMatrix);
		ThreadOperation thread3 = new ThreadOperation(matrix1, matrix2, "BB", resultMatrix);
		
		// Start all four threads running
		thread0.start();
		thread1.start();
		thread2.start();
		thread3.start();
		
		// wait for all four threads to complete
		try {
			thread0.join();
			thread1.join();
			thread2.join();
			thread3.join();
		}
		catch (InterruptedException e) {
			
		}
		
		
		// print out the resulting matrix
		print2dArray(resultMatrix);
		
		
		
	}
	
	// print out a given matrix
	public static void print2dArray(int[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				// print out each number
				System.out.printf("%-4d", array[row][col]);
			}
			// new line for every row
			System.out.println();
		}
	}
	
	// read in a matrix from a given file
	public static int[][] matrixFromFile(int rows, int cols, Scanner fileReader) {
		int[][] matrix = new int[rows][cols];
		
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				// read in the values and put in the proper places in the array
				matrix[r][c] = fileReader.nextInt();
			}
		}
		
		return matrix;
	}

}