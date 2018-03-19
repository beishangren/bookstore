package bookstore.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import bookstore.entity.UsersEntity;

public interface ValidationUsersRepository extends PagingAndSortingRepository<UsersEntity, Long>, JpaSpecificationExecutor<UsersEntity> {

	UsersEntity findByUserNameAndPassWord(String name, String password);

	UsersEntity findByUserName(String username);

	UsersEntity findOneByUserName(String name);


}
