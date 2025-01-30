
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int start = 1, end = M;
		int answer = 0;
		for (int i = 0; i < K; i++) {
			int apple = sc.nextInt();
			if(apple < start) {
				int move = start - apple;
				answer += move;
				start -= move;
				end -= move;
			} else if(apple > end) {
				int move = apple - end;
				answer += move;
				start += move;
				end += move;
			}
		}
		System.out.println(answer);
	}
}