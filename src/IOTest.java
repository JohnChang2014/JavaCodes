import java.io.*;

/**
 * @author eagle
 * 
 */
public class IOTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
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
