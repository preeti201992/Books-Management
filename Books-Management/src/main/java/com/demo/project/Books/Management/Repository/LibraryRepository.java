package com.demo.project.Books.Management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.project.Books.Management.DTO.Library;

public interface LibraryRepository extends JpaRepository<Library, Long>{

}
