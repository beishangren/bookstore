package bookstore.service;

import bookstore.domain.Book;
import java.util.List;

public interface BookService {
	void create(Book book);

	List<Book> find();

	Book findOne(Long id);
}
