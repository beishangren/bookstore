package bookstore.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import bookstore.domain.Book;
import bookstore.service.BookService;
@Controller
@RequestMapping("/index")
public class IndexController {

  @Autowired
  private BookService bookService;
  
  @ResponseBody
  @RequestMapping(value="/findAll",method=POST)
	public List<Book> findBook() {
	  	List<Book> listBook=bookService.find();
		return listBook;
	}
}
