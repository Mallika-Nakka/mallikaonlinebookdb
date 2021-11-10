
/*Author @mallika
version 0.1
*/

package com.bookapp.main;

import java.sql.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.bookapp.bean.Book;
import com.bookapp.dao.BookImpl;
import com.bookapp.dao.BookInter;
import com.bookapp.dao.ModelDAO;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;

public class Client {

	public static void main(String[] args) {
        
		boolean t = true;
		while (t) {
			System.out.println();
			System.out.println("Welcome to knowledge storage");
			System.out.println("please enter ");
			System.out.println("1)To add book to DB  2)Update a book ");
			System.out.println("3)Delete a book  4)Get a book by Author ");
			System.out.println("5)Get book by Category  6)To get all the available books");
			System.out.println("7)Get book by Id");
			System.out.println("Enter 8 to exit from the website");
			Scanner sc = new Scanner(System.in);
			int number = sc.nextInt();
			BookInter book = new BookImpl();
			//using the switch cases to know the user requirment
			switch (number) {
			case 1:
				System.out.println("How many books you wants add");
				int bookCount = sc.nextInt();
				System.out.println("Enter the details of book liike title,author,category,bookId,price");
				for (int i = 0; i < bookCount; i++) {
					String title = sc.next();
					String author = sc.next();
					String category = sc.next();
					int bookId = sc.nextInt();
					int price = sc.nextInt();
					Book book1 = new Book(title, author, category, bookId, price);
					book.addBook(book1);

				}
				System.out.println("Books added successfully");
				break;
			case 2:
				System.out.println("Enter bookId and the new price that you wants to update the price of the book");
				int bookId = sc.nextInt();
				int price = sc.nextInt();
				book.updateBook(bookId, price);

				System.out.println("Updated Successfully");

				break;
			case 3:
				System.out.println("Enter bookId that you wants to delete");
				int bookId1 = sc.nextInt();
				try {
					book.deleteBook(bookId1);
					System.out.println("Deleted Successfully");
				} catch (BookNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Enter the author name to find the realted author books");
				String authorName = sc.next();
				try {
					book.getBookbyAuthor(authorName);
				} catch (AuthorNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 5:
				System.out.println("Enter the category  to find the realted category books");
				String category = sc.next();
				try {
					book.getBookbycategory(category);
				} catch (CategoryNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 6:
				System.out.println("All the stuff is here");
				book.getAllBooks();
				break;
			case 7:
				System.out.println("Enter book id to get the details");
				int bookId2=sc.nextInt();
				try {
					book.getBookById(bookId2);
				} catch (BookNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 8:
				System.out.println("Exited");
				t = false;
			default:
				System.exit(10);
				System.out.println("Exited");
			}

		}

	}

}
