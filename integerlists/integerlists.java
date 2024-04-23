import java.util.LinkedList;
import java.util.Scanner;

class integerlists{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();sc.nextLine();
        for(int i=0;i<N;i++){
            String action = sc.next();
            int terms = sc.nextInt();sc.nextLine();
            String temp = sc.next();
            temp = temp.substring(1,temp.length()-1);
            String[] seq = temp.split(",");
            LinkedList<Integer> list = new LinkedList<>();
            for (int j=0;j<terms;j++){
                list.add(Integer.parseInt(seq[j]));
            }
            int flag = 0;//o is in order 1 is reverse
            for (char act:action.toCharArray()){
                if (act == 'R'){
                    flag = (flag+1)%2;
                }
                if (act =='D'){
                    if (terms == 0){
                        System.out.println("error");
                        flag=3;
                        break;
                    }else{
                        if (flag==0){
                            list.removeFirst();
                            }else{
                            list.removeLast();
                        } 
                    }
                    terms--;
                }
            }
            if (flag == 0){
                System.out.print("[");
                for (int j=0;j<list.size();j++){
                    if (j!=0){
                        System.out.print(",");
                    }
                    System.out.print(list.get(j));
                }
                System.out.print("]\n");
            }
            if (flag == 1){
                System.out.print("[");
                for (int j=0;j<list.size();j++){
                    if (j!=0){
                        System.out.print(",");
                    }
                    System.out.print(list.get(list.size()-j-1));
                }
                System.out.print("]\n");
            }
        }
        sc.close();
    }
}