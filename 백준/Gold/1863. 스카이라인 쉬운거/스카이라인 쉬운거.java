import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, answer;
	static int[] stack;
	static int top;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int answer = 0; // 0을 미리 넣어두고 시
		int top = 0; // 0이 들어있으니 top은 0번째 인덱스

		stack = new int[N + 1]; // 들어갈 수 있는 최대 크기 N

		// 입력 받으면서 정답 처리
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			// stack top이 num 보다 크면 뺀다.
			while (stack[top] > num) {
				top--;
				answer++;
			}
			// top이 작으면 넣는다
			if (stack[top] < num) {
				stack[++top] = num;
			}
		}
		System.out.println(answer + top);

	}

}
