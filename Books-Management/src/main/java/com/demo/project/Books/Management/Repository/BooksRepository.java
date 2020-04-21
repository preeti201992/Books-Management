package com.demo.project.Books.Management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.project.Books.Management.DTO.Books;

public interface BooksRepository extends JpaRepository<Books, Long>{
	
	List<Books> findByLibrary_libraryId(Long libId);
}
