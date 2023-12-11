class LinkedContainer<E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
    int size = 0;
    
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
    public void addFirstNode(E data){
        Node<E> newNode = firstNode;
        newNode.setData(data);
        firstNode = new Node(null, newNode, null);
        newNode.setPreviousNode(firstNode);
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
    public void swapTwoPostitons(int first,int second){
        if(first == second){
            System.out.println("What?");
            return;
        }
        Node<E> temp = new Node(null, getElementFromIndex(first).getNextElement(),getElementFromIndex(first).getPreviousElement());
        Node<E> tempSecond = new Node(null, getElementFromIndex(second).getNextElement(),getElementFromIndex(second).getPreviousElement());

        if(first+1==second){
            getElementFromIndex(first).getPreviousElement().setNextNode(getElementFromIndex(second));
            getElementFromIndex(first).setNextNode(temp.getNextElement().getPreviousElement());
            getElementFromIndex(second).setNextNode(tempSecond.getNextElement());
        }
        else{
            getElementFromIndex(second).getPreviousElement().setNextNode(getElementFromIndex(first));
            getElementFromIndex(first).getPreviousElement().setNextNode(tempSecond.getNextElement().getPreviousElement());
            tempSecond.getNextElement().getPreviousElement().setNextNode(temp.getNextElement());
            getElementFromIndex(second).setNextNode(tempSecond.getNextElement());
        }
        if(first>=1){
            getElementFromIndex(first).setPreviousNode(getElementFromIndex(first-1));
        }
        else{
            getElementFromIndex(first).setPreviousNode(firstNode);
        }
        getElementFromIndex(first+1).setPreviousNode(getElementFromIndex(first));
        if(second!=size-1){
            getElementFromIndex(second+1).setPreviousNode(getElementFromIndex(second));
        }
        else{
            lastNode.setPreviousNode(getElementFromIndex(second));
        }
        getElementFromIndex(second).setPreviousNode(getElementFromIndex(second-1));
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
    public void sort(){
        try 
		{ 
			for(int i=0; i < size-1; i++){  
                for(int j=1; j < (size-1)-i; j++){  
                     if((int)getElementData(j-1) > (int)getElementData(j)){  
                            swapTwoPostitons(j-1, j);
                    }  
                }
            }
		}  
		catch (NumberFormatException e)  
		{ 
			System.out.println("Not a integer"); 
            return;
		}
    }
    public void addAnoterLinked(LinkedContainer<E> add){
        for(int i =0; i<add.size;i++){
            addLastNode(add.getElementData(i));
        }
    }
    public void deleteByIndex(int index){
        if(index == 0){
            firstNode.setNextNode(getElementFromIndex(index+1));
            getElementFromIndex(index+1).setPreviousNode(firstNode);
        }
        else if(index==size-1){
            lastNode.setPreviousNode(getElementFromIndex(index-1));
            getElementFromIndex(index-1).setNextNode(lastNode);
        }
        else{
            getElementFromIndex(index-1).setNextNode(getElementFromIndex(index+1));
            getElementFromIndex(index+1).setPreviousNode(getElementFromIndex(index-1));
        }
        size--;
    }
    public void reshuffle(){
        int even = 1;
        for(int j = 0; j<size/2;j++){
            for(int i = size-1; i>even;i--){
                swapTwoPostitons(i-1, i);
            }
            even = even+2;
        }
    }
    public void shuffleWithKey(int key){
        int temp = 0;
        key=key-1;
        int timesReshuffled = 0;
        for(int k =0;k<size/key;k++){
            if(key+timesReshuffled+1 >=size){
                temp = size - (key+timesReshuffled+1);
            }
            for(int i =0; i<key+temp;i++){
                for(int j =0;j<key-i+temp;j++){
                    swapTwoPostitons(key-j+timesReshuffled-1+temp ,key-j+timesReshuffled+temp);
                }
                
            }
            timesReshuffled+=key+1;
        }
    }
    public void sortWithKey(int key){
        int rear=0;
        for(int i =0; i<size;i++){
            if(key > (int)getElementData(i)){
                if(i!=0){
                    while(true){
                        if((int)getElementData(i+rear)<(int)getElementData(i-1+rear)){
                            swapTwoPostitons(i-1+rear, i+rear);
                            rear--;
                        }
                        else{
                            rear=0;
                            break;
                        }
                    }   
                }
            }

        }
    }
}