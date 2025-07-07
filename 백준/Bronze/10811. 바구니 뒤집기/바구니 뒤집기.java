import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 바구니 개수
        int m = sc.nextInt(); // 바구니를 뒤집는 횟수

        int[] baskets = new int[n];
        for (int i = 0; i < n; i++) {
            baskets[i] = i + 1; // 1번부터 n번까지 바구니 초기화
        }

        for (int k = 0; k < m; k++) {
            int i = sc.nextInt() - 1; // 시작 인덱스 (0-based)
            int j = sc.nextInt() - 1; // 끝 인덱스 (0-based)

            // i~j 구간을 역순으로 뒤집기
            while (i < j) {
                int temp = baskets[i];
                baskets[i] = baskets[j];
                baskets[j] = temp;
                i++;
                j--;
            }
        }

        // 결과 출력
        for (int val : baskets) {
            System.out.print(val + " ");
        }
    }
}