import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, W, L;
	static int[] progress, weights;
	static int weight, vehicleCount, answer, nextVehicle, progressIndex, n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		n = N;
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		progress = new int[W];
		progressIndex = 0;
		weights = new int[N];
		weight = 0;
		vehicleCount = 0;
		answer = 0;
		nextVehicle = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}

//		System.out.println(Arrays.toString(weights));
		while (n > 0) {
//			System.out.println("progressIndex : " + progressIndex);
//			System.out.println("weight : " + weight);
//			System.out.println("vehicleCount : " + vehicleCount);
//			System.out.println("nextVehicle : " + nextVehicle);
//			System.out.println(Arrays.toString(progress));
//			System.out.println();

			int endWeight = progress[progressIndex];

			if (endWeight > 0) {
				vehicleCount--;
				n--;
			}
			weight -= endWeight;
			if (nextVehicle < N && weight + weights[nextVehicle] <= L && vehicleCount < W) {
				progress[progressIndex] = weights[nextVehicle];
				vehicleCount++;
				weight += weights[nextVehicle];
				nextVehicle++;
			} else {
				progress[progressIndex] = 0;
			}
			answer++;
			progressIndex = (progressIndex + 1) % W;
		}
		System.out.println(answer);
	}
}
