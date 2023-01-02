package ex.model.vo;

public class Favorite {

/* 
도서 등록번호는 배열등록

제목 작가 가격 출판사 4개정보


*/
	private int index;
	private String bookName; 
	private String author;
	private String publisher;
	
	public Favorite() {}

	public Favorite(int index, String bookName, String author, String publisher) {
		this.index = index;
		this.bookName = bookName;
		this.author = author;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return " " + bookName + "  " + author + "  " + publisher
				;
	}
	
	
	
	
	
	
}
