package s10_1;

import java.util.Scanner;

class Song{
	
	private String title;	//노래 제목
	private String singer;	//가수 이름
	private String year;	//발표 년도
	private String lang;	//가수 나라
	
	public Song(String title,String singer,String year,String lang){
		this.title = title;
		this.singer = singer;
		this.year = year;
		this.lang = lang;
		}
	
	public void show() {
		System.out.print(year + "년 " + lang + "의 " + singer + "가 부른 " + title);
		
	}
}


public class week5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("노래 제목, 가수 이름, 발표 년도, 가수 나라 순으로 입력>>");
		String title = scanner.nextLine();
		String singer = scanner.next();
		String year = scanner.next();
		String lang = scanner.next();
		Song song = new Song(title, singer, year, lang);
		song.show();
		
	}
}
