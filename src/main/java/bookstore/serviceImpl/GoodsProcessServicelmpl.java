package bookstore.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookstore.domain.Book;
import bookstore.domain.GoodsProcess;
import bookstore.domain.Users;
import bookstore.entity.BookEntity;
import bookstore.entity.GoodsProcessEntity;
import bookstore.entity.UsersEntity;
import bookstore.repositories.BookRepository;
import bookstore.repositories.GoodsProcessRepository;
import bookstore.service.BookService;
import bookstore.service.GoodsProcessService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class GoodsProcessServicelmpl implements GoodsProcessService{
	@Autowired
	private GoodsProcessRepository goodsProcessRepository;
	
	
	@Override
    @Transactional
	public void create(GoodsProcess goodsProcess) {
		GoodsProcessEntity goodsProcessEntity=new GoodsProcessEntity();
		goodsProcessEntity.setUserId(goodsProcess.getUserId());
		goodsProcessEntity.setGoodsId(goodsProcess.getGoodsId());
		goodsProcessEntity.setState(goodsProcess.getState());
		goodsProcessRepository.save(goodsProcessEntity);
	}
	
//	@Override
//    @Transactional
//	public Users findByName(String name) {
//		UsersEntity usersEntity=goodsProcessRepository.findByUserName(name);
//		return buildUsers(usersEntity);
//	}
//	@Override
//    @Transactional
//	public List<Book> find() {
//		 List<Book> list = new ArrayList<>();
//		 
//
//		 bookRepository.findAll().forEach(bookEntity->{
//			 list.add(buildBook(bookEntity));
//		 });
//		 return list;
//		
//	}
//	
//	public Users buildUsers(UsersEntity usersEntity) {
//
//		Users users=new Users(
//				usersEntity.getId(),
//				usersEntity.getUserName(),
//				usersEntity.getPassWord()
//				);
//		
//		return users;
//	}
}
