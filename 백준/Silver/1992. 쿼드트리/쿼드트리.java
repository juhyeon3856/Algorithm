
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	static String answer = "";
	static int[][] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 첫 번째 입력: N
		nums = new int[N][N]; // 크기를 N으로 설정

		for (int i = 0; i < N; i++) {
			String st = br.readLine();
			for (int j = 0; j < N; j++) {
				nums[i][j] = st.charAt(j) - '0';
			}
		}

		dfs(0, 0, N);
		System.out.println(answer);
	}

	private static void dfs(int r, int c, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (nums[r][c] != nums[r + i][c + j]) {
					int m = n / 2;
					answer += "(";
					dfs(r, c, m);
					dfs(r, c + m, m);
					dfs(r + m, c, m);
					dfs(r + m, c + m, m);
					answer += ")";
					return;
				}
			}
		}
		answer += nums[r][c];
	}
}