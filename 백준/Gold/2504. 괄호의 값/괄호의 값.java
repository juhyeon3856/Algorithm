import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 
 * @author ijuhyeon
 *
 *         아이디어 : queue구현 -> pointer 2개 두고 구현(지우지 않음)
 *
 *         복잡도 10,000 * 1 출력은 한번에
 */

public class Main {

	static char[] str;
	static char[] str_stack;
	static int[] value_stack;
	static int size; // 마지막 유효한 값의 인덱스 -> stack의 0인덱스는 패딩 있음

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 및 초기화
		str = br.readLine().toCharArray();
		str_stack = new char[str.length + 1];
		value_stack = new int[str.length + 1];
		str_stack[0] = '-';
		value_stack[0] = 0;
		size = 0;
		
		// 로직 (길이 최대 30이므로 그냥 다 넣어봄)
		for (char c : str) {
			int value = check(c, str_stack[size]);
			if (value != 0) { // 젤 위랑 맞아서 괄호 빼는 로직 
				value = value_stack[size] == 0 ? value : value_stack[size] * value;
				value_stack[--size] += value;
			} else { //모양 안맞아서 stack에 넣는 로직 
				size++;
				str_stack[size] = c;
				value_stack[size] = 0;
			}
		}
		
		// 정답
		if (size > 0) {
			System.out.println(0);
		} else {
			System.out.println(value_stack[0]);
		}
	}

	// 잘 닫혀있는지 확인 
	private static int check(char c, char s) {
		if (s == '(' && c == ')') return 2;
		if (s == '[' &&  c == ']') return 3;
		return 0;
	}

}
