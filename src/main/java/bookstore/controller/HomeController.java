package bookstore.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

//import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import bookstore.domain.Book;
import bookstore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContext;
@Controller
@RequestMapping("/")
public class HomeController {

  @Autowired
  private BookService bookService;
  
  @RequestMapping(method=GET)
  public String index() {
//	Book book=new Book();
//	book.setName("高级编程");
//	book.setPrice(10000);
//	bookService.create(book);
    return "index";
  }

  @RequestMapping(value="/register")
  public String register() {
    return "register";
  }
  
  @RequestMapping(value="/login")
  public String login() {
    return "login";
  }
  
  @RequestMapping(value="/order")
  public String order() {
    return "myOrder";
  }
  
  @RequestMapping(value="/cart")
  public String cart(HttpServletRequest request) {
	Object sec =request.getSession(false).getAttribute("SPRING_SECURITY_CONTEXT");
	if(null != sec)
	{
		SecurityContext sc = (SecurityContext) sec;
		System.out.println("++++++++++++++++++++++++++"+sc.getAuthentication().getName());
	}
    return "shoppingCart";
  }
  
  @RequestMapping(value="/address")
  public String address() {
    return "address";
  }
  
  @RequestMapping(value="/admin")
  public String admin() {
    return "admin";
  }
}
