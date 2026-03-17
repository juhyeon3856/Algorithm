import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 
 * @author ijuhyeon
 *
 *         문제 정 push X: 정수 X를 스택에 넣는 연산이다. pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다.
 *         만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다. size: 스택에 들어있는 정수의 개수를 출력한다. empty:
 *         스택이 비어있으면 1, 아니면 0을 출력한다. top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가
 *         없는 경우에는 -1을 출력한다. N : 10,000
 *
 *         아이디어 스택 구현
 *
 *         복잡도 10,000 * 1 출력은 한번에
 */

// 1 string equal 연산
// 2 stack에 int 대신 string넣기 

public class Main {

	static int N;
	static int[] stack;
	static int size;
	static Map<String, Integer> table;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 및 초기화
		init_table();
		N = Integer.parseInt(br.readLine());
		stack = new int[N];
		size = 0;
		sb = new StringBuilder();

		// 로직
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int type = table.get(st.nextToken());

			if (type == 0) { // push
				stack[size++] = Integer.parseInt(st.nextToken());
			} else if (type == 1) { // pop
				sb.append(size == 0 ? -1 : stack[--size]).append("\n");
			} else if (type == 2) { // size
				sb.append(size).append("\n");
			} else if (type == 3) {// empty
				sb.append(size == 0 ? 1 : 0).append("\n");
			} else { // top
				sb.append(size == 0 ? -1 : stack[size-1]).append("\n");
			}
		}
		
		System.out.println(sb);

	}

	private static void init_table() {
		table = new HashMap<String, Integer>();
		table.put("push", 0);
		table.put("pop", 1);
		table.put("size", 2);
		table.put("empty", 3);
		table.put("top", 4);

	}

}
