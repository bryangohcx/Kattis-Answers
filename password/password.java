import java.util.Arrays;
import java.util.Scanner;

class password{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        double[] probs = new double[N];
        double prob = 0;
        for (int i=0;i<N;i++){
            sc.next();
            //we dont care about the pw themselves
            double p = sc.nextDouble();
            probs[i] = p;
        }
        Arrays.sort(probs);
        for (int i=0;i<N;i++){
            double p = probs[probs.length-i-1];
            prob+=p*(i+1);
        }
        System.out.println(prob);
        sc.close();
    }
}