package lib;

class Node {
	private Node pre = null;
	private int data = 0;
	private Node next = null;

	public Node(int data) {
		setData(data);
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setPreNode(Node node) {
		this.pre = node;
	}

	public void setNextNode(Node node) {
		this.next = node;
	}

	public int getData() {
		return this.data;
	}

	public Node getNextNode() {
		return this.next;
	}

	public Node getPreNode() {
		return this.pre;
	}
}

public class LinkedList {
	private Node first = null;
	private Node last = null;
	private int total = 0;

	public int getTotalNodes() {
		return this.total;
	}

	public Node getFirstNode() {
		return this.first;
	}

	public Node getLastNode() {
		return this.last;
	}

	public int insertNode(Node node) {
		if (total == 0) {
			first = node;
			last = node;

		} else if (total > 0) {
			last.setNextNode(node);
			node.setPreNode(last);
			node.setNextNode(null);
			last = node;

		}
		total++;
		return total;
	}

	public int insertNode(int offset, Node node) {
		if (offset >= total) {
			insertNode(node);

		} else if (offset <= 0) {
			total++;
			first.setPreNode(node);
			node.setPreNode(null);
			node.setNextNode(first);
			first = node;

		} else {
			Node target = searchNode(offset);
			node.setPreNode(target.getPreNode());
			node.setNextNode(target);
			target.getPreNode().setNextNode(node);
			target.setPreNode(node);
			total++;
		}
		return total;
	}

	public int deleteNode(int index) {
		if (total > 0) {
			if (index <= 0) {
				this.first = this.first.getNextNode();
				this.first.setPreNode(null);

			} else if (index >= (total - 1)) {
				this.last = this.last.getPreNode();
				this.last.setNextNode(null);

			} else {
				Node target = searchNode(index);
				target.getPreNode().setNextNode(target.getNextNode());
				target.getNextNode().setPreNode(target.getPreNode());
			}
			total--;
		}
		return total;
	}

	public Node searchNode(int offset) {
		int pos = 0;
		Node target = first;

		while (pos < offset) {
			target = target.getNextNode();
			pos++;
		}
		return target;
	}

	public void printDataList() {
		printDataList(total);
	}

	public void printDataList(int n_Nodes) {
		int count = 0;
		Node current = first;

		while (current != null && count < n_Nodes) {
			System.out.printf(" %d ", current.getData());
			current = current.getNextNode();
			count++;
		}
	}

}