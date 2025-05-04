import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[] data;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new boolean[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = st.nextToken().equals("1");
		}
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.nextToken().equals("1")) {
				boy(Integer.parseInt(st.nextToken()));
			} else {
				girl(Integer.parseInt(st.nextToken()));
			}
		}
		for (int i = 1; i <= N; i++) {
			if (data[i]) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
			}
			if(i%20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);

	}

	private static void girl(int start) {
		int index1 = start - 1;
		int index2 = start + 1;
		data[start] = !data[start];
		while (index1 >= 1 && index2 <= N) {
			if (data[index1] == data[index2]) {
				data[index1] = !data[index1];
				data[index2] = !data[index2];
				index1--;
				index2++;
			} else {
				break;
			}
		}

	}

	private static void boy(int start) {
		int index = start;
		while (index <= N) {
			data[index] = !data[index];
			index += start;
		}

	}
}
