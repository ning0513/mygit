package com.han.dao;

import java.util.List;

import com.han.vo.Book;

public interface IBookDao {

	public int insertBook(Book book );
	
	public int deleteBook(Long id);
	
	public int updateBook(Book book);
	
	public List<Book> selectPageBooks(int page,int pageSize);
	
	public Book selectBook(Long id);
}
