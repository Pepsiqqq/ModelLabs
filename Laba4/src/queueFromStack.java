public class queueFromStack {
    stack<Integer> st;
    public queueFromStack(){
        st = new stack<Integer>();
    }
    public void push(Integer data){
        st.push(data);
    }
    public Integer pop(){
        stack<Integer> temp = new stack<Integer>();
        Integer result = 0;
        int size = st.getSize();
        for(int i =0; i<size;i++){
            if(i!=st.getSize()-1){
                temp.push(st.top());
            }
            result = st.top();
            st.pop();
        }
        st.clear();
        size = temp.getSize();
        for(int i =0;i<size;i++){
            st.push(temp.top());
            temp.pop();
        }
        return result;
    }
    public Integer peek(){
        stack<Integer> temp = new stack<Integer>();
        Integer result = 0;
        int size = st.getSize();
        for(int i =0; i<size;i++){
            temp.push(st.top());
            result = st.top();
            st.pop();
        }
        st.clear();
        size = temp.getSize();
        for(int i =0;i<size;i++){
            st.push(temp.top());
            temp.pop();
        }
        return result;
    }
    public boolean empty(){
        if(st.getSize()==0){
            return true;
        }
        return false;
    }
}
