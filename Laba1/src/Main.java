import java.util.Scanner;
class Main {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int result;
        do{
            System.out.println("Choose task from 1 to 5(1-5) or 0 to exit:");
            result = sc.nextInt();
            switch(result){
                case 1:{
                    WordBackwards.wordBackwardsMethodInit(sc);
                    break;
                }
                case 2:{
                    secondTask.secondTaskMethodInit(sc);
                    break;
                }
                case 3:{
                    thirdTask.fibonachInit(sc);
                    break;
                }
                case 4:{
                    forthTask.stairsInit(sc);
                    break;
                }
                case 5:{
                    lastTask.powInit(sc);
                    break;
                }
            }
        }while(result!=0);
        sc.close();
    }
    
}