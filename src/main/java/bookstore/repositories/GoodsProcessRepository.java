package bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import bookstore.domain.Book;
import bookstore.entity.BookEntity;
import bookstore.entity.GoodsProcessEntity;
import bookstore.entity.UsersEntity;

//@Repository
public interface GoodsProcessRepository extends PagingAndSortingRepository<GoodsProcessEntity, Long>, JpaSpecificationExecutor {

//	UsersEntity findByUserName(String name);
	List<GoodsProcessEntity> findByUserId(long id);



}
