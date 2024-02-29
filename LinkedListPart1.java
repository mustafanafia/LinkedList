import java.util.Scanner;
import java.util.Stack;

public class LinkedListPart1<T> {


    private class Node<T>{
        T element;
        Node<T>next;

        public Node(T e){
            element = e;

        } // element
    }//node class

    private int size = 0;
    private Node head;
    private Node tail;
    private Node temp;

    public LinkedListPart1(){
        head = new Node(null);
        tail = new Node(null);
        size = 0;
    }  // LinkedListPart1




    public void clear(){
        head = null;
        size = 0;

    } //clear

    public <T> void reverseList(){
        Stack<T> s1 = new Stack();
        System.out.print("The List Reversed: ");
        temp = new Node(null);
        temp = head;
        while(temp.next != null){
            s1.push((T) temp.element);
            temp = temp.next;

        } //while
        while(!s1.empty()){
            System.out.print(s1.pop() + ",");

        } //while
        System.out.println(s1);

    } // reverseList

    public T deleteLast(){
        System.out.println("In delete last");
        T resp;
        if(size == 0){
            System.out.println("List is empty");
            return null;

        } // if

        else{
            Node<T> temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            } //while
            resp = temp.next.element;
            temp.next = null;
            size--;

        } //else
        return resp;

    } //deleteLast

    public<T> void show(){
        System.out.println("In Show");
        Node<T> temp = head;
        System.out.println("[");
        while(temp.next != null){
            System.out.print(temp.element + ",");
            temp = temp.next;
            
        } //while
        
        System.out.print(temp.element + "]");
        
    } //show

    public void add (T e){
        Node<T> temp = new Node<T>(e);
        temp.next = head;
        head = temp;
        size++;
        
    } //add

    public boolean isEmpty(){
        return (size == 0);
        
    } //isEmpty

    public int getSize(){
        return size;
        
    } //get size

    public String toString(){
        if(head==null) {
            return "";
        } //if
        String result = "";
        Node current = head;
        while(current.next!=null){
            result +=current.element+", ";
            current=current.next;
        } //while

        return result;
        
    } //to String

    public T delete(T e){
        T temp = null;
        if (head == null) return null;
        else{
            temp = (T) head.element;
            head = head.next;
            size--;
            return temp;
        } //else
    } //delete

    public boolean contains(T e){

        Node<T> current = head;
        for (int i = 0; i < size; i++){
            if(current.element.equals(e)){
                return true;
            }
            else if (current == null){
                return false;
            }
            else {
                   
                current = current.next;
                
            } //if
            
        } //whi;e
        return false;
    } //contains

    
    
        public static void main(String[] args) {
        LinkedListPart1 list = new LinkedListPart1<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add("Mustafa");
       System.out.println("The list is: " + list);
        
        
       list.delete(5);
       System.out.println("Deleting the head..The list is now : " + list);
        
       list.reverseList();
              
       list.deleteLast();       
       System.out.println(list);
       
                          
        System.out.println("Test contains: " + list.contains(7));
       
       
       
        System.out.println("Test get size: " + list.getSize());               
        System.out.println("Test is empty?: " + list.isEmpty());        
        System.out.println("Clear the list...");
        list.clear();
        System.out.println("The list is now: " + list);
        System.out.println("Test is empty again ( should be true) ?: " + list.isEmpty());
        

    } //main
}
