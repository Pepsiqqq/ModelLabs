import java.util.Scanner;

public class thirdTask {
    static int fibonachi(int target){
        int result;
        if(target-2 >= 0){
            result = fibonachi(target-2) + fibonachi(target-1);
        }
        else if(target==1){
            result = 1;
        }
        else{
            result=0;
        }
        return result;
    }
    static void fibonachInit(Scanner sc){
        System.out.println("Type a number: ");
        String target = sc.next();
        System.out.println(fibonachi(Integer.parseInt(target)));
    }
}
