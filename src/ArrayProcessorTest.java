import java.util.ArrayList;

class ArrayProcessor {
	int[][] myArray;

	public ArrayProcessor(int[][] myArray) {
		this.myArray = myArray;
	}

	public int[][] rotateArray(int direction) {
		int[][] result = new int[myArray.length][myArray.length];
		if (direction > 1 || direction < 0) return result;
		int N = myArray.length;
		int max_r = N - 1;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int index = r * N + c;
				int new_r = 0, new_c = 0;

				if (direction == 0) { // counterclockwise
					new_r = max_r - (index % N);
					new_c = index / N;
				} else if (direction == 1) { // clockwise
					new_r = index % N;
					new_c = max_r - (index / N);
				}
				result[new_r][new_c] = myArray[r][c];
			}
		}

		return result;
	}

	public int[][] matrixZero() {
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();

		for (int i = 0; i < myArray.length; i++) {
			for (int j = 0; j < myArray[0].length; j++) {
				if (myArray[i][j] == 0) {
					x.add(i);
					y.add(j);
				}
			}
		}

		for (int i = 0; i < x.size(); i++) {
			int r = x.get(i);
			int c = y.get(i);
			for (int k = 0; k < myArray.length; k++)
				myArray[k][c] = 0;
			for (int j = 0; j < myArray[0].length; j++)
				myArray[r][j] = 0;
		}
		return myArray;
	}

	public void printArrayData(int[][] input) {
		for (int[] r : input) {
			for (int c : r) {
				System.out.printf(" %2d ", c);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void printArrayData() {
		this.printArrayData(this.myArray);
	}
}

public class ArrayProcessorTest {
	
	public static void testRotateArray(int[][] input) {
		
		System.out.println("Testing rotateArray method");
		ArrayProcessor test = new ArrayProcessor(input);
		System.out.println("Print input array");
		test.printArrayData();
		
		
		// rotation array in a counterclockwise direction
		int[][] result = test.rotateArray(0); 
		System.out.println("Print result in a counterclockwise direction");
		test.printArrayData(result);
		
		// rotation array in a clockwise direction
		result = test.rotateArray(1);
		System.out.println("Print result in a clockwise direction");
		test.printArrayData(result);
		
	}
	
	public static void testReplaceMatrixZero(int[][] input) {
		
		System.out.println("Testing matrizxZero method");
		ArrayProcessor test = new ArrayProcessor(input);
		System.out.println("Print input array");
		test.printArrayData();
		
		// replace the whole row and column with zero related to 
		// the position of a zero in the array
		int[][] result = test.matrixZero();
		System.out.println("Print result");
		test.printArrayData(result);

	}
	
	public static void main(String[] args) {
		
		int[][] myArray1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		testRotateArray(myArray1);
		
		int[][] myArray2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 0, 12 } };
		testReplaceMatrixZero(myArray2);
	}

}
