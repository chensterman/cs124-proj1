public class randmst2 {
  public static void main(String[] arg) 
  { 
      System.out.println("The Min Heap is "); 
      MinHeap minHeap = new MinHeap(15); 
      minHeap.insert(0,5); 
      minHeap.insert(1, 3); 
      minHeap.insert(2,17); 
      minHeap.insert(2,10); 
      minHeap.insert(2,1); 
      minHeap.insert(2,2); 
      minHeap.insert(2,4); 
      minHeap.insert(2,22); 
      minHeap.insert(8,9); 
      minHeap.minHeap(); 

      minHeap.print(); 
      System.out.println("The Min val is " + minHeap.remove()); 
  } 
}
