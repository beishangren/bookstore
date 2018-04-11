package bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import bookstore.domain.Book;
import bookstore.entity.BookEntity;
import bookstore.entity.ShoppingCartEntity;
import bookstore.entity.UsersEntity;

//@Repository
public interface ShoppingCartRepository extends PagingAndSortingRepository<ShoppingCartEntity, Long>, JpaSpecificationExecutor {

//	UsersEntity findByUserName(String name);
	List<ShoppingCartEntity> findByUserId(long id);

	void deleteById(long id);



}
