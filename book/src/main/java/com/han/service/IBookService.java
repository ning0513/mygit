package com.han.service;

import java.util.List;

import com.han.vo.Book;

public interface IBookService {
	
	public List<Book> findBooks(int page,int size);
	
	public int removeBook(Long id);

}
