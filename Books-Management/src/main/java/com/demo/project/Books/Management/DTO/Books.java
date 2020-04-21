package com.demo.project.Books.Management.DTO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// BOOKS table
// BOOK_ID , BOOK_NAME , BOOK_PRICE , LIBRARY_ID columns 

@Entity
@Table(name="BOOKS")
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "BOOK_ID" ,unique = true, nullable = false)
	private Long bookId;
	
	@Column(name = "BOOK_NAME", unique = true)
	private String bookName;
	
	@Column(name = "BOOK_PRICE")
	private String  price;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="LIB_ID")
	private Library library;
	
	public Books() {
		
	}

	
	public Books(String bookName, String price, Library library) {
		super();
		this.bookName = bookName;
		this.price = price;
		this.library = library;
	}


	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
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
		Books other = (Books) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		return true;
	}

}
