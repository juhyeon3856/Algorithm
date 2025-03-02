import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String answer = "";

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == ' ' || (c >= '0' && c <= '9')) {
				answer += c;
			} else if (c >= 'A' && c <= 'Z') {
				int temp = c - 'A';
				temp = (temp + 13) % 26;
				answer += (char) (temp + 'A');
			} else if (c >= 'a' && c <= 'z') {
				int temp = c - 'a';
				temp = (temp + 13) % 26;
				answer += (char) (temp + 'a');
			}
		}
		System.out.println(answer);

	}
}
