
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 665;
		while(N>0) {
			if(String.valueOf(++answer).contains("666")) N--;
		}
		System.out.println(answer);
        sc.close();
	}
}