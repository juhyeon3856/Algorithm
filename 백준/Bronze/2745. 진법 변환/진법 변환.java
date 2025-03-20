import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		HashMap<Character, Integer> charToNum = new HashMap<>();

		// 0-9 숫자 매핑
		for (int i = 0; i < 10; i++) {
			charToNum.put((char) ('0' + i), i); // 숫자는 그대로 매핑
		}

		// A-Z 알파벳 매핑
		for (int i = 0; i < 26; i++) {
			charToNum.put((char) ('A' + i), 10 + i); // A-Z를 10부터 시작하여 매핑
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		int B = Integer.parseInt(st.nextToken());
		int answer = 0;
		int mult = 1;
		for (int i = str.length() - 1; i >= 0; i--) {
			char c = str.charAt(i);
			answer += charToNum.get(c) * mult;
			mult *= B;
		}
		System.out.println(answer);

	}

}
