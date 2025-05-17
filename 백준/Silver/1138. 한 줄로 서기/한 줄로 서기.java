import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] data = new int[N+1];
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken()); // 왼쪽 사람들 중 키가 큰 사람 수
		}

//		List<Integer> answer = new LinkedList<Integer>();
		List<Integer> answer = new ArrayList<Integer>();

		for (int i = N; i > 0; i--) {
			answer.add(data[i], i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(answer.get(i)).append(" ");
		}
		System.out.println(sb);

	}

}
