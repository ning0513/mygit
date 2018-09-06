package com.han.vo;

public class Book {

	private Long id;
	private String name;
	private String author;
	private String info;
	private Double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", info=" + info + ", price=" + price + "]";
	}

	public Book(Long id, String name, String author, String info, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.info = info;
		this.price = price;
	}

	public Book(String name, String author, String info, Double price) {
		super();
		this.name = name;
		this.author = author;
		this.info = info;
		this.price = price;
	}

	public Book() {
		super();
	}

}
