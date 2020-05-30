package telran.lessons._36_BooksApplication.controllers;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

import telran.lessons._36_BooksApplication.dto.Book;

public class BookRestoreAppl {

	public static void main(String[] args) throws Exception {
	try(ObjectInputStream iso = new ObjectInputStream(new FileInputStream("books.data"))) {
		@SuppressWarnings("unchecked")
		List<Book> books = (List<Book>) iso.readObject();
		books.forEach(System.out::println);
	}
}
}
