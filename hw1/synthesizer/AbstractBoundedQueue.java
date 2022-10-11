package synthesizer;

abstract class AbstractBoundedQueue<T>  implements BoundedQueue<T> {
      int capacity;
      int fillCount;
      public int capacity(){
          return capacity;
      }
      public int fillCount(){
          return fillCount;
      }
}
