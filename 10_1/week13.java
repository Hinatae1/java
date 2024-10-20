package s10_1;

import java.util.Scanner;

class Seat {
    private String[] seats;  // 좌석 배열 (이름 저장)

    public Seat(int num) {
        seats = new String[num];  // 좌석 수만큼 배열 초기화
        for (int i = 0; i < seats.length; i++) {
            seats[i] = "---";  // 빈 좌석은 "---"로 표시
        }
    }

    public void reserve(String name, int seatNumber) {
        if (seatNumber < 1 || seatNumber > seats.length) {
            System.out.println("잘못된 좌석 번호입니다.");
        } else if (!seats[seatNumber - 1].equals("---")) {
            System.out.println("이미 예약된 좌석입니다.");
        } else {
            seats[seatNumber - 1] = name;
            System.out.println("예약되었습니다.");
        }
    }

    public void showSeats() {
        for (int i = 0; i < seats.length; i++) {
            System.out.print(seats[i] + " ");
        }
        System.out.println();
    }

    public void cancel(String name) {
        boolean found = false;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i].equals(name)) {
                seats[i] = "---";  // 좌석 취소
                found = true;
                System.out.println("취소되었습니다.");
                break;
            }
        }
        if (!found) {
            System.out.println("예약된 이름이 없습니다.");
        }
    }
}

class ConcertReservation {
    private Seat sSeat;
    private Seat aSeat;
    private Seat bSeat;

    public ConcertReservation() {
        sSeat = new Seat(10);  // S석 10개
        aSeat = new Seat(10);  // A석 10개
        bSeat = new Seat(10);  // B석 10개
    }

    public void reserveSeat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("좌석구분 S(1), A(2), B(3): ");
        int seatType = scanner.nextInt();
        System.out.print("이름: ");
        String name = scanner.next();
        System.out.print("번호: ");
        int seatNumber = scanner.nextInt();

        switch (seatType) {
            case 1:
                sSeat.reserve(name, seatNumber);
                break;
            case 2:
                aSeat.reserve(name, seatNumber);
                break;
            case 3:
                bSeat.reserve(name, seatNumber);
                break;
            default:
                System.out.println("잘못된 좌석 타입입니다.");
                break;
        }
    }

    public void showAllSeats() {
        System.out.print("S석: ");
        sSeat.showSeats();
        System.out.print("A석: ");
        aSeat.showSeats();
        System.out.print("B석: ");
        bSeat.showSeats();
    }

    public void cancelSeat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("좌석구분 S(1), A(2), B(3): ");
        int seatType = scanner.nextInt();
        System.out.print("이름: ");
        String name = scanner.next();

        switch (seatType) {
            case 1:
                sSeat.cancel(name);
                break;
            case 2:
                aSeat.cancel(name);
                break;
            case 3:
                bSeat.cancel(name);
                break;
            default:
                System.out.println("잘못된 좌석 타입입니다.");
                break;
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("콘서트 예약 시스템입니다.");

        while (true) {
            System.out.println("\n예약:1, 조회:2, 취소:3, 끝내기:4 >> ");
            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    reserveSeat();
                    break;
                case 2:
                    showAllSeats();
                    break;
                case 3:
                    cancelSeat();
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 메뉴입니다.");
                    break;
            }
        }
    }
}

public class week13 {
    public static void main(String[] args) {
        ConcertReservation reservation = new ConcertReservation();
        reservation.run();
    }
}
