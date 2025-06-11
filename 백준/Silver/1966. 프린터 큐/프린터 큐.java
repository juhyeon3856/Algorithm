import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			int gr = -1;
			int gc = -1; // 초기화
			st = new StringTokenizer(br.readLine());
			int answer = 0;
			boolean[][] data = new boolean[10][N]; // 중요도 1부터 9까지
			int[] count = new int[10];

			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				if (i == idx) {
					gr = num;
					gc = i;
				}
				count[num]++;
				data[num][i] = true;
			}

			int cr = 9;
			int cc = N - 1;
			while (cr != gr) {
				if(count[cr]==0) {
					cr--;
					continue;
				}
				if (data[cr][cc]) {
					answer+=count[cr];
					cr--;
				} else {
					cc = (cc - 1 + N) % N;
				}
			}
			
			answer += count[gr];
			while(cc != gc) {
				if (data[cr][cc]) {
					answer--;
				}
				cc = (cc - 1 + N) % N;
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
