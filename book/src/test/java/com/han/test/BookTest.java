package com.han.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.han.dao.IBookDao;
import com.han.vo.Book;

@ContextConfiguration(locations={"classpath:springConfig/applicationContext-core.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BookTest {

	@Autowired
	private IBookDao bookDao;

	@Test
	public void deleteBookTest(){
		
		int c = bookDao.deleteBook(1302l);
		System.out.println(c);
		Assert.assertEquals(1, c);
	}
	
	@Test
	public void selectBookTest(){
		
		Book book = bookDao.selectBook(1302L);
		Assert.assertNotNull(book);
	}	
	
	@Test
	public void selectBooksTest(){
		List<Book> books = bookDao.selectPageBooks(1, 30);
		Assert.assertEquals(30, books.size());
	}
}
