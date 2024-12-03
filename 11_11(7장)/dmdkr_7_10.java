package sam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class dmdkr_7_10 {
	public static void main(String[] args) {
		Scanner sr = new Scanner(System.in);
		while(true) {
			System.out.print("문자열들을 입력하세요>>");
			String str = sr.nextLine();
			
			if(str.equals("그만"))
				break;
			
			String[] words = str.split(" ");
			
			ArrayList<String> wordList = new ArrayList<>(Arrays.asList(words));
			
			for (int i = 0; i < wordList.size(); i++) {
				for (int j = i+1; j < wordList.size(); j++) {
					if(wordList.get(i).equals(wordList.get(j))) {
						wordList.remove(j);
						j--;
					}
				}
			}
			
			for(String w : wordList)
				System.out.print(w + " ");
			System.out.println();
		}
		sr.close();
	}
}
