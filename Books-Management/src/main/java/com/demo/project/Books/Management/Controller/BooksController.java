package com.demo.project.Books.Management.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.project.Books.Management.DTO.Books;
import com.demo.project.Books.Management.DTO.Library;
import com.demo.project.Books.Management.Repository.BooksRepository;
import com.demo.project.Books.Management.Repository.LibraryRepository;

@RestController
public class BooksController {
	
	@Autowired
	private BooksRepository repo;
	
	@Autowired
	private LibraryRepository lrepo;
	
	/* http://localhost:1992/saveBooks/1
	{
  		"bookName" : "Book 4",
  		"price" :"100"
	}  
    */
	@PostMapping("/saveBooks/{lib}")
	public String saveBooks(@Valid @RequestBody Books books , BindingResult result,@PathVariable(value = "lib") Long lib) {
		 String message="Success";
		 
		 if(result.hasErrors()) {
			 message="Please check the payload and send valid inputs.";
		 }else {
			
			 if(lrepo.existsById(lib)) {
				Library l= lrepo.getOne(lib);
				books.setLibrary(l);
				 repo.save(books);
				 message="The book details got saved in database.";
			 }else {
				 message="The Lib id:"+lib+" is not present in Library table."
				 		+ "Please add the library details first and then try to save the book. ";
			 }
			 		 			
		 }
		 		 
		 return message;
	}
	//http://localhost:1992/getAllBooks
	@GetMapping("/getAllBooks")
	public List<Books> getAllBooks() {
		
		List<Books> books = repo.findAll();
	if(books.isEmpty()) {
		return( new ArrayList<Books>());
	}else {
		return books;
	}
		
	}
	//http://localhost:1992/getBookById?id=1
	@GetMapping("/getBookById")
	public Books getBookById(@RequestParam Integer id) {
		
		Optional<Books>	books=repo.findById(id.longValue());
		Books booksById=books.get();
		
		return booksById;
	}
	
	/*http://localhost:1992/updateBookById/1
	{
		  "bookName" : "Book 123",
		  "price" :"123"
		}
	*/
	@PostMapping("/updateBookById/{bId}")
	public String updateBookById(@Valid @RequestBody Books books , BindingResult result,@PathVariable(value = "bId") Long bId        ) {
		
		String message="";
		if(result.hasErrors()) {
			message="Please enter valid inputs.";
		}else {
			if(repo.existsById(bId)) {
			    Books dbBook=repo.getOne(bId);
			    if(dbBook.getBookName()!=null) {
				    dbBook.setBookName(books.getBookName());
			    }
			    if(dbBook.getPrice()!=null) {
				    dbBook.setBookName(books.getPrice());
			    }
			   
				repo.save(dbBook);
				message="The data got updated for book with id :"+bId;
			}else {
				message="The book with id: "+ bId+" is not present in the database.";
			}
		}
		
		return message;
	}

	//http://localhost:1992/getAllBookByLibId?libId=2
	@GetMapping("/getAllBookByLibId")
	public List<Books> getAllBookByLibId(@RequestParam Integer libId) {
		
		if(lrepo.existsById(libId.longValue())) {
			List<Books> books=repo.findByLibrary_libraryId(libId.longValue());
			return books;
		}else {
			return (new ArrayList<Books>());
		}
		
		
	}
	
	//http://localhost:1992/deleteBookById?bId=1
	@GetMapping("/deleteBookById")
	public String deleteBookById(@RequestParam Integer bId) {
		
		String message="";
		if(repo.existsById(bId.longValue())) {
			repo.deleteById(bId.longValue());
			message="The book with id :"+bId+" is deleted from the database";
		}else {
			message="The requested Book with id :"+bId+" is not present in the database.";
		}
		
		return message;
		
	}
	
	
}
