package s10_1;

class Account {
	private int money;	//계좌 잔액
	
	public Account(int money) {
		this.money = money;		//초기 설정
	}
	
	//입금 메서드(단일 금액)
	public void deposit(int rmount) {
		money += rmount;	//잔액에 금액 더함
	}
	
	//배열로 여러 금액 입금
	public void deposit(int[] amont) {
		for(int rmount : amont) {
			money += rmount;	// 배열에 있는 각 금액을 잔액에 더함
		}
	}
	
	public int getBalance() {
		return money;
	}
	
	public int withdraw(int amount) {
		if(money >= amount) {
			money -= amount;	//잔액이 충분하면 요청한 금액 인출
			return amount;	//실제 인출한 금액 반환
		}else {
			int temp = money;	//남은 잔액만큼 인출
			money = 0;	//잔액을 0으로 설정
			return amount;	//실제 인출한 금액 반환
		}	
	}	
}

public class week8 {
	public static void main(String[] args) {
		Account a = new Account(100);	//100원을 예금하면서 계좌 생성
		a.deposit(5000);	//5000원 예금
		System.out.println("잔금은 " + a.getBalance() + "원입니다.");
	
		int bulk[] = {100, 500 ,200, 700};
		a.deposit(bulk);	//bulk[] 배열에 있는 모든 돈 예금
		System.out.println("잔금은 " + a.getBalance() + "원입니다.");
	
		int money = 1000;	//인출하고자 한는 금액
		int wMoney = a.withdraw(money);	//1000원 인출 시도. wMoney는 실제 인출한 금액
		if (wMoney < money)
			System.out.println(wMoney + "원만 인출");	// 잔금이 1000원보다 작는 경우
		else
			System.out.println(wMoney + "원 인출");	//잔금이 100원보다 큰 경우	
		
		System.out.println("잔금은 " + a.getBalance() + "원입니다.");
	}
}
