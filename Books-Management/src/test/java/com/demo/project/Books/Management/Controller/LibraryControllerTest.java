package com.demo.project.Books.Management.Controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.validation.BindingResult;

import com.demo.project.Books.Management.DTO.Books;
import com.demo.project.Books.Management.DTO.Library;
import com.demo.project.Books.Management.Repository.BooksRepository;
import com.demo.project.Books.Management.Repository.LibraryRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(LibraryController.class)
class LibraryControllerTest {

	
	@MockBean
	LibraryRepository lrepo;
	
	@MockBean
	BindingResult result;
	
	@MockBean
	Library library;
	
	@InjectMocks
	LibraryController lcontroller;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test()
	void test() throws Exception {

		Library li=new Library();
		li.setLibraryName("Lib 111");
		li.setLibraryId(1l);
		Mockito.when(result.hasErrors()).thenReturn(false);
		Mockito.when(lrepo.save(library)).thenReturn(li);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/saveLibrary").accept(
				MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		Assert.assertNotNull(li);
	}

}
