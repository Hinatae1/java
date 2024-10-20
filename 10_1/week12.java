package s10_1;

import java.util.Scanner;

class Dictionary {
    // 한글과 영어 단어 배열
    private static String[] kor = { "사랑", "아기", "돈", "미래", "희망" };
    private static String[] eng = { "love", "baby", "money", "future", "hope" };

    // 한글 단어를 입력받아 영어 단어를 반환하는 메서드
    public static String kor2Eng(String word) {
        for (int i = 0; i < kor.length; i++) {
            if (kor[i].equals(word)) {
                return eng[i];  // 일치하는 한글 단어의 영어 단어 반환
            }
        }
        return "저의 사전에 없습니다.";  // 단어를 찾지 못한 경우 메시지 반환
    }
}

public class week12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("한영 단어 검색 프로그램입니다.");

        while (true) {
            System.out.print("한글 단어? ");
            String input = scanner.nextLine();  // 사용자로부터 단어 입력받기

            if (input.equals("그만")) {  // 입력이 "그만"이면 프로그램 종료
                break;
            }

            // Dictionary 클래스의 kor2Eng 메서드를 이용해 영어 단어 출력
            String result = Dictionary.kor2Eng(input);
            System.out.println(input + "은(는) " + result);
        }

        scanner.close();  // 스캐너 종료
    }
}

