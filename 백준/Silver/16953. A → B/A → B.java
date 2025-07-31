import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int answer = 0;

		while (A < B) {
			if (B % 10 == 1) {
				B /= 10;
				answer++;
			} else if ((B & 1) == 0) {
				B = B >> 1;
				answer++;
			} else {
				answer = -1;
				break;
			}
		}
		if (A == B) {
			System.out.println(answer + 1);
		} else {
			System.out.println(-1);
		}

	}

}
