import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] data = new int[N][2];
		for (int i = 0; i < N; i++) {
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = i;
		}
		Arrays.sort(data, (o1, o2) -> (Integer.compare(o1[0], o2[0])));
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			answer[data[i][1]] = i;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
	}
}