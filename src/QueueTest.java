class Queue extends LinkedList {

	public void enqueue(int num) {
		this.insertNode(new Node(num));
	}

	public int dequeue() {
		int data = this.getFirstNode().getData();
		this.deleteNode(0);
		return data;
	}
}

public class QueueTest {

	public static void main(String[] args) {

		Queue myQueue = new Queue();

		for (int n = 1; n <= 10; n++) {
			int data = (int) Math.round((Math.random() * 20));
			myQueue.enqueue(data);
			System.out.print("Current queue: ");
			myQueue.printDataList();
			System.out.println();

			if (n > 5) {
				System.out.println("Take out: " + myQueue.dequeue());
				System.out.print("Current queue: ");
				myQueue.printDataList();
				System.out.println();
			}
		}

		System.out.println();
		System.out.println("Print my queue:");
		myQueue.printDataList();
		System.out.println();

	}

}
