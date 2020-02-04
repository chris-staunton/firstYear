/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5: 5]
- Comment: return type is string array, takes no parameters. it is public static
- My method reads the words from the "words.txt" file. [Mark out of 5: 5]
- Comment: i used a for loop and readLine to read each word from the file "words.txt".
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5: 5]
- Comment: my method returns all the contents from "words.txt" into a string array.

2. readWordList
- I have the correct method definition [Mark out of 5: 5]
- Comment: return type is ArrayList<String>. takes a string as parameter. it is public static
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5: 5]
- Comment: it returns an arraylist of the words (by using a ", " delimiter)

3. isUniqueList
- I have the correct method definition [Mark out of 5: 5]
- Comment: it is public static. return type is boolean. takes a string arrayList as parameter.
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5: 5]
- Comment: compares each word with each other.
- Exits the loop when a non-unique word is found. [Mark out of 5: 5]
- Comment: the exits the loop once a non-unique word is found
- Returns true is all the words are unique and false otherwise. [Mark out of 5: 5]
- Comment: returns true if all unique, false otherwise.

4. isEnglishWord
- I have the correct method definition [Mark out of 5: 5]
- Comment: it is public static. return type is boolean. takes a String as parameter.
- My method uses the binarySearch method in Arrays library class. [Mark out of 3: 3]
- Comment: i use the binarySearch method to find if the string is contained in the dictionary array.
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2: 2]
- Comment: returns true if binarySearch returns a value >= 0, false otherwise.

5. isDifferentByOne
- I have the correct method definition [Mark out of 5: 5]
- Comment: is public static. return type is boolean. takes 2 strings as parameters.
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10: 10]
- Comment: i used a counter to record the amount of differences. only returns true if the no. of diffs is 1. I changed the strings into char arrays and used a for loop to compare characters.

6. isWordChain
- I have the correct method definition [Mark out of 5: 5]
- Comment: it is public static. return type is boolean. takes a string arrayList as a parameter.
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10: 10]
- Comment:  calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message.

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of the Java.IO classes covered in lectures [Mark out of 10: 10]
- Comment: reads all the words from "words.txt" into a global String array called DICTIONARY.
- Asks the user for input and calls isWordChain [Mark out of 5: 5]
- Comment: repeatedly asks the user for input and calls isWordChain until an empty list is entered.

 Total Mark out of 100 (Add all the previous marks): 100
*/


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordLink {
	public static final String[] DICTIONARY = readDictionary();
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean finished = false;
			while(!finished) {
				System.out.println("Enter a comma separated list of words (or an empty list to quit): ");
				String wordList = input.nextLine();
				if(!wordList.equals("")) {
					ArrayList<String> words = readWordList(wordList);
					if(isWordChain(words)) {
						System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
					}
					else {
						System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
					}
				}
				else {
					finished = true;
					System.out.println("Goodbye.");
					input.close();
				}
			}
	}
	public static boolean isWordChain(ArrayList<String> wordList) {
		boolean isWordChain = false;
		if(isUniqueList(wordList)) {
			isWordChain=true;
			for(int i=0; i<wordList.size(); i++) {
				String firstWord = wordList.get(i);
				if(!isEnglishWord(firstWord)) {
					isWordChain = false;
				}
				if(i+1<wordList.size()) {
					
					String secondWord = wordList.get(i+1);
					if(isEnglishWord(firstWord)&&isEnglishWord(secondWord)) {
						if(!isDifferentByOne(firstWord, secondWord)) {
							isWordChain=false;
						}
					}
					else {
						isWordChain = false;
					}
				}
			}
		}
		return isWordChain;
	}
	public static boolean isDifferentByOne(String firstWord, String secondWord) {
		char[] firstWordArray = firstWord.toCharArray();
		char[] secondWordArray = secondWord.toCharArray();
		int uniqueCharCounter = 0;
		boolean isDifferentByOne = false;
		for(int i=0; i<firstWordArray.length&&uniqueCharCounter<=1; i++) {
			char testLetter = firstWordArray[i];
				if(testLetter!=secondWordArray[i]) {
					uniqueCharCounter++;
				}
		}
		if(uniqueCharCounter==1) {
			isDifferentByOne=true;
		}
		return isDifferentByOne;
	
	}
	public static boolean isEnglishWord(String word) {
		boolean isEnglishWord = false;
		if(Arrays.binarySearch(DICTIONARY, word)>=0) {
			isEnglishWord = true;
		}
		return isEnglishWord;
	}
	public static boolean isUniqueList(ArrayList<String> wordList) {
		boolean unique = true;
		for(int i=0; i<wordList.size() && unique; i++) {
			String testWord = wordList.get(i);
			for(int j = 0; j<wordList.size() && unique; j++) {
				if (testWord.equals(wordList.get(j))&& i!=j) {
					unique = false;
				}
			}
		}
		return unique;
	}
	public static ArrayList<String> readWordList(String wordList){
		String delimiter = ", ";
		String[] word = wordList.split(delimiter);
		ArrayList<String> words = new ArrayList<String>();
		for(int i=0; i<word.length; i++) {
			words.add(word[i]);
		}
		return words;
	}
	public static String[] readDictionary(){
		String[] dictionary = new String[658964];
		String word = null;
		try {
			
			File f = new File("words.txt");
			Scanner in = new Scanner(f);
			for(int i=0; i<658964; i++) {
				word = in.nextLine();
				dictionary[i] = word;
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		return dictionary;
	}
}
