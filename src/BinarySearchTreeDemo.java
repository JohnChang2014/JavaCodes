/**
 * 
 */
import lib.BinarySearchTree;


/**
 * @author Johnson chang
 *
 */
public class BinarySearchTreeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BinarySearchTree myBST = new BinarySearchTree();
		int[] input = {5, 3 ,1 , 4, 10, 9 ,7 , 8};
		
		System.out.println("Insert keys demo -------------");
		System.out.println(" Input: ");
		for (int data : input) {
			System.out.printf("%3d ", data);
			myBST.insertKey(data);
		}
		System.out.println();
		
		System.out.println("Output: ");
		myBST.printData("preorder");
		myBST.printData("inorder");
		myBST.printData("postorder");
		
		System.out.println();
		System.out.println("Search key demo -------------");
		System.out.print("Search for 10: ");
		if (myBST.searchKey(10)) System.out.println("exist!");
		else System.out.println("not exist!");
		System.out.print("Search for 12: ");
		if (myBST.searchKey(12)) System.out.println("exist!");
		else System.out.println("not exist!");
		System.out.print("Search for 3: ");
		if (myBST.searchKey(3)) System.out.println("exist!");
		else System.out.println("not exist!");
		
		System.out.println();
		System.out.println("Delete key demo -------------");
		System.out.print("Delete for 1: ");
		if (myBST.deleteKey(1)) {
			System.out.println("success");
			myBST.printData("inorder");
		} 
		System.out.print("Delete for 7: ");
		if (myBST.deleteKey(7)) {
			System.out.println("success");
			myBST.printData("inorder");
		}
		
		System.out.print("Delete for 5: ");
		if (myBST.deleteKey(5)) {
			System.out.println("success");
			myBST.printData("inorder");
		}
	}

}
