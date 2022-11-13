/**
 * Deque implemented by array.
 */
public class ArrayDeque<T> {
      public T[] deque;
      public int i;
      public int j;
      public int capacity;
      public int size;
      public ArrayDeque(){
          capacity=8;
          deque=(T[])new Object[capacity];
          i=j=0;
          size=0;
      }
      public void addFirst(T item){
           if(this.isFull()){
                this.resize((int)(capacity*1.5));
           }
           i=(i-1+capacity)%capacity;
           deque[i]=item;
           size+=1;
      }
      public void addLast(T item){
          if(this.isFull()){
              this.resize((int)(capacity*1.5));
          }
          deque[j]=item;
          j=(j+1)%capacity;
          size+=1;
      }
      public boolean isEmpty(){
          return size==0;
      }
      public int size(){
          return size;
      }
      public void printDeque(){
          if(this.isEmpty()){
              return;
          }
          if(i<j){
              for(int c=0;c<size;c++){
                  System.out.println(deque[c+i]);
              }
          }
          if(i>j){
              for(int c=i;c<capacity;c++){
                  System.out.println(deque[i]);
              }
              for(int c=0;c<j;c++){
                  System.out.println(deque[capacity-i+c]);
              }
          }
      }
      public T removeFirst(){
          if(isEmpty()){
              return null;
          }
          if(this.notFull()){
              this.resize((int)(capacity*0.5));
          }
          int c=i;
          i=(i+1)%capacity;
          size-=1;
          return deque[c];
      }
      public T removeLast(){
          if(isEmpty()){
              return null;
          }
          if(this.notFull()){
              this.resize((int)(capacity*0.5));
          }
          int c=(j-1+capacity)%capacity;
          j=c;
          size-=1;
          return deque[c];
      }
      public T get(int Index){
          if(i<j){
              if(Index>=i && Index<j){
                  return deque[Index];
              }
          }
          if(Index>=i || Index<j){
              return deque[Index];
          }
          return null;
      }
      public boolean notFull(){
          if(capacity<16){
              return false;
          }
          double a=size/(double)capacity;
          return a<0.25;
      }
      public boolean isFull(){
          return size==capacity-1;
      }
      public void resize(int newsize){
          if(this.notFull()){
              T[] Deque=(T[])new Object[newsize];
              if(i<j){
                  for(int c=i;c<i+size;c++) {
                      Deque[c - i] = deque[c];
                  }
              }
              if(i>j){
                  for(int c=i;c<capacity;c++){
                      Deque[c-i]=deque[c];
                  }
                  for(int c=0;c<j;c++){
                      Deque[capacity-i+c]=deque[c];
                  }
              }
              deque=Deque;
          }
          if(this.isFull()){
              T[] Deque=(T[])new Object[newsize];
              if(i<j){
                  for(int c=i;c<i+size;c++) {
                      Deque[c - i] = deque[c];
                  }
              }
              if(i>j){
                  for(int c=i;c<capacity;c++){
                      Deque[c-i]=deque[c];
                  }
                  for(int c=0;c<j;c++){
                      Deque[capacity-i+c]=deque[c];
                  }
              }
              deque=Deque;
          }
          capacity=newsize;
          i=0;
          j=size;
      }
      public static void main(String[] args){
          ArrayDeque list=new ArrayDeque();
          list.addFirst(1);
          list.addFirst(2);
          list.addFirst(3);
          list.addFirst(4);
          list.addFirst(5);
          list.addFirst(6);
          list.addFirst(7);
          list.addFirst(8);
          list.removeFirst();
      }

}
