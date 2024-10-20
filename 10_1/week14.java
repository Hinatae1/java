package s10_1;

class VArray {
    private int[] array;  // 내부 배열
    private int size;     // 현재 저장된 요소의 개수

    public VArray(int capacity) {
        array = new int[capacity];  // 초기 용량 설정
        size = 0;  // 배열에 저장된 요소의 개수 초기화
    }

    // 배열의 크기(용량)를 반환
    public int capacity() {
        return array.length;
    }

    // 배열에 저장된 요소의 개수를 반환
    public int size() {
        return size;
    }

    // 배열에 원소 추가
    public void add(int value) {
        if (size >= array.length) {
            resize();  // 배열 크기를 두 배로 늘림
        }
        array[size] = value;  // 배열의 끝에 추가
        size++;
    }

    // 배열의 인덱스에 원소 삽입
    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("인덱스 범위가 잘못되었습니다.");
            return;
        }

        if (size >= array.length) {
            resize();  // 배열 크기를 두 배로 늘림
        }

        // 배열의 index 위치에 값을 삽입하기 위해 요소들을 뒤로 이동
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
    }

    // 배열의 인덱스에서 원소 삭제
    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }

        // index 위치의 값을 삭제하고, 그 뒤의 값들을 앞으로 이동
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    // 모든 원소를 출력
    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // 내부 배열 크기를 두 배로 늘리는 메서드
    private void resize() {
        int newCapacity = array.length * 2;
        int[] newArray = new int[newCapacity];
        // 기존 배열의 값을 새 배열에 복사
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;  // 새 배열로 교체
    }
}

public class week14 {
    public static void main(String[] args) {
        VArray v = new VArray(5);  // 5개의 정수를 저장하는 가변 배열 객체 생성
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());

        // 7개 저장
        for (int i = 0; i < 7; i++) {
            v.add(i);  // 배열에 순서대로 정수 i 값 저장
        }
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        // 배열의 인덱스 3에 100 삽입
        v.insert(3, 100);
        // 배열의 인덱스 5에 200 삽입
        v.insert(5, 200);
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        // 배열의 인덱스 10의 정수 삭제
        v.remove(10);
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        // 5개 저장
        for (int i = 50; i < 55; i++) {
            v.add(i);
        }
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();
    }
}

