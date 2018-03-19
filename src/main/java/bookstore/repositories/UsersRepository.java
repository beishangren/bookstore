package bookstore.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import bookstore.entity.UsersEntity;

public interface UsersRepository extends PagingAndSortingRepository<UsersEntity, Long>, JpaSpecificationExecutor {

	UsersEntity findByUserName(String name);


}

