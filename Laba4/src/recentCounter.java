import java.util.LinkedList;
import java.util.Queue;


public class recentCounter {
    Queue<Integer> qu;
    Queue<Integer> temp;
    public recentCounter(){
        qu = new LinkedList<>();
        temp = new LinkedList<>();
    }
    public int ping(int t){
        int result = 0;
        int range = t - 3000;
        qu.add(t);
        int size = qu.size();
        for(int i = 0;i<size;i++ ){
            if(qu.peek()>=range&&qu.peek()<=t){
                result++;
            }
            temp.add(qu.poll());
        }
        qu.clear();
        for(int i = 0;i<size;i++){
            qu.add(temp.poll());
        }
        temp.clear();
        return result;
    }
}
