import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, K, M;
	static int[] visited, nums, shufNums;
	static int ans;
	static List<int[]> shuf;

	public static void main(String[] args) throws Exception {
		//System.setIn(new java.io.FileInputStream("./src/sample_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String Nstr = st.nextToken();
		N = Integer.parseInt(Nstr);
		K = Integer.parseInt(st.nextToken());

		visited = new int[1_000_001];

		ans = -1;

		M = Nstr.length();
		nums = new int[M];
		shuf = new ArrayList<int[]>();
		shufNums = new int[2];

		for (int i = 0; i < M; i++) {
			nums[M - i - 1] = N % 10;
			N /= 10;
		}

		shuffle(0, 0); // 섞을 인덱스 조합
		combi(0, 0);

		// 정답체크
		for (int i = 1_000_000; i > 0; i--) {
			if ((visited[i] & (1 << K)) != 0) {
				ans = i;
				break;
			}
		}

		System.out.println(ans);

	}

	private static void shuffle(int depth, int start) {
		if (depth == 2) {
			shuf.add(new int[] { shufNums[0], shufNums[1] });
			return;
		}
		for (int i = start; i < M; i++) {
			shufNums[depth] = i;
			shuffle(depth + 1, i + 1);
		}

	}

	private static void combi(int depth, int start) {
		if (depth == K) {
			visited[Array2Num()] |= 1 << K;
			return;
		}
		for (int i = 0; i < shuf.size(); i++) {
			int[] idx = shuf.get(i);
			if (idx[0] == 0 && nums[idx[1]] == 0)
				continue;
			swap(idx[0], idx[1]);
			if ((visited[Array2Num()] & (1 << depth)) != 0) { // 방문한 적 있으면
				swap(idx[0], idx[1]);
				continue;
			}
			visited[Array2Num()] |= (1 << depth);
			combi(depth + 1, i + 1);
			swap(idx[0], idx[1]);
		}
	}

	private static void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private static int Array2Num() {
		int result = 0;
		for (int i = 0; i < M; i++) {
			result *= 10;
			result += nums[i];
		}
		return result;
	}

}
