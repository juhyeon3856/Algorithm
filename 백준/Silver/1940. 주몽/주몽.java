import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(p);

		int a = 0;
		int b = N - 1;
		int answer = 0;
		while (a < b) {
			if (p[a] + p[b] == M) {
				answer++;
				a++;
				b--;
			} else if (p[a] + p[b] < M) {
				a++;
			} else {
				b--;
			}
		}
		System.out.println(answer);

	}

}
