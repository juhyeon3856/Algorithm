import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int size = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());

		nums[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				if (nums[j] >= n) {
					nums[j] = n;
					break;
				}
				if (j == size - 1) {
					nums[size++] = n;
					break;
				}
			}
		}
		System.out.println(size);
	}

}
