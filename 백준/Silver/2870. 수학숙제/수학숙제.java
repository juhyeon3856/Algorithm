
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.math.BigInteger;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<BigInteger> nums = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String st = br.readLine() + "end";
			int start = -1;
			for (int j = 0; j < st.length(); j++) {
				if (st.charAt(j) >= 48 && st.charAt(j) <= 59 && start == -1) {
					start = j;
				} else if (st.charAt(j) >= 97 && start != -1) {
                    nums.add(new BigInteger(st.substring(start, j)));
					start = -1;
				}
			}
		}

		Collections.sort(nums);
		for (int i = 0; i < nums.size(); i++) {
			System.out.println(nums.get(i));
		}
	}
}