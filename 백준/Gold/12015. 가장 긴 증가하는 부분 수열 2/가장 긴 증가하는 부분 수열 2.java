import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, answer;
	static int[] min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		answer = 0;
		min = new int[N];
		Arrays.fill(min, Integer.MAX_VALUE);
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			int idx = Arrays.binarySearch(min, num);
			if (idx < 0) {
				idx = -1 * (idx + 1);
			}
			min[idx] = num;
			answer = answer < idx ? idx : answer;
		}
		System.out.println(answer + 1);

	}
}