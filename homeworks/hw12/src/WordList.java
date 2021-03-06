import java.util.ArrayList;

public class WordList {
	private ArrayList<String> wordList;

	/**
	 * Initialize this word list object
	 */
	public WordList() {
		wordList = new ArrayList<>();
		// TODO Add your code here
	}

	/**
	 * Add a word to this word list
	 * 
	 * @param word
	 *            The word to add
	 */
	public void add(String word) {
		wordList.add(word);
		// TODO Add your code here
	}

	/**
	 * Remove the first occurrence of the specified word from this word list
	 * 
	 * @param word
	 *            The word to remove
	 * @return true if word was removed and the list was modified,
	 *         false otherwise.
	 */
	public boolean remove(String word) {
		if (wordList.contains(word)) {
			wordList.remove(word);
			return true;
		}
		return false;
		// TODO Add your code here
	}

	/**
	 * Test whether this list contains the specified word or not
	 * 
	 * @param word
	 *            The word to search for
	 * @return true if word exists in the list, false otherwise.
	 */
	public boolean contains(String word) {
		if (wordList.contains(word)) {
			return true;
		}
		return false;
		// TODO Add your code here
	}

	/**
	 * Remove all words from this word list
	 */
	public void clear() {
		wordList.removeAll(wordList);
		// TODO Add your code here
	}

	/**
	 * Return a reference to the wordList ArrayList
	 * 
	 * @return the wordList ArrayList
	 */
	public ArrayList<String> getWordList() {
		return wordList;
	}

	/**
	 * Calculate the average length of words in this word list. If the list is
	 * empty, return 0
	 * 
	 * @return The average length of words in the list, or 0 in case of an empty
	 *         list
	 */
	public double getAverageWordLength() {
		if (wordList.isEmpty()) {
			return 0;
		}
		double avg = 0;
		for (int i = 0; i < wordList.size(); i++) {
			avg += wordList.get(i).length();
		}
		avg /= wordList.size();
		return avg;
		// TODO Add your code here
	}

	/**
	 * Count the number of occurrences of the specified word in this list
	 * 
	 * @param word
	 *            The word to search for
	 * @return The number of occurrences of this word in the list
	 */
	public int countOccurrences(String word) {
		int i = 0;
		for (int j = 0; j < wordList.size(); j++) {
			if (wordList.get(j).equals(word)) {
				i++;
			}
			continue;
		}
		return i;
		// TODO Add your code here
	}

	/**
	 * Replace all occurrences of one word with another
	 * 
	 * @param oldWord
	 *            The word to be replaced
	 * @param newWord
	 *            The new word to replace all occurrences of old one
	 */
	public void replaceAll(String oldWord, String newWord) {
		for (int i = 0; i < wordList.size(); i++) {
			if (wordList.get(i).equals(oldWord)) {
				wordList.set(i, newWord);
			}
			continue;
		}
		// TODO Add your code here
	}
}