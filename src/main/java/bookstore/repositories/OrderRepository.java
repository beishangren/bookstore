package bookstore.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import bookstore.entity.BookEntity;
import bookstore.entity.OrderEntity;

//@Repository
public interface OrderRepository extends PagingAndSortingRepository<OrderEntity, Long>, JpaSpecificationExecutor {

//	BookEntity find(long goodsId);


}
