import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, answer;
	static int[][] nums;
	static int[] min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		nums = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			nums[i][0] = Integer.parseInt(st.nextToken());
			nums[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums, (o1, o2) -> (Integer.compare(o1[0], o2[0])));

		answer = 0;
		min = new int[N];
		Arrays.fill(min, Integer.MAX_VALUE);

		for (int i = 0; i < N; i++) {
			int num = nums[i][1];
			int idx = Arrays.binarySearch(min, num);
			if (idx < 0) {
				idx = -1 * (idx + 1);
			}
			min[idx] = num;
			answer = answer < idx ? idx : answer;
		}
		System.out.println(N - answer - 1);

	}
}