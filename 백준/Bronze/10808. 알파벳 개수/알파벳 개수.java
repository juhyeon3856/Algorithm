import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] cnt = new int[26];
		for (int i = 0; i < str.length(); i++) {
			cnt[str.charAt(i)-'a']++;
		}
		for (int i = 0; i < 26; i++) {
			System.out.print(cnt[i] + " ");
		}
	}
}
