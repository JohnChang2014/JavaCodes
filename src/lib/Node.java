/**
 * 
 */
package lib;

/**
 * @author Johnson Chang
 * 
 */
public class Node {
	private Node prev = null;
	private Node[] ref_nodes;
	int key;
	int n_links;

	public Node() {
		this.ref_nodes = new Node[1];
		this.n_links = 1;
	}

	public Node(int n_links) {
		this.ref_nodes = new Node[n_links];
		this.n_links = n_links;
	}

	public Node(int key, int n_links) {
		this.ref_nodes = new Node[n_links];
		this.n_links = n_links;
		this.key = key;
	}
	
	public void setPrevNode(Node node) {
		this.prev = node;
	}
	
	public Node getPrevNode() {
		return this.prev;
	}
	
	public boolean linkNode(int index, Node child) {
		if (index > this.n_links || index < 0) return false;
		this.ref_nodes[index] = child;
		return true;
	}

	public Node[] getAllNodes() {
		return this.ref_nodes;
	}
	
	public Node getNode(int index) {
		if (index > this.n_links || index < 0) return null;
		return this.ref_nodes[index];
	}
}