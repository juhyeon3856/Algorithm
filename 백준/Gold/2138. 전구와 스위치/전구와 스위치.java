import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[] isChange = new boolean[N];

		String input = br.readLine();
		String goal = br.readLine();

		for (int i = 0; i < N; i++) {
			isChange[i] = input.charAt(i) != goal.charAt(i);
		}

		if (N == 2) {
			if (isChange[0] != isChange[1]) {
				System.out.println(-1);
			} else if(isChange[0]){
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		} else {
			int answer = 0;
			int i = 1;

			// 0번째 안누르는 경우
			while (i + 1 < N) {
				if (isChange[i - 1]) {
					isChange[i] = !isChange[i];
					isChange[i + 1] = !isChange[i + 1];
					answer++;
				}
				i++;
			}

			if (isChange[N - 2] != isChange[N - 1]) {
				for (int j = 0; j < N; j++) {
					isChange[j] = input.charAt(j) != goal.charAt(j);
				}
				// 0번째 누르는 경우
				answer = 1;
				isChange[0] = !isChange[0];
				isChange[1] = !isChange[1];

				i = 1;
				while (i + 1 < N) {
					if (isChange[i - 1]) {
						isChange[i] = !isChange[i];
						isChange[i + 1] = !isChange[i + 1];
						answer++;
					}
					i++;
				}
				if (isChange[N - 2] != isChange[N - 1]) {
					System.out.println(-1);
				} else if (isChange[N - 1]) {
					System.out.println(answer + 1);
				} else {
					System.out.println(answer);
				}

			} else if (isChange[N - 1]) {
				System.out.println(answer + 1);
			} else {
				System.out.println(answer);
			}

		}

	}

}
