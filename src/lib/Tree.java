/**
 * 
 */
package lib;

/**
 * @author Johnson Chang
 *
 */
public abstract class Tree {
	Node root;
	Node current;
	int degree  = 0;
	int n_nodes = 0;
	
	public Tree() {
		this.degree = 2;
	}
	
	public Tree(int degree) {
		this.degree = degree;	
	}
		
	public abstract boolean insertKey(int key);
	
	public abstract boolean searchKey(int key);
	
	public abstract boolean deleteKey(int key);
	
	public Node parent() {
		return this.current.getPrevNode();
	}
}
