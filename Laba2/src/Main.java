import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        int result;
        do{
            System.out.println("Choose task from 1 to 10(1-10) or 0 to exit:");
            result = sc.nextInt();
            switch(result){
                case 1:{
                    System.out.println("Type in binary line and separate by comas without spaces(exp: 1,0,0,1,0): ");
                    System.out.println("Max consecutive number of 1 = " +binaryRepeat(input(sc)));
                    break;
                }
                case 2:{
                    System.out.println("Type in even numbers and separate by comas without spaces(exp: 1,231,43242,544,123): ");
                    System.out.println("Number of even numbers is: " + evenNumber(input(sc)));
                    break;
                }
                case 3:{
                    System.out.println("Type in numbers and separate by comas without spaces(exp: 1,231,43242,544,123): ");
                    System.out.println("Numbers squared and sorted: " + Arrays.toString(squareSort(input(sc))));
                    break;
                }
                case 4:{
                    System.out.println("Type in numbers and separate by comas without spaces(exp: 1,231,43242,544,123): ");
                    System.out.println("Numbers doubled after null: " + Arrays.toString(doublenull(input(sc))));
                    break;
                }
                case 5:{
                    System.out.println("Type in numbers for 1st array and separate by comas without spaces(exp: 1,231,43242,544,123): ");
                    int[] nums1 = input(sc);
                    System.out.println("Type in numbers for 2st array and separate by comas without spaces(exp: 1,231,43242,544,123): ");
                    int[] nums2 = input(sc);
                    System.out.println("Sorted and added array: " + Arrays.toString(addArraySort(nums1, nums2)));
                    break;
                }
                case 6:{
                    System.out.println("Type in numbers and separate by comas without spaces(exp: 1,231,43242,544,123): ");
                    System.out.println("The array: " + Arrays.toString(uniqueArray(input(sc))) + "Unique numbers: " + k);
                    break;
                }
                case 7:{
                    System.out.println("Type in numbers and separate by comas without spaces(exp: 1,231,43242,544,123): ");
                    System.out.println("Is duplicate number: " + duplicate(input(sc)));
                    break;
                }
                case 8:{
                    System.out.println("Type in numbers and separate by comas without spaces(exp: 1,231,43242,544,123): ");
                    System.out.println("Is mining number: " + miningNumber(input(sc)));
                    break;
                }
                case 9:{
                    System.out.println("Type in numbers and separate by comas without spaces(exp: 1,231,43242,544,123): ");
                    System.out.println("Bigger array: " + Arrays.toString(biggerRight(input(sc))));
                    break;
                }
                case 10:{
                    System.out.println("Type in numbers and separate by comas without spaces(exp: 1,231,43242,544,123): ");
                    System.out.println("Array by even: " + Arrays.toString(evenArray(input(sc))));
                    break;
                }
            }
        }while(result!=0);
        sc.close();
    }
    static int k = 0;
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
    static int binaryRepeat(int[] binary){
        int max_count = 0,count = 0;
        for(int i = 0; i<binary.length;i++){
            if(binary[i] == 1){
                count++;
            }
            else if(binary[i] != 0){
                System.out.println("Bad input, only 1 and 0, restart");
                return (Integer) null;
            }
            else{
                max_count = count;
                count = 0;
            }
        }
        if(count>max_count){
            max_count = count;
        }
        return max_count;
        
    }
    static int evenNumber(int[] evenNumbers){
        int count = 0;
        for(int i = 0;i<evenNumbers.length;i++){
            int forcount=0;
            while (evenNumbers[i] > 0)  
            { 
                evenNumbers[i] =evenNumbers[i] / 10; 
                forcount++;
            } 
            if(forcount%2==0){
                count++;
            }
        }
        return count;
    }
    static int[] squareSort(int[] numbers){
        int[] square = new int[numbers.length];
        for(int i =0;i<numbers.length;i++){
            square[i] = numbers[i]* numbers[i];
        }
        
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < square.length - 1; i++) {
            swapped = false;
            for (j = 0; j < square.length - i - 1; j++) {
                if (square[j] > square[j + 1]) {
                    temp = square[j];
                    square[j] = square[j + 1];
                    square[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
        
        return square;
    }
    static int[] doublenull(int[] numbers){
        int[] result = new int[numbers.length];
        int shift =0;
        for(int i = 0; i<numbers.length;i++){
            if(numbers[i-shift]==0){
                result[i] = 0;
                if(i != numbers.length-1){
                    result[i+1] = 0;
                    i++;
                    shift++;
                }
            }
            else{
                result[i] = numbers[i-shift];
            }
        }
        return result;

    }
    static int[] addArraySort(int[] nums1, int[]nums2){
        int[] result = new int[nums1.length+nums2.length];
        int f = 0,s =0;
        for(int i = 0; i<result.length;i++){
            if(f<nums1.length){
                result[i] = nums1[f];
                f++;
            }
            else{
                result[i] = nums2[s];
                s++;
            }}
        int temp;
        boolean swapped;
        for (int i = 0; i < result.length - 1; i++) {
            swapped = false;
                for (int j = 0; j < result.length - i - 1; j++) {
                    if (result[j] > result[j + 1]) {
                        temp = result[j];
                        result[j] = result[j + 1];
                        result[j + 1] = temp;
                        swapped = true;
                        }
                    }
                    if (swapped == false)
                        break;
        }
        return result;
    }
    static int[] uniqueArray(int[] numb){
        k=0;
        int temp;
        boolean swapped;
        boolean contains =false;
        int[] result = new int[numb.length];
        for(int i = 0;i<numb.length;i++){
            if(contains!=true){
                result[i-k] = numb[i];
            }
            else{
                contains=false;
            }
            if(i != numb.length-1){
                for (int j = 0;j<numb.length;j++){
                    if(result[j]==numb[i+1]){
                        contains = true;
                        k++;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < result.length - 1; i++) {
            swapped = false;
            if(k < i){
                for (int j = 0; j < result.length - i - 1; j++) {
                    if (result[j] > result[j + 1]) {
                        temp = result[j];
                        result[j] = result[j + 1];
                        result[j + 1] = temp;
                        swapped = true;
                        }
                    }
                    if (swapped == false)
                        break;
            }
        }
        return result;
    }
    static boolean duplicate(int[] numb){
        for(int i =0;i<numb.length;i++){
            for (int j = 0;j<numb.length;j++){
                    if(numb[i]==numb[j]&&i!=j){
                        return true;
                    }
                }
        }
        for(int i =0;i<numb.length;i++){
            for (int j = 0;j<numb.length;j++){
                    if(numb[i]==numb[j]*2&&i!=j){
                        return true;
                    }
                }
        }
        return false;
    }
    static boolean miningNumber(int[] numb){
        for(int i =0; i<numb.length;i++){
            if(i!=numb.length-1){
                if(numb[i]==numb[i+1]){   
                    return false;
                }
                else if(numb[i]<numb[i+1]){

                }
                else{

                    for(int j = i; j<numb.length;j++){
                        if(j!=numb.length-1){
                            if(numb[j]==numb[j+1]){   
                                return false;
                            }
                            else if(numb[j]>numb[j+1]){
                                
                            }
                            else{
                                return false;
                            }
                        }
                    }
                    break;
                }
            }
        }
        return true;
    }   
    static int[] biggerRight(int[] numb){
        int[] result = new int[numb.length];
        int position=0, max_number=0,positionlast = 0;
        for(int i =0; i<numb.length; i++){
            if(i==numb.length-1){
                result[i] = -1;
            }
            else{
                for(int j = positionlast;j<numb.length;j++){
                    if(max_number == numb[j]){
                        j++;
                        positionlast++;
                        max_number=0;
                    }
                    else if(max_number<numb[j]){
                        max_number = numb[j];
                        position = j;
                    }
                }
                for(int j=positionlast;j<=position;j++){
                    result[j] = max_number;
                }
                positionlast = position;
            }
        }
        return result;
    }
    static int[] evenArray(int[] numb){
        int[] result = new int[numb.length];
        int position = 0;
        for(int i = 0;i<numb.length;i++){
            if(numb[i]%2==0){
                result[position] = numb[i];
                position++;
            }
        }
        for(int i = 0;i<numb.length;i++){
            if(numb[i]%2!=0){
                result[position] = numb[i];
                position++;
            }
        }
        return result;
    }






}
