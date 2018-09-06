package com.han.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.han.dao.IBookDao;
import com.han.service.IBookService;
import com.han.vo.Book;

@Service
public class BookService implements IBookService {

	@Autowired
	private IBookDao bookDao;
	
	
	public List<Book> findBooks(int page, int size) {
		// TODO Auto-generated method stub
		return bookDao.selectPageBooks(page, size);
	}


	public int removeBook(Long id) {
		// TODO Auto-generated method stub
		return bookDao.deleteBook(id);
	}

}
