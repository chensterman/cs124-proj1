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

  public static MinHeap randomize1(MinHeap minHeap, int numpoints, int dimension, int reference, boolean[] traversed, double[][] points) {
    Random rand = new Random(); //instance of random class
    for(int i = 0; i < numpoints; i++) {
      if(!traversed[i]) {
        for(int j = 0; j < dimension; j++){
          points[i][j] = rand.nextDouble();
        }
        
        double d = 0.0;
        for(int k = 0; k < dimension; k++){
          d += (points[i][k] - points[reference][k]) * (points[i][k] - points[reference][k]);
        }
        d = Math.sqrt(d);
        //System.out.println(d);
        minHeap.insert(i, d);
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
    }
    
    return total / numtrials;
  }

  public static double traverse(int numpoints, int numtrials, int dimension) {
    double total = 0;

    for(int i = 0; i < numtrials; i++){
      boolean[] traversed = new boolean[numpoints];
      double[][] points = new double[numpoints][dimension];
      traversed[0] = true;
      Random rand = new Random();
      for (int j = 0; j < dimension; j++){
        points[0][j] = rand.nextDouble();
      }

      MinHeap minHeap = new MinHeap(); 
      minHeap = randomize1(minHeap, numpoints, dimension, 0, traversed, points);

  
      while (minHeap.size!=0) {


        Node min = minHeap.extract_min();

        if(!traversed[min.index]) {
          traversed[min.index] = true;
          total += min.weight;
          minHeap = randomize1(minHeap, numpoints, dimension, min.index, traversed, points);

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

      double averageWeight = traverse(32768, 5, 3);
      System.out.println("Average weight:" + averageWeight);
}
}