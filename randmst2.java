import java.util.*;

public class randmst2 {
  public static MinHeap randomize(MinHeap minHeap, int numpoints, boolean[] traversed) {
    Random rand = new Random(); //instance of random class
    for(int i = 0; i < numpoints; i++) {
      if(!traversed[i]) {
        double r = rand.nextDouble();
        //not too big if r < NUM
        minHeap.insert(i, r);
      }
    }
    return minHeap;
  }
  public static double traverse_0 (int numpoints, int numtrials) {
    double total = 0;

    for(int i = 0; i < numtrials; i++){
      boolean[] traversed = new boolean[numpoints];
      traversed[0] = true;
      MinHeap minHeap = new MinHeap(); 
      minHeap = randomize(minHeap, numpoints, traversed);

  
      while (minHeap.size!=0) {


        Node min = minHeap.extract_min();

        if(!traversed[min.index]) {
          traversed[min.index] = true;
          total += min.weight;
          minHeap = randomize(minHeap, numpoints, traversed);

        }

      }
      System.out.println(i + ": "+total);
    }
    
    return total / numtrials;
  }

  // public static double traverse(int numpoints, int numtrials, int dimension) {
  //   if(dimension == 0) {
  //     return traverse_0(numpoints, numtrials);
  //   }
  //   else {

  //   }
  // }
  public static void main(String[] arg) 
  { 
      double averageWeight = traverse_0(65536, 5);
      System.out.println("Average weight:" + averageWeight);

  
}
}