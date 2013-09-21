package lib;

/**
 * SentenceProcessor
 */
public class SentenceProcessor {
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
