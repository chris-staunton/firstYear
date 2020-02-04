/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

        Mark out of 5: 5
        Comment:  all variables have easy to understand names

 2. Did I indent the code appropriately?

        Mark out of 5: 5
        Comment:  all code is indented correctly, east to follow

 3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20: 20
        Comment:  i wrote the createCipher function correctly. takes a character array of the alphabet and returns a random array.

 4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:   20
        Comment: i wrote the encrypt function correctly. takes the user input and swaps the letter according to the cipher map

 5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:   20
        Comment: i wrote the decrypt function correctly.  takes the user input(encrypted version) and swaps the letters with the 
        appropriate alphabet characters

 6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?

       Mark out of 25:  25
        Comment: i wrote the main body correctly. I allowed the user to chose if they wanted to encrypt or decrypt some text. 
        		 Then the user enters their text, and it is either encrypted or decrypted. then it repeats.

 7. How well did I complete this self-assessment?

        Mark out of 5: 5
        Comment: assessed honestly

 Total Mark out of 100 (Add all the previous marks): 100

*/  
import java.util.Random;
import java.util.Scanner;

public class Cipher {
	public static final char[] ALPHABET = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ' };
	public static void main(String[] args) {
		char[] cipherMap = createCipher();
		Scanner inputScanner = new Scanner(System.in);
		boolean finished = false;
		while(!finished) {
			try {
				System.out.println("Enter 'encrypt', 'decrypt', or 'quit': ");
				if (inputScanner.hasNext("quit")) 
				{
					System.out.println("The program has terminated.");
					inputScanner.close();
					finished = true;
				}
				else if(inputScanner.hasNext("encrypt"))
				{
					inputScanner.nextLine();
					System.out.println("Enter your text to be encrypted: ");
					String originalText = inputScanner.nextLine();
					char[] originalTextArray = originalText.toCharArray();
					String encryptedText = encrypt(cipherMap, originalTextArray);
					System.out.println("Encrypted text: " + encryptedText);
				}
				else if (inputScanner.hasNext("decrypt"))
				{
					inputScanner.nextLine();
					System.out.println("Enter your text to be decrypted: ");
					String encryptedText = inputScanner.nextLine();
					char[] encryptedTextArray = encryptedText.toCharArray();
					String decryptedText = decrypt(cipherMap, encryptedTextArray);
					System.out.println("Decrypted text: " + decryptedText);
				}
				else
				{
					System.out.println("Error. Please enter a valid input.");
					inputScanner.nextLine();
				}
			}
			catch(java.lang.ArrayIndexOutOfBoundsException exception)
			{
				System.out.println("Invalid input.");
			}
		}
	}
	public static char[] createCipher() {
		char[] cipherMap = ALPHABET.clone();
		  if (ALPHABET!=null)
		  {
		    Random generator = new Random();
		    for (int index=0; index<cipherMap.length; index++ )
		    {
		      int otherIndex = generator.nextInt(cipherMap.length);
		      char temp = cipherMap[index];
		      cipherMap[index] = cipherMap[otherIndex];
		      cipherMap[otherIndex] = temp;
		    }
		  }
		return cipherMap;
	}
	public static String encrypt(char[] cipherMap, char[] originalTextArray) {
		int otherIndex = 0;
		int index = 0;
			while (index < originalTextArray.length) {
				if (originalTextArray[index] == ALPHABET[otherIndex]) {
					originalTextArray[index] = cipherMap[otherIndex];
					otherIndex = 0;
					index++;
				}
				else {
					otherIndex++;
				}
		}
		String encryptedText = new String(originalTextArray);
		return encryptedText;
	}
	public static String decrypt(char[] cipherMap, char[] encryptedTextArray) {
		int otherIndex = 0;
		int index = 0;
			while (index < encryptedTextArray.length) {
				if (encryptedTextArray[index] == cipherMap[otherIndex]) {
					encryptedTextArray[index] = ALPHABET[otherIndex];
					otherIndex = 0;
					index++;
				}
				else {
					otherIndex++;
				}
		}
		String decryptedText = new String(encryptedTextArray);
		return decryptedText;
	}
}