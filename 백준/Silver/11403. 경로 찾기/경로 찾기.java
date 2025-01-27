
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int[][] answer = new int[N][N];
		int[][] one = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				answer[i][j] = Integer.parseInt(st.nextToken());
				one[i][j] = answer[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			answer = mult(answer, one);
		}

		for (int[] row : answer) {
			System.out.println(Arrays.stream(row).mapToObj(String::valueOf).reduce((a, b) -> a + " " + b).get());
		}

	}

	public static int[][] mult(int[][] A, int[][] B) {
		int[][] result = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					result[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		return sum(A, result);
	}

	public static int[][] sum(int[][] A, int[][] B) {
		int[][] result = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (A[i][j] + B[i][j] >= 1) {
					result[i][j] = 1;
				}
			}
		}
		return result;
	}

}