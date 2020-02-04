import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileTutorial {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.println("Which file to write to?: ");
		String fileName = input.nextLine();
		toDocument(fileName);
	}
	public static void toDocument(String fileName) throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter word: ");
		String word = input.nextLine();
		FileWriter fout = new FileWriter(fileName);    
		BufferedWriter bout = new BufferedWriter(fout);
		      
		bout.write(word);    
		bout.flush();    
		bout.close();    
		fout.close();
		    
		System.out.println("success");  
	}

}
