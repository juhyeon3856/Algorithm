import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, answer;
	static boolean[] data;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new boolean[N + 4];
		data[N + 1] = true;
		data[N + 2] = true;
		data[N + 3] = true;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			data[Integer.parseInt(st.nextToken())] = true;
		}
		answer = 0;
		int i = 1;
//		System.out.println(Arrays.toString(data));
		while (i <= N) {
//			System.out.println("1111111");
			int print = 0;
			int exist = 0;
			while (data[i]) {
				i++;
				if(i > N) {
					System.out.println(answer);
					return;
				}
			}
			for (int j = 1; j < 3; j++) {
				if (data[i + j]) {
					exist++;
				}
			}
			while (exist < 3) {
//				System.out.println("222222222");
				print++;
				if (data[i]) {
					exist--;
				}
				if (data[i + 3]) {
					exist++;
				}
				i++;
			}
			answer += 2 * print + 5;
		}
		System.out.println(answer);

	}
}
