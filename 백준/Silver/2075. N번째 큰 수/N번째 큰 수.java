import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] data = new int[N][N];
		int[] index = new int[N];
		Arrays.fill(index, N - 1);
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// N번 최댓값 찾아서 빼기
		int maxValue = 0;
		for (int i = 0; i < N; i++) {
			int maxIndex = -1;
			maxValue = Integer.MIN_VALUE;
			for (int j = 0; j < N; j++) {
				if (data[index[j]][j] >= maxValue) {
					maxIndex = j;
					maxValue = data[index[j]][j];
				}
			}
			index[maxIndex]--;
		}
		System.out.println(maxValue);

	}
}
