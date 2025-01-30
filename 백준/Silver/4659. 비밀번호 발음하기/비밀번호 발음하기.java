
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String password = br.readLine();
		while (!password.equals("end")) {
			boolean case1 = false; // 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
			boolean case2 = true; // 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
			boolean case3 = true; // 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.

			Set<Character> set = new HashSet<>();
			set.add('a');
			set.add('e');
			set.add('i');
			set.add('o');
			set.add('u');

			for (int i = 0; i < password.length(); i++) {
				char c = password.charAt(i);
				if (set.contains(c))
					case1 = true;
				if (i > 1 && set.contains(c) == set.contains(password.charAt(i - 1))
						&& (set.contains(c) == set.contains(password.charAt(i - 2)))) {
					case2 = false;
					break;
				}
				if (i > 0 && c == password.charAt(i - 1) && c != 'e' && c != 'o') {
					case3 = false;
					break;
				}
			}
			if (case1 && case2 && case3) {
				System.out.println("<" + password + "> is acceptable.");
			} else {
				System.out.println("<" + password + "> is not acceptable.");
			}
			password = br.readLine();

		}
	}
}