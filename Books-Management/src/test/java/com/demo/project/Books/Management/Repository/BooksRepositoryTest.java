package com.demo.project.Books.Management.Repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.project.Books.Management.DTO.Books;
import com.demo.project.Books.Management.DTO.Library;

@DataJpaTest
@RunWith(SpringRunner.class)
class BooksRepositoryTest {

	@Autowired
	BooksRepository brepo;
	
	@Test
	void test() {

	Library r=new Library();
	r.setLibraryName("Lib 1");
	Books book=new Books("Book 100","1000",r);
	brepo.save(book);
	
	Assert.assertNotNull(book.getBookId());
	
	
	}

}
