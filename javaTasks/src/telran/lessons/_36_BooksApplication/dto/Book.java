package telran.lessons._36_BooksApplication.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long isbn;
	String title;
	String author;
	CoverType cover;
	int pages;
	String publisher;
	LocalDate publishDate;
	
	public Book() {
		
	}
	
	public Book(long isbn, String title, String author, CoverType cover, int pages, String publisher,
			LocalDate publishDate) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.cover = cover;
		this.pages = pages;
		this.publisher = publisher;
		this.publishDate = publishDate;
	}
	
	
	public long getIsbn() {
		return isbn;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (isbn ^ (isbn >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn != other.isbn)
			return false;
		return true;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}





	public String getTitle() {
		return title;
	}





	public void setTitle(String title) {
		this.title = title;
	}





	public String getAuthor() {
		return author;
	}





	public void setAuthor(String author) {
		this.author = author;
	}





	public CoverType getCover() {
		return cover;
	}





	public void setCover(CoverType cover) {
		this.cover = cover;
	}





	public int getPages() {
		return pages;
	}





	public void setPages(int pages) {
		this.pages = pages;
	}





	public String getPublisher() {
		return publisher;
	}





	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}





	public LocalDate getPublishDate() {
		return publishDate;
	}





	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	

	
	
}
