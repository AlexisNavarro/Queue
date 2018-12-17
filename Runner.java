//Author: Alexis Navarro
//Lab 9
//Last modification: 11/27/18

//PURPOSE OF THE PROGRAM: Is to understand how to use Queues and the ways to modify them.
// I had to modify the enqueue method in order to double the size of the queue if its filled while still keeping the original data.
// Then I had to understand how to print a queue while still not changing my queue.
// Afterwards, I had to create a reverse method that reverses the queue while still keeping the original information and having my queue reversed until it gets reversed again.
// To end, I had to create a method that is able to compare each number in the stack in order to find out which one is the largest. 
public class Runner{

//METHOD THAT PRINTS THE QUEUE
    public static void printQueue(Queue q){
        int s = q.size();

        for(int i = 0; i<s; i++){
            int temp = (int)q.dequeue();
            q.enqueue(temp);
            System.out.print(temp+" ");
        }
   }//END PRINT QUEUE


//METHOD TO FIND THE MAX NUMBER INSIDE THE QUEUE
   public static void findMaxInQueue(Queue q){
       int s = q.size();
       int max = 0;

       for(int i = 0; i < s; i++){
           int temp = (int)q.dequeue();
           if(temp > max){
               max = temp;
           }            
           q.enqueue(temp);
           //System.out.print(temp+" "); confirming if my queue was restored to how it was 
       }
       System.out.println(max); 
   }//END FIND MAX IN QUEUE


//METHOD TO REVERSE THE QUEUE
   public static void reverseQueue(Queue q){
        int s = q.size(); 
        Object[] items = new Object[s];

        for(int i = 0; i < s; i++){
            int temp = (int) q.dequeue();
            items[s-i-1] = temp;
        }

        for(int j = 0; j < items.length; j++){
            q.enqueue(items[j]);
        }
       
   }//END REVERSE QUEUE

    public static void main(String[] args){
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        System.out.println("\nMy queue is as follows:");
        printQueue(q);

        System.out.println("\n\nIm going to dequeue one element");
        System.out.println("My queue is as follows:");
        q.dequeue();
        printQueue(q);

        System.out.println("\n\nMy reversed queue is as follows:");
        reverseQueue(q);
        printQueue(q);

        System.out.println("\n\nIm going to enqueue 60");
        System.out.println("My queue is as follows:");
        q.enqueue(60);
        printQueue(q);

        System.out.println("\n\nIm going to enqueue 70");
        q.enqueue(70);
        System.out.println("My queue is as follows:");
        printQueue(q);

        System.out.println("\n\nMy reversed queue is as follows:");
        reverseQueue(q);
        printQueue(q);

        System.out.println("\n\nThe max of my Queue is: ");
        findMaxInQueue(q);

        System.out.println("\nMy queue is as follows:");
        printQueue(q);
       
    }//END MAIN


 
}//END CLASS 