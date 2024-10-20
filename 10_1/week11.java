package s10_1;

class ArrayUtil {
    // 배열 a와 b를 연결한 새로운 배열을 반환하는 메서드
    public static int[] concat(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];  // a와 b의 크기를 합친 새로운 배열 생성
        System.arraycopy(a, 0, result, 0, a.length);  // a 배열의 내용을 result 배열에 복사
        System.arraycopy(b, 0, result, a.length, b.length);  // b 배열의 내용을 result 배열에 복사
        return result;  // 새로운 배열 반환
    }

    // 배열을 출력하는 메서드
    public static void print(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1) {
                System.out.print(", ");  // 각 원소 사이에 ", " 추가
            }
        }
        System.out.println("]");  // 배열 출력 후 줄바꿈
    }
}

public class week11 {
    public static void main(String[] args) {
        int[] array1 = {1, 5, 7, 9};
        int[] array2 = {3, 6, -1, 100, 77};
        int[] array3 = ArrayUtil.concat(array1, array2);
        ArrayUtil.print(array3);
    }
}
