import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int blue = 0, red = 0;
		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == 'B') {
				blue++;
			} else {
				red++;
			}
		}
		char left = str.charAt(0);
		int leftCount = 0;
		for (int i = 0; i < N; i++) {
			if (left == str.charAt(i)) {
				leftCount++;
			} else {
				break;
			}
		}

		char right = str.charAt(N - 1);
		int rightCount = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (right == str.charAt(i)) {
				rightCount++;
			} else {
				break;
			}
		}
		
		int answer = Math.min(red, blue);
		answer = Math.min(answer, left=='B' ? blue - leftCount : red - leftCount);
		answer = Math.min(answer, right=='B' ? blue - rightCount : red - rightCount);
		System.out.println(answer);
	}
}
