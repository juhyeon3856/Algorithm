import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 바구니 수
        int m = sc.nextInt(); // 공을 바꾸는 횟수

        int[] basket = new int[n];

        // 초기 상태 설정
        for (int i = 0; i < n; i++) {
            basket[i] = i + 1; // 바구니 번호와 공 번호가 같음
        }

        // 공 바꾸기 로직
        for (int k = 0; k < m; k++) {
            int i = sc.nextInt(); // i번 바구니
            int j = sc.nextInt(); // j번 바구니

            // swap
            int temp = basket[i - 1]; // 인덱스는 0부터 시작하므로 -1
            basket[i - 1] = basket[j - 1];
            basket[j - 1] = temp;
        }

        // 최종 결과 출력
        for (int num : basket) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
