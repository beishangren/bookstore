package bookstore.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bookstore.domain.Book;
import bookstore.domain.GoodsProcess;
import bookstore.domain.Users;
import bookstore.entity.UsersEntity;
import bookstore.service.BookService;
import bookstore.service.GoodsProcessService;
import bookstore.service.UsersService;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContext;

import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("/shop")
public class GoodsProcessController {

  @Autowired
  private GoodsProcessService goodsProcessService;
  
  @Autowired
  private UsersService usersService;
  
  @ResponseBody
  @RequestMapping(value="/cart",method=POST)
	public void addGoods(HttpServletRequest request) {
	  Object sec =request.getSession(false).getAttribute("SPRING_SECURITY_CONTEXT");
	  SecurityContext sc = (SecurityContext) sec;
		if(null != sec)
		{
			
			System.out.println("++++++++++++++++++++++++++"+sc.getAuthentication().getName());
		}
		Users user=usersService.findByUserName(sc.getAuthentication().getName());
		System.out.println("------------------"+user.getId()+"+++++++"+user.getPassWord());
		
	}
}
