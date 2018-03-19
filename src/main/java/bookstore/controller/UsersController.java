/*package bookstore.controller;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import bookstore.domain.Users;
import bookstore.service.UsersService;

import org.springframework.http.HttpStatus;
@Controller
@RequestMapping("user")
public class UsersController {
	@Autowired
	private UsersService usersService;
	
	
	@ResponseBody
	@RequestMapping(value="/create",method=POST)
	public void createUser(@RequestBody Users users) {
		Users users1=new Users();
		users1.setUserName(users.getUserName());
		users1.setPassWord(users.getPassWord());
		System.out.println("++++++++"+users.getUserName()+"---------"+users.getPassWord());
		usersService.create(users1);
	}
	
	@RequestMapping(value="/login",method=POST)
	@ResponseStatus(HttpStatus.OK)
	public String login(@RequestBody Users users) {
		Users users1=new Users();
		
		users1=usersService.findByNameAndPassWord(users.getUserName(),users.getPassWord());
		if(users1==null)
		{
			System.out.println("无");
		}
		else {
			System.out.println("有");
		}
		return "/register";
	}
	
}
*/