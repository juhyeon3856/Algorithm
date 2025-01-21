
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[] callOne = new int[N + 1];
			int[] callZero = new int[N + 1];
			for (int j = 0; j <= N; j++) {
				if (j == 0) {
					callOne[j] = 0;
					callZero[j] = 1;
				} else if (j == 1) {
					callOne[j] = 1;
					callZero[j] = 0;
				} else {
					callOne[j] = callOne[j - 1] + callOne[j - 2];
					callZero[j] = callZero[j - 1] + callZero[j - 2];
				}
			}
			System.out.println(callZero[N] + " " + callOne[N]);
		}
	}

}