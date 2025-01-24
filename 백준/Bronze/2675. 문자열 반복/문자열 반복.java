import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			
			int N = sc.nextInt();
			String str = sc.next();
			
			for (int j = 0; j < str.length(); j++) {
				for (int j2 = 0; j2 < N; j2++) {
					System.out.print(str.charAt(j));
				}
			}
			
			System.out.println();
		}
		
	}
}