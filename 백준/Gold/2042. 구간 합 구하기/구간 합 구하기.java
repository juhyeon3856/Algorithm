import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[] tree;
	static int N, M, K, size, n, h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		h = (int) Math.ceil(Math.log(N) / Math.log(2)); // 3
		n = 1 << h; // 8
		size = n << 1; // 16
		tree = new long[size];

		for (int i = n; i < n + N; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}

		// init
		for (int i = n - 1; i > 0; i--) {
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
		}

//		System.out.println(Arrays.toString(tree));
		int turn = M + K;
		for (int i = 0; i < turn; i++) {
			st = new StringTokenizer(br.readLine());
			if (Integer.parseInt(st.nextToken()) == 1) {
				int idx = Integer.parseInt(st.nextToken()) + n - 1;
				tree[idx] = Long.parseLong(st.nextToken());
				for (int j = idx >> 1; j > 0; j = j >> 1) {
					tree[j] = tree[j * 2] + tree[2 * j + 1];
				}
//				System.out.println(Arrays.toString(tree));
			} else {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				System.out.println(sum(end) - sum(start - 1));
			}
		}

	}

	private static long sum(int end) {
//		System.out.println("end : " + end);
		int s = 0;
		int p = h; // 3
		int skip = 1 << p; // 8
		long result = 0;
		while (end != s) {
			while (end < skip + s) {
				p--;
				skip = 1 << p;
			}
			result += tree[(s + skip + n - 1) >> p];
//			System.out.println("s : " + s);
//			System.out.println("p : " + p);
//			System.out.println("skip : " + skip);
//			System.out.println("result : " + result);
			s += skip;
			p--;
			skip = 1 << p;
		}
//		System.out.println("end result: " + result);
		return result;
	}
}

//5 2 2
//1
//2
//3
//4
//5
//2 3 6
//2 2 5
//2 5 2
//2 3 5