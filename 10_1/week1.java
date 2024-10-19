package s10_1;

class TV {
	private String brand;
	private int size;
	private int price;
	
	public TV(String brand,int size,int price ) {
		this.brand = brand;
		this.size = size;
		this.price = price;
	}
	
	public void show() {
		
		System.out.println(brand + "에서 만든 " + price + "만원짜리의 " + size + "인치 TV");
	}
}

public class week1 {
	public static void main(String[] args) {
		TV tv = new TV("Samsung", 50, 300);
		tv.show();
	}
}
