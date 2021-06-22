package datastructure.tree;

import java.nio.channels.NonWritableChannelException;

/**
 * @author: liuhj
 * @Date: 2021/1/29 18:39
 * Description:
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        HeroNode heroNode = new HeroNode(1, "宋江");
        HeroNode heroNode2 = new HeroNode(2, "无用");
        HeroNode heroNode3  = new HeroNode(3, "卢俊义");
        HeroNode heroNode4 = new HeroNode(4, "林冲");
        HeroNode heroNode5 = new HeroNode(5, "关胜");
        heroNode.setLeftNode(heroNode2);
        heroNode.setRightNode(heroNode3);
        heroNode3.setRightNode(heroNode4);
        heroNode3.setLeftNode(heroNode5);
        binaryTree.setRoot(heroNode);

//        //前序遍历
//        System.out.println("前序遍历的结果为");
//        binaryTree.preOrder();
//        //中序遍历
//        System.out.println("中序遍历的结果为");
//        binaryTree.infixOrder();
//        //后序遍历
//        System.out.println("后序遍历的结果为");
//        binaryTree.postOrder();

//        //前序查找
//        System.out.println("前序查找的结果为");
//        binaryTree.preOrderSearch(5);
//        //中序查找
//        System.out.println("中序查找的结果为");
//        binaryTree.infixOrderSearch(5);
//        //后序查找
//        System.out.println("后序查找的结果为");
//        binaryTree.postOrderSearch(5);

        //删除节点
        System.out.println("删除前");
        binaryTree.preOrder();
        binaryTree.deleteNode(5);
        System.out.println("删除后");
        binaryTree.preOrder();

    }
}

//创建一个树类
//用来调用节点类
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root){
        this.root = root;
    }

    //前序遍历
    public void preOrder(){
        if (this.root != null ){
            this.root.preOrder();
        }else {
            System.out.println("根节点为空，不可以遍历");
        }
    }
    //中序遍历
    public void infixOrder(){
        if (this.root != null ){
            this.root.infixOrder();
        }else {
            System.out.println("根节点为空，不可以遍历");
        }
    }
    //后序遍历
    public void postOrder(){
        if (this.root != null ){
            this.root.postOrder();
        }else {
            System.out.println("根节点为空，不可以遍历");
        }
    }

    //前序查找
    public HeroNode preOrderSearch(int no){
        if (this.root != null){
            return this.root.preOrderSearch(no);
        }else {
            System.out.println("根节点为空，不能遍历");
            return null;
        }
    }
    //中序查找
    public HeroNode infixOrderSearch(int no){
        if (this.root != null){
            return this.root.infixOrderSearch(no);
        }else {
            System.out.println("根节点为空，不能遍历");
            return null;
        }
    }
    //后序查找
    public HeroNode postOrderSearch(int no){
        if (this.root != null){
            return this.root.postOrderSearch(no);
        }else {
            System.out.println("根节点为空，不能遍历");
            return null;
        }
    }

    //删除节点
    public void deleteNode(int no){
        if (root != null){
            if (root.getNo() == no){
                root = null;
            }else{
                root.deleteNode(no);
            }
        }else{
            System.out.println("根节点为空，不能删除");
        }
    }
}

//创建节点类
//包括no,name，左右节点
//三个方法，前中后遍历
class HeroNode{
    private int no;
    private String name;
    private HeroNode leftNode;
    private HeroNode rightNode;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(HeroNode leftNode) {
        this.leftNode = leftNode;
    }

    public HeroNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(HeroNode rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.leftNode != null){
            this.leftNode.preOrder();
        }
        if (this.rightNode != null){
            this.rightNode.preOrder();
        }
    }

    //中序遍历
    public void infixOrder(){

        if (this.leftNode != null){
            this.leftNode.infixOrder();
        }
        System.out.println(this);
        if (this.rightNode != null){
            this.rightNode.infixOrder();
        }
    }

    //后序遍历
    public void postOrder(){
        if (this.leftNode != null){
            this.leftNode.postOrder();
        }
        if (this.rightNode != null){
            this.rightNode.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no){
        System.out.println("jige ");
        if (this.no == no){
            System.out.println("找到该节点了");
            return this;
        }
        HeroNode resNode = null;
        //如果左子树不为空则遍历左子树
        if (this.leftNode != null){
            resNode = this.leftNode.preOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        //开始遍历右子树
        if (this.rightNode != null){
            resNode = this.rightNode.preOrderSearch(no);
        }
        return resNode;
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no){

        HeroNode resNode = null;
        //如果左子树不为空则遍历左子树
        if (this.leftNode != null){
            resNode = this.leftNode.infixOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        System.out.println("zhongxu");
        if (this.no == no){
            System.out.println("找到该节点了");
            return this;
        }
        //开始遍历右子树
        if (this.rightNode != null){
            resNode = this.rightNode.infixOrderSearch(no);
        }
        return resNode;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no){

        HeroNode resNode = null;
        //如果左子树不为空则遍历左子树
        if (this.leftNode != null){
            resNode = this.leftNode.postOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }

        //开始遍历右子树
        if (this.rightNode != null){
            resNode = this.rightNode.postOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        System.out.println("后序");
        if (this.no == no){
            System.out.println("找到该节点了");
            return this;
        }
        return resNode;
    }

    //删除节点
    public void deleteNode(int no){
        if (this.leftNode != null && this.leftNode.no == no){
            this.leftNode = null;
            return;
        }
        if (this.rightNode != null && this.rightNode.no == no){
            this.rightNode = null;
            return;
        }
        if (this.leftNode != null){
            this.leftNode.deleteNode(no);
        }
        if (this.rightNode != null){
            this.rightNode.deleteNode(no);
        }
    }

}