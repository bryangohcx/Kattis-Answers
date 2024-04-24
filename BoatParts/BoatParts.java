import java.util.Scanner;
import java.util.HashSet;

class Boatparts{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int d = sc.nextInt();
        HashSet<String> parts = new HashSet<>();
        for(int i=0;i<d;i++){
            String part = sc.next();
            if(!parts.contains(part)){
                parts.add(part);
                p--;
            }
            if (p==0){
                System.out.println(i+1);
                sc.close();
                return;
            }
        }
        if(p>0){
            System.out.println("paradox avoided");
        }
        sc.close();
    }
}