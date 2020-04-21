package com.demo.project.Books.Management.DTO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class LibraryTest {

	Library lib=new Library();
	
	@Test
	void testSettersAndGetters() {

		lib.setLibraryId(1L);
		lib.setLibraryName("libraryName");
		lib.getLibraryId();
		lib.getLibraryName();
		
		Assert.assertNotNull(lib);
	}
	
	@Test
	void testToString() {
		Assert.assertNotNull(lib.toString());
	}
	@Test
	void testToConstructor() {
		
		Library lib=new Library("libraryName");
		Assert.assertNotNull(lib);
	}

}
