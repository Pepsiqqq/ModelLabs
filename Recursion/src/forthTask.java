import java.util.Scanner;

public class forthTask {
    static int stairs(int target){
        if(target <= 1){
            return 1;   
        }
        return stairs(target - 1) + stairs(target - 2);
    }
    static void stairsInit(Scanner sc){
        System.out.println("Number of stairs: ");
        String target = sc.next();
        System.out.println(stairs(Integer.parseInt(target)));
    }
}
