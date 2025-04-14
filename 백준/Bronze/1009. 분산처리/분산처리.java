import java.util.Scanner;

class Main{
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i<N;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int answer = 1;
            for(int j = 0; j<b; j++){
                answer *= a;
                answer%=10;
            }
            if(answer==0){
                answer+=10;
            }
            System.out.println(answer);
        }
    }
}