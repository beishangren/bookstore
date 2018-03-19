package bookstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import bookstore.entity.UsersEntity;
import bookstore.repositories.ValidationUsersRepository;


public class ValidationUsersService implements UserDetailsService{
	private final ValidationUsersRepository validationusersRepository;
	
	public ValidationUsersService(ValidationUsersRepository validationusersRepository) {
		this.validationusersRepository=validationusersRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsersEntity usersEntity = validationusersRepository.findByUserName(username);
//		System.out.println("查询结果"+usersEntity.getUserName()+"++++");
		if (usersEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));
		return new User(usersEntity.getUserName(), usersEntity.getPassWord(), authorities);
	}
	
}
