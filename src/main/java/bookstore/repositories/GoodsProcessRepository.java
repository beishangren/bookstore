package bookstore.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import bookstore.entity.BookEntity;
import bookstore.entity.GoodsProcessEntity;
import bookstore.entity.UsersEntity;

//@Repository
public interface GoodsProcessRepository extends PagingAndSortingRepository<GoodsProcessEntity, Long>, JpaSpecificationExecutor {

//	UsersEntity findByUserName(String name);


}
