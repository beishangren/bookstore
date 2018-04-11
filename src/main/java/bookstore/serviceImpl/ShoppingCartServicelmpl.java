package bookstore.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookstore.domain.Book;
import bookstore.domain.ShoppingCart;
import bookstore.domain.Users;
import bookstore.entity.BookEntity;
import bookstore.entity.ShoppingCartEntity;
import bookstore.entity.UsersEntity;
import bookstore.repositories.BookRepository;
import bookstore.repositories.ShoppingCartRepository;
import bookstore.service.BookService;
import bookstore.service.ShoppingCartService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ShoppingCartServicelmpl implements ShoppingCartService{
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	
	@Override
    @Transactional
	public void create(ShoppingCart shoppingCart) {
		ShoppingCartEntity shoppingCartEntity=new ShoppingCartEntity();
		shoppingCartEntity.setUserId(shoppingCart.getUserId());
		shoppingCartEntity.setGoodsId(shoppingCart.getGoodsId());
		shoppingCartEntity.setBookName(shoppingCart.getBookName());
		shoppingCartEntity.setBookPrice(shoppingCart.getBookPrice());
		shoppingCartRepository.save(shoppingCartEntity);
	}
	
	@Override
    @Transactional
	public List<ShoppingCart> findCart(long id) {
		 List<ShoppingCart> list = new ArrayList<>();
		 shoppingCartRepository.findByUserId(id).forEach(shoppingCartEntity->{
			 list.add(buildShoppingCart(shoppingCartEntity));
		 });
		 return list;
	}
	
	@Override
    @Transactional
	public void del(long id) {
		System.out.println("ÒªÉ¾³ýµÄ"+id);
		 shoppingCartRepository.deleteById(id);
	}
	
	
	public ShoppingCart buildShoppingCart(ShoppingCartEntity shoppingCartEntity) {

		ShoppingCart shoppingCart=new ShoppingCart(
				shoppingCartEntity.getId(),
				shoppingCartEntity.getUserId(),
				shoppingCartEntity.getGoodsId(),
				shoppingCartEntity.getBookName(),
				shoppingCartEntity.getBookPrice()
				);
		
		return shoppingCart;
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
