package bookstore.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookstore.domain.Users;
import bookstore.entity.UsersEntity;
import bookstore.repositories.UsersRepository;
import bookstore.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	@Transactional
	public void create(Users users) {
		UsersEntity usersEntity1=new UsersEntity();
		usersEntity1.setUserName(users.getUserName());
		usersEntity1.setPassWord(users.getPassWord());
		usersRepository.save(usersEntity1);
	}
	

	@Override
	@Transactional
	public Users findByUserName(String name) {
		System.out.println("+++++++++++++++"+name);
		UsersEntity userEntity=new UsersEntity();
		userEntity=usersRepository.findByUserName(name);
		return buildUsers(userEntity);
	}
	
	public Users buildUsers(UsersEntity usersEntity) {
		Users users=new Users();
		users.setId(usersEntity.getId());
		users.setUserName(usersEntity.getUserName());
		users.setPassWord(usersEntity.getPassWord());
		return users;
	}
	
}

