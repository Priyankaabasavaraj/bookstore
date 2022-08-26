package bookstoredb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;


public class insertBook {
	
	
	
	private static Connection connection = null;
	private static Scanner scanner = new Scanner(System.in);

	
	public static void insertBook() {
		try {
		String sql = "insert into book(book_name,author_name,genre,price,book_id) values (?,?,?,?,?)";
		
		PreparedStatement preparedStatement = BookStoreDatabase.connection.prepareStatement(sql);
		System.out.println("Enter book name");
		preparedStatement.setString(1,scanner.nextLine());
		
		System.out.println("Enter author name");
		preparedStatement.setString(2,scanner.nextLine());

		System.out.println("Enter genre");
		preparedStatement.setString(3,scanner.nextLine());
		
		System.out.println("Enter price");
		preparedStatement.setInt(4,Integer.parseInt(scanner.nextLine()));
		
		System.out.println("Enter book id");
		preparedStatement.setInt(5,Integer.parseInt(scanner.nextLine()));
		

		 int rows = preparedStatement.executeUpdate();
		 
		 if(rows>0) {
			 System.out.println("Books added successfully...");
		 }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public  static void viewBookbyGenre() {
		try {
			
			System.out.println("Enter author name to view book");
			String ans=(scanner.nextLine());
			
			String sql="select * from book where author_name = "+ans;
			
			Statement statement = (Statement) connection.createStatement();
			
			ResultSet result = ((java.sql.Statement) statement).executeQuery(sql);
			
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
		catch(Exception e) {
			e.printStackTrace();
		}
	}
public  static void viewBookbyAuthor() {
	try {
		
		System.out.println("Enter author name to view book");
		String ans=(scanner.nextLine());
		
		String sql="select * from book where author_name = "+ans;
		
		Statement statement = (Statement) connection.createStatement();
		
		ResultSet result = ((java.sql.Statement) statement).executeQuery(sql);
		
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
	catch(Exception e) {
		e.printStackTrace();
	}
}
public static void viewBook() 
{
	try
	{

		Statement stmt = null;
		ResultSet res = null;
		String getBooks = "select * from book";
		BookStoreDatabase.res = ((java.sql.Statement) BookStoreDatabase.stmt).executeQuery(getBooks);
		if(((ResultSet) BookStoreDatabase.res).next()  == true)
		{
			do
			{
				System.out.println("book_Id : " + ((ResultSet) BookStoreDatabase.res).getString("book_Id") + "\nbook_name : "
						+ ((ResultSet) BookStoreDatabase.res).getString("book_name") + "\nauthorkName : "
						+ ((ResultSet) BookStoreDatabase.res).getString("author_name") + "\nbookGenre : "
						+ ((ResultSet) BookStoreDatabase.res).getString("genre") + "\nbookPrice : "
						+ ((ResultSet) BookStoreDatabase.res).getString("Price"));
				System.out.println("-------------------------------------------------");
			}while(((ResultSet) BookStoreDatabase.res).next()) ;
		}
		else
		{
			System.out.println("Book Store is empty\n");
		}
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}	
}
public static void SellBook(int book_id){
	try
	{
		PreparedStatement sql =BookStoreDatabase.PreparedStatement("delete from book where book_id=?");
		sql.setInt(1, book_id);
		int rowsAffected=sql.executeUpdate();
		System.out.println("Book sold succesfully!!");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}


}

	

