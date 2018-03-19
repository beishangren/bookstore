package bookstore.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookstore.domain.Book;
import bookstore.entity.BookEntity;
import bookstore.repositories.BookRepository;
import bookstore.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookServicelmpl implements BookService{
	@Autowired
	private BookRepository bookRepository;
	
	
	@Override
    @Transactional
	public void create(Book book) {
		BookEntity bookEntity=new BookEntity();
		bookEntity.setName(book.getName());
		bookEntity.setPrice(book.getPrice());
		bookEntity.setImage(book.getImage());
		bookEntity.setNumber(book.getNumber());
		bookRepository.save(bookEntity);
	}
	
	@Override
    @Transactional
	public List<Book> find() {
		 List<Book> list = new ArrayList<>();
		 

		 bookRepository.findAll().forEach(bookEntity->{
			 list.add(buildBook(bookEntity));
		 });
		 return list;
		
	}
	
	public Book buildBook(BookEntity bookEntity) {

		Book book=new Book(
				bookEntity.getId(),
				bookEntity.getName(),
				bookEntity.getPrice(),
				bookEntity.getImage(),
				bookEntity.getNumber()
				);
		
		return book;
	}
}
