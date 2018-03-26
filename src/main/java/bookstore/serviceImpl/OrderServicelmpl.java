package bookstore.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookstore.domain.Book;
import bookstore.domain.Order;
import bookstore.entity.BookEntity;
import bookstore.entity.OrderEntity;
import bookstore.repositories.BookRepository;
import bookstore.repositories.OrderRepository;
import bookstore.service.BookService;
import bookstore.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderServicelmpl implements OrderService{
	@Autowired
	private OrderRepository orderRepository;
	
	
	@Override
    @Transactional
	public void buy(Order order) {
		OrderEntity orderEntity=new OrderEntity();
		orderEntity.setName(order.getName());
		orderEntity.setBookName(order.getBookName());
		orderEntity.setPrice(order.getPrice());
		orderEntity.setState(order.getState());
		orderRepository.save(orderEntity);
	}
	
	
}
