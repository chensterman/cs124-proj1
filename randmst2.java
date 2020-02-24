import java.util.*;

public class randmst2 {
  public static MinHeap randomize(MinHeap minHeap, int numpoints, boolean[] traversed) {
    Random rand = new Random(); //instance of random class
    for(int i = 0; i < numpoints; i++) {
      if(!traversed[i]) {
        // double r = rand.nextDouble();
        double r = (rand.nextInt(10));
        System.out.println("window: " + i+ "testing boys" + r);
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
    minHeap.print();

    for(int i=0; i<traversed.length; i++) {
      System.out.print(traversed[i]);
    }
    while (minHeap.size!=0) {
      for(int i=0; i<traversed.length; i++) {
        System.out.print(traversed[i]);
      }
      System.out.println("WHILE");

      Node min = minHeap.extract_min();
      System.out.println("POP"+min.index + ": " + min.weight);
      if(!traversed[min.index]) {
        System.out.println("HI");
        traversed[min.index] = true;
        total += min.weight;
        System.out.println("Total: "+total);
        minHeap = randomize(minHeap, numpoints, traversed);
        minHeap.print();

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