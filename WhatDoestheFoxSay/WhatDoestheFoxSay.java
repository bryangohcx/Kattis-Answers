import java.util.HashSet;
import java.io.*;

class WhatDoestheFoxSay{
    public static void main(String[] args)throws IOException{
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        //add all other animals to a hashset
        while(N-->0){
            String[] allSay = br.readLine().split(" ");
            HashSet<String> sayWut = new HashSet<>();
            String brLine;
            while((brLine = br.readLine()) != null && !brLine.equals("what does the fox say?")){
                String tmp = brLine.split(" ")[2];
                sayWut.add(tmp);
            }
            //out fox say
            int flag = 0;
            for(String sound:allSay){
                if(!sayWut.contains(sound)){
                    if (flag++ != 0){
                        pw.print(" ");
                    }
                pw.print(sound);
                }
            }
            pw.println();
        }
        pw.flush();
        pw.close();
        br.close();
    }
}