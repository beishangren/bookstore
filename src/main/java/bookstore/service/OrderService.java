package bookstore.service;

import bookstore.domain.Book;
import bookstore.domain.Order;

import java.util.List;

public interface OrderService {

<<<<<<< HEAD
	void save(Order order);

	List<Order> find(); 

	Order findOne(long id);

	void update(long id);
=======
	void buy(Order order);
>>>>>>> branch 'master' of https://github.com/beishangren/bookstore.git

}
