package ex.model.vo;

public class Book {

/* 
도서 등록번호는 배열등록

제목 작가 가격 출판사 4개정보


*/
	private int index;
	private String bookName; 
	private String author;
	private int price;
	private String publisher;
	
	public Book() {}

	public Book(int index, String bookName, String author, int price, String publisher) {
		this.index = index;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "  " + bookName + "  " + author + "  " + price + "  " + publisher
				;
	}
	
	
	
	
}
