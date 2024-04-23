import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class classy{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0;i<N;i++){
            int n = sc.nextInt();
            Person[] people = new Person[n];
            sc.nextLine();//clear the emptyline
            for (int j=0;j<n;j++){
                String temp = sc.nextLine();
                String name = temp.split(":")[0];
                temp = temp.split(" ")[1];
                String[] socialClass = temp.split("-");
                people[j] = new Person(name, socialClass);
            }
            Arrays.sort(people,new CustomComparator());
            for(Person p:people){
                System.out.println(p.name);
            }
            System.out.println("==============================");
        }
        sc.close();
    }

}
class CustomComparator implements Comparator<Person> {
    @Override
    public int compare(Person A, Person B) {
        int x = 0;
        int a = A.SocialClass.length;
        int b = B.SocialClass.length;
        while (true){
            if (x>=a && x>=b) break;
            char aa = a-x<=0?'m':A.SocialClass[a-x-1].charAt(0);
            char bb = b-x<=0?'m':B.SocialClass[b-x-1].charAt(0);
            int d = aa-bb;
            if (d==0){x++;continue;}
            if (d>0) return -1;
            if (d<0) return 1;
        }
        return(A.name.compareTo(B.name));


    }
}
class Person{
    String name;
    String[] SocialClass;
    Person(String name, String[] SocialClass){
        this.name = name;
        this.SocialClass = SocialClass;
    }
}
