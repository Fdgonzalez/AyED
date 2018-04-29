package RoundRobinSimulation;

public class ProcessList {
    private final int QUANTUM = 10;
    private Node first;
    private Node last;
    private Node current;
    private Node prev;
    private int currentTime;
    public ProcessList(){
        first = last = current= prev = null;
    }
    public void insert(Job job){
        if(first == null){//special case: List is empty
            first = last = new Node(job);
            first.next = first;
            prev = first;
            return;
        }
        Node temp = new Node(job);
        last.next = temp;
        last = temp;
        temp.next = first;
    }
    public void print(){
        if(first == null)
            return;
        Node pointer = first;
        System.out.println("-----------");
        do{
            if(pointer == current)
                System.out.print("->");
            else
                System.out.print("  ");
            System.out.print(pointer.job);
            System.out.println();
            pointer = pointer.next;
        }while(pointer != first);
        System.out.println("-----------");

    }
    public void process(){
        if(first == null)
            return;
        if(current == null)
            current = first;
        if(currentTime >= QUANTUM){
            prev = current;
            current = current.next;
            currentTime = 0;
        }
        if(current.job.getTime() <= 0){
            //remove job from list
            currentTime = 0;
            if(current == current.next){ // only element on list
                current = first = last = null;
                return;
            }else {
                if(current == last)
                    last = prev;
                if(current == first){
                    first = current.next;
                }
                prev.next = current.next;
                current = current.next;
            }
        }
        current.job.subtract(1);
        currentTime++;
    }
    private static class Node{
        Job job;
        Node next;
        Node(Job job){
            this.job = job;
            next = null;
        }
    }
}
