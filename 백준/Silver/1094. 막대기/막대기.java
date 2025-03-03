import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = Integer.toBinaryString(sc.nextInt());
		int answer = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)=='1') 
				answer++;
		}
		System.out.println(answer);
	}
}
