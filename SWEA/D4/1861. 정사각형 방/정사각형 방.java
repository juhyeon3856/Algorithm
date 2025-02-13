import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, maxStart, maxValue;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			maxStart = 0;
			maxValue = 0;
			map = new int[N * N][2]; // 1->0부터 순서대로 N^2까지의 인덱스를 저장

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[Integer.parseInt(st.nextToken()) - 1] = new int[] { i, j };
				}
			}

			int idx = 0;
			while (idx < N * N) {
				boolean conti = true;
				int value = 1;
				// 다음 값은 idx+value;
				while (conti) {
					if(idx+value==N*N) {
						if (value > maxValue) {
							maxValue = value;
							maxStart = idx+1;
						}
						idx = N*N;
						break;
					}
					if (isNext(map[idx + value - 1], map[idx + value])) {
						value++;
					} else {
						if (value > maxValue) {
							maxValue = value;
							maxStart = idx+1;
						}
						idx = idx + value;
						conti = false;
					}
				}
			}

			System.out.println("#" + t + " " + maxStart + " " + maxValue);

		}

	}

	private static boolean isNext(int[] prev, int[] next) {
		int r = Math.abs(prev[0] - next[0]);
		int c = Math.abs(prev[1] - next[1]);
		return (r == 0 && c == 1) || (r == 1 && c == 0);
	}

}
