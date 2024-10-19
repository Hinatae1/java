package s10_1;

class Cube{
	private int width;
	private int height;
	private int high;
	
	public Cube(int width, int height, int high) {
		this.width = width;
		this.height = height;
		this.high = high;
	}
	
	public int getVolume() {
		return width * height * high;
	}
	
	public void increase(int w, int h, int i) {
		width += w;
		height += h;
		high += i;
	}
	public boolean isZero() {
		return getVolume() == 0;
	}
	
}
public class week2 {
	public static void main(String[] args) {
		Cube cube = new Cube(1, 2, 3);	//가로, 세로, 높이가 1,2,3인 큐브 객체 생성
		System.out.println("큐브의 부피는 " + cube.getVolume());
		cube.increase(1, 2, 3);//가로, 세로, 높이 각각 1,2,3, 씩 증가
		System.out.println("큐브의 부피는 " + cube.getVolume());
		if(cube.isZero())
				System.out.println("큐브의 부피는 0");
		else
				System.out.println("큐브의 부피는 0이 아님");
	}
}
