# Books-Management

Created Project with below technologies
1. SpringBoot : Web
2. JPA
3. H2 Database
4. Test : Junit and Mockito

Please uncomment the lines of BooksManagementApplication related to CommandLineRunner to populate the tables in H2 database.

PFB the APIs created

1. Save book details 

http://localhost:1992/saveBooks/<library_id>

Payload
 
 {
  		"bookName" : "Book 4",
  		"price" :"100"
	}  
 
2. Fetch All books details

http://localhost:1992/getAllBooks

3. Fetch book details specific to a Book id.

http://localhost:1992/getBookById?id=1    id is bookId

4. Update book details 

http://localhost:1992/updateBookById/1
	{
		  "bookName" : "Book 123",
		  "price" :"123"
		}
  
 5. Fetch all books specific to a library id
 
 http://localhost:1992/getAllBookByLibId?libId=2
 
 6. Delete a book
 
 http://localhost:1992/deleteBookById?bId=1
 
 7. Save Library details
 
 http://localhost:1992/saveLibrary
		{
	  		"libraryName" : "Library 3"
	  	}
