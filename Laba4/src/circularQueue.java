public class circularQueue {
    int qu[];
    int front,rear;
    int maxSize;
    int size;
    public circularQueue(int maxSize){
        this.maxSize = maxSize;
        qu = new int[maxSize];
        this.size = 0;
        front= rear= -1;
    }
    int Front(){
        if(front == -1){
            return -1;
        }
        return qu[front];
    }
    int Rear(){
        if(front == -1){
            return -1;
        }
        return qu[rear];
    }
    boolean enQueue(int val){
        if((front == 0 && rear == maxSize - 1) || (rear == (front - 1) % (maxSize - 1)))
        {
        System.out.println("Queue is Full");
        }
        else if(front == -1)
        {
            front = 0;
            rear = 0;
            qu[rear] = val;
        }
        else if(rear == maxSize - 1 && front != 0)
        {
            rear = 0;
            qu[rear] = val;
        }
        else
        {
            rear += 1;
            qu[rear] = val;

        }
        return true;
    }
    public boolean deQueue(){
        if(front == -1)
        {
            System.out.print("Empty");
            return false; 
        }
        if(front == rear)
        {
            front = -1;
            rear = -1;
        }
        else if(front == maxSize - 1)
        {
            front = 0;
        }
        else
        {
            front = front + 1;
        }
        return true;
    }
    boolean isEmpty(){
        if(front == -1){
            return true;
        }
        return false;
    }
    boolean isFull(){
         if((front == 0 && rear == maxSize - 1) || (rear == (front - 1) % (maxSize - 1))){
            return true;
        }
        return false;
    }
}
