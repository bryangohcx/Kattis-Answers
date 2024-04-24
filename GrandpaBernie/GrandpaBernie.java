import java.util.*;
import java.io.*;

public class GrandpaBernie {
    public static void main (String[]args)throws IOException{
        //tools
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Create the hashmap
        int n = Integer.parseInt(br.readLine());
        HashMap<String,LinkedList<Integer>> travels = new HashMap<>();
        
        for (int i=0;i<n;i++){
            String brLine = br.readLine();
            String City = brLine.split(" ")[0];
            int Year = Integer.parseInt(brLine.split(" ")[1]);
            travels.computeIfAbsent(City, k -> new LinkedList<>()).add(Year);
        }
        
        //Sort the years for each city
        for (LinkedList<Integer> years : travels.values()) {
            Collections.sort(years);
        }

        //Query the travels
        int m = Integer.parseInt(br.readLine());
        while(m-->0){
            String[] brList = br.readLine().split(" ");
            String City = brList[0];
            int time = Integer.parseInt(brList[1]);
            int YearWent = travels.get(City).get(time-1);
            pw.println(YearWent);
        }

        //output
        pw.flush();
        br.close();
    }
}