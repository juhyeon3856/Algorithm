import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] data;
	static int N, M, count;
	static long answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		data = new int[N];
		int half = N / 2;

		int[] A = new int[1 << half];
		int[] B = new int[1 << (N - half)];

		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		// 반으로 나눈 후 가능한 subset 구하기
		count = 0;
		subset(0, 0, half, A, 0);
		count = 0;
		subset(0, half, N, B, 0);

		// 가능한 subset의 합 정렬하기
		Arrays.sort(B);


		// A로 만들수 있는 합에 더 필요한 수가 B에 몇개 있는지 확인하기
		for (int i = 0; i < (1 << half); i++) {
			int num = M - A[i];

			// 해당 값이 없으면 continue; 
			int exist = Arrays.binarySearch(B, num);
			if (exist < 0)
				continue;

			int index1 = Arrays.binarySearch(B, num - 1);
			index1 = index1 < 0 ? -1 * (index1 + 1) : index1;
			while (B[index1] < num) {
				index1++;
			}

			int index2 = Arrays.binarySearch(B, num + 1);
			index2 = index2 < 0 ? -1 * (index2 + 1) - 1 : index2 - 1;

			while (B[index2] > num) {
				index2--;
			}

			answer += index2 - index1 + 1;

		}
		if (M == 0)
			answer--;
		System.out.println(answer);

	}

	private static void subset(int depth, int start, int end, int[] arr, int flag) {
		if (depth == end - start) {
			int sum = 0;
			for (int i = 0; i < end - start; i++) {
				if ((flag & (1 << i)) != 0) {
					sum += data[start + i];
				}
			}
			arr[count++] = sum;
			return;
		}

		subset(depth + 1, start, end, arr, flag | 1 << depth);
		subset(depth + 1, start, end, arr, flag);

	}

}
