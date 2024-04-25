import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ZipfsSong{
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] brArr = br.readLine().split(" ");
        int n = Integer.parseInt(brArr[0]);
        int m = Integer.parseInt(brArr[1]);
        PriorityQueue<monkeySong> pq = new PriorityQueue<>(new monkeySongComparator());

        for(int i=0;i<n;i++){
            brArr = br.readLine().split(" ");
            int timesListened = Integer.parseInt(brArr[0]);
            String songTitle = brArr[1];
            int albumOrder = i+1;
            monkeySong tmp = new monkeySong(songTitle, albumOrder, timesListened);
            pq.add(tmp);
        }
        
        for(int i=0;i<m;i++){
            System.out.println(pq.poll().songTitle);
        }
        br.close();
    }
}
class monkeySong{
    String songTitle;
    int albumOrder;
    int timesListened;
    monkeySong(String songTitle,int albumOrder,int timesListened){
        this.songTitle = songTitle;
        this.albumOrder = albumOrder;
        this.timesListened = timesListened;
    }
}
class monkeySongComparator implements Comparator<monkeySong>{
    @Override
    public int compare(monkeySong ms1, monkeySong ms2){
        // Compare based on quality (timesListened / albumOrder)
        double quality1 = (double) ms1.timesListened / ms2.albumOrder;
        double quality2 = (double) ms2.timesListened / ms1.albumOrder;
    
        // Compare qualities and give precedence to the one appearing first on the album
        if (quality1 > quality2) return -1;
        if (quality1 < quality2) return 1;
        else return Integer.compare(ms1.albumOrder, ms2.albumOrder);
    }
    
}