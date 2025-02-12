import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = 1;
		while (num > 0) {
			try {
				String str = br.readLine();
				num = Integer.parseInt(str);
				int cnt = 1;
				long sum = 1 % num;
				long prev = sum;
				int mul = 10 % num;
				while (sum > 0) {
					prev = prev * mul % num;
					sum = (sum + prev) % num;
					cnt++;
				}
				System.out.println(cnt);
			} catch (Exception e) {
				break;
			}
		}
	}

}
