package com.demo.project.Books.Management.Repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.project.Books.Management.DTO.Library;

@DataJpaTest
@RunWith(SpringRunner.class)
class LibraryRepositoryTest {

	@Autowired
	LibraryRepository lrepo;
	
	@Test
	void test() {

		Library r=new Library();
		r.setLibraryName("Lib 5");
		lrepo.save(r);
		Assert.assertNotNull(r.getLibraryId());
	}

}
