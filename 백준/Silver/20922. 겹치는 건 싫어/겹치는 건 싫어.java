import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());
      int[] visited = new int[200_000];
      int[] nums = new int[N];
      int answer = 0;
      int len = 0;
      st = new StringTokenizer(br.readLine());
      for (int i = 0, j = 0; i < N; i++) {
         int num = Integer.parseInt(st.nextToken());
         nums[i] = num;
         len++;
         if (++visited[num] > K) {
            do {
               visited[nums[j]]--;
               len--;
            } while (nums[j++] != num);
         } else {
            
         }
         answer = Math.max(answer, len);
//         System.out.println("i : " + i);
//         System.out.println("j : " + j);
//         System.out.println("len : " + len);
//         System.out.println("visited : " + Arrays.toString(visited));
      }
      System.out.println(answer);
   }

}
