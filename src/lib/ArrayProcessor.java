package lib;
import java.util.ArrayList;

public class ArrayProcessor {
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