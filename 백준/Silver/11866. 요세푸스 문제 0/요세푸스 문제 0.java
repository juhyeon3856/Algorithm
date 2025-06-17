import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()) - 1;

		StringBuilder sb = new StringBuilder();
		sb.append("<");

		ArrayList<Integer> data = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			data.add(i);
		}

		int i = K;

		while (--N > 0) {
			sb.append(data.remove(i)).append(", ");
			i = (i + K) % N;
		}

		sb.append(data.get(0)).append(">");

		System.out.println(sb);
	}

}
