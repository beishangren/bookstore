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
	public void save(Order order) {
		OrderEntity orderEntity=new OrderEntity();
		orderEntity.setName(order.getName());
		orderEntity.setBookName(order.getBookName());
		orderEntity.setPrice(order.getPrice());
		orderEntity.setState(order.getState());
		orderEntity.setUserId(order.getUserId());
		orderRepository.save(orderEntity);
	}
	
	@Override
    @Transactional
	public List<Order> find(long id) {
		 List<Order> list = new ArrayList<>();
		 orderRepository.findByUserId(id).forEach(orderEntity->{
			 list.add(buildOrder(orderEntity));
		 });
		 return list;
		
	}
	
	@Override
    @Transactional
	public Order findOne(long id) {
		 OrderEntity orderEntity = new OrderEntity();
		 orderEntity=orderRepository.findOne(id);
		 return buildOrder(orderEntity);	
	}
	
	
	@Override
    @Transactional
	public void update(long id) {
		OrderEntity orderEntity=orderRepository.findOne(id);
		orderEntity.setState("delivery");
		orderRepository.save(orderEntity);
	}
	
	@Override
    @Transactional
	public void confirm(long id) {
		OrderEntity orderEntity=orderRepository.findOne(id);
		orderEntity.setState("complete");
		orderRepository.save(orderEntity);
	}

	public Order buildOrder(OrderEntity orderEntity) {
		Order order=new Order(
				orderEntity.getId(),
				orderEntity.getName(),
				orderEntity.getBookName(),
				orderEntity.getPrice(),
				orderEntity.getState(),
				orderEntity.getUserId()
				);
		return order;
	}

	
}
