import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static ArrayList<Integer> prime;
	static int N, answer, first, last, pSize, sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		prime = new ArrayList<Integer>();
		answer = 0;
		first = 0;
		last = 1;
		sum = 0;

		makePrime();
		pSize = prime.size();
		towPointer();
		System.out.println(answer);

	}

	private static void towPointer() {
		sum = 2;
		while (first <= last) {
			if (N < sum) {
				sum -= prime.get(first++);
			} else if (N > sum && last < pSize) {
				sum += prime.get(last++);
			} else if(last < pSize){
				answer++;
				sum -= prime.get(first++);
				sum += prime.get(last++);
			} else if(sum == N){
				answer++;
				sum -= prime.get(first++);
			} else {
				break;
			}
		}

	}

	private static void makePrime() {
		prime.add(2);
		for (int i = 3; i <= N; i++) {
			int div = 2;
			boolean isprime = true;
			while (i >= div * div) {
				if (i % div++ == 0) {
					isprime = false;
					break;
				}
			}
			if (isprime) {
				prime.add(i);
			}
		}

	}

}
