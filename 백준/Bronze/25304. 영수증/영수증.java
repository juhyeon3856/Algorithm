import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tot = sc.nextInt();
        int n = sc.nextInt();
        int sum = 0;
        for(int i=0; i<n;i++){
            int p = sc.nextInt();
            int c = sc.nextInt();
            sum += p*c;
        }
        if(sum==tot){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}