import java.util.Scanner;

class Main {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];
        for(int i = 0; i<n;i++){
            list[i] = sc.nextInt();
        }
        int find = sc.nextInt();
        int answer = 0;
        for(int i = 0; i<n;i++){
            if(list[i]==find){
                answer++;
            }
        }
        System.out.println(answer);
    }
}