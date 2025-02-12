
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;


class Solution
{
    static int N, L, max;
	static int[][] p;
    
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			max = 0;
			p = new int[N][2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				p[i][0] = Integer.parseInt(st.nextToken());
				p[i][1] = Integer.parseInt(st.nextToken());
			}

			subset(0, 0, 0);
			System.out.println("#" + test_case + " " + max);
		}
	}

	private static void subset(int depth, int f, int k) {
		if (depth == N) {
			if (k <= L && f > max) {
				max = f;
			}
			return;
		}
        
		if (k <= L) {
			subset(depth + 1, f + p[depth][0], k + p[depth][1]);
			subset(depth + 1, f, k);
		}

	}
}