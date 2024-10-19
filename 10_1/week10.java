package s10_1;

import java.util.Scanner;

class DayDiary {
    int date;
    String memo;

    public DayDiary(int date) {
        this.date = date;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMemo() {
        return memo;
    }
}

class MonthDiary {
    private DayDiary[] days = new DayDiary[30];

    public MonthDiary(int year, int month) {
        for (int i = 0; i < days.length; i++) {
            days[i] = new DayDiary(i + 1);
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            getMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    write(scanner);
                    break;
                case 2:
                    show(scanner);
                    break;
                case 3:
                    showAll();
                    break;
                case 4:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private void getMenu() {
        System.out.println("1. 메모 작성");
        System.out.println("2. 특정 날짜 메모 조회");
        System.out.println("3. 모든 메모 조회");
        System.out.println("4. 프로그램 종료");
        System.out.print("메뉴를 선택하세요: ");
    }

    private void write(Scanner scanner) {
        System.out.print("날짜(1~30): ");
        int date = scanner.nextInt() - 1;
        System.out.print("메모(4글자 이하): ");
        String memo = scanner.next();
        if (memo.length() <= 4) {
            days[date].setMemo(memo);
            System.out.println("메모가 저장되었습니다.");
        } else {
            System.out.println("메모는 4글자 이하로 입력해주세요.");
        }
    }

    private void show(Scanner scanner) {
        System.out.print("조회할 날짜(1~30): ");
        int date = scanner.nextInt() - 1;
        String memo = days[date].getMemo();
        if (memo != null) {
            System.out.println(date + 1 + "일: " + memo);
        } else {
            System.out.println("해당 날짜에 메모가 없습니다.");
        }
    }

    private void showAll() {
        for (int i = 0; i < days.length; i++) {
            String memo = days[i].getMemo();
            if (memo != null) {
                System.out.println((i + 1) + "일: " + memo);
            }
        }
    }
}

public class week10 {
    public static void main(String[] args) {
        MonthDiary monthDiary = new MonthDiary(2024, 10);
        monthDiary.run();
    }
}
