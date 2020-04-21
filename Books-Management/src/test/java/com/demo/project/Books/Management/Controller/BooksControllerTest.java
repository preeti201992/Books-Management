package com.demo.project.Books.Management.Controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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

import com.demo.project.Books.Management.DTO.Books;
import com.demo.project.Books.Management.DTO.Library;
import com.demo.project.Books.Management.Repository.BooksRepository;
import com.demo.project.Books.Management.Repository.LibraryRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(BooksController.class)
class BooksControllerTest {
	
	@MockBean
	private LibraryRepository lrepo;
	
	@MockBean
	BooksRepository brepo;
	
	@InjectMocks
	BooksController b;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        
    }
	
	@Test
	void test() throws Exception {
		Library l1=new Library("lib 1");
		List<Library> value=new ArrayList<Library>();
		value.add(l1);
		Mockito.when(lrepo.findAll()).thenReturn(value);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/getAllBooks").accept(
				MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	}

}
