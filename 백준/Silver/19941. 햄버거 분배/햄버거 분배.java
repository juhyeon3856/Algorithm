import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String str = br.readLine();

		int answer = 0;

		for (int h = 0, p = 0; h < N && p < N;) {
			// 다음 사람 찾기
			while (p < N && str.charAt(p) != 'P') {
				p++;
			}
			h = Math.max(h, p - K);
			h = Math.max(0, h);
			// 먹을 수 있는 가능한 h 값 중 가장 작은
			while (h < N && str.charAt(h) != 'H') {
				h++;
			}
			if (h >= N || p >= N) {
				break;
			} else if (h > p + K) {
				h = p + K;
				p++;
			} else {
				// 한명이 햄버거 하나 먹음 -> answer++;
				answer++;
//				System.out.println("h : " + h + ", p : " + p + ", answer : " + answer);
				h++;
				p++;
			}

		}
		System.out.println(answer);

	}

}


//20 1
//01 2 3 4 5 67 8 9 0 1 2 3 4 5 6 7 8 9
//HH P H P P HH P P H P P P H P H P H P