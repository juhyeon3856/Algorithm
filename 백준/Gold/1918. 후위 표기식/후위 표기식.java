import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
	static Map<Character, Integer> order;
	static String problem;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		order = new HashMap<Character, Integer>();
		order.put('+', 2);
		order.put('-', 2);
		order.put('*', 1);
		order.put('/', 1);

		problem = br.readLine();
		List<Character> stack = new LinkedList<Character>();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < problem.length(); i++) {
			char c = problem.charAt(i);
			if (c == '(') {
				stack.add(0, '(');
			} else if (c == ')') {
				while (stack.get(0) != '(') {
					sb.append(stack.remove(0));
				}
				stack.remove(0);
			} else if (order.keySet().contains(c)) {
				while (!stack.isEmpty() && stack.get(0) != '(' && order.get(c) >= order.get(stack.get(0))) {
					sb.append(stack.remove(0));
				}
				stack.add(0, c);
			} else {
				sb.append(c);
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.remove(0));
		}
		System.out.println(sb);

	}

}
