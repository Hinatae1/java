package s10_1;

class Rectangle {
    private int x;      // 사각형의 왼쪽 위 꼭짓점의 x 좌표
    private int y;      // 사각형의 왼쪽 위 꼭짓점의 y 좌표
    private int width;  // 사각형의 너비
    private int height; // 사각형의 높이

    // 생성자
    public Rectangle(int x, int y, int width, int height) {
        this.x = x; 
        this.y = y; 
        this.width = width; 
        this.height = height; 
    }

    // 정사각형인지 확인하는 메서드
    public boolean isSquare() {
        return width == height; // 너비와 높이가 같으면 정사각
    }

    // 사각형 r이 현재 사각형에 포함되는지 확인하는 메서드
    public boolean contains(Rectangle r) {
        return (r.x >= x) && (r.y >= y) && 
               (r.x + r.width <= x + width) && 
               (r.y + r.height <= y + height); // r의 모든 점이 현재 사각형 내부에 있는지 확인
    }

    // 사각형 정보를 출력하는 메서드
    public void show() {
        System.out.println("("+x+","+y+")에서 크기가 "+ width + "x"+ height+"인 사각형");
    }
}

public class week6 {
	public static void main(String[] args) {
		Rectangle a = new Rectangle(3, 3, 6, 6);	//(3,3) 점에서 6x6 크기의 사각형
		Rectangle b = new Rectangle(4, 4, 2, 3);	//(4,4) 점에서 2x3 크기의 사각형
		
		a.show();
		if(a.isSquare()) System.out.println("a는 정사각형입니다.");
		else System.out.println("a는 직사각형입니다.");
		if(a.isSquare()) System.out.println("a는 b를 포합합니다.");

	}
}

