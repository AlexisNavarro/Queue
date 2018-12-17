public class Queue{
    private int QUEUE_SIZE = 5;
    private Object[] items;
    private int front, back, count;


    public Queue() {
        items = new Object[QUEUE_SIZE];
        front = 0;
        back = QUEUE_SIZE -1;
        count =0;
    }//END QUEUE


    public boolean isEmpty(){
        return count ==0;
    }//END IS EMPTY


    public boolean isFull(){
        return count == QUEUE_SIZE;
    }//END IS FULL


    public void enqueue(Object newItem){
        if (!isFull()){
            back = (back+1) % QUEUE_SIZE;
            items[back] = newItem;
            count++;
            return;
        }else{
//IMPROVED THE ENQUEUE TO DOUBLE THE QUEUE IF ITS FILLED AND STILL HAVE THE SAME DATA OF THE ORIGINAL STACK WITHOUT LOSING THE ORIGINAL STACK
            System.out.println("Queue is full. Doubling the size,");
            QUEUE_SIZE= QUEUE_SIZE * 2;
            Object[] stack2 = new Object[QUEUE_SIZE];
            
            int frontTemp = front;
            for(int i = 0; i < items.length; i++){
                stack2[i] = items[frontTemp];
                frontTemp = (frontTemp+1)%items.length;
            }
            items=stack2;
            front = 0;
            back = count-1;
            enqueue(newItem);
        }
    }//END ENQUEUE

    public Object dequeue(){
        if (!isEmpty()){
            Object queueFront = items[front];
            front = (front+1) % QUEUE_SIZE;
            count--;
            return queueFront;
        }else{
            System.out.println("Trying to dequeue from empty queue");
            return null;
        }
    }//END DEQUEUE


    public void dequeueAll(){
        items = new Object[QUEUE_SIZE];
        front = 0;
        back = QUEUE_SIZE -1;
        count =0;
    }//END DEQUEUE ALL


    public Object peek(){
        if (!isEmpty()) {
            return items[front];
        }else{
            System.out.println("Trying to peek with empty queue");
        }
        return null;
    }//END PEEK

    public int size(){
        return count;
    }//END SIZE

   
}//END QUEUE