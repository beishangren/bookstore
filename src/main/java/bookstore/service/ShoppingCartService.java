package bookstore.service;

import bookstore.domain.Book;
import bookstore.domain.ShoppingCart;
import bookstore.domain.Users;

import java.util.List;

public interface ShoppingCartService {
	void create(ShoppingCart shoppingCart);

	List<ShoppingCart> findCart(long id);

	void del(long id);

//	Users findByName(String name);
}
