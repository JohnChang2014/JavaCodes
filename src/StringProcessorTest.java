import lib.StringProcessor;

public class StringProcessorTest {

	public static void main(String[] args) {

		StringProcessor test = new StringProcessor();
		test.uniqueString("ikstutiklp");
		test.uniqueString("j opj");
		test.uniqueString(" p pto");

		String s1 = "j opj";
		String s2 = "jpo j";
		boolean result = test.isAnagrams(s1, s2);
		if (result) System.out.println("They are anagrams");
		else System.out.println("They are not anagrams");

		System.out.println();
		
		s1     = "erbottlewat";
		s2     = "waterbottle";
		result = test.isRotation(s1, s2);
		if (result) System.out.println("s1 is a rotation of s2");
		else System.out.println("s1 is not a rotation of s2");

	}
}
