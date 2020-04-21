package com.demo.project.Books.Management.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// LIBRARY Table 
// LIBRARY_ID , LIBRARY_NAME columns

@Entity
@Table(name="LIBRARY")
public class Library {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LIBRARY_ID")
	private Long libraryId;
	
	@Column(name="LIBRARY_NAME")
	private String libraryName;
	
	public Library() {
		
	}

	public Library(String libraryName) {
		super();
		this.libraryName = libraryName;
	}


	public Long getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Long libraryId) {
		this.libraryId = libraryId;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	@Override
	public String toString() {
		return "Library [libraryId=" + libraryId + ", libraryName=" + libraryName +  "]";
	}

}
