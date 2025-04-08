import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] min = new int[N];
		int[] idx = new int[N];
		int[] nums = new int[N];
		Arrays.fill(min, Integer.MAX_VALUE);
		int size = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			nums[i] = num;
			int index = Arrays.binarySearch(min, num);
			if (index < 0) {
				index = -1 * (index + 1);
			}
			idx[i] = index;
			min[index] = num;
			size = size < index ? index : size;
		}
//		System.out.println(Arrays.toString(min));
		size++;
		int[] answer = new int[size];
		StringBuilder sb = new StringBuilder();
		sb.append(size--).append("\n");
		for (int i = N - 1; i >= 0; i--) {
			if (size == idx[i]) {
				answer[size--] = nums[i];
			}
		}

//		System.out.println(size);
//		System.out.println(Arrays.toString(answer));

		for (int i = 0; i < answer.length; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
	}

}
