import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			Map<String, Integer> count = new HashMap<>();
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String str = st.nextToken();
				if (count.containsKey(str)) {
					count.put(str, count.get(str) + 1);
				} else {
					count.put(str, 1);
				}
			}
			int answer = 1;
			for (String key : count.keySet()) {
				answer *= count.get(key) + 1;
			}
			System.out.println(answer - 1);
		}
	}
}
