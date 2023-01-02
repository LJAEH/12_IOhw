package ex.service;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ex.model.vo.Book;
import ex.model.vo.Favorite;

public class LibrarianService {

	
	private Scanner sc = new Scanner(System.in);
	
	private List<Book> BookList = new ArrayList<Book>();
	
	private List<Favorite> favoriteList = new ArrayList<Favorite>();
	
	public LibrarianService() {
		
		BookList.add(new Book(1, "코딩메시", "JMH", 80000, "코딩학원"));
		BookList.add(new Book(2, "클립스튜디오초급반", "Clip", 48000, "Clip"));
		BookList.add(new Book(3, "광진구", "중곡동", 2500, "지하철"));
	
	}
	
	public void displayMenu() {
		
		int menuNum = 0;
		
		do {
			System.out.println("책관리 프로그램(사서전용)");
			System.out.println("1. 등록");
			System.out.println("2. 조회");
			System.out.println("3. 수정");
			System.out.println("4. 제거");
			System.out.println("5. 즐겨찾기 추가");
			System.out.println("6. 즐겨찾기 삭제");
			System.out.println("7. 즐겨찾기 프린트");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("\n 메뉴 번호 선택 >>>");
			
			try{
				menuNum = sc.nextInt();
				System.out.println(); 
				
				switch(menuNum) {
				case 1: System.out.println( addBook() );break;
				case 2: selectAll(); break;
				case 3: System.out.println( updateBook() ); break;
				case 4: System.out.println( removeBook() ); break;
				case 5: System.out.println( favorite() );break;
				case 6: System.out.println( removeFavorite() );break;
				case 7: output(); break;
				case 0: System.out.println("프로그램 종료");break;
				default : System.out.println("번호 재입력");
				
				}
			
			}catch (InputMismatchException e) {
				
				System.out.println("\n error : 재입력");
				sc.nextLine();
				menuNum = -1; 
			}
			
		} while(menuNum != 0);
	}
	
	public String addBook() throws InputMismatchException {
	
		System.out.println("책 정보 추가");
		
		int index = 0;
		if( BookList.size() != 0) {
			index = BookList.size();
		}
		System.out.print("책 제목 : ");
		String bookName = sc.next();
		System.out.print("저자 : ");
		String author = sc.next();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		System.out.print("출판사 : ");
		String publisher = sc.next();
		
		if( BookList.add(new Book(index, bookName, author, price, publisher))) {
			return "등록 성공";
		} else {
			return "등록 실패";
		}
	}
	
	public void selectAll() {
		
		System.out.println("등록 정보 조회");
		if( BookList.isEmpty() ) {
			System.out.println(" 등록된 책이 없습니다. ");
			return;
		}
		System.out.println("===== 1조 도서목록 =====");
		
		int index = 0;
		
		for ( Book std : BookList ) {
		//	System.out.print((index++));
			System.out.println(std);
		}
	}
	
	public String updateBook() throws InputMismatchException {
		System.out.println("등록 정보 수정");
		System.out.print("인덱스 번호 입력");
		int i = sc.nextInt();
		sc.nextLine();
		
		if( BookList.isEmpty()){
			return "등록 정보 없음";
		} else if ( i < 0 ) {
			return "등록번호는 0번부터 시작합니다.";
		} else if (i >= BookList.size()) {
			return "범위를 넘어선 값을 입력할 수 없음";
		} else {
			System.out.println("등록번호" + i + " 책 정보" );
			System.out.println( BookList.get(i) );
			
			int index = i;
			System.out.print("책 제목 : ");
			String bookName = sc.next();
			System.out.print("저자 : ");
			String author = sc.next();
			System.out.print("가격 : ");
			int price = sc.nextInt();
			System.out.print("출판사 : ");
			String publisher = sc.next();
			
			Book temp = BookList.set(i, new Book(index, bookName, author, price, publisher));
			
			return temp.getBookName() + "의 정보가 수정되었습니다.";
		}
		
	}
	
	public String removeBook() throws InputMismatchException {
		
		System.out.println("등록 정보 제거");
		System.out.print("등록 번호 입력");
		int index = sc.nextInt();
		sc.nextLine();
		
		if( BookList.isEmpty()) {
			return "등록 정보 없음";
		} else if ( index < 0 ) {
			return "등록번호는 0번부터 시작합니다.";
		} else if (index >= BookList.size()) {
			return "범위를 넘어선 값을 입력할 수 없음";
		} else {
			
			System.out.println("정말 삭제 하시겠습니까  (Y/N) : ");
			char ch = sc.next().toUpperCase().charAt(0);
			
			if ( ch == 'Y' ) {
				Book temp = BookList.remove(index);
				return temp.getBookName()+"의 정보가 삭제 되었습니다.";
			} else if (ch == 'N') {
				return "취소 되었습니다.";
			} else {
				return "정확히 입력해 주세요.";
			}
			
		}
	}
	
	public String favorite() throws InputMismatchException {
		System.out.println("즐겨찾기등록");
		System.out.print("즐겨찾기할 책 인덱스 : ");
		int i = sc.nextInt();
		sc.nextLine();
		
		if( BookList.isEmpty()){
			return "등록 정보 없음";
		} else if ( i < 0 ) {
			return "등록번호는 0번부터 시작합니다.";
		} else if (i >= BookList.size()) {
			return "범위를 넘어선 값을 입력할 수 없음";
		} else {
			System.out.println("등록번호" + i + " 를 즐겨찾기합니다." );
			
			Book temp = BookList.get(i);
			
			int index = i;
			String BookName = temp.getBookName();
			String author = temp.getAuthor();
			String publisher = temp.getPublisher();
			
			favoriteList.add(new Favorite(index, BookName, author, publisher));
			
			return "즐겨찾기 등록";
		}
	
	}
	
	public String removeFavorite() throws InputMismatchException {
		
		System.out.println("즐겨찾기 조회");
		if( favoriteList.isEmpty() ) {
			return " 등록된 책이 없습니다. ";
		}
		
		int fn = 0;
		
		for ( Favorite std : favoriteList ) {
			
			System.out.print(fn++);
			System.out.println(std);
		}
		
		System.out.print("삭제할 즐겨찾기 인덱스 입력 : ");
		int i = sc.nextInt();
		sc.nextLine();
		
		if( favoriteList.isEmpty()){
			return "등록 정보 없음";
		} else if ( i < 0 ) {
			return "등록번호는 0번부터 시작합니다.";
		} else if (i >= favoriteList.size()) {
			return "범위를 넘어선 값을 입력할 수 없음";
		} else {
			System.out.println("정말 삭제 하겠습니까? (Y/N) : ");
			char ch = sc.next().toUpperCase().charAt(0);
			if(ch == 'Y') {
				Favorite temp = favoriteList.remove(i);
				return temp.getBookName()+"의 정보가 제거되었습니다.";
			} else {
				return "취소";
			}
		}
	}
	
	public void output() {
		
		String filePath = "favorites.txt";
		
		BufferedWriter writer = null; 
		
		try {
			File file = new File(filePath);
			if(!file.exists) {
				
			}
			
		
			
			
		} catch(IOException e) {
			System.out.println("예외 발생");
			e.printStackTrace(); 
		} finally {
			try {
				.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}
		
	
	
	
	
	
}
