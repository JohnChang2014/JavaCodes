import java.util.ArrayList;
import java.io.*;

class ArrayProcessor {
	int[][] pic;

	public ArrayProcessor(int[][] pic) {
		this.pic = pic;
	}

	public int[][] rotateImage(int direction) {
		int[][] result = new int[pic.length][pic.length];
		int N = pic.length;
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
				// System.out.println(pic[r][c] + ":(" + r +"," + c + ") --> ("
				// + new_r + "," + new_c + ")");
				result[new_r][new_c] = pic[r][c];
			}
		}

		return result;
	}

	public int[][] matrixZero() {
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();

		for (int i = 0; i < pic.length; i++) {
			for (int j = 0; j < pic[0].length; j++) {
				if (pic[i][j] == 0) {
					x.add(i);
					y.add(j);
				}
			}
		}

		for (int i = 0; i < x.size(); i++) {
			int r = x.get(i);
			int c = y.get(i);
			for (int k = 0; k < pic.length; k++)
				pic[k][c] = 0;
			for (int j = 0; j < pic[0].length; j++)
				pic[r][j] = 0;
		}
		return pic;
	}
}

class StringProcessor {
	String input;

	public StringProcessor() {
	}

	public StringProcessor(String input) {
		this.input = input;
		System.out.println(" input: " + input);
	}

	public String uniqueString() {
		String check_input = input;
		for (int n = 0; n < check_input.length(); n++) {
			String rest = check_input.substring(n + 1);
			rest = rest
					.replaceAll(Character.toString(check_input.charAt(n)), "");
			// System.out.println("rest --> "+rest);
			check_input = check_input.substring(0, n + 1) + rest;
			// System.out.println(check_input.length() + ", new -->"+
			// check_input);
		}
		System.out.println("output: " + check_input);
		return check_input;
	}

	public boolean isAnagrams(String s1, String s2) {
		System.out.println("Input1: " + s1);
		System.out.println("Input2: " + s2);
		if (s1.length() != s2.length()) return false;
		for (int i = 0; i < s1.length(); i++) {
			System.out
					.println(s1.charAt(i) + " v.s. " + s2.charAt((s1.length() - 1) - i));
			if (s1.charAt(i) != s2.charAt((s1.length() - 1) - i)) return false;
		}
		return true;
	}

	public boolean isSubstring(String s1, String s2) {
		int pos = s1.indexOf(Character.toString(s2.charAt(0)));
		if (pos < 0) return false;
		String s1_1 = s1.substring(pos).trim();
		String s2_1 = s2.substring(0, s1_1.length()).trim();
		System.out.println("L1-> " + s1_1 + " v.s. " + s2_1);
		if (!s1_1.equals(s2_1)) return false;
		System.out.println("phase 2");
		String s1_2 = s1.substring(0, pos);
		String s2_2 = s2.substring(s2_1.length());
		System.out.println("L2-> " + s1_2 + " v.s. " + s2_2);
		if (!s1_2.equals(s2_2)) return false;

		System.out.println("===> " + s2 + " is a rotation of " + s1);
		return true;
	}
}

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

class LinkedList {
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

/**
 * MultiplicationTable
 */
class MultiplicationTable {
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

/**
 * SentenceProcessor
 */
class SentenceProcessor {
	String sentence;

	public SentenceProcessor(String sen) {
		System.out.println(" Input: " + sen);
		setSentence(sen);
	}

	public void setSentence(String sen) {
		this.sentence = sen;
	}

	public String[] getWordsetOfSentence() {
		return this.sentence.split("\\s");
	}

	public String reverseWordsOfSentence() {
		StringBuffer sb = new StringBuffer();
		String[] wordset = this.getWordsetOfSentence();

		for (String s : wordset)
			sb.insert(0, s).insert(0, ' ');

		String result = sb.toString().trim();
		System.out.println("Output: " + result);
		return result;
	}
}

/**
 * @author eagle
 * 
 */
public class AllTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * MultiplicationTable myMultiplication = new MultiplicationTable(7);
		 * myMultiplication.printMultiplicationTable();
		 */

		/*
		 * String sentence = "reverse the word"; SentenceProcessor mySen = new
		 * SentenceProcessor(sentence); mySen.reverseWordsOfSentence();
		 */

		/*
		 * LinkedList myList = new LinkedList();
		 * 
		 * for (int n = 1; n <= 10; n++) { int data = (int)
		 * Math.round((Math.random() * 20)); int offset = (int)
		 * Math.round(Math.random() * myList .getTotalNodes()); Node node = new
		 * Node(data); System.out.println(data + " -> offset: " + offset);
		 * myList.insertNode(offset, node); System.out.print("Current list: ");
		 * myList.printDataList(); System.out.println(); }
		 * 
		 * System.out.println("Print my linkedlist:"); myList.printDataList();
		 * System.out.println();
		 */

		/*
		 * Queue myQueue = new Queue();
		 * 
		 * for (int n = 1; n <= 10; n++) { int data = (int)
		 * Math.round((Math.random() * 20)); myQueue.enqueue(data);
		 * System.out.print("Current queue: "); myQueue.printDataList();
		 * System.out.println();
		 * 
		 * if (n > 5) { System.out.println("Take out: " + myQueue.dequeue());
		 * System.out.print("Current queue: "); myQueue.printDataList();
		 * System.out.println(); } }
		 * 
		 * System.out.println("Print my queue:"); myQueue.printDataList();
		 * System.out.println();
		 */

		/*
		 * String input = "ikstutiklp"; String input = "j opj"; String input =
		 * " p  pto"; StringProcessor test = new StringProcessor(input); String
		 * result = test.uniqueString();
		 */

		/*
		 * String s1 = "j opj"; String s2 = "jpo j"; StringProcessor test = new
		 * StringProcessor(s1); boolean result = test.isAnagrams(s1, s2);
		 * System.out.println(result);
		 */

		/*
		 * int[][] pic = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, {
		 * 13, 14, 15, 16 } }; for (int[] r : pic) { for (int c : r) {
		 * System.out.printf(" %2d ", c); } System.out.println(); }
		 * System.out.println("After rotation in counterclockwise----->");
		 * ArrayProcessor test = new ArrayProcessor(pic); int[][] result =
		 * test.rotateImage(0); for (int[] r : result) { for (int c : r) {
		 * System.out.printf(" %2d ", c); } System.out.println(); }
		 * System.out.println("After rotation in clockwise----->"); result =
		 * test.rotateImage(1); for (int[] r : result) { for (int c : r) {
		 * System.out.printf(" %2d ", c); } System.out.println(); }
		 */

		/*
		 * int[][] pic = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 0, 12 }};
		 * 
		 * for (int[] r : pic) { for (int c : r) { System.out.printf(" %2d ",
		 * c); } System.out.println(); }
		 * 
		 * System.out.println("After matrix zero----->"); ArrayProcessor test =
		 * new ArrayProcessor(pic); int[][] result = test.matrixZero(); for
		 * (int[] r : result) { for (int c : r) { System.out.printf(" %2d ", c);
		 * } System.out.println(); }
		 */
		/*
		 * StringProcessor test = new StringProcessor(); String s2 =
		 * "waterbottle"; String s1 = "erbottlewat"; boolean result =
		 * test.isSubstring(s1, s2); System.out.println(result);
		 */
		/*
		 * char c; // Create a BufferedReader using System.in BufferedReader br
		 * = new BufferedReader(new InputStreamReader(System.in));
		 * System.out.println("Enter characters, 'q' to quit."); // read
		 * characters do { c = (char) br.read(); System.out.println(c); } while
		 * (c != 'q');
		 */

		/*
		 * // Read a string from console using a BufferedReader. // Create a
		 * BufferedReader using System.in BufferedReader br = new
		 * BufferedReader(new InputStreamReader(System.in)); String str;
		 * System.out.println("Enter lines of text.");
		 * System.out.println("Enter 'end' to quit."); do { str = br.readLine();
		 * System.out.println(str); } while (!str.equals("end"));
		 */

		// Read a string from console using a BufferedReader.
		// Create a BufferedReader using System.in
		FileInputStream f = new FileInputStream("./files/list.txt");
		FileWriter of = new FileWriter("./files/list_result.txt");
		BufferedReader fileReader = new BufferedReader(new InputStreamReader(f));
		BufferedWriter fileWriter = new BufferedWriter(of);
		String str = fileReader.readLine();
		while (str != null ) {
			System.out.println(str);
			fileWriter.write("checked " + str);
			fileWriter.newLine();
			str = fileReader.readLine();
		} 
		fileWriter.flush();
		f.close();
		of.close();
	}

}
