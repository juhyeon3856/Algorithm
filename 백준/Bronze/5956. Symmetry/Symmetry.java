
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int answer = 0;
		int depth = 0;
		while (N > 0 && M > 0) {
			if (N % 2 == 1 && M % 2 == 1) {
				answer += Math.pow(4, depth++);
				N = (N - 1) / 2;
				M = (M - 1) / 2;
			} else {
				break;
			}
		}
		System.out.println(answer);
        sc.close();
	}

}