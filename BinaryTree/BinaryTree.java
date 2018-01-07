import java.util.Stack;

public class BinaryTree {
  private TreeNode root = null;

  public BinaryTree() {
    root = new TreeNode(1, "A");
  }

  // 获取二叉树的高
  public int getHeight() {
    return getHeight(root);
  }

  private int getHeight(TreeNode node) {
    if(node == null) {
      return 0;
    } else {
      int i = getHeight(node.leftNode) + 1;
      int j = getHeight(node.leftNode) + 1;
      return i > j ? i: j;
    }
  }

  // 获取二叉树的节点
  public int getSize() {
    return getSize(root);
  }

  private int getSize(TreeNode node) {
    if(node == null) {
      return 0;
    } else {
      return getSize(node.leftNode) + getSize(node.rightNode) + 1;
    }
  }

/////////////////////// Begin 使用递归进行遍历 //////////////////////
  // 前序遍历 ABDECF
  public void preOrder(TreeNode node) {
    if(node == null) {
      return;
    } else {
      System.out.println("preOrder data:" + node.getData());
      preOrder(node.leftNode);
      preOrder(node.rightNode);
    }
  }

  // 中序遍历 DBEACF
  public void inOrder(TreeNode node) {
    if(node == null) {
      return;
    } else {
      inOrder(node.leftNode);
      System.out.println("inOrder data:" + node.getData());
      inOrder(node.rightNode);
    }
  }

  // 后序遍历 DEBFCA
  public void postOrder(TreeNode node) {
    if(node == null) {
      return;
    } else {
      postOrder(node.leftNode);
      postOrder(node.rightNode);
      System.out.println("postOrder data:" + node.getData());
    }
  }
/////////////////////// End 使用递归进行遍历 /////////////////////

////////////////////// Begin 使用栈进行遍历 /////////////////////
 // 前序遍历
  public void stackPreOrder(TreeNode node) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    if(node != null) {
      stack.push(node);
    }
    while(!stack.isEmpty()) {
      node = stack.pop();
      System.out.println("stackPreOrder data:" + node.getData());
      if(node.rightNode != null)
        stack.push(node.rightNode);
      if(node.leftNode != null)
        stack.push(node.leftNode);
    }
  }

 // 中序遍历
  public void stackInOrder(TreeNode node) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    if(node != null) {
      stack.push(node);
    }
    while(!stack.isEmpty()) {
      TreeNode n = stack.pop();
      TreeNode leftChild = n.leftNode;
      TreeNode rightChild = n.rightNode;

      if(leftChild == null && rightChild == null) {
        System.out.println("stackInOrder data:" + n.getData());
      } else {
        if(rightChild != null) {
          stack.push(rightChild);
        }
        stack.push(new TreeNode(n.getIndex(), n.getData()));
        if(leftChild != null) {
          stack.push(leftChild);
        }
      }
    }
  }

 // 后序遍历
  public void stackPostOrder(TreeNode node) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    if(node != null) {
      stack.push(node);
    }
    while(!stack.isEmpty()) {
      TreeNode n = stack.pop();
      TreeNode leftChild = n.leftNode;
      TreeNode rightChild = n.rightNode;

      if(leftChild == null && rightChild == null) {
        System.out.println("stackPostOrder data:" + n.getData());
      } else {
        stack.push(new TreeNode(n.getIndex(), n.getData()));
        if(rightChild != null) {
          stack.push(rightChild);
        }
        if(leftChild != null) {
          stack.push(leftChild);
        }
      }
    }
  }
////////////////////// End 使用栈进行遍历 ///////////////////////
  /**
   * 构建二叉树
   *        A
   *    B       C
   * D    E       F
   */
  public void createBinaryTree() {
    TreeNode nodeB = new TreeNode(2, "B");
    TreeNode nodeC = new TreeNode(3, "C");
    TreeNode nodeD = new TreeNode(4, "D");
    TreeNode nodeE = new TreeNode(5, "E");
    TreeNode nodeF = new TreeNode(6, "F");
    root.leftNode = nodeB;
    root.rightNode = nodeC;
    nodeB.leftNode = nodeD;
    nodeB.rightNode = nodeE;
    nodeC.rightNode = nodeF;
  }

  public class TreeNode {
    private int index;
    private String data;
    private TreeNode leftNode;
    private TreeNode rightNode;

    public int getIndex() {
      return index;
    }

    public void setIndex(int index) {
      this.index = index;
    }

    public String getData() {
      return data;
    }

    public void setData(String data) {
      this.data = data;
    }

    public TreeNode(int index, String data) {
      this.index = index;
      this.data = data;
      this.leftNode = null;
      this.rightNode = null;
    }
  }

  public static void main(String[] args) {
    BinaryTree binaryTree= new BinaryTree();
    binaryTree.createBinaryTree();
    int height = binaryTree.getHeight();
    int size = binaryTree.getSize();
    System.out.println("treeHeight：" + height);
    System.out.println("treeSize：" + size);
    binaryTree.preOrder(binaryTree.root);
    binaryTree.inOrder(binaryTree.root);
    binaryTree.postOrder(binaryTree.root);
    binaryTree.stackPreOrder(binaryTree.root);
    binaryTree.stackInOrder(binaryTree.root);
    binaryTree.stackPostOrder(binaryTree.root);
  }
}
