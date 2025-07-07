import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] count;
	static char answer;
	static int maxCount;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		count = new int[26];

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c < 'a') {
				count[c - 'A']++;
			} else {
				count[c - 'a']++;
			}
		}

		for (int i = 0; i < 26; i++) {
			if (count[i] > maxCount) {
				maxCount = count[i];
				answer = (char) (i + 'A');
			} else if (count[i] == maxCount) {
				answer = '?';
			}
		}
		System.out.println(answer);
	}

}
