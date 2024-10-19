package s10_1;

class Average{
	private int [] number; //최대 10개의 정수 저장
	private int count;	//현재 저장된 정수 개수
	
	public Average() {	
		number = new int[10];	//최대 10개의 정수 저장
		count = 0;
	}
	
	public void put(int num) {
		if(count < 10) {
			number[count] = num;	//배열에 정수 저장
			count++;	//저장된 정수 증가
		}
	}
	
	public void showAll() {
		System.out.println("***** 저장된 데이터 모두 출력 *****");
		for(int i = 0; i < count; i++) {
			System.out.print(number[i]+ " ");
		}
		System.out.println();
	}
	
	public int getAvg() {
		int sum = 0;
		for(int i = 0; i < count; i++) {
			sum += number[i];
		}
		return sum / count;
		
	}
}



public class week4 {
	public static void main(String[] args) {
		Average avg = new Average();
		avg.put(10);	//10저장
		avg.put(15);	//15저장
		avg.put(100);	//100저장
		avg.showAll();	//저장된 모든 원소 출력
		System.out.print("평균은 " + avg.getAvg());	//평균 출력
	}
}
