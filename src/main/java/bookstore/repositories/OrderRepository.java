package bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import bookstore.domain.Order;
import bookstore.entity.BookEntity;
import bookstore.entity.OrderEntity;

//@Repository
public interface OrderRepository extends PagingAndSortingRepository<OrderEntity, Long>, JpaSpecificationExecutor {

	List<OrderEntity> findByUserId(long id);

//	BookEntity find(long goodsId);


}
