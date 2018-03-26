package bookstore.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bookstore.domain.Book;
import bookstore.domain.GoodsProcess;
import bookstore.domain.Users;
import bookstore.service.BookService;
import bookstore.service.GoodsProcessService;
import bookstore.service.UsersService;
import java.util.List;
import org.springframework.security.core.context.SecurityContext;

import javax.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/shop")
public class GoodsProcessController {

  @Autowired
  private GoodsProcessService goodsProcessService;
  
  @Autowired
  private UsersService usersService;
  
  @Autowired
  private BookService bookService;
  
  @ResponseBody
  @RequestMapping(value="/cart",method=POST)
	public void addGoods(HttpServletRequest request,@RequestParam("id") int id) {
	  Object sec =request.getSession(false).getAttribute("SPRING_SECURITY_CONTEXT");
	  SecurityContext sc = (SecurityContext) sec;
	  Users user=usersService.findByUserName(sc.getAuthentication().getName());
	  GoodsProcess goodsProcess=new GoodsProcess();
		goodsProcess.setUserId((int)user.getId());
		goodsProcess.setGoodsId(id);
		goodsProcessService.create(goodsProcess);
//	  if(state.equals("add"))
//	  {
//		  System.out.println("+++++++++======+++++++++++"+state);
//	  }
		if(null != sec)
		{
			
			System.out.println("++++++++++++++++++++++++++"+sc.getAuthentication().getName());
		}
		
		System.out.println("------------------"+user.getId()+"+++++++"+user.getPassWord());
		System.out.println("+++++++++++++++++++"+id);
		
	}
  
  @ResponseBody
  @RequestMapping(value="/findCart",method=POST)
	public List<Book> findCart(HttpServletRequest request) {
	  Object sec =request.getSession(false).getAttribute("SPRING_SECURITY_CONTEXT");
	  SecurityContext sc = (SecurityContext) sec;
		if(null != sec)
		{
			
			System.out.println("++++++++++++++++++++++++++"+sc.getAuthentication().getName());
		}
		Users user=usersService.findByUserName(sc.getAuthentication().getName());
		List<Book> book=goodsProcessService.findCart(user.getId());
		
		return book;
	}
  
//  @ResponseBody
//  @RequestMapping(value="/buy",method=POST)
//	public String buy(HttpServletRequest request) {
//	  Object sec =request.getSession(false).getAttribute("SPRING_SECURITY_CONTEXT");
//	  SecurityContext sc = (SecurityContext) sec;
//		if(null != sec)
//		{
//			
//			System.out.println("++++++++++++++++++++++++++"+sc.getAuthentication().getName());
//		}
//		Users user=usersService.findByUserName(sc.getAuthentication().getName());
//		List<Book> book=goodsProcessService.findCart(user.getId());
//		System.out.println("++++++++++++++++++++++++++"+book.get(0).getName());
//		System.out.println("++++++++++++++++++++++++++"+book.get(1).getName());
//
//		return "success";
//	}
}
