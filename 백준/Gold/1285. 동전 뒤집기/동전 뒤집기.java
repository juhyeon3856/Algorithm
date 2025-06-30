import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, xorKey, answer;
	static int[] data;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		data = new int[N];
		xorKey = (1 << N) - 1;
		answer = 200; // 정답이 될 수 있는 최댓값 (N*N/2)

		// 한 행을 bitMast로 저장
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				if (str.charAt(j) == 'T') {
					data[i] += 1 << j;
				}
			}
		}

		// subset으로 모든 경우를 살펴보기
		// for문으로 0개를 선택할 때 부터 N/2개를 선택하는 경우만 보아도 무관함
		// 하지만 N이 그렇게 크지 않으므로 그냥 2^N가지 경우의 수 다 보겠음.
		subset(0);

		// 정답 출력
		System.out.println(answer);

	}

	private static void subset(int depth) {
		if (depth == N) {
			// i번째 행에 0인 비트가 몇개 있는지 count해서 모든 행에 있는 작은 면의 개수 세기
			// (작은 면의 개수로 뒷면의 수 맞출 수 있으니까)
			int countAll = 0;
			for (int i = 0; i < N; i++) {
				int countLine = 0;
				for (int j = 0; j < N; j++) {
					if ((data[j] & (1 << i)) == 0) {
						countLine++;
					}
				}
				countAll += countLine > N / 2 ? N - countLine : countLine;
			}
			answer = Math.min(countAll, answer);
			return;
		}

		// 전부 뒤집고 들어가고
		data[depth] ^= xorKey;
		subset(depth + 1);

		// 나와서 다시 전부 뒤집고 들어가고
		data[depth] ^= xorKey;
		subset(depth + 1);

	}

}
