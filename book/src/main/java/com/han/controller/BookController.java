package com.han.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.han.service.IBookService;
import com.han.vo.Book;

@Controller
public class BookController {
	
	@Autowired
	private IBookService bookService;

	
	@RequestMapping("/loadBooks/{page}/{size}")
	@ResponseBody
	public List<Book> loadBooks(@PathVariable int page,@PathVariable int size){
		List<Book> books = bookService.findBooks(page, size);
		return books;
	}
	
	
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public int delete(@PathVariable long id){
		return bookService.removeBook(id);
	}
	
	
	
}
