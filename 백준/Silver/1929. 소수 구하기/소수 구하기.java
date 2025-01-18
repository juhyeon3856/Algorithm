import java.util.*;

public class Main {

	static int[] count;

	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(), n=sc.nextInt();
		
		List<Integer> prime = new LinkedList<>();
        int count = 0;
		for(int i=2; i<=n; i++) {
			boolean isPrime = true;
			for(int p:prime) {
				if(i%p==0) {
					isPrime = false;
					break;
				}
                if(p*p>i) break;
			}
			if(isPrime) {
				if(i>=m) System.out.println(i);
				prime.add(i);
			}
		}
	}
}