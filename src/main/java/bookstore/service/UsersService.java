package bookstore.service;

import bookstore.domain.Users;

public interface UsersService {
	void create(Users users);

	Users findByUserName(String name);
}
