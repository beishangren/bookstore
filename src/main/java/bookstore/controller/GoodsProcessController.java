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
import bookstore.service.BookService;
import bookstore.service.GoodsProcessService;

import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("/shop")
public class GoodsProcessController {

  @Autowired
  private GoodsProcessService goodsProcessService;
  
  @ResponseBody
  @RequestMapping(value="/cart",method=POST)
	public void addGoods() {
//		System.out.println(book.getId()+"/*/-*/*-"+book.getName()+"**********"+book.getNumber()+"************"+book.getPrice());
//	  	bookService.create(book);
//		book.setName("1");
//		return book;
	}
}
