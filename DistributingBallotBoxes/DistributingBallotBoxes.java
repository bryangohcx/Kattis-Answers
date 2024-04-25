import java.io.*;
import java.util.PriorityQueue;
import java.util.Comparator;

class DistributingBallotBoxes{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String brLine = br.readLine();
            if (brLine.equals("-1 -1")) break;
            if (brLine.equals("")) continue;
            int cities = Integer.parseInt(brLine.split(" ")[0]);
            int ballotBoxesLeft = Integer.parseInt(brLine.split(" ")[1]);
            PriorityQueue<City> citiesArray = new PriorityQueue<>(new Comparator<City>(){
                @Override
                public int compare(City c1,City c2) {
                    return c1.sizeBox>c2.sizeBox?-1:1;
                }
            });

            for(int i=0;i<cities;i++){
                City tmp = new City(Integer.parseInt(br.readLine()));
                citiesArray.add(tmp);
                ballotBoxesLeft--;
            }
            while(ballotBoxesLeft>0){
                City tmp = citiesArray.poll();
                tmp.addBalotBox();
                tmp.updateSizeBox();
                citiesArray.add(tmp);
                ballotBoxesLeft--;
            }
            int minimaxBoxsize = citiesArray.peek().sizeBox;
            System.out.println(minimaxBoxsize);
        }
        
    }
}
class City{
    int cityPopulation;
    int balotBoxes;
    int sizeBox;
    City(int cityPopulation){
        this.cityPopulation = cityPopulation;
        this.balotBoxes = 1;
        this.sizeBox = cityPopulation;
    }
    void addBalotBox(){
        this.balotBoxes++;
    }
    void updateSizeBox(){
        if(cityPopulation%balotBoxes==0){
            this.sizeBox = cityPopulation / balotBoxes;
        }else{
            this.sizeBox = cityPopulation / balotBoxes + 1;
        }
        

    }
}