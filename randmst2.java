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
    
    return total;
  }

  public static void traverse(int numpoints, int numtrials, int dimension) {

  }
  public static void main(String[] arg) 
  { 
      double total = traverse_0(8, 0);
      System.out.println(total);

  
}
}