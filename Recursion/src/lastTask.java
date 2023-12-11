import java.util.Scanner;

public class lastTask {
    static int power(int num,int exp){
        if(exp <= 1){
            return num;
        }
        return num*power(num,exp-1);
    }
    static void powInit(Scanner sc){
        System.out.println("Number: ");
        String num = sc.next();
        System.out.println("Exponent: ");
        String exp = sc.next();
        System.out.println(power(Integer.parseInt(num),Integer.parseInt(exp)));
    }
}
