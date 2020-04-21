package com.demo.project.Books.Management;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.project.Books.Management.DTO.Books;
import com.demo.project.Books.Management.DTO.Library;
import com.demo.project.Books.Management.Repository.BooksRepository;
import com.demo.project.Books.Management.Repository.LibraryRepository;

@SpringBootApplication
public class BooksManagementApplication 
//implements CommandLineRunner
{

//	@Autowired
//	LibraryRepository lRepo;
//	
//	@Autowired
//	BooksRepository bRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BooksManagementApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		
//		Library lib=new Library("Library 1");		
//		Library lib1=new Library("Library 2");
//		
//		Books b=new Books("Book 1" ,"100",lib);		
//		Books b1=new Books("Book 2" ,"200",lib1);		
//		Books b3=new Books("Book 3" ,"300",lib);
//		
//		bRepo.saveAll(Arrays.asList(b,b1,b3));
//	}

}
