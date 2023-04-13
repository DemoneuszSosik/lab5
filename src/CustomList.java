import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class CustomList<T> extends AbstractList<T> {
    @Override
    public T get(int i){
        Node thisNode=head;
        for(int k=0;k<i;++k){
            if(thisNode!=null){
                thisNode=thisNode.next;
            }
            else{
                throw new NoSuchElementException();
            }
        }
        return thisNode.value;
    }
    @Override
    public int size(){
        Node thisNode=head;
        int result=0;
        while(thisNode!=null){
            thisNode=thisNode.next;
            result++;
        }
        return result;
    }

    private class Node{
        T value;
        Node next;
        public Node(T value,Node next){
            this.value=value;
            this.next=next;
        }
    }
    private Node head=null;
    private Node tail=null;
    public void addLast(T value){
        Node node = new Node(value, null);
        if(head==null){
            head = node;
        }else if(head==tail){
            head.next=node;
        }else{
            tail.next=node;
        }
        tail=node;
    }
    public T getLast(){
        return tail.value;
    }
    public void addFirst(T value){
        Node node = new Node(value, null);
        if(head==null){
            head=node;
            tail=node;
        }else{
            node.next=head;
            head=node;
        }
    }
    public T getFirst(){
        return head.value;
    }
    public T removeFirst(){
        T first=getFirst();
        if(head==tail){
            head=null;
            tail=null;
        }else{
            head=head.next;
        }
        return first;
    }
    public T removeLast(){
        T last=getLast();
        Node newLast=head;
        if(head==tail){
            head=null;
            tail=null;
            return last;
        }
        while(newLast.next!=tail){
            newLast=newLast.next;
        }
        newLast.next=null;
        tail=newLast;
        return last;

    }
    @Override
    public boolean add(T t) {
        addLast(t);
        return true;
    }
    public Iterator<T> iterator(){
        return new Iterator<T>(){
            Node tempNode=head;
            @Override
            public boolean hasNext() {
                return tempNode!=null;
            }

            @Override
            public T next() {
                T value=tempNode.value;
                tempNode=tempNode.next;
                return value;
            }
        };
    }
    public Stream<T> stream(){
        Stream.Builder<T> stream=Stream.builder();
        for(T s: this){
            stream.accept(s);
        }
        return stream.build();
    }
}
