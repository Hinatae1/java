package s10_1;

import java.util.Random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Player {
    String name;
    int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }
}

class GuessGame {
    private List<Player> players = new ArrayList<>();
    private Random random = new Random();

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        // 선수 정보 입력
        System.out.print("게임에 참여할 선수 수를 입력하세요: ");
        int numPlayers = scanner.nextInt();
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("선수 " + (i + 1) + "의 이름을 입력하세요: ");
            String name = scanner.next();
            players.add(new Player(name));
        }

        // 게임 진행
        while (true) {
            int targetNumber = random.nextInt(100) + 1; // 1부터 100까지 랜덤 숫자 생성
            System.out.println("새로운 라운드 시작! 1부터 100 사이의 숫자를 맞춰보세요.");

            for (Player player : players) {
                System.out.print(player.name + "의 숫자: ");
                int guess = scanner.nextInt();
                int diff = Math.abs(targetNumber - guess);

                // 최소 차이값과 해당 선수 저장
                int minDiff = Integer.MAX_VALUE;
                Player winner = null;
                for (Player p : players) {
                    int currentDiff = Math.abs(targetNumber - p.score);
                    if (currentDiff < minDiff) {
                        minDiff = currentDiff;
                        winner = p;
                    }
                }

                // 승자 발표 및 점수 증가
                System.out.println("정답은 " + targetNumber + "였습니다.");
                System.out.println(winner.name + "님이 가장 가까워 1점 획득!");
                winner.score++;
            }

            // 게임 계속 여부 확인
            System.out.print("게임을 계속하시겠습니까? (y/n): ");
            String continueGame = scanner.next();
            if (!continueGame.equalsIgnoreCase("y")) {
                break;
            }
        }

        // 최종 결과 발표
        System.out.println("게임 종료!");
        System.out.println("최종 결과:");
        for (Player player : players) {
            System.out.println(player.name + ": " + player.score + "점");
        }

        // 승자 찾기
        Player finalWinner = players.get(0);
        for (int i = 1; i < players.size(); i++) {
            if (players.get(i).score > finalWinner.score) {
                finalWinner = players.get(i);
            }
        }
        System.out.println("최종 승자는 " + finalWinner.name + "님입니다! 축하합니다!");
    }
}

public class week9 {
    public static void main(String[] args) {
        GuessGame game = new GuessGame();
        game.startGame();
    }
}

