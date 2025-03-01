import java.util.Scanner;

public class Main  {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int size = str.length();
		for (int i = 0; i < size/2; i++) {
			if(str.charAt(i)!=str.charAt(size - 1 - i)) {
				System.out.println(0);
				return;
			}
		}
		System.out.println(1);
		sc.close();
	}

}
