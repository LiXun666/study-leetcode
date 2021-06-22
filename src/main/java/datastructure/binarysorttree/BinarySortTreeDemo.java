package datastructure.binarysorttree;

import javax.swing.text.rtf.RTFEditorKit;

/**
 * @author: liuhj
 * @Date: 2021/2/24 11:29
 * Description:
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        System.out.println("root=" + binarySortTree.getRoot());
        //中序遍历该树
        System.out.println("开始二叉排序树的中序遍历");
        binarySortTree.infixOrder(); //升序排列

        //删除叶子节点2
        System.out.println("删除后");
        binarySortTree.delNode(3);
        binarySortTree.delNode(7);
        binarySortTree.delNode(12);
        binarySortTree.delNode(5);
        binarySortTree.delNode(9);
        binarySortTree.delNode(1 );
        binarySortTree.infixOrder(); //升序排列

        System.out.println("root=" + binarySortTree.getRoot());
    }
}

//创建二叉排序树
class BinarySortTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    //查找要删除的节点
    public Node search(int value){
        if (root == null){
            return null;
        }else {
            return root.search(value);
        }
    }

    //查找要删除的父节点
    public Node searchParent(int value){
        if (root == null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    //找到左子树最大值对应的节点并删除，返回该最大值
    public int delMaxLeftNode(Node node){
        Node target = node;
        while (target.right != null){
            target = target.right;
        }
        delNode(target.value);
        return target.value;
    }
    //找到右树的最小值对应的节点并删除，返回该最小值
    public int delMinRightNode(Node node){
        Node target = node;
        while (target.left != null){
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    //删除一个节点
    public void delNode(int value){
        if (root == null){
            return;
        }
        //找到value对应的节点
        Node targetNode = search(value);
        //找到的节点为null,证明没有该节点
        if (targetNode == null ){
            System.out.println("没有该节点");
            return;
        }
        //找到的该树的root的左右节点都为空，证明tartget找到的就是root
        if (root.left == null && root.right == null){
            root = null;
            return;
        }
        //下面就是找到了tartget节点
        //该节点的父节点为
        Node parent = searchParent(value);
        //如果要删除的节点为叶子节点
        if (targetNode.left == null && targetNode.right == null){
            //判断是父节点的左节点还是有节点
            if (parent.left != null && parent.left.value == value){
                parent.left = null ;
            }else if (parent.right != null && parent.right.value ==value){
                parent.right = null;
            }
        }else if (targetNode.left != null && targetNode.right != null){
//            int minValue = delMinRightNode(targetNode.right);
//            targetNode.value = minValue;
            int max = delMaxLeftNode(targetNode.left);
            targetNode.value = max;
        }else {
            if (targetNode.left != null){
                if (parent != null){
                    if (parent.left.value == value){
                        parent.left = targetNode.left;
                    }else {
                        parent.right = targetNode.left;
                    }
                }else {
                    root = targetNode.left;
                }
            }
            if (targetNode.right != null){
                if (parent != null){
                    if (parent.left.value == value){
                        parent.left = targetNode.right;
                    }else {
                        parent.right = targetNode.right;
                    }
                }else {
                    root = targetNode.right;
                }
            }
        }

    }

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.indixOrder();
        } else {
            System.out.println("该二叉树为空，不能遍历");
        }
    }
}

//创建节点
class Node {
    int value;
    Node left;
    Node right;

    //查找一个节点
    public Node search(int value){
        if(value == this.value){
            return this;
        }else if (value < this.value){
            //则需要向左子树查找
            if (this.left == null){
                return null;
            }
            return this.left.search(value);
        }else {
            //向右子树递归查找
            if (this.right ==null){
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     *
     * @param value 要找到的节点的值
     * @return 找到的节点的父节点
     */
    public Node searchParent(int value){
        //当前节点就是要删除节点的父节点，就返回当前节点
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        }else {
            //如果value的值比当前节点的值小，且当前节点左节点不为空
            if(value < this.value && this.left !=null){
                return this.left.searchParent(value);
            }else if (value > this.value && this.right != null){
                return this.right.searchParent(value);
            }else {
                return null;
            }
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //添加节点
    //递归的方式，满足二叉排序树的特点
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    public void indixOrder() {
        if (this.left != null) {
            this.left.indixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.indixOrder();
        }
    }
}