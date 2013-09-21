package lib;

/**
 * MultiplicationTable
 */
public class MultiplicationTable {
	int range;

	public MultiplicationTable(int range) {
		setRange(range);
	}

	public void setRange(int range) {
		this.range = range;
	}

	public void printMultiplicationTable() {
		for (int m = 1; m <= this.range; m++) {
			for (int n = 1; n <= this.range; n++) {
				System.out.printf(" %2d ", m * n);
			}
			System.out.println();
		}
	}
}