import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main  {
	static int[][] map;
	static int N, answer;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		nums = new int[N + 1];
		map = new int[N][N];
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			nums[i] = i;
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		do {
			int dist = baseCondition();
			if (dist < answer) {
				answer = dist;
			}
		} while (np(N - 1));
		System.out.println(answer);
	}

	private static int baseCondition() {
		nums[N] = nums[0];
		int dist = 0;
		for (int i = 1; i <= N; i++) {
			if (map[nums[i - 1]][nums[i]] == 0) {
				return Integer.MAX_VALUE;
			}
			dist += map[nums[i - 1]][nums[i]];
		}
		return dist;
	}

	private static boolean np(int size) {
		int i = size;
		while (i > 0 && nums[i - 1] > nums[i])
			i--;
		if (i == 0)
			return false;
		int j = size;
		while (nums[i - 1] > nums[j])
			j--;
		int temp = nums[i - 1];
		nums[i - 1] = nums[j];
		nums[j] = temp;
		int k = size;
		while (i < k) {
			temp = nums[k];
			nums[k] = nums[i];
			nums[i] = temp;
			i++;
			k--;
		}
		return true;
	}
}
