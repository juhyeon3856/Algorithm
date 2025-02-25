import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] min = new int[N];
		int[] idx = new int[N];
		int[] nums = new int[N];
		Arrays.fill(min, Integer.MAX_VALUE);
		int size = 1;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			nums[i] = num;
			for (int j = 0; j <= size; j++) {
				if (num <= min[j]) {
					idx[i] = j;
					min[j] = num;
					if (j == size)
						size++;
					break;
				}
			}
		}

		int[] answer = new int[size];
		StringBuilder sb = new StringBuilder();
		sb.append(size--).append("\n");
		for (int i = N - 1; i >= 0; i--) {
			if (size == idx[i]) {
				answer[size--] = nums[i];
			}
		}

		for (int i = 0; i < answer.length; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
	}

}
