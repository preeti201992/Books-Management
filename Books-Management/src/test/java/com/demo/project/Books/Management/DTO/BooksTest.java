package com.demo.project.Books.Management.DTO;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class BooksTest {

	Books book=new Books();
	
	@MockBean
	Library library;

	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	void testGettersAndSetters() {

		book.setBookId(1l);
		book.setBookName("bookName");
		book.setPrice("price");
		book.setLibrary(library);
		
		book.getBookId();
		book.getBookName();
		book.getPrice();
		book.getLibrary();
		
		Assert.assertNotNull(book);
		
	}
	
	@Test
	void testToString() {
		
		Assert.assertNotNull(book.toString());
		
	}
	@Test
	void testConstructor() {
		
		Books b1=new Books("Book1","1000",library);
		Assert.assertNotNull(b1);
		
	}
	@Test
	void testEquals() {
		
		Books b1=new Books();
		book.equals(null);
		book.equals(b1);
		Assert.assertNotNull(book.equals(book));
		
	}
	

}
