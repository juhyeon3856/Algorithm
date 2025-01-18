import java.util.*;

public class Main {

	static int[] count;

	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        
		List<int[]> queue = new LinkedList<>();
        queue.add(new int[] {n, 0});
        int[] q = queue.remove(0);
        
        while(q[0]>1){
            if(q[0]%3==0){
                queue.add(new int[] {q[0]/3, q[1]+1});
            }
            if(q[0]%2==0){
                queue.add(new int[] {q[0]/2, q[1]+1});
            }
            queue.add(new int[] {q[0]-1, q[1]+1});
            q = queue.remove(0);
        }
        System.out.println(q[1]);
	}
}