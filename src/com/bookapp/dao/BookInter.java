
/*Author @mallika
version 0.1
*/

package com.bookapp.dao;

import java.util.List;

import com.bookapp.bean.Book;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;

public interface BookInter {
	void addBook(Book book);
	boolean deleteBook(int bookId) throws BookNotFoundException;
	Book getBookById(int bookId) throws BookNotFoundException;
	boolean updateBook(int bookId,int price);
	
	
	List<Book> getAllBooks();
	List<Book> getBookbyAuthor(String author) throws AuthorNotFoundException;
	List<Book> getBookbycategory(String category) throws CategoryNotFoundException;
	
}
