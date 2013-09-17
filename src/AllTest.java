import java.util.ArrayList;
import java.io.*;





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
