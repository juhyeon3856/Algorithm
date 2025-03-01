import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main  {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int c = str.charAt(0)-0;
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 'a'; i <= 'z'; i++) {
			if (map.containsKey(i) && map.get(i) >= 5) {
				sb.append(Character.toChars(i));
			}
		}
		if (sb.length()==0) {
			System.out.println("PREDAJA");
		} else {
			System.out.println(sb);
		}
	}
}
