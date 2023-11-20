import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        int result;
        do{
            System.out.println("Choose task from 1 to 9(1-9) or 0 to exit:");
            result = sc.nextInt();
            switch(result){
                case 1:{
                    System.out.println("Type in first node and separate by comas without spaces(exp: 1,0,0,1,0): ");
                    int[] firstNode = input(sc);
                    LinkedContainer<Integer> first = new LinkedContainer<>();
                    for(int i =0; i<firstNode.length;i++){
                        first.addLastNode(firstNode[i]);
                    }

                    System.out.println("Type in second node and separate by comas without spaces(exp: 1,0,0,1,0): ");
                    int[] secondNode = input(sc);
                    LinkedContainer<Integer> second = new LinkedContainer<>();
                    for(int i =0; i<secondNode.length;i++){
                        second.addLastNode(secondNode[i]);
                    }

                    LinkedContainer<Integer> linked = new LinkedContainer<>();
                    linked.addAnoterLinked(first);  
                    linked.addAnoterLinked(second);          
                    linked.sort();
                    System.out.println("United and sorted list: " + linked.result());
                    break;
                }
                case 2:{
                    System.out.println("Type in numbers for linked list and separate by comas without spaces(exp: 1,0,0,1,0): ");
                    int[] Node = input(sc);
                    LinkedContainer<Integer> list = new LinkedContainer<>();
                    for(int i =0; i<Node.length;i++){
                        list.addLastNode(Node[i]);
                    }
                    list.sort();
                    for(int i =0; i<list.size;i++){
                        for(int j=0; j<list.size;j++){
                            if(list.getElementData(i) ==list.getElementData(j)&& i!=j){
                                list.deleteByIndex(j);
                            }
                        }
                    }
                    System.out.println("Sorted and deleted dublicate node: " + list.result());
                    break;
                }
                case 3:{
                   
                    break;
                }
                case 4:{
                    System.out.println("Type in node and separate by comas without spaces(exp: 1,0,0,1,0): ");
                    int[] Node = input(sc);
                    LinkedContainer<Integer> list = new LinkedContainer<>();
                    for(int i =0; i<Node.length;i++){
                        list.addLastNode(Node[i]);
                    }
                    list.reshuffle();
                    System.out.println("Reshuffled list: " + list.result());
                    break;
                }
                case 5:{
                    System.out.println("Type in node and separate by comas without spaces(exp: 1,0,0,1,0): ");
                    int[] Node = input(sc);
                    LinkedContainer<Integer> list = new LinkedContainer<>();
                    for(int i =0; i<Node.length;i++){
                        list.addLastNode(Node[i]);
                    }
                    System.out.println("Type value to delete: ");
                    int res = Integer.parseInt(sc.next());
                    list = deleteNode(list, res);
                    System.out.println("New list: " + list.result());
                    break;
                }
                case 6:{
                    System.out.println("Type in node and separate by comas without spaces(exp: 1,0,0,1,0): ");
                    int[] Node = input(sc);
                    LinkedContainer<Integer> list = new LinkedContainer<>();
                    for(int i =0; i<Node.length;i++){
                        list.addLastNode(Node[i]);
                    }
                    list =doubleValue(list);
                    System.out.println("Doubled value: " + list.result());
                    break;
                }
                case 7:{
                    System.out.println("Type in numbers of nodes you want to add: ");
                    int n = Integer.parseInt(sc.next());
                    int[][] Node = new int[n][];
                    for(int i = 0; i<n;i++){
                        System.out.println("Type in"+ n +"node and separate by comas without spaces(exp: 1,0,0,1,0): ");
                        int[] temp = input(sc);
                        Node[i] = temp;
                    }
                    LinkedContainer<Integer> list = new LinkedContainer<>();
                    for(int i =0;i<Node.length;i++){
                        for(int j = 0; j<Node[i].length;j++){
                            list.addLastNode(Node[i][j]);
                        }
                    }
                    list.sort();
                    System.out.println("Added and sorted: " + list.result());
                    break;
                }
                case 8:{
                    System.out.println("Type in node and separate by comas without spaces(exp: 1,0,0,1,0): ");
                    int[] Node = input(sc);
                    LinkedContainer<Integer> list = new LinkedContainer<>();
                    for(int i =0;i<Node.length;i++){
                        list.addLastNode(Node[i]);
                    }
                    System.out.println("Type in Key: ");
                    list.shuffleWithKey(Integer.parseInt(sc.next()));
                    System.out.println("Shuffled: " + list.result());
                    break;
                }
                case 9:{
                    System.out.println("Type in node and separate by comas without spaces(exp: 1,0,0,1,0): ");
                    int[] Node = input(sc);
                    LinkedContainer<Integer> list = new LinkedContainer<>();
                    for(int i =0;i<Node.length;i++){
                        list.addLastNode(Node[i]);
                    }
                    System.out.println("Type in Key: ");
                    list.sortWithKey(Integer.parseInt(sc.next()));
                    System.out.println("Sorted with key: " + list.result());
                    break;
                }
            }
        }while(result!=0);
        sc.close();
    }
    static int[] input(Scanner sc){
        String in = sc.next();
        String[] inSepar = in.split(",",-1);
        int[] binary = new int[inSepar.length];
        int index = 0;
        for(int i = 0;i < inSepar.length;i++)
        {
            try
            {
                binary[index] = Integer.parseInt(inSepar[i]);
                index++;
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("Bad input, deleted from line");
            }
        }
        return binary = Arrays.copyOf(binary, index);
    }
    static LinkedContainer<Integer> deleteNode(LinkedContainer<Integer> list, int value){
        int id= 0;
        for(int i =0; i<list.size;i++){
            if((int)list.getElementData(i)==value){
                id=i;
                break;
            }
        }
        list.deleteByIndex(id);
        return list;
    }
    static LinkedContainer<Integer> doubleValue(LinkedContainer<Integer> list){
        LinkedContainer<Integer> updatedList = new LinkedContainer<>();
        int number = 0;
        for(int i =0 ; i<list.size;i++){
            number += list.getElementData(i)* Math.pow(10,list.size-i-1);
        }
        number = number * 2;
        while (number > 0){
            updatedList.addFirstNode(number%10);
            number = number/10;
        } 
        return updatedList;
    }
}
