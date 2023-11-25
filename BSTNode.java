public class BSTNode<T> {
  
  public String key; //Possibly change of implementation (KEY) --> Only object of contact using compare to for searching...
  public T data;
  public BSTNode<T> left , right;

  public BSTNode(String k , T val) {
      key = k;
      data = val;
      left = right = null;
  }

  public BSTNode(String k , T val ,BSTNode<T> l ,BSTNode<T> r) {
      key = k;
      data = val;
      left = l;
      right = r;
  }

}
