public class stack<E> {
    private E[] data;
    private int size;

    public stack() {
        this.size = 0;
    }
    public void push(E d){
        E[] oldStack = data;
        data = (E[])new Object[size+1];
        for(int i = 0; i<size;i++){
            data[i] = oldStack[i];
        }
        data[size] = d;
        size++;
    }
    public E popRet(){
        E[] oldStack = data;
        data = (E[])new Object[size-1];
        for(int i = 0; i<size-1;i++){
            data[i] = oldStack[i];
        }
        size--;
        return oldStack[size];
    }
    public void pop(){
        E[] oldStack = data;
        data = (E[])new Object[size-1];
        for(int i = 0; i<size-1;i++){
            data[i] = oldStack[i];
        }
        size--;
        //return oldStack[size];
    }
    public E top(){
        return data[size-1];
    }
    public int getSize(){
        return size;
    }
    public Integer getMin(){
        Integer temp = 0;
        for(int i =0; i<size;i++){
            if((Integer)data[i]<temp){
                temp = (Integer)data[i];
            }
        }
        return temp;
    }
    public void clear(){
        data = (E[])new Object[0];
        size = 0;
    }
}
