import java.util.*;
import java.io.PrintWriter;
import java.util.Collections;
class DSGuess{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        while(sc.hasNext()){
            Integer actions = sc.nextInt();
            Queue<Integer> q = new LinkedList<>();
            Stack<Integer> s = new Stack<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int qFlag = 1 , sFlag = 1, pqFlag = 1;
            int inBag = 0, outBag = 0;
            for (int i = 0; i < actions; i++){
                int action = sc.nextInt();
                Integer element = sc.nextInt();
                switch (action) {
                    case 1:
                        q.offer(element);
                        s.push(element);
                        pq.offer(element);
                        inBag++;
                        break;
                    case 2:
                        if (inBag<=outBag)break;
                        if(q.poll()!=element) qFlag = 0;
                        if(s.pop()!=element) sFlag = 0;
                        if(pq.poll()!=element) pqFlag = 0;
                        outBag++;
                        break;
                    default:
                        break;
                }
            }
            //add the flags together as integers to find how many are true
            int flagCount = qFlag + sFlag + pqFlag;
            if(flagCount==0) pw.println("impossible");
            else if(flagCount>=2) pw.println("not sure");
            else if(qFlag==1) pw.println("queue");
            else if(sFlag==1) pw.println("stack");
            else if(pqFlag==1) pw.println("priority queue");
            pw.flush();
        }
        pw.flush();
        sc.close();
        pw.close();
    }
}