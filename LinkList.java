public class LinkList<T extends Number> {

private Node head;
private Node tail;
private int size;

private class Node<T>{
T element;
Node<T> next;
public Node(T e){
element=e;
}
public Node(){}
}
public LinkList(){
head= new Node(null);
tail=head;
size=0;
}

//accessors

public Node getHead() {
return head;
}

public Node getTail() {
return this.getIndexNode(size-1);
}
public <T> int getSize() {
return size;
}
public <T> Node<T> getIndexNode(int index){
Node<T> current=this.head;
for (int i = 0; i < index; i++) {
current=current.next;
}
return current;
}

//mutate
public <T> void clear(){
this.head=null;
size=0;
}
public <T> void add(T e,int index){
Node<T> toAdd=new Node<>(e);
//Integer zero=0;
//System.out.println(index);
if(index==(size)){
Node<T> temp=this.getIndexNode(this.size - 1);
temp.next=toAdd;
}else if (index>0&&index<size){
Node<T> temp=this.getIndexNode(index-1);
toAdd.next=temp.next.next;
temp.next.next=toAdd;
}
else {
//System.out.println("DDDDDDDDDDDDDDDd");
toAdd.next=this.head;
this.head=toAdd;
}

size++;
}
public <T> void addFront(T e){
Node<T> toAdd=new Node<>(e);
toAdd.next=this.head;
this.head=toAdd;
size++;
}
public <T> T delete(int index){
T e;
if(index==size-1){
Node<T> current=head;
for (int i = 0; i < size-1; i++) {
current=current.next;
}
e=current.next.element;
current.next=null;
}
else if(index==0){
e= (T) head.element;
this.head=head.next;
}
else{
Node<T> current=head;
for (int i = 0; i < index-1; i++) {
current=current.next;
}
e=current.next.element;
current.next=current.next.next;
}
size--;
return e;
}
public <T> T deleteBack(){
T e;
Node<T> current=head;
for (int i = 0; i < size-1; i++) {
current=current.next;
}
e=current.element;
current=null;
size--;
return e;
}

//mis
public <T> boolean contains(T e){
for (int i = 0; i < size; i++) {
if(this.getIndexNode(i).element.equals(e)) return true;
}
return false;
}
public <T> int containsAndCount(T e){
int count=0;
for (int i = 0; i < size; i++) {
if(this.getIndexNode(i).element.equals(e)) count++;
}
return count;
}
public <T> void reverseList(){
Node<T> currentHead=this.head;
Node<T> current=getTail();
T temp;
for (int i = 0; i < this.size/2; i++) {
temp= (T) this.getIndexNode(i).element;
this.getIndexNode(i).element=this.getIndexNode(size-i-1).element;
this.getIndexNode(size-i-1).element=temp;
}
}
public String toString() {
String s = "<";
Node<T> current=head;
for (int i = 0; i < size-1; i++) {
s+=current.element+",";
current=current.next;
}
if(size!=0) {
s += current.element;
}
return s+">";
}
public <T> boolean isEmpty(){

return this.head==null;
}

public static void main(String[] args) {
LinkList<Integer> linkedList=new LinkList<>();
for (int i = 1; i < 10; i++) {
//System.out.println(i);
linkedList.add((Integer)i,i);
}
System.out.println("Note that everything is test respectively.\n");
System.out.println("Testing add, getSize, and toString");
System.out.println("Size is "+linkedList.getSize());
System.out.println(linkedList+"\n\n");

System.out.println("Testing reverseList and getHead");
linkedList.reverseList();
System.out.println("head is "+linkedList.getHead().element);
System.out.println(linkedList+"\n\n");

System.out.println("Testing addFront and add(middle case, the other two have been tested)\n");
System.out.println("Adding 4 to the front and adding 12 in the 5 index");
linkedList.addFront(4);
linkedList.add(12,5);
System.out.println(linkedList+"\n\n");

System.out.println("Testing contains, containsAndCount, and isEmpty");
System.out.println("contains 4? "+linkedList.contains(4));
System.out.println("there are "+linkedList.containsAndCount(4)+" 4's within the linked list");
System.out.println("Is the linked list empty? "+linkedList.isEmpty());
System.out.println(linkedList+"\n\n");

System.out.println("Testing delete and deleteBack");
System.out.println("removing the fourth index which is "+linkedList.delete(4).toString());
System.out.println("removing the last index which is "+linkedList.deleteBack().toString());
System.out.println(linkedList+"\n\n");

System.out.println("Testing clear and isEmpty");
linkedList.clear();
System.out.println("is the list? "+linkedList.isEmpty());
System.out.println(linkedList+"\n\n");
}
}