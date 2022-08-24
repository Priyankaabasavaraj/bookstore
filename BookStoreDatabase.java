package bookstoredb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BookStoreDatabase {
	private static Connection connection = null;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		BookStoreDatabase id = new BookStoreDatabase();
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dbURL = "jdbc:mysql://localhost:3306/bookstore";
		String username = "root";
		String password = "Priyanka&34";

		connection = DriverManager.getConnection(dbURL, username, password);
		System.out.println("Enter your choice:");
		System.out.println("1. Insert values into book");
		System.out.println("2. Sell book");
		System.out.println("3. view books");
		System.out.println("4. Exit!!!!");
		int choice = Integer.parseInt(scanner.nextLine());
		
		switch(choice) {
		case 1:
			id.insertBook();
			break;	
			
		case 2:
			id.sellBook();
			break;	
			
		case 3:
			id.viewBook();
			break;	

		case 4:
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
	
	public void insertBook() throws SQLException {
		
		String sql = "insert into book(book_name,author_name,genre,price,book_id) values (?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		System.out.println("Enter book name");
		preparedStatement.setString(1,scanner.nextLine());
		
		System.out.println("Enter author name");
		preparedStatement.setString(2,scanner.nextLine());

		System.out.println("Enter genre");
		preparedStatement.setString(3,scanner.nextLine());
		
		System.out.println("Enter price");
		preparedStatement.setInt(4,Integer.parseInt(scanner.nextLine()));
		
		System.out.println("Enter book id");
		preparedStatement.setString(5,scanner.nextLine());


		 int rows = preparedStatement.executeUpdate();
		 
		 if(rows>0) {
			 System.out.println("Record inserted successfully...");
		 }
	}
	
	
	public void sellBook() throws SQLException{
		
		System.out.println("Enter book id to sell");
		int book_id=Integer.parseInt(scanner.nextLine());
		
		String sql="delete from book where book_id="+book_id;
		Statement statement=connection.createStatement();
		int rows=statement.executeUpdate(sql);
		if(rows>0) {
			System.out.println("Book sold successfully...");
			
		}
	}
	
	
	public void viewBook() throws SQLException{
		
		System.out.println("Enter book id to view book");
		int number=Integer.parseInt(scanner.nextLine());
		
		String sql="select * from book where book_id = "+number;
		
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		if(result.next()) {		
			int book_id = result.getInt("book id");
			String book_name=result.getString("book name");
			String author_name=result.getString("author name");
			String genre=result.getString("genre");
			int price = result.getInt("price");
			
			System.out.println("book id: "+book_id);
			System.out.println("book name: "+book_name);
			System.out.println("author name: "+author_name);
			System.out.println("genre: "+genre);
			System.out.println("price: "+price);
		}
		else {
			System.out.println("No book found!!");
		}
		}
	}


