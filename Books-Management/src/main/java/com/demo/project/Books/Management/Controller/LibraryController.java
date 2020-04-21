package com.demo.project.Books.Management.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.project.Books.Management.DTO.Books;
import com.demo.project.Books.Management.DTO.Library;
import com.demo.project.Books.Management.Repository.BooksRepository;
import com.demo.project.Books.Management.Repository.LibraryRepository;

@RestController
public class LibraryController {

	@Autowired
	private LibraryRepository repo;
	
	/* http://localhost:1992/saveLibrary
		{
	  		"libraryName" : "Library 3"
	  	}	  
	  */
	@PostMapping("/saveLibrary")
	public String saveBooks(@Valid @RequestBody Library library , BindingResult result) {
		 String message="Success";
		 
		 if(result.hasErrors()) {
			 message="Please check the payload and send valid inputs.";
		 }else {
			 repo.save(library);
		 }
		 		 
		 return message;
	}

	
}
