
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {

	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] numbers = java.util.Arrays.stream(br.readLine().split(" ")) // 입력 받은 한 줄을 공백 기준으로 분리하여 스트림 생성
				.mapToInt(Integer::parseInt) // 각 문자열을 int로 변환
				.toArray(); // int 배열로 변환 // 한 줄로 int[] 변환
		
		int[] answer = new int[N];
		
		Stack<Integer> stack = new Stack<>();
		for (int i = N-1; i >=0; i--) {
			answer[i] = -1;
			while(!stack.isEmpty()) {
				if(stack.peek()>numbers[i]) {
					answer[i] = stack.peek();
					break;
				} else {
					stack.pop();
				}
			}
			stack.add(numbers[i]);
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);

	}

}
