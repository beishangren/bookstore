package bookstore.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bookstore.domain.Book;
import bookstore.domain.ShoppingCart;
import bookstore.domain.Users;
import bookstore.service.BookService;
import bookstore.service.ShoppingCartService;
import bookstore.service.UsersService;
import java.util.List;
import org.springframework.security.core.context.SecurityContext;

import javax.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/shop")
public class ShoppingCartController {

  @Autowired
  private ShoppingCartService shoppingCartService;
  
  @Autowired
  private UsersService usersService;
  
  @Autowired
  private BookService bookService;
  
  @ResponseBody
  @RequestMapping(value="/cart",method=POST)
	public String addGoods(HttpServletRequest request,@RequestParam("id") long id) {
	  Object sec =request.getSession(false).getAttribute("SPRING_SECURITY_CONTEXT");
	  SecurityContext sc = (SecurityContext) sec;
	  Users user=usersService.findByUserName(sc.getAuthentication().getName());
	  Book book=bookService.findOne(id);
	  ShoppingCart goodsProcess=new ShoppingCart();
		goodsProcess.setUserId((int)user.getId());
		goodsProcess.setGoodsId(id);
		goodsProcess.setBookName(book.getName());
		goodsProcess.setBookPrice(book.getPrice());
		shoppingCartService.create(goodsProcess);
		System.out.println("已添加到购物车");
		return "success";
		
	}
  
  @ResponseBody
  @RequestMapping(value="/findCart",method=POST)
	public List<ShoppingCart> findCart(HttpServletRequest request) {
	  Object sec =request.getSession(false).getAttribute("SPRING_SECURITY_CONTEXT");
	  SecurityContext sc = (SecurityContext) sec;

		Users user=usersService.findByUserName(sc.getAuthentication().getName());
		List<ShoppingCart> shoppingCart=shoppingCartService.findCart(user.getId());
		
		return shoppingCart;
	}
  
 
  @RequestMapping(value="/delete",method=POST)
	public void del(HttpServletRequest request,@RequestParam("id") long id) {
	  shoppingCartService.del(id);
//	  return "success";
	}
}
