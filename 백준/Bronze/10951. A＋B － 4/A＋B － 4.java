import java.util.Scanner;

class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        try{
            while(true){
                int a = sc.nextInt();
                int b = sc.nextInt();
                System.out.println(a+b);
            }
        } catch(Exception e) {
            
        }
    }
}