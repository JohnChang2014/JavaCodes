/**
 * 
 */
package lib;

/**
 * @author Johnson Chang
 * 
 */
public class BinarySearchTree extends Tree {
	
	private Node leftChild() {
		return this.current.getNode(0);
	}

	private Node rightChild() {
		return this.current.getNode(1);
	}

	public boolean insertKey(int key) {

		/*
		 * case 1: if tree is empty, then insert the key as root node
		 */
		if (this.n_nodes == 0) {
			this.root = new Node(this.degree);
			this.root.key = key;
			this.current = this.root;
			this.n_nodes++;
			return false;
		}

		/*
		 * case 2: if the new key is smaller than the key of current node, then
		 * go into the left child of current node and compare again.
		 */
		if (key < this.current.key) {
			if (leftChild() == null) {
				Node child = new Node(key, this.degree);
				child.setPrevNode(this.current);
				this.current.linkNode(0, child);
				this.n_nodes++;
				return true;
			} else {
				this.current = leftChild();
				insertKey(key);
			}

			/*
			 * case 3: if the new key is greater than or equal to the key of
			 * current node, then go into the right child of current node and
			 * compare again.
			 */
		} else if (key >= this.current.key) {
			if (rightChild() == null) {
				Node child = new Node(key, this.degree);
				child.setPrevNode(this.current);
				this.current.linkNode(1, child);
				this.n_nodes++;
				return true;
			} else {
				this.current = rightChild();
				insertKey(key);
			}
		}

		this.current = this.root;
		return true;
	}

	private Node searchKeyFromNode(Node start, int key) {
		this.current = start;

		/*
		 * case 1: if tree is empty, return false as no match
		 */
		if (this.n_nodes == 0) return null;

		/*
		 * case 2: if key is located in current node, return true as a match
		 */
		if (this.current.key == key) return this.current;

		/*
		 * case 3: if current node is a leaf node, return false as no match
		 */
		if (leftChild() == null && rightChild() == null) return null;

		/*
		 * case 4: go further in to child nodes to search if the key exists in
		 * the tree
		 */
		if (leftChild() != null && key < this.current.key) {
			return searchKeyFromNode(leftChild(), key);
		} else if (rightChild() != null && key >= this.current.key) {
			return searchKeyFromNode(rightChild(), key);
		}
		return null;
	}

	public boolean searchKey(int key) {
		Node result = searchKeyFromNode(this.root, key);
		if (result == null) return false;
		return true;
	}

	private boolean deleteKeyFromNode(Node start, int key) {
		Node target = searchKeyFromNode(start, key);
		Node left = target.getNode(0);
		Node right = target.getNode(1);

		/*
		 * case 1: if target is a leaf node, set null to its parent reference
		 * and its parent node's reference.
		 */
		if (left == null && right == null) {
			removeNodeFromParent(target);
			target.setPrevNode(null);
			return true;
		}

		/*
		 * case 2: if target has two child nodes or only has left child node,
		 * find maximum key from its left subtree and then switch its key and
		 * maximum key.
		 */
		if ((left != null && right != null) || (left != null && right == null)) {
			Node max = searchLeftMaximum(target.getNode(0));
			switchKey(target, max);
			return true;
		}

		/*
		 * case 3: if target only has right child nodes, find minimum key from
		 * its right subtree and then switch its key and minimum key.
		 */
		if (left == null && right != null) {
			Node min = searchRightMinimum(target.getNode(1));
			switchKey(target, min);
			return true;
		}

		return false;
	}

	public boolean deleteKey(int key) {
		this.current = this.root;
		return deleteKeyFromNode(this.current, key);
	}

	public Node searchLeftMaximum(Node start) {
		while (start.getNode(1) != null) {
			start = start.getNode(1);
		}
		return start;
	}

	public Node searchRightMinimum(Node start) {
		while (start.getNode(0) != null) {
			start = start.getNode(0);
		}
		return start;
	}

	private boolean removeNodeFromParent(Node target) {
		if (target == null) return false;
		Node parent = target.getPrevNode();
		if (parent.getNode(0) == target) parent.linkNode(0, null);
		if (parent.getNode(1) == target) parent.linkNode(1, null);
		return true;
	}

	private boolean switchKey(Node target, Node replacement) {
		target.key = replacement.key;
		deleteKeyFromNode(replacement, replacement.key);
		return true;
	}

	private void traverse(Node start, String order) {
		Node left  = start.getNode(0);
		Node right = start.getNode(1);
		
		if (order == "preorder") {
			System.out.printf("%3d ", start.key);
			if (left != null) traverse(left, order);
			if (right != null) traverse(right, order);
		}
		
		if (order == "inorder") {
			if (left != null) traverse(left, order);
			System.out.printf("%3d ", start.key);
			if (right != null) traverse(right, order);
		}

		if (order == "postorder") {
			if (left != null) traverse(left, order);
			if (right != null) traverse(right, order);
			System.out.printf("%3d ", start.key);
		}
	}

	public void printData(String order) {
		traverse(this.root, order);
		System.out.println();
	}
}
