import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(); // 첫 번째 주사위
        int b = sc.nextInt(); // 두 번째 주사위
        int c = sc.nextInt(); // 세 번째 주사위

        int prize;

        if (a == b && b == c) {
            prize = 10000 + a * 1000; // 세 개 모두 같은 경우
        } else if (a == b || a == c) {
            prize = 1000 + a * 100; // 두 개만 같은 경우 (a와 b 또는 a와 c)
        } else if (b == c) {
            prize = 1000 + b * 100; // b와 c가 같은 경우
        } else {
            prize = Math.max(a, Math.max(b, c)) * 100; // 모두 다른 경우
        }

        System.out.println(prize);
    }
}