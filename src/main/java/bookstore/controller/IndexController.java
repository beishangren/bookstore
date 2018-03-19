package bookstore.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import bookstore.domain.Book;
import bookstore.domain.Users;
import bookstore.service.BookService;
import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
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
