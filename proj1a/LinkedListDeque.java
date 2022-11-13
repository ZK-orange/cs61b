/**
 * Deque (usually pronounced like “deck”) is an irregular acronym of
 * double-ended queue. Double-ended queues are sequence containers with dynamic
 * sizes that can be expanded or contracted on both ends (either its front or
 * its back).
 */
public class LinkedListDeque<T> {
       public Node list;
       public int size=0;
       public class Node<T>{
           public T item;
           public Node pre;
           public Node next;
           public Node(Node pre,T item,Node next){
               this.item=item;
               this.pre=pre;
               this.next=next;
           }
           public Node(){

           };
       }
       public LinkedListDeque(){
           list=new Node();
           list.pre=list;
           list.next=list;
       }
       public void addFirst(T item){
           Node a=new Node(list,item,list.next);
           list.next.pre=a;
           list.next=a;
           size+=1;
       }
       public void addLast(T item){
           Node a=new Node(list.pre,item,list);
           list.pre.next=a;
           list.pre=a;
           size+=1;
       }
       public boolean isEmpty(){
           return size==0;
       }
       public int size(){
           return size;
       }
       public void printDeque(){
           if(size==0){
               return;
           }
           Node p=list.next;
           for(int i=0;i<size;i++){
               System.out.println(p.item);
               p=p.next;
           }
       }
       public T removeFirst(){
           if(size==0){
               return null;
           }
           T a=(T)list.next.item;
           list.next.next.pre=list;
           list.next=list.next.next;
           size-=1;
           return a;

       }
       public T removeLast(){
           if(size==0){
               return null;
           }
           T a=(T)list.pre.item;
           list.pre.pre.next=list;
           list.pre=list.pre.pre;
           size-=1;
           return a;
       }
       public T get(int index){
           if(index>=size){
               return null;
           }
           Node p=list.next;
           for(int i=0;i<index;i++){
               p=p.next;
           }
           return (T)p.item;
       }

       public static void main(String[] args){
           LinkedListDeque list= new LinkedListDeque();
           list.addFirst(2);
           list.addFirst(3);
           list.addLast(1);
           list.printDeque();
           list.removeFirst();
           list.removeLast();
       }

}