import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<int[]> chicken;
	static List<int[]> house;
	static int N, R;
	static int[] nums;
	static int answer;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		nums = new int[R];

		chicken = new ArrayList<int[]>();
		house = new ArrayList<int[]>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1)
					house.add(new int[] { i, j });
				if (n == 2)
					chicken.add(new int[] { i, j });
			}
		}
		answer = 2 * N * house.size();

		// 입력완 로직시작

		combi(0, 0);
		System.out.println(answer);

	}

	private static void combi(int depth, int start) {
		if (depth == R) {
			int d = distAll();
			answer = d < answer ? d : answer;
			return;
		}
		for (int i = start; i < chicken.size(); i++) {
			nums[depth] = i;
			combi(depth + 1, i + 1);
			nums[depth] = 0;
		}

	}

	private static int distAll() {
		int result = 0;
		for (int[] h : house) {
			result += dist(h);
		}
		return result;
	}

	private static int dist(int[] n1) {
		int result = 2 * N;
		for (int n : nums) {
			int d = Math.abs(n1[0] - chicken.get(n)[0]) + Math.abs(n1[1] - chicken.get(n)[1]);
			result = d < result ? d : result;
		}
		return result;
	}

}
