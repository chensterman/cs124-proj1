import java.util.*;
import java.lang.*;
import java.io.*;


public class randmst{


    static boolean[] inserted = new boolean[10];
    // Node  
    static class Node {  
        int index;  
    
        // Lower values indicate higher priority  
        int weight;  
    
        Node next;  
    
    } 
  
    static Node node = new Node(); 
    
// Function to Create A New Node  
    static Node newNode(int d, int w)  
    {  
        Node temp = new Node();  
        temp.index = d;  
        temp.weight = w;  
        temp.next = null;  
        inserted[d] = true;

        return temp;  
    }  
    
    // Return the value at head  
    static int peek(Node head)  
    {  
        return (head).weight;  
    }  
        
    // Removes the element with the  
    // highest priority form the list  
    static Node pop(Node head)  
    {  
        System.out.println("hiii"+ head.index);
        Node temp = head;  
        (head)  = (head).next;  

        return head; 
    }    
        
    // Function to push according to priority  
    static Node push(Node head, int d, int w)  
    {  
        if(inserted[d] == true) {
            Node check = head;
            while(check.next != null) {
                if(check.index == d) { 
                    System.out.println("HIIIII");
                    if(w < check.weight) {
                        check.weight = w;
                        System.out.println("HI!!");
                        break;
                    }
                }
                check = check.next;
            }
            System.out.println(check.index + ":" + check.weight);
            return check;
        }

        inserted[d] = true;
        System.out.println(d);

        Node start = (head);  
        
        // Create new Node  
        Node temp = newNode(d, w);  
        
        // Special Case: The head of list has lesser  
        // priority than new node. So insert new  
        // node before head node and change head node.  
        if ((head).weight > w) {  
        
            // Insert New Node before head  
            temp.next = head;  
            (head) = temp;  
        }  
        else {  
        
            // Traverse the list and find a  
            // position to insert new node  
            while (start.next != null &&  
                start.next.weight < w) {  
                start = start.next;  
            }  
        
            // Either at the ends of the list  
            // or at required position  
            temp.next = start.next;  
            start.next = temp;  
        }  

        return head; 
    }  

    // Function to check is list is empty  
    static int isEmpty(Node head)  
    {  
        return ((head) == null)?1:0;  
    }     
    
    
    public static void traverse(int numpoints, int numtrials, int dimension) {
        //generate
        Random rand = new Random(); //instance of random class

        if (dimension == 0) {
            // int num = numpoints * (numpoints - 1) / 2 ;
            // double[] edges = new double[num - 1];
        
            // for (int i = 0; i < num; i++) {
            //     //AHHHHHH (inclusive?)
            //     edges[i]=rand.nextDouble();
            //     System.out.println(i + ":" + edges[i]);
            // }
            
            boolean[] visited = new boolean[numpoints];

            Node pq = newNode(4, 4);  
            pq = push(pq, 5, 3);  
            pq = push(pq, 6, 2);  
            pq = push(pq, 5, 0);  

            while (isEmpty(pq)==0) {  
                System.out.printf("%d ", peek(pq));  
                pq=pop(pq);  
            }  

           
        




        }


        else {
            double[] vertices = new double[numpoints * dimension];

            for (int i = 0; i < vertices.length; i++) {
                //AHHHHHH (inclusive?)
                vertices[i]=rand.nextDouble();
                System.out.println(vertices[i]);
            }
             //traverse
        }
      

       


    }

    
    
    public static void main(String[] args){
        traverse(262144, 1, 0);

    }
}