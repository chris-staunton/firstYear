import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineBookStore {
	public static int ISBN_INDEX = 0;
	public static int TITLE_INDEX = 1;
	public static int AUTHOR_INDEX = 2;
	public static int PUBLISHER_INDEX = 3;
	public static int PUBLISHER_YEAR_INDEX = 4;
	public static int QUANTITY_INDEX = 5;
	public static int PRICE_INDEX = 6;
	public static void printBookDetails(ArrayList<Book>bookList) {
		//String printBookDetails = null;
		for(int i=0; i<bookList.size(); i++) {
			System.out.println(bookList.get(i).toString());
		}
		
	}
	public static Book getBook(ArrayList<Book>bookList, String title) {
		Book aBook = null;
		for(int i=0; i<bookList.size(); i++) {
			if(bookList.get(i).getTitle().equals(title)) {
				aBook = bookList.get(i);	
			}
		}
		return aBook;
	}
	public static void topUpCard(ChargeCard card, double amount) {
		card.topUpFunds(amount);
	}
	public static void purchaseBook(ArrayList<Book>bookList) {
		System.out.println("Please enter positive amount to top up your card: ");
		Scanner inputScan = new Scanner(System.in);
		double topUpAmount = inputScan.nextDouble();
		ChargeCard card = new ChargeCard();
		topUpCard(card, topUpAmount);
		boolean finished = false;
		while(!finished) {
			System.out.println(card.getFunds());
			System.out.println("Enter title of book: ");
			String title = inputScan.nextLine();
			Book theBook = getBook(bookList, title);
			if((theBook!=null&&theBook.getQuantity()>0)) {
				if(card.getFunds()>=theBook.getPrice()) {
					int quantity = theBook.getQuantity()-1;
					theBook.setQuantity(quantity);
					card.removeFunds(theBook.getPrice());
				}
				else {
					System.out.println("Non sufficient funds.");
				}
			}
			else {
				System.out.println("Error, book not in stock.");
			}
			System.out.println("Make another purchase or enter quit?");
			String repeat = inputScan.nextLine();
			if(repeat.equals("quit")) {
				finished =true;
			}
		}
		System.out.println("Goodbye.");
	}
	public static void main(String[] args) {
		ArrayList<Book> bookList = new ArrayList<Book>();
		try {
			FileReader fileReader = new FileReader("books.txt");// Enter the entire path of the file if needed
			BufferedReader bufferedReader = new BufferedReader(fileReader);  
			boolean endOfFile = false;
	        while(!endOfFile){
	        	String bookLine = bufferedReader.readLine();
	        	if (bookLine != null) {
	        		String[] bookData = bookLine.split(", ");
	        		String isbn = bookData[ISBN_INDEX];
	        		String title = bookData[TITLE_INDEX];
	        		String author = bookData[AUTHOR_INDEX];
	        		String publisher = bookData[PUBLISHER_INDEX];
	        		int publishYear = Integer.parseInt (bookData[PUBLISHER_YEAR_INDEX]);
	        		int quantity = Integer.parseInt (bookData[QUANTITY_INDEX]);
	        		double price = Double.parseDouble (bookData[PRICE_INDEX]);
	        		Book book = new Book(isbn, title, author, publisher, publishYear, quantity, price);
	        		bookList.add(book);

	        	} else {
	        		endOfFile = true;
	        	}
	        }
	        
	        bufferedReader.close();    
	        fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		printBookDetails(bookList);
		purchaseBook(bookList);
	}
}
