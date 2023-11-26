import java.util.Stack;

public class BST<T> implements Comparable<T>{
  BSTNode<T> root , current;
  Boolean a;
  private String contactName;
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

  

  public void printTree() {
    inOrder(root);
  }

  public void inOrder(BSTNode<T> p) {
    if(p != null) {
    inOrder(p.left);
    System.out.println(p.data);
    inOrder(p.right); 
    }
  }
  public void inOrderList(BSTNode<T> p) {
    if(p != null) {
    inOrder(p.left);
    inOrder(p.right); 
    }
  }
  public void printList() {

  }

  public void traverseList() {
    inOrder(root);
  }
  // public boolean inOrderTraversal(BSTNode<T> p) {
  //   if(p == null) {
  //       return false;
  //   }
  //   if(p != null) {
  //     inOrderTraversal(p.left);
  //     inOrderTraversal(p.right);
  //     return true;
  //   }
  // }
  

  public boolean traverseBST() {
    if (current == null) {
        return true;
    }

    boolean foundLast = traverseLeftSubtree(current.left);  // Recursively traverse left subtree
    if (foundLast) {
        // Check if the current node is the last node in the right subtree
        if (current.right == null) {
            return true;
        }

        current = current.right;  // Move to the next node in the right subtree
        return false;
    }

    return false;
}

private  boolean traverseLeftSubtree(BSTNode<T> node) {
    if (node == null) {
        return true;
    }

    boolean foundLast = traverseLeftSubtree(node.left);  // Recursively traverse left subtree
    if (foundLast) {

        // Check if the current node is the last node in the right subtree
        if (node.right == null) {
            return traverseRightSubtree(current.right);  // Recursively traverse right subtree
        }
    }

    return false;
}

private  boolean traverseRightSubtree(BSTNode<T> node) {
    if (node == null) {
        return true;
    }

    boolean foundLast = traverseLeftSubtree(node.left);  // Recursively traverse left subtree
    if (foundLast) {

        // Check if the current node is the last node in the right subtree
        if (node.right == null) {
            return true;
        }
    }

    return false;
}


public void printBST() {
  if (root == null) {
      return;
  }

  Stack<BSTNode<T>> stack = new Stack<BSTNode<T>>();
  BSTNode<T> current = root;

  while (current != null || !stack.isEmpty()) {
      while (current != null) {
          stack.push(current);
          current = current.left;
      }

      current = stack.pop();
      System.out.println(current.data);
      current = current.right;
  }
}

  
  

  public BSTNode<T> findRoot() {
      return current = root;
  }

  
  public boolean findPhone(String tkey) {
    BSTNode<T> p = root,q = root;

    //Cant find a key in a empty tree
    if(empty()) {
      return false;
    }

    //Q moves 1 step behind P 

    while(p != null) {
      q=p;
      //Found the key
      if(((Contact) p.data).getPhoneNumber().equalsIgnoreCase(tkey)) {
        current = p;
        return true;
      }
      else if(tkey.compareTo(((Contact) p.data).getPhoneNumber()) < 0) {
        p = p.left;
      }
      else {
        p = p.right;
      }
    }
    current = q;
    return false;
  }

  public boolean findEmailAddress(String tkey) {
    BSTNode<T> p = root,q = root;

    //Cant find a key in a empty tree
    if(empty()) {
      return false;
    }

    //Q moves 1 step behind P 

    while(p != null) {
      q=p;
      //Found the key
      if(((Contact) p.data).getEmailAddress().equalsIgnoreCase(tkey)) {
        current = p;
        return true;
      }
      else if(tkey.compareTo(((Contact) p.data).getEmailAddress()) < 0) {
        p = p.left;
      }
      else {
        p = p.right;
      }
    }
    current = q;
    return false;
  }
  public boolean findAddress(String tkey) {
    BSTNode<T> p = root,q = root;

    //Cant find a key in a empty tree
    if(empty()) {
      return false;
    }

    //Q moves 1 step behind P 

    while(p != null) {
      q=p;
      //Found the key
      if(((Contact) p.data).getAddress().equalsIgnoreCase(tkey)) {
        current = p;
        return true;
      }
      else if(tkey.compareTo(((Contact) p.data).getAddress()) < 0) {
        p = p.left;
      }
      else {
        p = p.right;
      }
    }
    current = q;
    return false;
  }
  public boolean findBirthday(String tkey) {
    BSTNode<T> p = root,q = root;

    //Cant find a key in a empty tree
    if(empty()) {
      return false;
    }

    //Q moves 1 step behind P 

    while(p != null) {
      q=p;
      //Found the key
      if(((Contact) p.data).getBirthday().equalsIgnoreCase(tkey)) {
        current = p;
        return true;
      }
      else if(tkey.compareTo(((Contact) p.data).getBirthday()) < 0) {
        p = p.left;
      }
      else {
        p = p.right;
      }
    }
    current = q;
    return false;
  }


  public boolean findKey(String tkey) {
    BSTNode<T> p = root,q = root;

    //Cant find a key in a empty tree
    if(empty()) {
      return false;
    }

    //Q moves 1 step behind P 

    while(p != null) {
      q=p;
      //Found the key
      if(p.key.equalsIgnoreCase(tkey)) {
        current = p;
        return true;
      }
      else if(tkey.compareTo(p.key) < 0) {
        p = p.left;
      }
      else {
        p = p.right;
      }
    }
    current = q;
    return false;
  }



  public boolean insert(String k , T val) {
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
      if(k.compareTo(current.key) < 0) {
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
  
  // public boolean update(int key , T data) {
  //     remove_key(current.key);
  //     return insert(key, data);
  // }

  // private BSTNode<T> remove_aux(int key , BSTNode<T> p , BooleanWrapper flag) {
  //     BSTNode<T> q , child = null;
  //     if(p == null) {
  //       return null;
  //     }
  //     if(key < p.key) {
  //       p.left = remove_aux(key, p.left, flag);
  //     }
  //     else if(key > p.key) {
  //       p.right = remove_aux(key, p.right, flag);
  //     }
  //     else {
  //       flag.set(true);
  //       if(p.left != null && p.right != null) {
  //         q = find_min(p.right);
  //         p.key = q.key;
  //         p.data = q.data;
  //         p.right = remove_aux(q.key, p.right, flag);
  
  //       }
  //       else {
  //         if(p.right == null) {
  //             child = p.left;
  //         }
  //         else if(p.left == null) {
  //             child = p.right;
  //         }
  //         return child;
  //       }
  //     }
  //     return p;
  // }

  // public boolean remove_key(int tkey) {
  //     BooleanWrapper removed = new BooleanWrapper(false);
  //     BSTNode<T> p;
  //     p = remove_aux(tkey , root , removed);
  //     current = root = p;
  //     return removed.get();
  // }

  public int compareTo(String c) {
		return contactName.compareTo(c);
	}

	public int compareTo(Contact c) {
		return contactName.compareTo(c.contactName);
	}

  @Override
  public int compareTo(Object o) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
  }


//   public BSTNode<T> search(BSTNode<T> root, Contact data) {
//     if (root == null || root.data == data) {
//         return root;
//     }

//     if (data < root.data) {
//         return search(root.left, data);
//     } else {
//         return search(root.right, data);
//     }
// }

}
