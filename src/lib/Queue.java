package lib;

// test123
public class Queue extends LinkedList {

	public void enqueue(int num) {
		this.insertNode(new Node(num));
	}

	public int dequeue() {
		int data = this.getFirstNode().getData();
		this.deleteNode(0);
		return data;
	}
}
