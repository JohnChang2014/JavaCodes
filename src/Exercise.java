
public class Exercise {
	
	public static int recursion(int start) {
		if (start == 0) return 0;
		System.out.println("-> " + start);
		return recursion(start-1);
	}
	
	public static void main(String[] args) {
		//recursion(50);
	}

}
