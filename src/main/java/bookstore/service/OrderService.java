package bookstore.service;

import bookstore.domain.Book;
import bookstore.domain.Order;

import java.util.List;

public interface OrderService {


	void save(Order order);

	List<Order> find(long id); 

	Order findOne(long id);

	void update(long id);

	void confirm(long id);


}
