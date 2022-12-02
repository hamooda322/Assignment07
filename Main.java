
  class tree {

    class NODE {
      int value;
      NODE right;
      NODE left;
    }
  
    NODE root = null; // root initializer

    // function to add nodes to tree
    public void addNode(int toAdd) { 
      if (root == null) { // first node in tree
        root = new NODE();
        root.value = toAdd;
        root.right = null;
        root.left = null;
      }
      else { // any other node insertion
        NODE prev = null;
        NODE curr = root;
        while (curr != null) {
          if (curr.value < toAdd) { // moves through children based on orderly value
            prev = curr;
            curr = curr.right;
          }
          else  {
            prev = curr;
            curr = curr.left;
          }
        }

        if (prev.value < toAdd) { // adds new node to right child since value is greater
          prev.right = new NODE();
          prev.right.value = toAdd;
          prev.right.right = null;
          prev.right.left = null;
        }
        else { // adds new node to left child since value is smaller
          prev.left = new NODE();
          prev.left.value = toAdd;
          prev.left.right = null;
          prev.left.left = null;
        }
      }
    }

    public void checkTree(NODE root) { // function to check if binary search tree is valid using an in order traveral
      if (root == null) {
        return;
      }
      else {
        checkTree(root.left);
        System.out.print(root.value);
        checkTree(root.right);
      }
    }

    public void check() { // calls the checkTree function from main
      checkTree(root);
    }

    public void deleteNode(int toDelete) { // function to delete node
      NODE curr = root;
      NODE prev = root;

      while (curr != null) { // finds desired node to delete
        if (curr.value > toDelete) {
          prev = curr;
          curr = curr.left;
        }
        else if (curr.value < toDelete) {
          prev = curr;
          curr = curr.right;
        }
        else {
          break;
        }
      }
      if (curr != null) {
        if (curr.right != null) { // if node to delete has a right child
          curr.value = smallestNode(curr);
        }
        else if (curr == root) { // if node to delete is the root
          root = root.left;
        }
        else { // if node to delete is not the root and has no right children
          if (prev.value > toDelete) {
            prev.left = curr.left;
          }
          else {
            prev.right = curr.left;
          }
        }
      }
    }

    public int smallestNode(NODE node) { // finds the smallest right child if the node to delete has a right child
      NODE curr = node.right;
      NODE prev = node;

      while (curr.left != null) {
        prev = curr;
        curr = curr.left;
      }

      if (curr.right != null) {
        prev.right = curr.right;
      }
      else { // if no child exists upon smallest right child
        prev.right = null;
      }
      return curr.value;
    }

  }

  class Main { // main executes tree
    public static void main(String[] args) {

      tree bst = new tree(); // new tree instance
      bst.addNode(5);
      bst.addNode(3);
      bst.addNode(2);
      bst.addNode(4);
      bst.addNode(6);
      bst.addNode(7);

      bst.check();
      System.out.print("\n");

      bst.deleteNode(5);
      bst.deleteNode(5);
      bst.deleteNode(6);
      bst.deleteNode(7);
      bst.deleteNode(1);
      bst.deleteNode(2);
      bst.deleteNode(3);
      bst.deleteNode(4);
      bst.deleteNode(5);
      bst.deleteNode(5);
      bst.deleteNode(6);
      bst.deleteNode(7);
      bst.deleteNode(1);
      bst.deleteNode(2);
      bst.deleteNode(3);
      bst.deleteNode(4);
      

      bst.check();
    }
  }