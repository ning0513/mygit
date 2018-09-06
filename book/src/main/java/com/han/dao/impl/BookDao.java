package com.han.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.han.dao.IBookDao;
import com.han.vo.Book;

@Repository
public class BookDao extends BaseDao implements IBookDao {

	public int insertBook(Book book) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `book` VALUES(DEFAULT,?,?,?,?)";
		return jdbcTemplate.update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getInfo());
	}

	public int deleteBook(Long id) {
		String sql = "DELETE FROM `book` WHERE `id` = ?";
		return jdbcTemplate.update(sql,id);
	}

	public int updateBook(Book book) {
		String sql = "UPDATE `book` SET `name`=?,`author`=?,`price`=?,`info`=? WHERE `id` = ?";
		return jdbcTemplate.update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getInfo(),book.getId());
	}

	public List<Book> selectPageBooks(int page, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `book` LIMIT ?,?";
		return jdbcTemplate.query(sql, new BookRowMapper(),(page-1)*pageSize,pageSize);
	}

	public Book selectBook(Long id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `book` WHERE `id` = ? ";
		List<Book> books = jdbcTemplate.query(sql, new BookRowMapper(),id);
		return books==null || books.isEmpty() ? null : books.get(0);
	}

	
	class BookRowMapper implements RowMapper<Book>{

		public Book mapRow(ResultSet rs, int index) throws SQLException {
			// TODO Auto-generated method stub
			Book book = new Book(rs.getLong("id"), rs.getString("name"), rs.getString("author"), rs.getString("info"),rs.getDouble("price"));
			return book;
		}

		
	}
}
