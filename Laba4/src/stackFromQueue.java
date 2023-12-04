import java.util.LinkedList;
import java.util.Queue;

public class stackFromQueue<E> {
    private Queue<E> qu1;
    private int size;
    public stackFromQueue(){
        qu1 = new LinkedList<E>();
        size = 0;
    }
    public void push(E x){
        qu1.add(x);
        size++;
    }
    public E pop(){
        Queue<E> temp = new LinkedList<>();
        E data = (E)new Object();
        for(int i =0; i<size;i++){ 
            if(i!=size-1){
                temp.add(qu1.remove());
            }
            else{
                data = qu1.remove();
            }
        }  
        size--;
        qu1.clear();
        for(int i =0; i<size;i++){
            qu1.add(temp.remove());
        }
        return data;
    }
    public E top(){
        Queue<E> temp = new LinkedList<>();
        E data = (E)new Object();
        for(int i =0; i<size;i++){
            if(i==size-1){
                data = qu1.peek();
            } 
            temp.add(qu1.remove());
        }  
        qu1.clear();
        for(int i =0; i<size;i++){
            qu1.add(temp.remove());
        }
        return data;
    }
    public boolean empty(){
        if(size==0){
            return true;
        }
        return false;
    }
    public int getSize(){
        return size;
    }

}
