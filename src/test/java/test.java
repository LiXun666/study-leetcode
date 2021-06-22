import com.sun.media.jfxmedia.events.BufferListener;
import leetcode.BSTIterator;
import leetcode.LC2;
import leetcode.MinStack;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author:lx
 * @Date: 2020/10/23 12:12
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        System.out.println(701/26);
        System.out.println((char)('A'+25-1));

    }

    public static void sort(int[] nums, int l,int r){
        if (l<r){
            int mid = (l+r)/2;
            sort(nums,l,mid);
            sort(nums,mid+1,r);
        }
    }

    public static class Node {
        public char val;
        public Node left;
        public Node right;

        public Node(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static Node build() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        return A;
    }
    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
        int left = size(root.left);
        System.out.println(left);
        int right = size(root.right);
        System.out.println(right);

        return left+right+1;
    }


}
