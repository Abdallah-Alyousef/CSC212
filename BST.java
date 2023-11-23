public class BST<T> {
  BSTNode<T> root , current;
  Boolean a;
  public BST() {
    root = current = null;
  }

  //returns true if the root is null and false otherwise
  public boolean empty() {
    return root == null;
  }

  //This will always be false since BST acts like a LL not like an array
  public boolean full() {
    return false;
  }

  //Returns the data of the current node
  public T retrieve() {
    return current.data;
  }


  public boolean findKey(int tkey) {
    BSTNode<T> p = root,q = root;

    //Cant find a key in a empty tree
    if(empty()) {
      return false;
    }

    //Q moves 1 step behind P 

    while(p != null) {
      q=p;
      //Found the key
      if(p.key == tkey) {
        current = p;
        return true;
      }
      else if(tkey < p.key) {
        p = p.left;
      }
      else {
        p = p.right;
      }
    }
    current = q;
    return false;
  }
  public boolean insert(int k , T val) {
    BSTNode<T> p , q=current;
    //if the nodes exists then we wont add
    if(findKey(k)) { 
      current = q; //Since findKey() will move the current so we place it where it was
      return false; //since insert failed and the node existed already
    }
    p = new BSTNode<T>(k, val);
    if(empty()) {
      root = current = p;
      return true;
    }
    else {
      if(k < current.key) {
        current.left = p;
      }
      else {
        current.right = p;
      }
      current = p;
      return true;
    }
  }

  private BSTNode<T> find_min(BSTNode<T> p) {
      if(p==null) return null;

      while(p.left != null) {
        p = p.left;
      }
      return p;
  }
  
  public boolean update(int key , T data) {
      remove_key(current.key);
      return insert(key, data);
  }

  private BSTNode<T> remove_aux(int key , BSTNode<T> p , BooleanWrapper flag) {
      BSTNode<T> q , child = null;
      if(p == null) {
        return null;
      }
      if(key < p.key) {
        p.left = remove_aux(key, p.left, flag);
      }
      else if(key > p.key) {
        p.right = remove_aux(key, p.right, flag);
      }
      else {
        flag.set(true);
        if(p.left != null && p.right != null) {
          q = find_min(p.right);
          p.key = q.key;
          p.data = q.data;
          p.right = remove_aux(q.key, p.right, flag);
  
        }
        else {
          if(p.right == null) {
              child = p.left;
          }
          else if(p.left == null) {
              child = p.right;
          }
          return child;
        }
      }
      return p;
  }

  public boolean remove_key(int tkey) {
      BooleanWrapper removed = new BooleanWrapper(false);
      BSTNode<T> p;
      p = remove_aux(tkey , root , removed);
      current = root = p;
      return removed.get();
  }
}
