package bookstore.controller;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bookstore.domain.Users;
import bookstore.service.UsersService;

@Controller
@RequestMapping("/user")
public class UsersController {
	@Autowired
	private UsersService usersService;
	
	
	@ResponseBody
	@RequestMapping(value="/create",method=POST)
	public String createUser(HttpServletRequest request,@RequestBody Users users) {
		Users users1=new Users();
		users1.setUserName(users.getUserName());
		users1.setPassWord(users.getPassWord());
		System.out.println("++++++++"+users.getUserName()+"---------"+users.getPassWord());
		usersService.create(users1);
		return "success";
	}
}