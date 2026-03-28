import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long ans;
	static int[][] input;
	static int[] numAB, numCD;

	static int debug;

	public static void main(String[] args) throws Exception {
		//System.setIn(new java.io.FileInputStream("./src/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		ans = 0;
		input = new int[4][N];

		numAB = new int[N * N];
		numCD = new int[N * N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[0][i] = Integer.parseInt(st.nextToken());
			input[1][i] = Integer.parseInt(st.nextToken());
			input[2][i] = Integer.parseInt(st.nextToken());
			input[3][i] = Integer.parseInt(st.nextToken());
		}

		// make AB set
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				numAB[i * N + j] = input[0][i] + input[1][j];
				numCD[i * N + j] = input[2][i] + input[3][j];
			}
		}

		Arrays.sort(numAB);
		Arrays.sort(numCD);

		int i = 0;
		int j = N * N - 1;
		while (i < N * N && j >= 0) {
			int result = numAB[i] + numCD[j];
			if (result == 0) {

				// i중복 처리
				long icnt = 1;
				while (i < N * N - 1 && numAB[i] == numAB[i + 1]) {
					i++;
					icnt++;
				}
				// j중복 처리
				long jcnt = 1;
				while (j > 0 && numCD[j] == numCD[j-1]) {
					j--;
					jcnt++;
				}
				
				ans += icnt * jcnt;
				i++;
				j--;
			} else if (result < 0) {
				i++;
			} else if (result > 0) {
				j--;
			}
		}

		System.out.println(ans);

	}

}
