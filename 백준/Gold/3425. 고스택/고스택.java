import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static long[] stack;
	static StringTokenizer st;
	static String[] cmds;
	static int[] values;
	static int N, size, ci;
	static long result;

	public static void main(String[] args) throws Exception {
		//System.setIn(new java.io.FileInputStream("./src/sample_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		sb = new StringBuilder();

		while (true) {
			// 종료조건
			String input = br.readLine();
			if ("QUIT".equals(input)) {
				break;
			}

			// 초기화
			ci = 0;
			cmds = new String[100001];

			while (true) {
				if ("END".equals(input)) { // stack 초기화 후 계산 돌리기
					N = Integer.parseInt(br.readLine());
					values = new int[N];
					for (int i = 0; i < N; i++) {

						stack = new long[1001];
						size = 0;

						stack[size++] = Integer.parseInt(br.readLine());
						sb.append(machine() ? result : "ERROR").append("\n");
					}
					break;
				}
				cmds[ci++] = input;
				input = br.readLine();
			}

			sb.append("\n");
			br.readLine();
		}
		System.out.println(sb);

	}

	private static boolean machine() {
		for (int i = 0; i < ci; i++) {
			String cmd = cmds[i];
			if ("POP".equals(cmd)) { // POP: 스택 가장 위의 숫자를 제거한다.
				if (size <= 0)
					return false;
				size--;

			} else if ("INV".equals(cmd)) { // INV: 첫 번째 수의 부호를 바꾼다. (42 -> -42)
				if (size <= 0)
					return false;
				stack[size-1] *= -1;

			} else if ("DUP".equals(cmd)) { // DUP: 첫 번째 숫자를 하나 더 스택의 가장 위에 저장한다.
				if (size <= 0)
					return false;
				stack[size] = stack[size - 1];
				size++;

			} else if ("SWP".equals(cmd)) { // SWP: 첫 번째 숫자와 두 번째 숫자의 위치를 서로 바꾼다.
				if (size <= 1)
					return false;
				long temp = stack[size - 1];
				stack[size - 1] = stack[size - 2];
				stack[size - 2] = temp;

			} else if ("ADD".equals(cmd)) { // ADD: 첫 번째 숫자와 두 번째 숫자를 더한다.
				if (size <= 1)
					return false;
				stack[size - 2] += stack[size - 1];
				if (Math.abs(stack[size - 2]) > 1_000_000_000)
					return false;
				size--;

			} else if ("SUB".equals(cmd)) { // SUB: 첫 번째 숫자와 두 번째 숫자를 뺀다. (두 번째 - 첫 번째)
				if (size <= 1)
					return false;
				stack[size - 2] -= stack[size - 1];
				if (Math.abs(stack[size - 2]) > 1_000_000_000)
					return false;
				size--;

			} else if ("MUL".equals(cmd)) { // MUL: 첫 번째 숫자와 두 번째 숫자를 곱한다.
				if (size <= 1)
					return false;
				stack[size - 2] *= stack[size - 1];
				if (Math.abs(stack[size - 2]) > 1_000_000_000)
					return false;
				size--;

			} else if ("DIV".equals(cmd)) { // DIV: 첫 번째 숫자로 두 번째 숫자를 나눈 몫을 저장한다.
				if (size <= 1)
					return false;
				if (stack[size - 1] == 0)
					return false;

				long num1 = Math.abs(stack[size - 1]);
				long num2 = Math.abs(stack[size - 2]);
				long mul = stack[size-1] * stack[size-2];
				long sign = mul < 0 ? -1 : 1;
				stack[size - 2] = (num2 / num1) * sign;
				size--;

			} else if ("MOD".equals(cmd)) { // MOD: 첫 번째 숫자로 두 번째 숫자를 나눈 나머지를 저장한다.
				if (size <= 1)
					return false;
				if (stack[size - 1] == 0)
					return false;

				long num1 = Math.abs(stack[size - 1]);
				long num2 = Math.abs(stack[size - 2]);
				long sign = stack[size - 2] < 0 ? -1 : 1;
				stack[size - 2] = (num2 % num1) * sign;
				size--;
			} else { // NUM X: X를 스택의 가장 위에 저장한다. (0 ≤ X ≤ 109)
				st = new StringTokenizer(cmd);
				if (!"NUM".equals(st.nextToken()))
					System.out.println("NOOOOOOOOOOOOOOOOOo");
//				st.nextToken();
				stack[size] = Integer.parseInt(st.nextToken());
				size++;
			}
		}

		if (size == 1) {
			result = stack[0];
			return true;
		}

		return false;
	}

}
