import java.util.*;

public class randmst3 {
    public static double traverse_0 (int numpoints, int numtrials) {
        double total = 0;
    
        for(int i = 0; i < numtrials; i++){
          
          double[] keyWeight = new double[numpoints];
          for (int k = 1; k < numpoints; k++){
            keyWeight[k] = Double.MAX_VALUE;
          }
    
          keyWeight[0] = -1.0;
      
          int traverseCounter = 1;
          while (true) {
            double min = Double.MAX_VALUE;
            int minIndex = -1;
            
            for(int j = 1; j < numpoints; j++){
              if(keyWeight[j] != -1.0) {
                Random rand = new Random();
                double rn = rand.nextDouble();
                if (keyWeight[j] > rn){
                  keyWeight[j] = rn;
                }
                
                if (keyWeight[j] < min){
                  min = keyWeight[j];
                  minIndex = j;
                }
              }
            }
    
            total += min;
            System.out.println(min);
            keyWeight[minIndex] = -1.0;
    
            traverseCounter++;
            if (traverseCounter == numpoints){
              break;
            }
          }
          System.out.println("Trial " + (i + 1) + ": " + total);
        }
        
        return total / numtrials;
      }
    
    public static void main(String[] arg) 
    { 
          //double averageWeight = traverse_0(1000, 5);
          //System.out.println("Average weight:" + averageWeight);
    
        double averageWeight = traverse_0(262144, 5);
        System.out.println("Average weight:" + averageWeight);
    }
}