import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        int result;
        do{
            System.out.println("Choose task from 1 to 15(1-15) 1-7 is stack and 8-15 is queue or 0 to exit:");
            result = sc.nextInt();
            switch(result){
                case 1:{
                    System.out.println("Type in line and separate by comas without spaces(exp: (,),{,},[,] ): ");
                    stack<Character> st = new stack<Character>();
                    char[] input = inputChar(sc);
                    char[] brackets = {'(',')','[',']','{','}'};
                    for(int i =0; i<input.length;i++){
                        st.push(input[i]);
                    }
                    boolean errors = false;
                    if(st.getSize()%2!=0){
                        System.out.println("False");
                        break;
                    }
                    for(int i = 0; i< st.getSize();i++){
                        Character lastElement = st.top();
                        st.pop();
                        boolean hasBracket = false;
                        int bracketN = 0;
                        for(int j = 1; j<brackets.length;j=j+2){
                            if(lastElement == brackets[j]){
                                hasBracket = true;
                                bracketN = j; 
                                break;
                            }
                        }
                        Character prevLastElement = st.top(); 
                        st.pop();
                        if(!hasBracket||prevLastElement!=brackets[bracketN-1]){
                            System.out.println("False");
                            errors = true;
                            break;
                        }
                    }
                    if(!errors){
                    System.out.println("True");
                    }
                    break;
                }
                case 2:{
                    System.out.println("Type in line and separate by comas without spaces(exp: 1,2,3,4,5,6 ): ");
                    BinaryTree tree = new BinaryTree();
                    Integer[] input = inputInt(sc);
                    for(int i=0;i<input.length;i++){
                        tree.addValue(input[i], tree.root);
                    }
                    tree.printInorder(tree.root);
                    System.out.println();
                    break;
                }
                case 3:{
                    //System.out.println("Type in line and separate by comas without spaces(exp: 1,2,3,4,5 ");
                    stack<Integer> st = new stack<Integer>();
                    st.push(-2);
                    st.push(0);
                    st.push(-3);
                    System.out.println(st.getMin().toString() + " ");
                    st.pop();
                    System.out.println(st.top().toString() + " "); 
                    System.out.println(st.getMin());
                    break;
                }
                case 4:{
                    //ystem.out.println("Type in line and separate by comas without spaces(exp: (,),{,},[,] ): ");
                    queueFromStack qu = new queueFromStack();
                    qu.push(1);
                    qu.push(2);
                    System.out.println(qu.peek().toString()+" "+qu.pop().toString()+" "+qu.empty());
                    break;
                }
                case 5:{
                    System.out.println("Type in line without spaces(exp: 3[a]2[bc] ): ");
                    String in = sc.next();
                    stack<Integer> number = new stack<>();
                    stack<String> stackStr = new stack<>();
                    int num = 0;
                    String str = new String();
                    for(char ch : in.toCharArray()) {
                        if(ch >= '0' && ch <= '9') { // num = the number
                            num = (num * 10) + ch - '0';
                        } 
                        else if(ch == '[') { // 
                            stackStr.push(str);
                            str = new String();
                            number.push(num);
                            num = 0;
                        } 
                        else if(ch == ']') {
                            String temp = str;
                            str = stackStr.popRet();
                            int count = number.popRet();

                            while(count-- > 0) {
                                str+=temp;
                            }
                        } else {
                            str+=ch;
                        }
                    }
                    System.out.println("New String = "+ str);
                    break;
                }
                case 6:{
                    System.out.println("Type in line and separate by comas without spaces(exp: 2,3,+,4,-,7,* ): ");
                    String input = sc.next();
                    String[] inputSepar = input.split(",",-1);
                    stack<Integer> st = new stack<>();
                    for(String val: inputSepar){
                        if (val.equals("+")) {
                            int n1 = st.popRet();  
                            int n2 = st.popRet();  
                            int res = n2 + n1;  
                            st.push(res);       
                        } else if (val.equals("-")) {
                            int n1 = st.popRet();  
                            int n2 = st.popRet();  
                            int res = n2 - n1;   
                            st.push(res);       
                        } else if (val.equals("*")) {
                            int n1 = st.popRet();  
                            int n2 = st.popRet();  
                            int res = n2 * n1;   
                            st.push(res);       
                        } else if (val.equals("/")) {
                            int n1 = st.popRet();  
                            int n2 = st.popRet();  
                            int res = n2 / n1;  
                            st.push(res);       
                        } else {
                            st.push(Integer.parseInt(val)); 
                        }
                    }
                    System.out.println("The number: " + st.popRet());
                    break;
                }
                case 7:{
                    System.out.println("Type in line without spaces(exp: ()(()())())() ): ");
                    String input = sc.next();
                    char[] bracket = input.toCharArray();
                    int res = 0;
                    for(int i =0;i<bracket.length;i++){
                        if(bracket[i] == '('){
                            if(bracket[i+1] == ')'){
                                res+=2;
                                i++;
                            }
                            else{
                                res = 0;

                            }
                        }
                    }
                    System.out.println("Result : " + res);
                    break;
                }
                case 8:{
                    System.out.println("Type in line: ");
                    char[] in = sc.next().toCharArray();
                    int i;
                    boolean has = false;
                    for(i = 0;i<in.length;i++){
                        has=false;
                        for(int j = 0;j<in.length;j++){
                            if(in[i]==in[j]&&i!=j){
                                has = true;
                                break;
                            }
                        }
                        if(!has){
                            break;
                        }

                    }
                    if(i == in.length&&has==true){
                        i=-1;
                    }
                    System.out.println("Number: " + i);
                    break;
                }
                case 9:{
                    stackFromQueue<Integer> stqu = new stackFromQueue<>();
                    stqu.push(1);
                    stqu.push(2);
                    System.out.println(stqu.top());
                    System.out.println(stqu.pop());
                    System.out.println(stqu.empty());
                    break;
                }
                case 10:{
                    //System.out.println("Type in line: ");
                    recentCounter c = new recentCounter();
                    System.out.println(c.ping(1));
                    System.out.println(c.ping(100));
                    System.out.println(c.ping(3001));
                    System.out.println(c.ping(3002));
                    break;
                }
                case 11:{
                    deque de = new deque(3);
                    de.insertLast(1);
                    de.insertLast(2);
                    de.insertFront(3);
                    de.insertFront(4);
                    System.out.println(de.getRear());
                    System.out.println(de.isFull());
                    de.deleteLast();
                    de.insertFront(4);
                    System.out.println(de.getFront());
                    break;
                }
                case 12:{
                    circularQueue de = new circularQueue(3);
                    de.enQueue(1);
                    de.enQueue(2);
                    de.enQueue(3);
                    de.enQueue(4);
                    System.out.println(de.Rear());
                    System.out.println(de.isFull());
                    de.deQueue();
                    de.enQueue(4);
                    System.out.println(de.Rear());
                    break;
                }
                case 13:{
                    int[] res = stam(sc);
                    for(int i =0;i<res.length;i++){
                        System.out.print(res[i] + " ");
                    }
                    break;
                }
                case 14:{
                    System.out.println("Type in line and separate by comas without spaces(exp: 1,5,2,3,4,5,6 ): ");
                    int[] line = inputint(sc);
                    System.out.println("Type in k: ");
                    int k = Integer.parseInt(sc.next());
                    int[] res = new int[line.length-(k-1)];
                    int pos = 0;
                    for(int i = 0;i<res.length;i++){
                        for(int j = pos;j<pos + k;j++){
                            if(line[j]>res[i]){
                                res[i] = line[j];
                            }
                        }
                        pos++;
                    }
                    for(int i = 0; i<res.length;i++){
                        System.out.print(res[i]+ " ");
                    }
                    System.out.println();
                    break;
                }
                case 15:{
                    System.out.println("Type in line: ");
                    int[] input = inputint(sc);
                    System.out.println("Type in k: ");
                    int k = Integer.parseInt(sc.next());
                    System.out.println(substring(input,k));
                    break;
                }
            }
        }while(result!=0);
        sc.close();
    }
    static int substring(int[] input, int k) {
        Deque<int[]> qu = new LinkedList<>();
        int res = -10000;
        for (int i = 0; i < input.length; i++) {
            int num = input[i];
            int total = 0;
            if(!qu.isEmpty()){
                total = num +qu.getFirst()[1];
            }
            else{
                total = num + 0;
            }
            res = Math.max(res, total);
            while (!qu.isEmpty() && total >= qu.getLast()[1]) {
                qu.removeLast();
            }

            if (total > 0) {
                qu.addLast(new int[]{i, total});
            }

            if (!qu.isEmpty() && qu.getFirst()[0] == i - k) {
                qu.removeFirst();
            }
        }

        return res;        
    }
    static boolean canReplace(char[] target, int j, char[] stamp)
    {
        for(int i=0;i<stamp.length;i++)
        {
            if(target[i+j] != '*' && target[i+j] != stamp[i]) {
                return false;
            }
        }
        return true;
    }
    static int replace(char[] target, int j, int length, int stars)
    {
        for(int i=0;i<length;i++)
        {
            if(target[i+j] != '*')
            {
                target[i+j] = '*';
                stars++;
            }
        }
        return stars;
    }
     static int[] inputint(Scanner sc){
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
    static int[] stam(Scanner sc){
        System.out.println("Type in stamp: ");
        char[] stamp = sc.next().toCharArray();
        System.out.println("Type in target: ");
        char[] target = sc.next().toCharArray();
        int stars = 0;
        boolean[] visited = new boolean[target.length];
        Stack<Integer> result = new Stack<>();
        while(stars < target.length)
        {
            boolean replaced = false;
            for(int i =0;i<=target.length-stamp.length;i++)
            {
                if(!visited[i] && canReplace(target,i,stamp))
                {
                    stars = replace(target,i,stamp.length,stars);
                    replaced = true;
                    visited[i] = true;
                    result.add(i);
                    if(stars == target.length)
                    {
                        break;
                    }
                }
                
            }
            if(!replaced){
                return new int[0];
            }
        }
        int anw[] = new int[result.size()];
        int temp = result.size();
        for(int i=0;i<temp;i++)
            {
                anw[i] = result.pop();
            }
        return anw;
    }
    static char[] inputChar(Scanner sc){
        String in = sc.next();
        String[] inSepar = in.split(",",-1);
        char[] binary = new char[inSepar.length];
        int index = 0;
        for(String val : inSepar)
        {
            try
            {
                binary[index] = val.charAt(0);
                index++;
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("Bad input, deleted from line");
            }
        }
        return binary = Arrays.copyOf(binary, index);
    }
    static Integer[] inputInt(Scanner sc){
        String in = sc.next();
        String[] inSepar = in.split(",",-1);
        Integer[] binary = new Integer[inSepar.length];
        int index = 0;
        for(int i = 0;i < inSepar.length;i++)
        {
            try
            {
                if(inSepar[i].equals("null")){
                    binary[index] = null;
                    index++;
                }
                else{
                    binary[index] = Integer.parseInt(inSepar[i]);
                    index++;    
                }
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("Bad input, deleted from line");
            }
        }
        return binary = Arrays.copyOf(binary, index);
    }
    static class Node {
        Integer key;
        Node left, right;
        boolean end;
        public Node(Integer item)
        {
            end = false;
            key = item;
            left = right = null;
        }
    }
    static class BinaryTree {
        Node root;
        public BinaryTree() { 
            root = null; 
        }
        void addValue(Integer key,Node add){
            if(root == null){
                root = new Node(key);
            }
            else if(add.left == null){
                add.left = new Node(key);
            }
            else if(add.right == null){
                add.right = new Node(key);
            }
            else if(add.left.end){
                addValue(key, add.right);
            }
            else if(add.left.key==null){
                if(add.right.key==null){
                    add.end=true;
                    addValue(key, root);
                }
                else{
                addValue(key, add.right);
                }
            }
            else{
                addValue(key, add.left);
            }
        }
        void printInorder(Node node)
        {
            if (node == null)
                return;
            printInorder(node.left);
            if(node.key != null){
                System.out.print(node.key + " ");
            }
            printInorder(node.right);
        }
    }
}
