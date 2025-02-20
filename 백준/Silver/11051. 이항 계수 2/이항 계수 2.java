import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		K = N - K < K ? N - K : K;
		int P = 10007;
		int answer = 1;
		int div = 1;
		int time = K;

		for (int i = N; i > N - K; i--) {
			answer = (answer * i) % P;
			div = (div * time--) % P;
		}

		int d = div;
		for (int i = 1; i < P - 2; i++) {
			div = (div * d) % P;
		}

		answer = (div * answer) % P;
		System.out.println(answer);

	}

}
