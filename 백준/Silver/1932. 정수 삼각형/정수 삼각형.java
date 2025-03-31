import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, answer;
	static int[][] paper;

	public static void main(String[] args) throws Exception {

		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = 0;

		paper = new int[N][];
		paper[0] = new int[] { Integer.parseInt(br.readLine()) };

		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			paper[i] = new int[i + 1];
			paper[i][0] = paper[i - 1][0] + Integer.parseInt(st.nextToken());
			for (int j = 1; j < i; j++) {
				int prev = paper[i - 1][j - 1] > paper[i - 1][j] ? paper[i - 1][j - 1] : paper[i - 1][j];
				paper[i][j] = prev + Integer.parseInt(st.nextToken());
			}
			paper[i][i] = paper[i - 1][i - 1] + Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			answer = paper[N - 1][i] > answer ? paper[N - 1][i] : answer;
		}
		System.out.println(answer);
	}

}
