package lib;

public class StringProcessor {

	public String uniqueString(String input) {
		String check_input = input;
		System.out.println("input: " + input);
		for (int n = 0; n < check_input.length(); n++) {
			String rest = check_input.substring(n + 1);
			rest = rest.replaceAll(Character.toString(check_input.charAt(n)), "");
			check_input = check_input.substring(0, n + 1) + rest;
		}
		System.out.println("output: " + check_input);
		System.out.println();
		return check_input;
	}

	public boolean isAnagrams(String s1, String s2) {
		System.out.println("Input1: " + s1);
		System.out.println("Input2: " + s2);
		
		if (s1.length() != s2.length()) return false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt((s1.length() - 1) - i)) return false;
		}
		return true;
	}

	public boolean isRotation(String s1, String s2) {
		System.out.println("input1: " + s1);
		System.out.println("input2: " + s2);
		
		int pos = s1.indexOf(Character.toString(s2.charAt(0)));
		if (pos < 0) return false;
		String s1_1 = s1.substring(pos).trim();
		String s2_1 = s2.substring(0, s1_1.length()).trim();
		if (!s1_1.equals(s2_1)) return false;
		
		String s1_2 = s1.substring(0, pos);
		String s2_2 = s2.substring(s2_1.length());
		
		if (!s1_2.equals(s2_2)) return false;

		return true;
	}
}