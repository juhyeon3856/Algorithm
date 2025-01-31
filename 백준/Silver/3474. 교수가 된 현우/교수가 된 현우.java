import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			int answer = 0;
			int pow = 1;
			while(Math.pow(5, pow)<=num) {
				answer += num/Math.pow(5, pow++);
			}
			System.out.println(answer);
		}
		sc.close();
	}
}