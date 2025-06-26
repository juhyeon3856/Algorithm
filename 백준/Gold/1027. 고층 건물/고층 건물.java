import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N; // 빌딩의 수
	static int[] data; // i번째 빌딩의 높이 data
	static int[] nums; // 비교해볼 서로 다른 두 nums
	static int[] count; // i번째 빌딩에서 볼 수 있는 빌딩의 수를 count

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		data = new int[N];
		nums = new int[2];
		count = new int[N];

		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		// 서로 다른 두개의 빌딩을 선택하기
		combi(0, 0);

		// 볼 수 있는 빌딩의 수가 가장 많은 값을 찾기
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, count[i]);
		}
		System.out.println(answer);
	}

	private static void combi(int depth, int start) {
		if (depth == 2) {
			// 선택된 두 빌딩이 서로 볼 수 있는지 확인 및 반영하는 함수
			look(nums[0], nums[1]);
			return;
		}

		for (int i = start; i < N; i++) {
			nums[depth] = i;
			combi(depth + 1, i + 1);
		}
	}

	private static void look(int x1, int x2) {

		// x1은 x2보다 항상 작음
		for (int i = x1 + 1; i < x2; i++) {
			if (data[i] >= equation(x1, x2, i)) {
				return;
			}
		}

		// return 되지 않고 for문을 다 돌면 두 빌딩은 서로 볼 수 있음
		count[x1]++;
		count[x2]++;

	}

	// x1과 x2를 이은 직선의 방정식 위에서 x일 때의 y값을 리턴함
	private static double equation(int x1, int x2, int x) {
		double y1 = data[x1];
		double y2 = data[x2];
		return ((y2 - y1) / (x2 - x1)) * (x - x1) + y1;
	}

}
