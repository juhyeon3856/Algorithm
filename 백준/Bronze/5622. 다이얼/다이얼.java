import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int answer = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c < 'A') {
				answer += 2;
			} else if (c < 'D') {
				answer += 3;
			} else if (c < 'G') {
				answer += 4;
			} else if (c < 'J') {
				answer += 5;
			} else if (c < 'M') {
				answer += 6;
			} else if (c < 'P') {
				answer += 7;
			} else if (c < 'T') {
				answer += 8;
			} else if (c < 'W') {
				answer += 9;
			} else {
				answer += 10;
			}
		}
		System.out.println(answer);
	}

}
