import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			HashSet<Integer> note = new HashSet<>();
			for (int i = 0; i < N; i++) {
				note.add(Integer.parseInt(st.nextToken()));
			}
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				if(note.contains(Integer.parseInt(st.nextToken()))) {
					sb.append("1").append("\n");
				} else {
					sb.append("0").append("\n");
				}
			}
			System.out.print(sb);

		}

	}
}
