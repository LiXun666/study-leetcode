package datastructure.avl;

import sun.awt.geom.AreaOp;

import java.util.Date;

/**
 * @author: liuhj
 * @Date: 2021/2/24 22:19
 * Description:
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr = {10,11,7,6,8,9};
        //创建avltree对象
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }

        //遍历
        System.out.println("中序遍历");
        avlTree.infixOrder();
        System.out.println("没有做平和处理前");
        System.out.println("树的高度："+ avlTree.getRoot().height());
        System.out.println("左子树的高度："+ avlTree.getRoot().leftHeight());
        System.out.println("右子树的高度："+ avlTree.getRoot().rightHeight());
        System.out.println("根节点:"+avlTree.getRoot());
        System.out.println("根的左节点:"+avlTree.getRoot().left);
        System.out.println("根的右节点:"+avlTree.getRoot().right);
    }

}

//创建avltree
class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    //查找要删除的节点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找要删除的父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    //找到左子树最大值对应的节点并删除，返回该最大值
    public int delMaxLeftNode(Node node) {
        Node target = node;
        while (target.right != null) {
            target = target.right;
        }
        delNode(target.value);
        return target.value;
    }

    //找到右树的最小值对应的节点并删除，返回该最小值
    public int delMinRightNode(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    //删除一个节点
    public void delNode(int value) {
        if (root == null) {
            return;
        }
        //找到value对应的节点
        Node targetNode = search(value);
        //找到的节点为null,证明没有该节点
        if (targetNode == null) {
            System.out.println("没有该节点");
            return;
        }
        //找到的该树的root的左右节点都为空，证明tartget找到的就是root
        if (root.left == null && root.right == null) {
            root = null;
            return;
        }
        //下面就是找到了tartget节点
        //该节点的父节点为
        Node parent = searchParent(value);
        //如果要删除的节点为叶子节点
        if (targetNode.left == null && targetNode.right == null) {
            //判断是父节点的左节点还是有节点
            if (parent.left != null && parent.left.value == value) {
                parent.left = null;
            } else if (parent.right != null && parent.right.value == value) {
                parent.right = null;
            }
        } else if (targetNode.left != null && targetNode.right != null) {
//            int minValue = delMinRightNode(targetNode.right);
//            targetNode.value = minValue;
            int max = delMaxLeftNode(targetNode.left);
            targetNode.value = max;
        } else {
            if (targetNode.left != null) {
                if (parent != null) {
                    if (parent.left.value == value) {
                        parent.left = targetNode.left;
                    } else {
                        parent.right = targetNode.left;
                    }
                } else {
                    root = targetNode.left;
                }
            }
            if (targetNode.right != null) {
                if (parent != null) {
                    if (parent.left.value == value) {
                        parent.left = targetNode.right;
                    } else {
                        parent.right = targetNode.right;
                    }
                } else {
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

class Node {
    int value;
    Node left;
    Node right;

    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    //返回当前节点的高度，以当前节点为根节点的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //查找一个节点
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            //则需要向左子树查找
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            //向右子树递归查找
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * @param value 要找到的节点的值
     * @return 找到的节点的父节点
     */
    public Node searchParent(int value) {
        //当前节点就是要删除节点的父节点，就返回当前节点
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            //如果value的值比当前节点的值小，且当前节点左节点不为空
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value > this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
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

        if (rightHeight() - leftHeight() > 1){
            if (right != null && right.leftHeight() > right.rightHeight()){
                right.rightRotate();
                leftRotate();
            }else {
                leftRotate();
            }
            return;
        }
        if (leftHeight() - rightHeight() > 1){
            //如果左子树的右子树的高度大于左子树左子树的高度
            if (left != null && left.rightHeight() > left.leftHeight()){
                left.leftRotate();
                rightRotate();
            }else {
                rightRotate();
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

    //根节点左旋转的方法
    public void leftRotate(){
        //设置一个新的节点
        Node newNode= new Node(value);
        //新节点的左节点等于，当前的节点的左节点
        newNode.left = left;
        //新节点的右节点等于当前节点的右节点的左节点
        newNode.right = right.left;
        //把当前节点的值变成右节点的值
        value = right.value;
        //当前节点有节点等于右节点的有节点
        right = right.right;
        //当前节点的左节点等于新节点
        left = newNode;
    }

    //根节点右旋转的方法
    public void rightRotate(){
        Node newNode = new Node(value);
        //新节点的右子树，为当前节点的右子树
        newNode.right = right;
        //新节点的左子树，为当前节点的左子树的右子树
        newNode.right = left.right;
        //当前节点的值变成左子树的值
        value = left.value;
        //当前节点的左子树为左子树的左子树
        left = left.left;
        //右子树为新节点
        right = newNode;
    }
}
