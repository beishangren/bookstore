package bookstore.service;

import bookstore.domain.Book;
import bookstore.domain.GoodsProcess;
import bookstore.domain.Users;

import java.util.List;

public interface GoodsProcessService {
	void create(GoodsProcess goodsProcess);

	List<Book> findCart(long id);

//	Users findByName(String name);
}
