package chapter7;

import java.util.ArrayList;

public class Question5 {
	
	public static void main(String[] args) {
		
	}

}

class Book {
	String genre;
	String author;
	String synopsis;
	
	public Book(String genre, String author, String synopsis) {
		this.author = author;
		this.genre = genre;
		this.synopsis = synopsis;
	}
}

class Library {
	ArrayList<Book> booklist = new ArrayList<>();
	Book currentbook;
	
	public void addBook(Book book) {
		booklist.add(book);
	}
	
	public void setCurrentBook(Book book) {
		this.currentbook = book;
	}
	
	public Book getCurrentBook(Book book) {
		return currentbook;
	}
	
	public ArrayList<Book> searchByGenre(String genre) {
		ArrayList<Book> searchResult = new ArrayList<>();
		for (int i=0; i<booklist.size(); i++) {
			if (booklist.get(i).genre.equals(genre)) {
				searchResult.add(booklist.get(i));
			}
		}
		return searchResult;
	}
	
	public ArrayList<Book> searchByAuthor(String author) {
		ArrayList<Book> searchResult = new ArrayList<>();
		for (int i=0; i<booklist.size(); i++) {
			if (booklist.get(i).author.equals(author)) {
				searchResult.add(booklist.get(i));
			}
		}
		return searchResult;
	}
	
}
