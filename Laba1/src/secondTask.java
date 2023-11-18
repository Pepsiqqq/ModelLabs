import java.util.Scanner;

class LinkedContainer<E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;
    
    public LinkedContainer (){
        lastNode = new Node<E>(null, null, null);
        firstNode = new Node<E>(null, lastNode, null);
        lastNode.setPreviousNode(firstNode);
    }
    private class Node<E> { 
        private E data; 
        private Node<E> next;
        private Node<E> previous; 
        private Node(E d, Node<E> next, Node<E> previous){
            this.data = d; 
            this.next = next;
            this.previous = previous;
        }
        void setData(E data){
            this.data = data;
        }
        void setNextNode(Node<E> next){
            this.next = next;
        }
        void setPreviousNode(Node<E> previous){
            this.previous = previous;
        }
        Node<E> getNextElement(){
            return next;
        }
        Node<E> getPreviousElement(){
            return previous;
        }
        E getData(){
            return data;
        }
    } 
    public void addLastNode(E data){
        Node<E> newNode = lastNode;
        newNode.setData(data);
        lastNode = new Node(null, null, newNode);
        newNode.setNextNode(lastNode);
        size++;
    }
    public E getElementData(int index){
        Node<E> target = firstNode.getNextElement();
        for(int i = 0;i<index;i++){
            target = target.getNextElement();
        }
        return target.getData();
    }
    public Node<E> getElementFromIndex(int index){
        Node<E> target = firstNode.getNextElement();
        for(int i = 0;i<index;i++){
            target = target.getNextElement();
        }
        return target;
    }
    public void swap(int currentEl){
        if(size >= 2){
            if(currentEl+2 < size){
                currentEl+=2;
                swap(currentEl);
                currentEl-=2;
            }
            if(currentEl+1 != size){
            lastNode.setPreviousNode(getElementFromIndex(currentEl));
            Node<E> Temp = new Node(null, getElementFromIndex(currentEl).getNextElement(), getElementFromIndex(currentEl).getPreviousElement());
            Node<E> Temp2 = new Node(null, getElementFromIndex(currentEl+1).getNextElement(), getElementFromIndex(currentEl+1).getPreviousElement());
            getElementFromIndex(currentEl).setPreviousNode(getElementFromIndex(currentEl+1));

            getElementFromIndex(currentEl).setNextNode(getElementFromIndex(currentEl+2));
            
            if(currentEl==0){
                firstNode.setNextNode(Temp.getNextElement());
            }
            else{
                Temp.getPreviousElement().setNextNode(Temp.getNextElement());
            }
            getElementFromIndex(currentEl).setPreviousNode(Temp.getPreviousElement());
            getElementFromIndex(currentEl).setNextNode(Temp2.getPreviousElement());
            
            
            }
        }
    }
    public String result(){
        String res = "";
        res += getElementData(0);
        if(size>0){
            for(int i=1;i<size;i++){
                res += ","+ getElementData(i);
            }
        }
        return res;
    }
}

public class secondTask{
    static void secondTaskMethodInit(Scanner sc){
        System.out.println("Type numbers and separate them with comas(1,4,56,34,7):");
        String input = sc.next();
        String[] lis = input.split(",",-1);
        LinkedContainer<String> ll = new LinkedContainer<>();
        for(int i = 0; i<lis.length;i++){
            ll.addLastNode(lis[i]);
        }
        ll.swap(0);
        System.out.println(ll.result());
    }
}