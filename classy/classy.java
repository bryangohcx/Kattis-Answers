package classy;

import java.io.*;

public class classy {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        for(int j=0;j<N;j++){
            int p = Integer.parseInt(br.readLine());
            Person[] people = new Person[p];
            for(int i=0;i<p;i++){
                String str = br.readLine();
                String Name = str.split(":")[0];
                String SC = str.split(" ")[1];
                String[] SocialClass = SC.split("-");
                people[i] = new Person(Name,SocialClass);
            }
        }

        
        
    }
}

class Person{
    String Name;
    String[] SocialClass;

    public Person(String Name, String[] socialClass) {
        
    }
}