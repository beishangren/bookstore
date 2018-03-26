package bookstore.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import bookstore.entity.BookEntity;

//@Repository
public interface BookRepository extends PagingAndSortingRepository<BookEntity, Long>, JpaSpecificationExecutor {

//	BookEntity find(long goodsId);


}
