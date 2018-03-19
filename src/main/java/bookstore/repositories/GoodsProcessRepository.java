package bookstore.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import bookstore.entity.BookEntity;
import bookstore.entity.GoodsProcessEntity;

//@Repository
public interface GoodsProcessRepository extends PagingAndSortingRepository<GoodsProcessEntity, Long>, JpaSpecificationExecutor {


}
