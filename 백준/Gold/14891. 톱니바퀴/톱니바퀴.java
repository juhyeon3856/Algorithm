import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] state;
	static int[] index;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		state = new boolean[5][8];
		index = new int[5];
		for (int i = 1; i <= 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				state[i][j] = str.charAt(j) == '1';
			}
		}

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			// 큰쪽 돌아가니?
			int endIdx = num;
			for (int j = num; j < 4; j++) {
				if (state[j][(index[j] + 2) % 8] == state[j + 1][(index[j + 1] + 6) % 8]) {
					break;
				} else {
					endIdx++;
				}
			}
			// 큰쪽 업데이트
			for (int j = num + 1; j <= endIdx; j++) {
				if ((j - num) % 2 == 0) {
					index[j] = (index[j] - dist + 8) % 8;
				} else {
					index[j] = (index[j] + dist + 8) % 8;
				}
			}

			// 작은 쪽 돌아가니?
			endIdx = num;
			for (int j = num; j > 1; j--) {
				if (state[j][(index[j] + 6) % 8] == state[j - 1][(index[j - 1] + 2) % 8]) {
					break;
				} else {
					endIdx--;
				}
			}
			// 작은쪽 업데이트
			for (int j = num; j >= endIdx; j--) {
				if((num-j)%2==0) {
					index[j] = (index[j] - dist + 8) % 8;
				} else {
					index[j] = (index[j] + dist + 8) % 8;
				}
				
			}
		}
		int answer = 0;
//		for (int i = 1; i <= 4; i++) {
//			System.out.println(Arrays.toString(state[i]));
//
//		}
//		System.out.println(Arrays.toString(index));
		for (int i = 0; i < 4; i++) {
			if (state[i + 1][index[i+1]]) {
				answer += 1 << i;
			}
		}
		System.out.println(answer);
	}

}
