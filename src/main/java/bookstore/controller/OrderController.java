package bookstore.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bookstore.domain.Book;
import bookstore.domain.GoodsProcess;
import bookstore.domain.Order;
import bookstore.domain.Users;
import bookstore.service.BookService;
import bookstore.service.GoodsProcessService;
import bookstore.service.OrderService;
import bookstore.service.UsersService;
import java.util.List;
import org.springframework.security.core.context.SecurityContext;

import javax.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/order")
public class OrderController {

  @Autowired
  private GoodsProcessService goodsProcessService;
  
  @Autowired
  private UsersService usersService;
  
  @Autowired
  private BookService bookService;
  
  @Autowired
  private OrderService orderService;
  
  @ResponseBody
  @RequestMapping(value="/buy",method=POST)
	public void buy(HttpServletRequest request,@RequestParam("id") long id) {
	  Object sec =request.getSession(false).getAttribute("SPRING_SECURITY_CONTEXT");
	  SecurityContext sc = (SecurityContext) sec;
		Users user=usersService.findByUserName(sc.getAuthentication().getName());
		Book book=bookService.findOne(id);
		Order order=new Order();
			order.setName(user.getUserName());
			order.setBookName(book.getName());
			order.setPrice(book.getPrice());
			order.setState("buy");
		orderService.buy(order);
			
			
	}
}
