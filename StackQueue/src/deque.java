public class deque{
    int qu[];
    int maxSize;
    int size;
    public deque(int maxSize){
        this.maxSize = maxSize;
        qu = new int[maxSize];
        this.size = 0;
    }
    boolean insertFront(int val){
        if(size == maxSize){
            System.out.println("Full");
            return false;
        }
        int[] temp = qu;
        qu = new int[maxSize];
        qu[0] = val;
        for(int i = 1;i<size+1;i++){
            qu[i] = temp[i-1];
        }
        /*Queue<Integer> temp = new LinkedList<>();
        for(int i =0; i<size;i++){ 
            temp.add(qu.remove());
        }  
        qu.clear();
        qu.add(val);
        for(int i =0; i<size;i++){
            qu.add(temp.remove());
        }
        */
        size++;
        return true;
    }
    boolean insertLast(int val){
        if(size == maxSize){
            System.out.println("Full");
            return false;
        }
        int[] temp = qu;
        qu = new int[maxSize];
        qu[size] = val;
        for(int i = 0;i<size;i++){
            qu[i] = temp[i];
        }
        size++;
        return true;
    }
    
    boolean deleteFront() {
        if(size>0){
            int[] temp = qu;
            qu = new int[maxSize];
            for(int i = 0;i<size-1;i++){
                qu[i] = temp[i+1];
            }
            size--;
            return true;
        }
        System.out.println("Empty");
        return false;
    }
    
    boolean deleteLast() {
        if(size>0){
            int[] temp = qu;
            qu = new int[maxSize];
            for(int i = 0;i<size-1;i++){
                qu[i] = temp[i];
            }
            size--;
            return true;
        }
        System.out.println("Empty");
        return false;
    }
    int getFront(){
        if(size == 0){
            return -1;
        }
        return qu[0];
    }
    int getRear(){
        if(size == 0){
            return -1;
        }
        return qu[size-1];
    }
    boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }
    boolean isFull(){
        if(size==maxSize){
            return true;
        }
        return false;
    }
}