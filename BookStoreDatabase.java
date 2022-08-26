package bookstoredb;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;


public class BookStoreDatabase {
	static Connection connection = null;
	private static Scanner scanner = new Scanner(System.in);
	public static Object stmt;
	public static Object res;

	public static void main(String[] args) {
		//BookStoreDatabase bds= new BookStoreDatabase();
		

		try {
			Statement stmt = null;
			ResultSet resSet = null;
			ResultSet res = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dbURL = "jdbc:mysql://localhost:3306/bookstore";
		String username = "root";
		String password = "Priyanka&34";

		connection = DriverManager.getConnection(dbURL, username, password);
		System.out.println("Enter your choice:");
		System.out.println("1. Add book");
		System.out.println("2. view book by genre ");
		System.out.println("3. view book  by author");
		System.out.println("4. sell book");
		System.out.println("5. view stock");
		System.out.println("6. Exit!!");
		
		int choice = Integer.parseInt(scanner.nextLine());
		
		switch(choice) {
		case 1:
		      insertBook.insertBook();
			break;
			
		case 2:
			insertBook.viewBookbyGenre();	     
			break;
			
		case 3:
			insertBook.viewBookbyAuthor();	     
			break;
			
		case 4:
			insertBook.viewBook();
			break;
			
		case 5:
			int book_id = 0;
			insertBook.SellBook(book_id);
			break;
			
		case 6:
			 System.out.println("Thank you!!!!!!!!!!!! please exit............");
		      break;
		      default : System.out.println("Please enter a valid numbers");
		      break;
			
		}
		}
		catch(Exception e) {
			throw new RuntimeException("Something went wrong");
			
		}
	}

	public static PreparedStatement PreparedStatement(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
	
	
	
